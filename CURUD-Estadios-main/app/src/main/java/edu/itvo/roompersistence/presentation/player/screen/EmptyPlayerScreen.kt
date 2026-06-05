package edu.itvo.roompersistence.presentation.player.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun EmptyPlayerScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,

        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically
        ),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Default.Groups,
            contentDescription = null,

            modifier = Modifier
                .size(96.dp)
                .alpha(0.7f),

            tint = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "No players registered",

            style = MaterialTheme.typography.headlineSmall,

            color = MaterialTheme.colorScheme.onSurface,

            textAlign = TextAlign.Center
        )

        Text(
            text = "Press the + button to add your first player",

            style = MaterialTheme.typography.bodyLarge,

            color = MaterialTheme.colorScheme.onSurfaceVariant,

            textAlign = TextAlign.Center
        )
    }
}