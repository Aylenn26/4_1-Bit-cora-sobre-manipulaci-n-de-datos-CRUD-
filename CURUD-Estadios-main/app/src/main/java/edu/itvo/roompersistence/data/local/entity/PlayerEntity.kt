package edu.itvo.roompersistence.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class PlayerEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val fullName: String,

    val nickName: String,

    val nationality: String,

    val gender: String,

    val birthDate: String,

    val photo: String?,

    val position: String
)