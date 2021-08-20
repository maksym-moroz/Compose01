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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.maksym.moroz.compose01.R
import com.maksym.moroz.compose01.features.main.presentation.common.ViewStatePlaceholder

@Composable
fun MainDetailsView(
    toDoId: Int?,
    onSaveClicked: () -> Unit,
    onCancelClicked: () -> Unit,
    viewModel: MainDetailsViewModel = hiltViewModel(),
) {
    DisposableEffect(Unit) {
        viewModel.loadToDo(toDoId)
        onDispose(onCancelClicked)
    }
    val viewState by remember(viewModel) { viewModel.viewState }
        .collectAsState()

    when (viewState) {
        is ViewState.Data -> {
            GetToDo(
                viewState = viewState,
                onSaveClicked = onSaveClicked,
                onCancelClicked = onCancelClicked,
            )
        }
        ViewState.Empty -> GetToDo(
            onSaveClicked = onSaveClicked,
            onCancelClicked = onCancelClicked,
        )
        ViewState.Loading -> ViewStatePlaceholder(R.string.loading)
    }
}

@Composable
private fun GetToDo(
    viewState: ViewState = ViewState.Empty,
    onSaveClicked: () -> Unit,
    onCancelClicked: () -> Unit,
) {
    val (title, setTitle) = rememberSaveable {
        mutableStateOf((viewState as? ViewState.Data)?.value?.item?.title ?: "")
    }
    val (description, setDescription) = rememberSaveable {
        mutableStateOf((viewState as? ViewState.Data)?.value?.item?.description ?: "")
    }

    ToDo(
        title,
        setTitle,
        description,
        setDescription,
        onSaveClicked,
        onCancelClicked,
    )
}

@Composable
private fun ToDo(
    title: String,
    setTitle: (String) -> Unit,
    description: String,
    setDescription: (String) -> Unit,
    onSaveClicked: () -> Unit,
    onCancelClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = title,
            onValueChange = setTitle,
            modifier = Modifier
                .padding(8.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = description,
            onValueChange = setDescription,
            modifier = Modifier
                .height(160.dp)
                .padding(8.dp),
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            Button(
                onClick = onCancelClicked,
                modifier = Modifier.padding(8.dp),
            ) {
                Text(text = stringResource(R.string.cancel))
            }

            Button(
                onClick = onSaveClicked,
                enabled = title.isNotEmpty() || description.isNotEmpty(),
                modifier = Modifier.padding(8.dp),
            ) {
                Text(text = stringResource(R.string.save))
            }
        }
    }
}
