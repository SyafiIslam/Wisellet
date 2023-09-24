package com.syafi.wisellet

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var showDialog = mutableStateOf(false)

    fun onFabClick() {
        showDialog.value= true
    }
}