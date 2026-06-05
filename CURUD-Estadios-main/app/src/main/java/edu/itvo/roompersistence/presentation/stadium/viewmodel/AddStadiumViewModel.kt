package edu.itvo.roompersistence.presentation.stadium.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itvo.roompersistence.domain.model.Stadium
import edu.itvo.roompersistence.domain.usecase.StadiumUseCases
import edu.itvo.roompersistence.presentation.stadium.event.AddStadiumEvent
import edu.itvo.roompersistence.presentation.stadium.event.AddStadiumUiEvent
import edu.itvo.roompersistence.presentation.stadium.state.AddStadiumUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddStadiumViewModel @Inject constructor(
    private val useCases: StadiumUseCases
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(AddStadiumUiState())

    val uiState =
        _uiState.asStateFlow()

    private val _uiEvent =
        Channel<AddStadiumUiEvent>()

    val uiEvent =
        _uiEvent.receiveAsFlow()

    fun onEvent(
        event: AddStadiumEvent
    ) {

        when (event) {

            is AddStadiumEvent.OnNameChanged -> {

                _uiState.update {
                    it.copy(name = event.value)
                }
            }

            is AddStadiumEvent.OnCityChanged -> {

                _uiState.update {
                    it.copy(city = event.value)
                }
            }

            is AddStadiumEvent.OnCountryChanged -> {

                _uiState.update {
                    it.copy(country = event.value)
                }
            }

            is AddStadiumEvent.OnCapacityChanged -> {

                // Solo permitir dígitos en el campo
                if (event.value.all { it.isDigit() }) {

                    _uiState.update {
                        it.copy(capacity = event.value)
                    }
                }
            }

            is AddStadiumEvent.OnPhotoSelected -> {

                _uiState.update {
                    it.copy(photoUri = event.value)
                }
            }

            AddStadiumEvent.SaveStadium -> {

                saveStadium()
            }
        }
    }

    private fun saveStadium() {

        viewModelScope.launch {

            val state = uiState.value

            /*
            =========================================
            VALIDACIONES
            =========================================
             */

            if (state.name.isBlank()) {

                _uiEvent.send(
                    AddStadiumUiEvent.ShowSnackbar(
                        message = "El nombre del estadio es obligatorio"
                    )
                )

                return@launch
            }

            if (state.city.isBlank()) {

                _uiEvent.send(
                    AddStadiumUiEvent.ShowSnackbar(
                        message = "La ciudad es obligatoria"
                    )
                )

                return@launch
            }

            if (state.capacity.isBlank()) {

                _uiEvent.send(
                    AddStadiumUiEvent.ShowSnackbar(
                        message = "La capacidad es obligatoria"
                    )
                )

                return@launch
            }

            /*
            =========================================
            GUARDAR
            =========================================
             */

            useCases.addStadium(
                Stadium(
                    name = state.name,
                    city = state.city,
                    country = state.country,
                    capacity = state.capacity.toIntOrNull() ?: 0,
                    photo = state.photoUri
                )
            )

            _uiEvent.send(
                AddStadiumUiEvent.ShowSnackbar(
                    message = "Estadio guardado correctamente",
                    navigateBack = true
                )
            )
        }
    }
}
