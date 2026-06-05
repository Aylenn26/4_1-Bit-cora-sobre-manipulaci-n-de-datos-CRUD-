package edu.itvo.roompersistence.presentation.player.event

import edu.itvo.roompersistence.domain.model.Gender
import edu.itvo.roompersistence.domain.model.Position
import java.time.LocalDate

sealed interface AddPlayerEvent {

    data class OnFullNameChanged(
        val value: String
    ) : AddPlayerEvent

    data class OnNickNameChanged(
        val value: String
    ) : AddPlayerEvent

    data class OnNationalityChanged(
        val value: String
    ) : AddPlayerEvent

    data class OnGenderChanged(
        val value: Gender
    ) : AddPlayerEvent

    data class OnBirthDateChanged(
        val value: LocalDate
    ) : AddPlayerEvent

    data class OnPositionChanged(
        val value: Position
    ) : AddPlayerEvent

    data class OnPhotoSelected(
        val value: String
    ) : AddPlayerEvent

    data object SavePlayer : AddPlayerEvent
}