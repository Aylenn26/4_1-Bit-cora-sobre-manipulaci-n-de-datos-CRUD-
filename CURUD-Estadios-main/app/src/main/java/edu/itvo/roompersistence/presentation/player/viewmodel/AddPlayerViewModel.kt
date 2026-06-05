package edu.itvo.roompersistence.presentation.player.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itvo.roompersistence.domain.model.Player
import edu.itvo.roompersistence.domain.usecase.PlayerUseCases
import edu.itvo.roompersistence.presentation.player.event.AddPlayerEvent
import edu.itvo.roompersistence.presentation.player.event.AddPlayerUiEvent
import edu.itvo.roompersistence.presentation.player.state.AddPlayerUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPlayerViewModel @Inject constructor(
    private val useCases: PlayerUseCases
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(AddPlayerUiState())

    val uiState =
        _uiState.asStateFlow()

    private val _uiEvent =
        Channel<AddPlayerUiEvent>()

    val uiEvent =
        _uiEvent.receiveAsFlow()

    fun onEvent(
        event: AddPlayerEvent
    ) {

        when (event) {

            is AddPlayerEvent.OnFullNameChanged -> {

                _uiState.update {
                    it.copy(
                        fullName = event.value
                    )
                }
            }

            is AddPlayerEvent.OnNickNameChanged -> {

                _uiState.update {
                    it.copy(
                        nickName = event.value
                    )
                }
            }

            is AddPlayerEvent.OnNationalityChanged -> {

                _uiState.update {
                    it.copy(
                        nationality = event.value
                    )
                }
            }

            is AddPlayerEvent.OnGenderChanged -> {

                _uiState.update {
                    it.copy(
                        gender = event.value
                    )
                }
            }

            is AddPlayerEvent.OnBirthDateChanged -> {

                _uiState.update {
                    it.copy(
                        birthDate = event.value
                    )
                }
            }

            is AddPlayerEvent.OnPositionChanged -> {

                _uiState.update {
                    it.copy(
                        position = event.value
                    )
                }
            }

            is AddPlayerEvent.OnPhotoSelected -> {

                _uiState.update {
                    it.copy(
                        photoUri = event.value
                    )
                }
            }

            AddPlayerEvent.SavePlayer -> {

                savePlayer()
            }
        }
    }

    private fun savePlayer() {

        viewModelScope.launch {

            val state = uiState.value

            /*
            =========================================
            VALIDATIONS
            =========================================
             */

            if (state.fullName.isBlank()) {

                _uiEvent.send(
                    AddPlayerUiEvent.ShowSnackbar(
                        message = "Full name is required"
                    )
                )

                return@launch
            }

            if (state.birthDate == null) {

                _uiEvent.send(
                    AddPlayerUiEvent.ShowSnackbar(
                        message = "Please select birth date"
                    )
                )

                return@launch
            }

            /*
            =========================================
            SAVE PLAYER
            =========================================
             */

            useCases.addPlayer(
                Player(
                    fullName = state.fullName,
                    nickName = state.nickName,
                    nationality = state.nationality,
                    gender = state.gender,
                    birthDate = state.birthDate,
                    photo = state.photoUri,
                    position = state.position
                )
            )

            /*
            =========================================
            SUCCESS EVENT
            =========================================
             */

            _uiEvent.send(
                AddPlayerUiEvent.ShowSnackbar(
                    message = "Player saved successfully",
                    navigateBack = true
                )
            )
        }
    }
}