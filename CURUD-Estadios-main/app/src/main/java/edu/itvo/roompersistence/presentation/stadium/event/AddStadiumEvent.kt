package edu.itvo.roompersistence.presentation.stadium.event

sealed interface AddStadiumEvent {

    data class OnNameChanged(
        val value: String
    ) : AddStadiumEvent

    data class OnCityChanged(
        val value: String
    ) : AddStadiumEvent

    data class OnCountryChanged(
        val value: String
    ) : AddStadiumEvent

    data class OnCapacityChanged(
        val value: String
    ) : AddStadiumEvent

    data class OnPhotoSelected(
        val value: String
    ) : AddStadiumEvent

    data object SaveStadium : AddStadiumEvent
}
