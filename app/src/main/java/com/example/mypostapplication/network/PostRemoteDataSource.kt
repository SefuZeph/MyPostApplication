package com.example.mypostapplication.network

import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(
    private val postService: PostService
) : BaseDataSource() {
    suspend fun getPosts() = getResult { postService.getAllPosts() }
}
