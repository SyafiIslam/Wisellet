package com.syafi.wisellet.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.syafi.wisellet.model.Income
import com.syafi.wisellet.model.Transaction

@Database (
    entities = [Transaction::class, Income::class],
    version = 1
)
abstract class Database(): RoomDatabase() {
    abstract val dao: TransactionDao
}