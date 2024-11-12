package com.example.myapplication.di

import android.app.Application
import androidx.room.Room
import com.example.myapplication.db.MainDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun provideMainDb(app: Application) : MainDb{
        return Room.databaseBuilder(
            app,
            MainDb::class.java,
            "info.db"
        ).createFromAsset("db/info.db").build()
    }
}