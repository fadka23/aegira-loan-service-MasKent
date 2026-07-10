package com.blas.creditappdemo.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blas.creditapp.data.model.LoanApplicationListItemResponse
import com.blas.creditappdemo.domain.repository.KreditRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoanListViewModel @Inject constructor(
    private val repository: KreditRepository
) : ViewModel() {

    private val _loanApplications = MutableStateFlow<List<LoanApplicationListItemResponse>>(emptyList())
    val loanApplications: StateFlow<List<LoanApplicationListItemResponse>> = _loanApplications

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun loadApplications() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = repository.getAllApplications(0, 10)
                _loanApplications.value = response.data?.content ?: emptyList()
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
}