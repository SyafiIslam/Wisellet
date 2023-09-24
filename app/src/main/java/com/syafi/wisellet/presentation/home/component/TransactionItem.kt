package com.syafi.wisellet.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.syafi.wisellet.model.Transaction
import com.syafi.wisellet.presentation.home.HomeViewModel
import com.syafi.wisellet.ui.theme.blue
import com.syafi.wisellet.ui.theme.green
import com.syafi.wisellet.ui.theme.red
import com.syafi.wisellet.util.Category

@Composable
fun TransactionItem(transaction: Transaction, viewModel: HomeViewModel) {
    Card(
        modifier = Modifier.padding(bottom = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {

        viewModel.formatDate(transaction.date)

        Row(
            Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TransactionIcon(category = transaction.category)

                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = transaction.title,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.blue,
                        fontSize = 16.sp
                    )
                    Text(text = transaction.description, fontSize = 14.sp, color = Color.Gray)
                }
            }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text =
                    if (transaction.category != Category.INCOME) {
                        "-Rp ${viewModel.formatLongWithDots(transaction.amount)}"
                    } else {
                        "Rp ${viewModel.formatLongWithDots(transaction.amount)}"
                    },
                    color =
                    if (transaction.category != Category.INCOME) {
                        MaterialTheme.colorScheme.red
                    } else {
                        MaterialTheme.colorScheme.green
                    },
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "${viewModel.date} ${viewModel.month.take(3)}",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
    }
}