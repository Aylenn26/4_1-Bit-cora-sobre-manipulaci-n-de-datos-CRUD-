package edu.itvo.roompersistence.presentation.stadium.event

sealed interface AddStadiumUiEvent {

    data class ShowSnackbar(
        val message: String,
        val navigateBack: Boolean = false
    ) : AddStadiumUiEvent
}
