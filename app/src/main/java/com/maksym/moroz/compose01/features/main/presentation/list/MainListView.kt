package com.maksym.moroz.compose01.features.main.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.maksym.moroz.compose01.R
import com.maksym.moroz.compose01.features.main.presentation.navigation.ScreenNavigation

@Composable
fun MainListView(
    navController: NavController,
    viewModel: MainListViewModel,
) {
    val list = viewModel.list.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        if (list.value.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center,

                ) {
                    Button(
                        onClick = {
                            navController.navigate(ScreenNavigation.DETAILS.name)
                        },
                        shape = MaterialTheme.shapes.small,
                    ) {
                        Text(
                            text = stringResource(R.string.new_note_question_mark),
                            modifier = Modifier
                                .padding(8.dp),
                            color = Color.White,
                            fontSize = 16.sp,
                        )
                    }
                }
            }
        } else {
            items(list.value) {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter,
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        verticalArrangement = Arrangement.Top,
                    ) {
                        Text(
                            text = it.item.title,
                            color = Color.Black,
                            fontSize = 24.sp,
                        )
                        Text(
                            text = it.item.description,
                            color = Color.Black,
                            fontSize = 16.sp,
                        )
                    }
                }
            }
        }
    }
}