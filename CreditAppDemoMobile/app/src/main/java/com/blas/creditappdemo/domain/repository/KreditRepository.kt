package com.blas.creditappdemo.domain.repository

import com.blas.creditapp.data.model.ApiResponse
import com.blas.creditapp.data.model.LoanApplicationListItemResponse
import com.blas.creditapp.data.model.LoanApplicationRequest
import com.blas.creditapp.data.model.LoanApplicationResponse
import com.blas.creditapp.data.model.PageResponse
import com.blas.creditappdemo.data.model.KreditResponse

interface KreditRepository {
    suspend fun submitLoanApplication(id: String, request: LoanApplicationRequest): LoanApplicationResponse
    suspend fun getAllApplications(page: Int, size: Int): ApiResponse<PageResponse<LoanApplicationListItemResponse>>
}