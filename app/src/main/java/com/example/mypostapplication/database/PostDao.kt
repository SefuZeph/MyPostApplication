package com.example.mypostapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mypostapplication.domain.Posts

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(customers: List<Posts>)

    @Query("SELECt * FROM Posts")
    fun getAllPosts(): LiveData<List<Posts>>
}