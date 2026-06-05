package edu.itvo.roompersistence.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.itvo.roompersistence.presentation.HomeScreen
import edu.itvo.roompersistence.presentation.player.screen.AddPlayerScreen
import edu.itvo.roompersistence.presentation.stadium.screen.AddStadiumScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PlayerRoutes.Home.route    // <-- inicio en Home
    ) {

        /*
        =========================================
        HOME (tabs: jugadores + estadios)
        =========================================
         */

        composable(
            route = PlayerRoutes.Home.route
        ) {

            HomeScreen(

                onNavigateToAddPlayer = {
                    navController.navigate(PlayerRoutes.AddPlayer.route)
                },

                onNavigateToEditPlayer = { playerId ->
                    navController.navigate(
                        PlayerRoutes.EditPlayer.createRoute(playerId)
                    )
                },

                onNavigateToAddStadium = {
                    navController.navigate(PlayerRoutes.AddStadium.route)
                }
            )
        }

        /*
        =========================================
        ADD PLAYER
        =========================================
         */

        composable(
            route = PlayerRoutes.AddPlayer.route
        ) {

            AddPlayerScreen(
                playerId = null,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        /*
        =========================================
        EDIT PLAYER
        =========================================
         */

        composable(
            route = PlayerRoutes.EditPlayer.route,
            arguments = listOf(
                navArgument("playerId") {
                    type = NavType.LongType
                }
            )
        ) { backStackEntry ->

            val playerId =
                backStackEntry.arguments?.getLong("playerId")

            AddPlayerScreen(
                playerId = playerId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        /*
        =========================================
        ADD STADIUM
        =========================================
         */

        composable(
            route = PlayerRoutes.AddStadium.route
        ) {

            AddStadiumScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
