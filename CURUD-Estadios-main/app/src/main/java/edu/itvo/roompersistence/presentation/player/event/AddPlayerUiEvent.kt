package edu.itvo.roompersistence.presentation.player.event


sealed interface AddPlayerUiEvent {

    data class ShowSnackbar(
        val message: String,
        val navigateBack: Boolean = false
    ) : AddPlayerUiEvent
}