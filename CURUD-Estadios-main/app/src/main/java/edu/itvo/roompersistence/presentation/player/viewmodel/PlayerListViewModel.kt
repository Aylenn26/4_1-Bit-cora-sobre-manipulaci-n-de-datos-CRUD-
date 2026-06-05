package edu.itvo.roompersistence.presentation.player.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itvo.roompersistence.domain.model.Player
import edu.itvo.roompersistence.domain.usecase.PlayerUseCases
import edu.itvo.roompersistence.presentation.player.event.PlayerListEvent
import edu.itvo.roompersistence.presentation.player.state.PlayerListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerListViewModel @Inject constructor(
    private val useCases: PlayerUseCases
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            PlayerListUiState()
        )

    val uiState =
        _uiState.asStateFlow()

    init {
        observePlayers()
    }

    /*
    =========================================
    EVENTS
    =========================================
     */

    fun onEvent(
        event: PlayerListEvent
    ) {

        when (event) {

            is PlayerListEvent.DeletePlayer -> {

                deletePlayer(
                    event.player
                )
            }
        }
    }

    /*
    =========================================
    OBSERVE PLAYERS
    =========================================
     */

    private fun observePlayers() {

        useCases
            .getPlayers()
            .onEach { players ->

                _uiState.update {

                    it.copy(
                        players = players
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    /*
    =========================================
    DELETE PLAYER
    =========================================
     */

    private fun deletePlayer(
        player: Player
    ) {

        viewModelScope.launch {

            useCases.deletePlayer(
                player
            )
        }
    }
}