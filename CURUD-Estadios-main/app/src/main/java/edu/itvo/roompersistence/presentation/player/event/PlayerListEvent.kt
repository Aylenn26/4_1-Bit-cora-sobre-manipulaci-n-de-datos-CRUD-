package edu.itvo.roompersistence.presentation.player.event

import edu.itvo.roompersistence.domain.model.Player


sealed interface PlayerListEvent {

    data class DeletePlayer(
        val player: Player
    ) : PlayerListEvent
}