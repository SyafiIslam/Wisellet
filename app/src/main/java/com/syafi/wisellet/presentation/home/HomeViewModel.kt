package com.syafi.wisellet.presentation.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.syafi.wisellet.data.Repository
import com.syafi.wisellet.util.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val transactions= repository.getAllTransaction()
    val totalIncome = repository.getTotalByCategory(Category.INCOME)
    val dateFormat= DateTimeFormatter.ofPattern("yyyy-MM-dd")
    var date by mutableStateOf("")
    var month by mutableStateOf("")

    fun formatLongWithDots(value: Long): String {
        val stringValue = value.toString()
        val length = stringValue.length

        if (length <= 3) {
            return stringValue
        }

        val formatted = StringBuilder()
        var dotCount = 0

        for (i in length - 1 downTo 0) {
            formatted.append(stringValue[i])

            if (++dotCount == 3 && i > 0) {
                formatted.append('.')
                dotCount = 0
            }
        }
        return formatted.reverse().toString()
    }

    fun formatDate(_date: String) {
        val localDate= LocalDate.parse(_date, dateFormat)
        date= localDate.dayOfMonth.toString()

        var _month= localDate.month.toString().lowercase()

        month= _month.replaceFirstChar {
            it.uppercase()
        }

    }
}