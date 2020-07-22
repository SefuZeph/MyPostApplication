package com.example.mypostapplication.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mypostapplication.repository.PostRepository
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PaymentDaoTest {

    private lateinit var appDatabase: AppDatabase

    private lateinit var postDao: PostDao

    private lateinit var postRepository: PostRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Test
    fun saveAllPosts() = runBlocking<Unit> {
    }
}