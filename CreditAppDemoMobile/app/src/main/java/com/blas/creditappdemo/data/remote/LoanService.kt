package com.blas.creditappdemo.data.remote

import com.blas.creditapp.data.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LoanService {

    @POST("{id}/submit")
    suspend fun submitLoanApplication(
        @Path("id") id: String,
        @Body request: LoanApplicationRequest
    ): LoanApplicationResponse

    @GET("loan-applications")
    suspend fun getAllApplications(
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("status") status: String? = null,
        @Query("risk_level") riskLevel: String? = null,
        @Query("customer_name") customerName: String? = null,
        @Query("application_number") applicationNumber: String? = null
    ): ApiResponse<PageResponse<LoanApplicationListItemResponse>>
}