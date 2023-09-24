package com.syafi.wisellet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.syafi.wisellet.navigation.Navigation
import com.syafi.wisellet.presentation.component.CustomScaffold
import com.syafi.wisellet.ui.theme.WiselletTheme
import com.syafi.wisellet.util.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            WiselletTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route
                    val viewModel= viewModel<MainViewModel>()
                    CustomScaffold(
                        viewModel = viewModel,
                        navController = navController,
                        showBottomBar = currentRoute in listOf(
                            Route.HOME,
                            Route.GRAPH,
                            Route.WALLET
                        ),
                        screenWithTopBar = navBackStackEntry?.destination?.route,
                        showFab = currentRoute === Route.HOME
                    ) {
                        Navigation(navController = navController, viewModel)
                    }
                }
            }
        }
    }
}