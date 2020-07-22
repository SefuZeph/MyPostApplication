package com.example.mypostapplication.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Posts(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long = 0,

    @ColumnInfo(name = "user_id", index = true) val userId: String,

    @ColumnInfo(name = "title", index = true) val title: String,

    @ColumnInfo(name = "body") val body: String
)