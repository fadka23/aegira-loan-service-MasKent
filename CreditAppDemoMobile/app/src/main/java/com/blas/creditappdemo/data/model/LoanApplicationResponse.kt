package com.blas.creditapp.data.model

import com.google.gson.annotations.SerializedName

data class LoanApplicationResponse(
    @SerializedName("traceId") val traceId: String = "",
    @SerializedName("evaluatedAt") val evaluatedAt: String = "",
    @SerializedName("result") val result: ScoringResult = ScoringResult()
)

data class ScoringResult(
    @SerializedName("kolektibilitas") val kolektibilitas: Int = 0,
    @SerializedName("kolektibilitasLabel") val kolektibilitasLabel: String = "",
    @SerializedName("internalScore") val internalScore: Int = 0,
    @SerializedName("breakdown") val breakdown: ScoreBreakdown = ScoreBreakdown(),
    @SerializedName("recommendation") val recommendation: String = ""
)

data class ScoreBreakdown(
    @SerializedName("paymentHistory") val paymentHistory: Int = 0,
    @SerializedName("income") val income: Int = 0,
    @SerializedName("debtToIncome") val debtToIncome: Int = 0,
    @SerializedName("dtiRatio") val dtiRatio: Double = 0.0
)