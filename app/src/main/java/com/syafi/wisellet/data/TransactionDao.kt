package com.syafi.wisellet.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.syafi.wisellet.model.Income
import com.syafi.wisellet.model.Transaction
import com.syafi.wisellet.util.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Upsert
    suspend fun addTransaction(transaction: Transaction)

    @Upsert
    suspend fun addIncome(income: Income)

    @Query("SELECT * FROM `transaction`")
    fun getAllTransaction(): Flow<List<Transaction>>

    @Query("SELECT SUM(amount) FROM `transaction` WHERE `category` == :category")
    fun getTotalByCategory(category: String): Flow<Long>
}