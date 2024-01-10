package com.example.lab5.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.lab5.data.local.MovieEntity
import com.example.lab5.data.local.MovieRemoteKeyEntity
import com.example.lab5.data.local.MoviesDatabase
import com.example.lab5.data.remote.MoviesApi
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator @Inject constructor(
    private val moviesApi: MoviesApi,
    private val moviesDb: MoviesDatabase
) : RemoteMediator<Int, MovieEntity>() {
    private val moviesDao = moviesDb.moviesDao
    private val remoteKeysDao = moviesDb.remoteKeysDao

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKey = getRemoteKeyClosestToCurrentPosition(state)
                remoteKey?.nextKey?.minus(1) ?: 1
            }

            LoadType.PREPEND -> {
                val remoteKey = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKey?.prevKey
                prevKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKey != null)
            }

            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                nextKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
        }

        try {
            val response = moviesApi.getMovies(page = page)
            val endOfPaginationReached = response.movies.isEmpty()
            val prevKey = if (page <= 1) null else page - 1
            val nextKey = if (endOfPaginationReached) null else page + 1

            moviesDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    remoteKeysDao.deleteAllRemoteKeys()
                    moviesDao.deleteAllMovies()
                }

                val remoteKeys = response.movies.map { movie ->
                    movie.toMovieRemoteKeyEntity(
                        prevKey = prevKey,
                        currentPage = page,
                        nextKey = nextKey
                    )
                }
                remoteKeysDao.upsertAllRemoteKeys(remoteKeys = remoteKeys)

                val moviesToCache = response.movies.map { movie ->
                    movie.toMovieEntity(page = page)
                }
                moviesDao.upsertAllMovies(movies = moviesToCache)
            }

            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, MovieEntity>): MovieRemoteKeyEntity? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let {
            remoteKeysDao.getRemoteKeyByMovieId(it.id)
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, MovieEntity>): MovieRemoteKeyEntity? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let {
            remoteKeysDao.getRemoteKeyByMovieId(it.id)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, MovieEntity>): MovieRemoteKeyEntity? {
        return state.anchorPosition?.let {
            state.closestItemToPosition(it)?.id?.let { id ->
                remoteKeysDao.getRemoteKeyByMovieId(id)
            }
        }
    }
}