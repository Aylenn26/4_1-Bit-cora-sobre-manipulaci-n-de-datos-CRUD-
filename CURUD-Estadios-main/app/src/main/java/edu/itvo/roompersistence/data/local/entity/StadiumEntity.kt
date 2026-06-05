package edu.itvo.roompersistence.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stadiums")
data class StadiumEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,

    val city: String,

    val country: String,

    val capacity: Int,

    val photo: String?
)
