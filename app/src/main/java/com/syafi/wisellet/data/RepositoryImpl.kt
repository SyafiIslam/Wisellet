package com.syafi.wisellet.data

import com.syafi.wisellet.model.Income
import com.syafi.wisellet.model.Transaction
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val dao: TransactionDao
): Repository {
    override suspend fun addTransaction(transaction: Transaction) {
        dao.addTransaction(transaction)
    }

    override suspend fun addIncome(income: Income) {
        dao.addIncome(income)
    }

    override fun getAllTransaction(): Flow<List<Transaction>> {
        return dao.getAllTransaction()
    }

    override fun getTotalByCategory(category: String): Flow<Long> {
        return dao.getTotalByCategory(category)
    }
}