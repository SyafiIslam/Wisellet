package com.syafi.wisellet.presentation.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.syafi.wisellet.MainViewModel
import com.syafi.wisellet.ui.theme.blue

@Composable
fun Fab(
    viewModel: MainViewModel
) {
    FloatingActionButton(
        onClick = {
            viewModel.onFabClick()
        },
        containerColor = MaterialTheme.colorScheme.blue,
        shape = CircleShape
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "",
            tint = Color.White
        )
    }
}