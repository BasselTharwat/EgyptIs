package com.example.egyptis.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.egyptis.R
import com.example.egyptis.ui.utils.EgyptIsLayout

/**
 * enum values that represent the screens in the app
 */
enum class EgyptIsScreen(@StringRes val title: Int) {
    Home(title = R.string.Home_title),
    Recommendations(title = R.string.Recommendations_title),
    Details(title = R.string.Details_title)
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EgyptIsAppBar(
    currentScreen: EgyptIsScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.surface
            )
                },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.inverseSurface
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = MaterialTheme.colorScheme.surface,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Composable
fun EgyptIsApp(
    modifier: Modifier = Modifier,
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController()
){
    val viewModel: MonumentViewModel = viewModel()
    val monumentUIState = viewModel.uiState.collectAsState().value

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = EgyptIsScreen.valueOf(
        backStackEntry?.destination?.route ?: EgyptIsScreen.Home.name
    )

    val layout: EgyptIsLayout = when (windowSize) {
        WindowWidthSizeClass.Expanded -> EgyptIsLayout.THREE_PAGED
        WindowWidthSizeClass.Medium -> EgyptIsLayout.TWO_PAGED
        else -> EgyptIsLayout.ONE_PAGED
    }



    Scaffold(
        topBar = {
            EgyptIsAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        }
    ) { innerPadding ->

        if (layout == EgyptIsLayout.ONE_PAGED) {
            NavHost(
                navController = navController,
                startDestination = EgyptIsScreen.Home.name,
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)

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
        } else if (layout == EgyptIsLayout.TWO_PAGED) {

            Row(modifier = Modifier.fillMaxSize()) {
                Home(
                    monumentUIState = monumentUIState,
                    modifier = modifier.weight(1f)
                ) {
                }
                NavHost(
                    navController = navController,
                    startDestination = EgyptIsScreen.Recommendations.name,
                    modifier = Modifier.weight(2f)
                ) {
                    composable(route = EgyptIsScreen.Recommendations.name) {
                        Recommendations(
                            monumentUIState = monumentUIState,
                            onMonumentClick = { monument ->
                                viewModel.updateCurrentMonument(monument)
                                navController.navigate(EgyptIsScreen.Details.name)
                            }
                        )
                    }
                    composable(route = EgyptIsScreen.Details.name) {
                        MonumentDetails(monumentUIState = monumentUIState)
                    }
                }
            }
        } else {
            Row(modifier = Modifier.fillMaxSize()) {
                Home(monumentUIState = monumentUIState,
                    modifier = modifier.weight(1f)) {
                }
                Recommendations(
                    modifier = Modifier.weight(2f),
                    monumentUIState = monumentUIState,
                    onMonumentClick = { monument ->
                        viewModel.updateCurrentMonument(monument)
                    }
                )
                MonumentDetails(
                    modifier = Modifier.weight(3f),
                    monumentUIState = monumentUIState
                )
            }
        }
    }

}


