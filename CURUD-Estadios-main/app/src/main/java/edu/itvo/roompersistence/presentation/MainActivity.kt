package edu.itvo.roompersistence.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import android.os.Build
import dagger.hilt.android.AndroidEntryPoint
import edu.itvo.roompersistence.presentation.navigation.AppNavGraph
import edu.itvo.roompersistence.presentation.ui.theme.RoomPersistenceTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            RoomPersistenceTheme {

                AppNavGraph()
            }
        }
    }
}