package com.maksym.moroz.compose01.features.main.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.maksym.moroz.compose01.R
import com.maksym.moroz.compose01.features.main.presentation.common.ViewStatePlaceholder
import com.maksym.moroz.compose01.ui.theme.Purple700

@Composable
fun MainListView(
    onToDoClicked: (Int) -> Unit,
    onGotAToDoClicked: () -> Unit,
    viewModel: MainListViewModel = hiltViewModel(),
) {
    val actions = ListActions(
        onToDoClicked = onToDoClicked,
        onGotAToDoClicked = onGotAToDoClicked,
    )

    val (query, setQuery) = rememberSaveable { mutableStateOf("") }
    SearchAndAdd(query, setQuery, actions)

    val viewState by viewModel.updateQuery(query)
        .collectAsState()

    when (viewState) {
        is ViewState.Data -> ViewStateLazyColumn(viewState as ViewState.Data, actions)
        is ViewState.Loading -> ViewStatePlaceholder(R.string.loading)
        is ViewState.Nothing -> ViewStatePlaceholder(R.string.nothing_found)
        is ViewState.Empty -> ViewStatePlaceholder(R.string.nothing_to_do)
        is ViewState.Error -> ViewStatePlaceholder(R.string.something_went_wrong) {
            background(Color.Red)
        }
    }
}

@Composable
private fun SearchAndAdd(
    query: String,
    setQuery: (String) -> Unit,
    actions: ListActions,
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = setQuery,
                modifier = Modifier.padding(8.dp),
            )

            Button(
                onClick = actions.onGotAToDoClicked
            ) {
                Text(
                    text = stringResource(R.string.got_a_note_question_mark),
                    modifier = Modifier
                        .padding(8.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(Color.DarkGray, Color.LightGray),
                            ),
                            shape = RoundedCornerShape(8.dp),
                            alpha = 0.3F,
                        ),
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }
        }
    }
}

@Composable
private fun ViewStateLazyColumn(
    viewState: ViewState.Data,
    actions: ListActions,
) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
    ) {
        items(viewState.value) { toDo ->
            Box(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 8.dp,
                        end = 8.dp,
                    )
                    .fillMaxWidth()
                    .clickable {
                        actions.onToDoClicked(toDo.id)
                    },
                contentAlignment = Alignment.CenterStart,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 4.dp,
                        )
                        .background(
                            color = Purple700,
                            shape = RoundedCornerShape(8.dp),
                        )
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Top,
                ) {
                    Text(
                        text = toDo.item.title,
                        color = Color.White,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .background(
                                brush = Brush.horizontalGradient(
                                    listOf(Color.DarkGray, Color.LightGray),
                                ),
                                shape = RoundedCornerShape(4.dp),
                                alpha = 0.2F,
                            )
                            .padding(horizontal = 4.dp),
                    )
                    Text(
                        text = toDo.item.description,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .background(
                                brush = Brush.horizontalGradient(
                                    listOf(Color.DarkGray, Color.LightGray),
                                ),
                                shape = RoundedCornerShape(8.dp),
                                alpha = 0.2F,
                            )
                            .padding(horizontal = 4.dp),
                        fontStyle = FontStyle.Italic,
                    )
                }
            }
        }
    }
}
