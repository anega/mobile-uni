package com.example.lab4.di

import android.app.Application
import androidx.room.Room
import com.example.lab4.data.MoviesDatabase
import com.example.lab4.data.MoviesRepository
import com.example.lab4.data.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesMoviesDatabase(app: Application): MoviesDatabase {
        return Room
            .databaseBuilder(app, MoviesDatabase::class.java, "movies_db")
            .build()
    }

    @Provides
    @Singleton
    fun providesMoviesRepository(db: MoviesDatabase): MoviesRepository {
        return MoviesRepositoryImpl(db.dao)
    }
}