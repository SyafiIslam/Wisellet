package com.syafi.wisellet.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.syafi.wisellet.MainViewModel
import com.syafi.wisellet.util.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    showBottomBar: Boolean = false,
    screenWithTopBar: String?,
    showFab: Boolean = false,
    viewModel: MainViewModel,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        content = content,
        modifier = modifier,
        bottomBar = {
            if (showBottomBar) BottomBar(navController = navController) else Unit
        },
        floatingActionButton = {
            if (showFab) Fab(viewModel) else Unit
        },
        topBar = {
            when(screenWithTopBar) {
                Route.ADD_INCOME -> AppBar(title = "Add Income", navController = navController)
                Route.ADD_OUTCOME -> AppBar(title = "Add Outcome", navController = navController)
                else -> Unit
            }
        }
    )
}