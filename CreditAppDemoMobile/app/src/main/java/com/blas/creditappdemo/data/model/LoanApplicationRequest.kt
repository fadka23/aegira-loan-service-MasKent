package com.blas.creditapp.data.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class LoanApplicationRequest(
    @SerializedName("fullName") val fullName: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("monthlyIncome") val monthlyIncome: BigDecimal,
    @SerializedName("totalCurrentInstallment") val totalCurrentInstallment: BigDecimal,
    @SerializedName("requestedAmount") val requestedAmount: BigDecimal,
    @SerializedName("loanPurpose") val loanPurpose: String,
    @SerializedName("paymentHistory") val paymentHistory: String
)