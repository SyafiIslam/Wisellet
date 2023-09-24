package com.syafi.wisellet.presentation.home.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.syafi.wisellet.ui.theme.green
import com.syafi.wisellet.ui.theme.red
import com.syafi.wisellet.util.Route

@Composable
fun HomeDialog(showDialog: MutableState<Boolean>, navController: NavController) {

    Dialog(onDismissRequest = {
        Log.i("ilang", "ilang")
        showDialog.value = false
    }) {
        Column(
            Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            Text(text = "Choose Transaction", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            ChooseItem(
                title = "Income",
                icon = Icons.Default.AttachMoney,
                bgColor = MaterialTheme.colorScheme.green,
                onClick = {
                    showDialog.value= false
                    navController.navigate(Route.ADD_INCOME)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ChooseItem(
                title = "Outcome",
                icon = Icons.Default.MoneyOff,
                MaterialTheme.colorScheme.red,
                onClick = {
                    showDialog.value= false
                    navController.navigate(Route.ADD_OUTCOME)
                }
            )
        }
    }
}

@Composable
fun ChooseItem(
    title: String,
    icon: ImageVector,
    bgColor: Color,
    onClick: () -> Unit = {}
) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .clip(RoundedCornerShape(5.dp))
            .background(bgColor)
            .padding(horizontal = 8.dp, vertical = 8.dp)
            ,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(imageVector = icon, contentDescription = title, tint = Color.White)
        Text(text = title, color = Color.White, fontWeight = FontWeight.SemiBold)
    }
}