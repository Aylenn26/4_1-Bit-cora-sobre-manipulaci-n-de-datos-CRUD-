package edu.itvo.roompersistence.domain.model

data class Stadium(
    val id: Long = 0L,
    val name: String,
    val city: String,
    val country: String,
    val capacity: Int,
    val photo: String?
)
