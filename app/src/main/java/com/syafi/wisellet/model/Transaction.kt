package com.syafi.wisellet.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.syafi.wisellet.util.Category

@Entity
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int= 0,
    val date: String,
    val title: String,
    val category: String= Category.INCOME,
    val description: String,
    val amount: Long= 0
)