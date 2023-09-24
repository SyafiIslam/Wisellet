@file:OptIn(ExperimentalMaterial3Api::class)

package com.syafi.wisellet.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.syafi.wisellet.ui.theme.blue
import com.syafi.wisellet.util.Route

@Composable
fun AppBar(title: String, navController: NavController) {
    TopAppBar(
        title = {
            Text(text = title, color = Color.White)
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Route.HOME)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.blue)
    )
}