package com.maksym.moroz.compose01.features.main.presentation.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainDetailsView(
    navController: NavController,
    viewModel: MainDetailsViewModel,
) {
    val title = viewModel.title.collectAsState()
    val description = viewModel.description.collectAsState()

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = title.value,
            onValueChange = { viewModel.updateTitle(it) },
            singleLine = true,

            )
        OutlinedTextField(
            value = description.value,
            onValueChange = { viewModel.updateDescription(it) },
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(8.dp),
            ) {
                Text(text = "Cancel")
            }

            Button(
                onClick = {
                    viewModel.saveNote()
                    navController.popBackStack()
                },
                enabled = viewModel.ableToSave(),
                modifier = Modifier.padding(8.dp),
            ) {
                Text(text = "Save")
            }
        }
    }
}
