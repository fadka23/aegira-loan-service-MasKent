package com.blas.creditappdemo.ui.form.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SharedFormViewModel @Inject constructor() : ViewModel() {
    
    // Example form data
    private val _formData = MutableStateFlow(FormData())
    val formData: StateFlow<FormData> = _formData

    fun updateStep1(name: String) {
        _formData.value = _formData.value.copy(name = name)
    }

    // Add more update methods for other steps...
}

data class FormData(
    val name: String = "",
    val address: String = "",
    val income: Long = 0,
    val creditAmount: Long = 0
)