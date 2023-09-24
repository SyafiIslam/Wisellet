package com.syafi.wisellet.di

import android.app.Application
import androidx.room.Room
import com.syafi.wisellet.data.Database
import com.syafi.wisellet.data.Repository
import com.syafi.wisellet.data.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application):Database {
        return Room.databaseBuilder(
            app,
            Database::class.java,
            "transaction_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: Database) :Repository {
        return RepositoryImpl(db.dao)
    }
}

