package com.syafi.wisellet.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.syafi.wisellet.util.Category

@Entity
data class Income (
    @PrimaryKey(autoGenerate = true)
    val id: Int= 0,
    val title: String= "",
    val description: String= "",
    val amount: Long= 0L,
    val date: String= "",
)