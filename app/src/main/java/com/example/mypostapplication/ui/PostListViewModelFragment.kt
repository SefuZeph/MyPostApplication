package com.example.mypostapplication.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.mypostapplication.repository.PostRepository

class PostListViewModelFragment @ViewModelInject constructor(
    postRepository: PostRepository
) : ViewModel() {

    val posts = postRepository.getPosts()
}