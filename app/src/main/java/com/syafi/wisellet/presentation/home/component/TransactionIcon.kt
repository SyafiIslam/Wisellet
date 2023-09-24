package com.syafi.wisellet.presentation.home.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.DirectionsCarFilled
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material.icons.outlined.LocalGasStation
import androidx.compose.material.icons.outlined.Medication
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material.icons.outlined.ShoppingBasket
import androidx.compose.material.icons.outlined.Wash
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.syafi.wisellet.util.Category

@Composable
fun TransactionIcon(category: String) {

    Icon(
        imageVector =
        when (category) {
            Category.INCOME -> Icons.Outlined.AttachMoney
            Category.FOOD -> Icons.Outlined.Fastfood
            Category.LAUNDRY -> Icons.Outlined.Wash
            Category.TRANSPORT -> Icons.Outlined.DirectionsCarFilled
            Category.PAYMENT -> Icons.Outlined.Sell
            Category.FUEL -> Icons.Outlined.LocalGasStation
            Category.MEDICINE -> Icons.Outlined.Medication
            else -> Icons.Outlined.ShoppingBasket
        },
        contentDescription = category,
        Modifier.size(29.dp).clip(RoundedCornerShape(15.dp))
    )
}