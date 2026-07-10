package com.blas.creditappdemo.data.repository

import com.blas.creditapp.data.model.ApiResponse
import com.blas.creditapp.data.model.LoanApplicationListItemResponse
import com.blas.creditapp.data.model.LoanApplicationRequest
import com.blas.creditapp.data.model.LoanApplicationResponse
import com.blas.creditapp.data.model.PageResponse
import com.blas.creditapp.data.model.ScoreBreakdown
import com.blas.creditapp.data.model.ScoringResult
import com.blas.creditappdemo.data.remote.LoanService
import com.blas.creditappdemo.domain.repository.KreditRepository
import java.math.BigDecimal
import java.time.OffsetDateTime
import javax.inject.Inject

class KreditRepositoryImpl @Inject constructor(
    private val apiService: LoanService
) : KreditRepository {
    //submit app application response mocked
    override suspend fun submitLoanApplication(id: String, request: LoanApplicationRequest): LoanApplicationResponse {
        return LoanApplicationResponse()
    }

    //get app application response mocked
    override suspend fun getAllApplications(page: Int, size: Int): ApiResponse<PageResponse<LoanApplicationListItemResponse>> {
        val vehicles = (1..14).map { "Kendaraan $it" }
        val statuses = listOf("APPROVED", "IN_REVIEW", "REJECTED", "SUBMITTED")
        val risks = listOf("LOW", "MEDIUM", "HIGH", "VERY_HIGH")

        val mockItems = vehicles.mapIndexed { index, name ->
            LoanApplicationListItemResponse(
                id = java.util.UUID.randomUUID().toString(),
                applicationNumber = "APP-${100 + index}",
                customerName = name,
                requestedAmount = BigDecimal((10..100).random() * 1000000),
                status = statuses[index % statuses.size],
                riskLevel = risks[index % risks.size],
                submittedAt = "2026-05-${String.format("%02d", (index % 28) + 1)}T10:00:00Z"
            )
        }

        return ApiResponse(
            status = "success",
            message = null,
            data = PageResponse(
                content = mockItems,
                pageNumber = page,
                pageSize = size,
                totalElements = mockItems.size.toLong(),
                totalPages = 1
            )
        )
    }
}