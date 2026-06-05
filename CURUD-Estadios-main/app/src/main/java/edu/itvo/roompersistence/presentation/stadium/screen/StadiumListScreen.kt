package edu.itvo.roompersistence.presentation.stadium.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Stadium
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import edu.itvo.roompersistence.presentation.stadium.components.StadiumItem
import edu.itvo.roompersistence.presentation.stadium.event.StadiumListEvent
import edu.itvo.roompersistence.presentation.stadium.viewmodel.StadiumListViewModel

@Composable
fun StadiumListScreen(
    modifier: Modifier = Modifier,
    viewModel: StadiumListViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.stadiums.isEmpty()) {

        /*
        =========================================
        ESTADO VACÍO — diferente al de jugadores:
        ícono más pequeño, texto en color secundario
        =========================================
         */

        Column(
            modifier = modifier.padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(
                space = 12.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Default.Stadium,
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .alpha(0.5f),
                tint = MaterialTheme.colorScheme.secondary
            )

            Text(
                text = "No hay estadios aún",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary
            )

            Text(
                text = "Usa el botón + para registrar\nel primer estadio",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }

    } else {

        /*
        =========================================
        LISTA — padding inferior para el FAB
        =========================================
         */

        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 80.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(
                items = uiState.stadiums,
                key = { it.id }
            ) { stadium ->

                StadiumItem(
                    stadium = stadium,
                    onDeleteClick = {
                        viewModel.onEvent(
                            StadiumListEvent.DeleteStadium(stadium)
                        )
                    }
                )
            }
        }
    }
}