package com.example.mypostapplication.injection

import android.content.Context
import com.example.mypostapplication.repository.PostRepository
import com.example.mypostapplication.database.AppDatabase
import com.example.mypostapplication.database.PostDao
import com.example.mypostapplication.network.PostRemoteDataSource
import com.example.mypostapplication.network.PostService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun providePostService(retrofit: Retrofit): PostService =
        retrofit.create(PostService::class.java)

    @Singleton
    @Provides
    fun providePostRemoteDataSource(postService: PostService) =
        PostRemoteDataSource(postService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun providePostDao(db: AppDatabase) = db.postDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: PostRemoteDataSource,
        localDataSource: PostDao
    ) =
        PostRepository(
            remoteDataSource,
            localDataSource
        )
}