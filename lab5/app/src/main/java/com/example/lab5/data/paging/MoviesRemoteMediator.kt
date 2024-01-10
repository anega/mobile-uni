package com.example.lab5.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.lab5.data.local.MovieEntity
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
            LoadType.REFRESH -> TODO()
            LoadType.PREPEND -> TODO()
            LoadType.APPEND -> TODO()
        }

        try {
            val response = moviesApi.getMovies()
            return MediatorResult.Success(endOfPaginationReached = true)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }
}