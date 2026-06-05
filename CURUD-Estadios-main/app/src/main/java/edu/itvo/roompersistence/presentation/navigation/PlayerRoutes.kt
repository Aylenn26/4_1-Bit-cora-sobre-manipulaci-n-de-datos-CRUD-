package edu.itvo.roompersistence.presentation.navigation

sealed class PlayerRoutes(
    val route: String
) {

    // Pantalla principal con tabs (jugadores + estadios)
    data object Home : PlayerRoutes("home")

    // ---------- Jugadores ----------

    data object PlayerList : PlayerRoutes("player_list")

    data object AddPlayer : PlayerRoutes("add_player")

    data object EditPlayer : PlayerRoutes("edit_player/{playerId}") {

        fun createRoute(playerId: Long): String = "edit_player/$playerId"
    }

    // ---------- Estadios ----------

    data object AddStadium : PlayerRoutes("add_stadium")
}
