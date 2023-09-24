package com.syafi.wisellet.presentation.home.component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.syafi.wisellet.presentation.home.HomeViewModel
import com.syafi.wisellet.ui.theme.green

@Composable
fun Income(modifier: Modifier = Modifier, viewModel: HomeViewModel) {

    val totalIncome = viewModel.totalIncome.collectAsState(initial = 0L)

    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.green),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp)
        ) {
            Column(Modifier.weight(1f)) {
                Column {
                    Text(text = "Income", fontSize = 14.sp, color = Color.White)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Rp " + viewModel.formatLongWithDots(totalIncome.value),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                imageVector = Icons.Default.TrendingUp,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(35.dp)
            )
        }
    }
}