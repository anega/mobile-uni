package com.example.lab5.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MovieRemoteKeysDao {
    @Upsert
    suspend fun upsertAllRemoteKeys(remoteKeys: List<MovieRemoteKeyEntity>)

    @Query("SELECT * FROM movie_remote_keys WHERE movie_id = :movieId")
    suspend fun getRemoteKeyByMovieId(movieId: Int): MovieRemoteKeyEntity

    @Query("DELETE FROM movie_remote_keys")
    suspend fun deleteAllRemoteKeys()
}