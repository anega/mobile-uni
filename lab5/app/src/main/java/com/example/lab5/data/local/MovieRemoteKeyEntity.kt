package com.example.lab5.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_remote_keys")
data class MovieRemoteKeyEntity(
    @PrimaryKey
    @ColumnInfo("movie_id")
    val movieId: Int,
    @ColumnInfo("prev_key")
    val prevKey: Int?,
    @ColumnInfo("current_page")
    val currentPage: Int,
    @ColumnInfo("next_key")
    val nextKey: Int?
)
