package com.maksym.moroz.compose01.features.main.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.maksym.moroz.compose01.features.main.presentation.details.MainDetailsView
import com.maksym.moroz.compose01.features.main.presentation.list.MainListView
import com.maksym.moroz.navigation.Screen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.List(),
) {
    val actions = remember(navController) { Actions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(Screen.List()) {
            MainListView(
                onToDoClicked = actions.openToDoDetail,
                onGotAToDoClicked = actions.openToDoNew,
            )
        }
        composable(
            route = Screen.Detail(),
            arguments = listOf(
                navArgument(Screen.Detail.ID) {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) { backStackEntry ->
            val toDoId = backStackEntry.arguments?.getInt(Screen.Detail.ID)
            MainDetailsView(
                toDoId = toDoId,
                onSaveClicked = actions.navigateUp,
                onCancelClicked = actions.navigateUp,
            )
        }
    }
}

internal data class Actions(val navController: NavHostController) {

    val openToDoDetail: (Int) -> Unit = { id ->
        navController.navigate(Screen.Detail(id)) {
            launchSingleTop = true
        }
    }
    val openToDoNew: () -> Unit = {
        navController.navigate(Screen.Detail()) {
            launchSingleTop = true
        }
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}
