package com.syafi.wisellet.presentation.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.InsertChart
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.InsertChartOutlined
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.wisellet.model.BottomaBarData
import com.syafi.wisellet.ui.theme.blue
import com.syafi.wisellet.util.Route

@Composable
fun BottomBar(navController: NavController) {
    val navList = listOf(
        BottomaBarData(
            Icons.Outlined.Home,
            Icons.Filled.Home,
            "Home",
            Route.HOME
        ),

        BottomaBarData(
            Icons.Outlined.InsertChartOutlined,
            Icons.Filled.InsertChart,
            "Graph",
            Route.GRAPH
        ),
        BottomaBarData(
            Icons.Outlined.CreditCard,
            Icons.Filled.CreditCard,
            "Wallet",
            Route.WALLET
        ),
    )
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    NavigationBar(
        Modifier
            .size(height = 50.dp, width = 400.dp)
            .shadow(elevation = 6.dp)
        ,
        containerColor = Color.White) {
        navList.forEach {
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(it.route) },
                icon = {
                    Icon(
                        imageVector =
                            if (it.route === currentRoute) it.selectedIcon else it.unSelectedIcon,
                        contentDescription = it.label,
                        tint =
                            if (currentRoute === it.route) MaterialTheme.colorScheme.blue else Color.Gray,
                        modifier = Modifier.size(25.dp)
                    )
                }
            )
        }
    }
}