package com.example.mypostapplication.network

import com.example.mypostapplication.domain.PostList
import retrofit2.Response
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    suspend fun getAllPosts() : Response<PostList>
}