package com.blas.creditapp.data.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class ApiResponse<T>(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String?,
    @SerializedName("data") val data: T?
)

data class PageResponse<T>(
    @SerializedName("content") val content: List<T>,
    @SerializedName("pageNumber") val pageNumber: Int,
    @SerializedName("pageSize") val pageSize: Int,
    @SerializedName("totalElements") val totalElements: Long,
    @SerializedName("totalPages") val totalPages: Int
)

data class LoanApplicationListItemResponse(
    @SerializedName("id") val id: String,
    @SerializedName("applicationNumber") val applicationNumber: String,
    @SerializedName("customerName") val customerName: String,
    @SerializedName("requestedAmount") val requestedAmount: BigDecimal,
    @SerializedName("status") val status: String,
    @SerializedName("riskLevel") val riskLevel: String?,
    @SerializedName("submittedAt") val submittedAt: String?
)