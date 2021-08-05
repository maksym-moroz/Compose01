package com.maksym.moroz.compose01.features.main.presentation.list

import androidx.annotation.StringRes
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.maksym.moroz.compose01.R
import com.maksym.moroz.compose01.features.main.presentation.navigation.ScreenNavigation
import com.maksym.moroz.compose01.ui.theme.Purple700

@Composable
fun MainListView(
    navController: NavController,
    viewModel: MainListViewModel,
) {
    val listViewState by remember(viewModel) { viewModel.currentToDoList }
        .collectAsState()
    val searchViewState by remember(viewModel) { viewModel.searchResultList }
        .collectAsState()
    val query by remember(viewModel) { viewModel.searchQuery }
        .collectAsState()

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
                onValueChange = { viewModel.updateQuery(it) },
                modifier = Modifier.padding(8.dp)
            )

            Button(
                onClick = {
                    navController.navigate(ScreenNavigation.DETAILS.route)
                },
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

    when (listViewState) {
        is ListViewState.Data -> ViewStateLazyColumn(
            listViewState as ListViewState.Data,
            searchViewState,
            navController
        )
        is ListViewState.Loading -> ViewStatePlaceholder(R.string.loading)
        is ListViewState.Empty -> ViewStatePlaceholder(R.string.nothing_to_do)
        is ListViewState.Error -> ViewStatePlaceholder(R.string.something_went_wrong) {
            background(Color.Red)
        }
    }
}

@Composable
private fun ViewStateLazyColumn(
    listViewState: ListViewState.Data,
    searchViewState: SearchViewState,
    navController: NavController,
) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
    ) {

        val currentList = when (searchViewState) {
            is SearchViewState.Data -> listViewState.value.filter { toDo ->
                searchViewState.value.any { toDoFts -> toDo.id == toDoFts.id }
            }
            is SearchViewState.Empty -> listViewState.value
            is SearchViewState.Invalid -> emptyList()
        }
        items(currentList) { toDo ->
            Box(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 8.dp,
                        end = 8.dp,
                    )
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(
                            ScreenNavigation.DETAILS.route,
                        )
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

@Composable
private inline fun ViewStatePlaceholder(
    @StringRes placeholder: Int,
    modifier: Modifier.() -> Modifier = { this },
) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .modifier(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Text(
            text = stringResource(placeholder),
            modifier = Modifier
                .padding(16.dp),
            color = Color.White,
            fontSize = 16.sp,
        )
    }
}