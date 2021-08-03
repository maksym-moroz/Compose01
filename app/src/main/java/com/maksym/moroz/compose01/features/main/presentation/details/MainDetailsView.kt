package com.maksym.moroz.compose01.features.main.presentation.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainDetailsView(
    navController: NavController,
    viewModel: MainDetailsViewModel,
) {
    val title = remember(viewModel) { viewModel.title }
        .collectAsState()
    val description = remember(viewModel) { viewModel.description }
        .collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = title.value,
            onValueChange = { viewModel.updateTitle(it) },
            modifier = Modifier.padding(8.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = description.value,
            onValueChange = { viewModel.updateDescription(it) },
            modifier = Modifier
                .height(160.dp)
                .padding(8.dp),
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.padding(8.dp),
            ) {
                Text(text = "Cancel")
            }

            Button(
                onClick = {
                    viewModel.saveNote()
                    navController.navigateUp()
                },
                enabled = viewModel.ableToSave(),
                modifier = Modifier.padding(8.dp),
            ) {
                Text(text = "Save")
            }
        }
    }
}
