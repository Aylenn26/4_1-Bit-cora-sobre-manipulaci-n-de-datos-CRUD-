package edu.itvo.roompersistence.presentation.player.state

import edu.itvo.roompersistence.domain.model.Gender
import edu.itvo.roompersistence.domain.model.Position
import java.time.LocalDate


data class AddPlayerUiState(

    val fullName: String = "",

    val nickName: String = "",

    val nationality: String = "",

    val gender: Gender = Gender.Masculino,

    val birthDate: LocalDate? = null,

    val photoUri: String? = null,

    val position: Position = Position.DEFENDER,

    val isLoading: Boolean = false,

    val errorMessage: String? = null,

    )