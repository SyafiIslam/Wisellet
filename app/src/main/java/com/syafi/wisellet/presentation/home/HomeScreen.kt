package com.syafi.wisellet.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.syafi.wisellet.MainViewModel
import com.syafi.wisellet.model.Income
import com.syafi.wisellet.presentation.home.component.Greeting
import com.syafi.wisellet.presentation.home.component.HomeDialog
import com.syafi.wisellet.presentation.home.component.Income
import com.syafi.wisellet.presentation.home.component.Outcome
import com.syafi.wisellet.presentation.home.component.TotalBalance
import com.syafi.wisellet.presentation.home.component.TransactionItem
import com.syafi.wisellet.ui.theme.TextBlue
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    navController: NavController,
    homeViewModel: HomeViewModel= hiltViewModel()
) {

    val transactions= homeViewModel.transactions.collectAsState(initial = emptyList())

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        item {
            Greeting()
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
            TotalBalance()
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Income(modifier = Modifier.weight(1f), homeViewModel)
                Outcome(modifier = Modifier.weight(1f))
            }
        }

        item {
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = "Recent Transactions",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.TextBlue
            )
            Spacer(modifier = Modifier.height(12.dp))
            
        }

        items(transactions.value) {
            TransactionItem(transaction = it, homeViewModel)
        }

        if (mainViewModel.showDialog.value) {
            item {
                HomeDialog(showDialog = mainViewModel.showDialog, navController)
            }
        }
    }
}