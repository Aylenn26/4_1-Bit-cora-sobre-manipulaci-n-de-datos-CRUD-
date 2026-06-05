package edu.itvo.roompersistence.presentation.player.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import edu.itvo.roompersistence.presentation.player.component.PlayerItem
import edu.itvo.roompersistence.presentation.player.event.PlayerListEvent
import edu.itvo.roompersistence.presentation.player.viewmodel.PlayerListViewModel

@Composable
fun PlayerListScreen(
    onNavigateToAddPlayer: () -> Unit,
    onNavigateToEditPlayer: (Long) -> Unit,
    viewModel: PlayerListViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(

        // FAB extendido con texto en lugar de solo icono
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onNavigateToAddPlayer,
                icon = {
                    Icon(
                        imageVector = Icons.Default.PersonAdd,
                        contentDescription = null
                    )
                },
                text = { Text("Nuevo Jugador") }
            )
        },

        // FAB alineado al centro en vez de la derecha
        floatingActionButtonPosition = FabPosition.Center

    ) { innerPadding ->

        if (uiState.players.isEmpty()) {

            EmptyPlayerScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )

        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 80.dp   // espacio para el FAB
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = uiState.players,
                    key = { player -> player.id }
                ) { player ->

                    PlayerItem(
                        player = player,
                        onEditClick = {
                            onNavigateToEditPlayer(player.id)
                        },
                        onDeleteClick = {
                            viewModel.onEvent(
                                PlayerListEvent.DeletePlayer(player)
                            )
                        }
                    )
                }
            }
        }
    }
}