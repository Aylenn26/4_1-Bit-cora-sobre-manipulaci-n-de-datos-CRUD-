package edu.itvo.roompersistence.presentation.stadium.event

import edu.itvo.roompersistence.domain.model.Stadium

sealed interface StadiumListEvent {

    data class DeleteStadium(
        val stadium: Stadium
    ) : StadiumListEvent
}
