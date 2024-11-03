package com.example.practice_5

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todos(
    @PrimaryKey val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId: Int
)