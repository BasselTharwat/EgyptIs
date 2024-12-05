package com.example.egyptis.ui

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.egyptis.R

/**
 * enum values that represent the screens in the app
 */
enum class EgyptIsScreen(@StringRes val title: Int) {
    Home(title = R.string.Home_title),
    Recommendations(title = R.string.Recommendations_title),
    Details(title = R.string.Details_title)
}

@Composable
fun EgyptIsApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val viewModel: MonumentViewModel = viewModel()
    val monumentUIState = viewModel.uiState.collectAsState().value

    NavHost(navController = navController,
        startDestination = EgyptIsScreen.Home.name,
        modifier = modifier
            .fillMaxSize()
            //.verticalScroll(rememberScrollState())

    ) {
        composable(route = EgyptIsScreen.Home.name) {
            Home(monumentUIState = monumentUIState,
                onCategoryClick = { category ->
                    viewModel.updateCurrentCategory(category)
                    navController.navigate(EgyptIsScreen.Recommendations.name)
                })
        }

        composable(route = EgyptIsScreen.Recommendations.name) {
            Recommendations(monumentUIState = monumentUIState,
                onMonumentClick = { monument ->
                    viewModel.updateCurrentMonument(monument)
                    navController.navigate(EgyptIsScreen.Details.name)
                })
        }
        composable(route = EgyptIsScreen.Details.name) {
            MonumentDetails(monumentUIState = monumentUIState)
        }
    }
}