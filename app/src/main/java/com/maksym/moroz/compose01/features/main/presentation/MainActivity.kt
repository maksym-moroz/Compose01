package com.maksym.moroz.compose01.features.main.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.maksym.moroz.compose01.features.main.presentation.navigation.NavGraph
import com.maksym.moroz.compose01.ui.theme.Compose01Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose01Theme {
                NavGraph()
            }
        }
    }
}
