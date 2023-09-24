package com.syafi.wisellet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.syafi.wisellet.MainViewModel
import com.syafi.wisellet.presentation.add_transaction.income.IncomeScreen
import com.syafi.wisellet.presentation.add_transaction.outcome.OutcomeScreen
import com.syafi.wisellet.presentation.graph.GraphScreen
import com.syafi.wisellet.presentation.home.HomeScreen
import com.syafi.wisellet.presentation.wallet.WalletScreen
import com.syafi.wisellet.util.Route

@Composable
fun Navigation(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(navController = navController, startDestination = Route.HOME) {
        composable(Route.HOME) {
            HomeScreen(viewModel, navController)
        }
        composable(Route.GRAPH) {
            GraphScreen()
        }
        composable(Route.WALLET) {
            WalletScreen()
        }
        composable(Route.ADD_INCOME) {
            IncomeScreen(navController = navController)
        }
        composable(Route.ADD_OUTCOME) {
            OutcomeScreen()
        }
    }
}