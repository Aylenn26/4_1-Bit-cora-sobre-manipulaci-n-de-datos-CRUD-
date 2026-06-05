package edu.itvo.roompersistence.domain.model

import java.time.LocalDate

data class Player(
    val id: Long = 0L,
    val fullName: String,
    val nickName: String,
    val nationality: String,
    val gender: Gender,
    val birthDate: LocalDate,
    val photo: String?,
    val position: Position
)