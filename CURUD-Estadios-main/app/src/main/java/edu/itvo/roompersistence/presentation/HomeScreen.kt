package edu.itvo.roompersistence.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Stadium
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import edu.itvo.roompersistence.presentation.player.screen.PlayerListScreen
import edu.itvo.roompersistence.presentation.stadium.screen.StadiumListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToAddPlayer: () -> Unit,
    onNavigateToEditPlayer: (Long) -> Unit,
    onNavigateToAddStadium: () -> Unit
) {

    // Tab seleccionado: 0 = Jugadores, 1 = Estadios
    var selectedTab by remember { mutableIntStateOf(0) }

    // Controla si el menú del FAB está expandido
    var fabExpanded by remember { mutableStateOf(false) }

    Scaffold(

        topBar = {

            CenterAlignedTopAppBar(

                title = {

                    Text(
                        if (selectedTab == 0) "Jugadores" else "Estadios"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = Color.Unspecified
                )
            )
        },

        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = {
                        selectedTab = 0
                        fabExpanded = false
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Groups,
                            contentDescription = null
                        )
                    },
                    label = { Text("Jugadores") }
                )

                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = {
                        selectedTab = 1
                        fabExpanded = false
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Stadium,
                            contentDescription = null
                        )
                    },
                    label = { Text("Estadios") }
                )
            }
        },

        floatingActionButton = {

            Box(
                contentAlignment = Alignment.BottomEnd
            ) {

                /*
                =========================================
                OPCIONES DEL MINI-MENÚ (aparecen encima del FAB)
                =========================================
                 */

                AnimatedVisibility(
                    visible = fabExpanded,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut()
                ) {

                    androidx.compose.foundation.layout.Column(
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)
                    ) {

                        // Opción: Agregar Estadio
                        ExtendedFloatingActionButton(
                            onClick = {
                                fabExpanded = false
                                onNavigateToAddStadium()
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Stadium,
                                    contentDescription = null
                                )
                            },
                            text = { Text("Agregar Estadio") },
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )

                        // Opción: Agregar Jugador
                        ExtendedFloatingActionButton(
                            onClick = {
                                fabExpanded = false
                                onNavigateToAddPlayer()
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.PersonAdd,
                                    contentDescription = null
                                )
                            },
                            text = { Text("Agregar Jugador") },
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )

                        /*
                        =========================================
                        FAB PRINCIPAL — abre/cierra el menú
                        =========================================
                         */

                        FloatingActionButton(
                            onClick = { fabExpanded = !fabExpanded }
                        ) {

                            Icon(
                                imageVector = if (fabExpanded) {
                                    Icons.Default.Close
                                } else {
                                    Icons.Default.Add
                                },
                                contentDescription = null
                            )
                        }
                    }
                }

                // FAB principal visible cuando el menú está cerrado
                AnimatedVisibility(
                    visible = !fabExpanded,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut()
                ) {

                    FloatingActionButton(
                        onClick = { fabExpanded = true }
                    ) {

                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Agregar"
                        )
                    }
                }
            }
        }

    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            when (selectedTab) {

                0 -> PlayerListScreen(
                    onNavigateToAddPlayer = onNavigateToAddPlayer,
                    onNavigateToEditPlayer = onNavigateToEditPlayer
                )

                1 -> StadiumListScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
