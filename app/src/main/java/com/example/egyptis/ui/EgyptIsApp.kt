package com.example.egyptis.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun EgyptIsApp(
    modifier: Modifier = Modifier,
){
    val viewModel: MonumentViewModel = viewModel()
    val monumentUIState = viewModel.uiState.collectAsState().value





}