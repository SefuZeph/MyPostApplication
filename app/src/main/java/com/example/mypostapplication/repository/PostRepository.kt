package com.example.mypostapplication.repository

import com.example.mypostapplication.database.PostDao
import com.example.mypostapplication.network.PostRemoteDataSource
import com.example.mypostapplication.util.performGetOperation
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource,
    private val localDataSource: PostDao
) {
    fun getPosts() = performGetOperation(
        databaseQuery = { localDataSource.getAllPosts() },
        networkCall = { remoteDataSource.getPosts() },
        saveCallResult = { localDataSource.saveAll(it.results) }
    )
}