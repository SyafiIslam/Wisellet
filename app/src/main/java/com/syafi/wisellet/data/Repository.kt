package com.syafi.wisellet.data

import com.syafi.wisellet.model.Income
import com.syafi.wisellet.model.Transaction
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun addTransaction(transaction: Transaction)
    suspend fun addIncome(income: Income)
    fun getAllTransaction(): Flow<List<Transaction>>
    fun getTotalByCategory(category: String): Flow<Long>
}