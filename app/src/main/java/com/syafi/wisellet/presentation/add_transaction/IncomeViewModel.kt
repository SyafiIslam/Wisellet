package com.syafi.wisellet.presentation.add_transaction

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syafi.wisellet.data.Repository
import com.syafi.wisellet.model.Income
import com.syafi.wisellet.model.Transaction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class IncomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    var dateValue by mutableStateOf(LocalDate.now().toString())
        private set

    var amoutValue by mutableStateOf("")
        private set

    var descriptionValue by mutableStateOf("")
        private set

    var titleValue by mutableStateOf("")
        private set


    fun dateChange(date: String) {
        dateValue= date
    }

    fun amountChange(amount: String) {
        amoutValue= amount
    }

    fun descriptionChange(description: String) {
        descriptionValue= description
    }

    fun titleChange(title: String) {
        titleValue= title
    }

    suspend fun onSaveClick(context: Context) {
        val date= dateValue
        val amount= amoutValue
        val title= titleValue
        val description= descriptionValue

        if (date.isBlank() || amount.isBlank() || description.isBlank() || title.isBlank()) {
            Toast.makeText(context, "⚠️ Fill all data ⚠️", Toast.LENGTH_SHORT).show()
            return
        }

        val transaction= Transaction(
            date= date,
            amount = amount.toLong(),
            description = description,
            title = title
        )

        viewModelScope.launch {
            repository.addTransaction(transaction)
        }
        Toast.makeText(context, "✅ Success", Toast.LENGTH_SHORT).show()
        delay(1000)
        return
    }
}

