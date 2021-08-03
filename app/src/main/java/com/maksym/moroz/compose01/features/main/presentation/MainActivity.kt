package com.maksym.moroz.compose01.features.main.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maksym.moroz.compose01.features.main.presentation.details.MainDetailsView
import com.maksym.moroz.compose01.features.main.presentation.details.MainDetailsViewModel
import com.maksym.moroz.compose01.features.main.presentation.list.MainListView
import com.maksym.moroz.compose01.features.main.presentation.list.MainListViewModel
import com.maksym.moroz.compose01.features.main.presentation.navigation.ScreenNavigation
import com.maksym.moroz.compose01.ui.theme.Compose01Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainListViewModel: MainListViewModel by viewModels()
    private val mainDetailsViewModel: MainDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose01Theme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = ScreenNavigation.LIST.name,
                ) {
                    composable(ScreenNavigation.LIST.name) {
                        MainListView(
                            navController = navController,
                            viewModel = mainListViewModel,
                        )
                    }

                    composable(ScreenNavigation.DETAILS.name) {
                        MainDetailsView(
                            navController = navController,
                            viewModel = mainDetailsViewModel,
                        )
                    }
                }
            }
        }
    }
}
