package edu.itvo.roompersistence.presentation.player.state

import edu.itvo.roompersistence.domain.model.Player

data class PlayerListUiState(

    val players: List<Player> = emptyList()
)