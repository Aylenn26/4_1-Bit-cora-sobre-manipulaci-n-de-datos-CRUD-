package edu.itvo.roompersistence.domain.model


enum class Position(
    val displayName: String
) {

    GOALKEEPER("Portero"),

    DEFENDER("Defensa"),

    MIDFIELDER("Centro Campista"),

    FORWARD("Delantero")
}