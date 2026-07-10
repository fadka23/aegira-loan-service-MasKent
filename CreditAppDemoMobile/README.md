# CreditAppDemo

CreditApp is a modern Android application demo designed for digital credit applications. It features a complete end-to-end flow from application listing to a multi-step submission process with simulated document verification and automated scoring results.

## 🚀 Features

- **Dashboard / Application List**: View all existing loan applications in a clean, card-based RecyclerView with status and risk level indicators.
- **Multi-Step Form Flow**: A seamless 4-step process for submitting new credit applications:
    1. **Formulir**: Interactive form with real-time validation.
    2. **Verifikasi Dokumen**: Simulated OCR and document authenticity check.
    3. **Processing**: Automated background scoring simulation.
    4. **Results**: Detailed scoring breakdown including risk indices and system recommendations.
- **Modern UI/UX**:
    - Full **Edge-to-Edge** support for a truly modern feel.
    - Jetpack **Navigation Component** for robust fragment transitions.
    - Material Design 3 components.
- **Robust Architecture**:
    - **Single Activity Architecture**.
    - **Clean Architecture** principles with clear separation of Data, Domain, and UI layers.
    - **Shared ViewModel** for consistent state management across the form flow.

## 🌐 API Documentation

The application integrates with two primary backend endpoints to manage the credit lifecycle.

### 1. Fetch Application List
- **Endpoint**: `GET /loan-applications`
- **Purpose**: Retrieves a paginated list of loan applications. This is used to populate the main dashboard, showing the customer name, requested amount, current status, and risk level.
- **Sample Response**:
```json
{
  "status": "success",
  "message": null,
  "data": {
    "content": [
      {
        "id": "550e8400-e29b-41d4-a716-446655440000",
        "applicationNumber": "APP-101",
        "customerName": "John Doe",
        "requestedAmount": 50000000,
        "status": "APPROVED",
        "riskLevel": "LOW",
        "submittedAt": "2026-05-01T10:00:00Z"
      }
    ],
    "pageNumber": 0,
    "pageSize": 10,
    "totalElements": 1,
    "totalPages": 1
  }
}
```

### 2. Submit Loan Application
- **Endpoint**: `POST /{id}/submit`
- **Purpose**: Submits the final credit application data for automated scoring. It triggers the background risk evaluation and returns the detailed scoring result.
- **Sample Response**:
```json
{
  "traceId": "uat-1714275000000-ab12cd",
  "evaluatedAt": "2026-04-28T02:00:00.000Z",
  "result": {
    "kolektibilitas": 1,
    "kolektibilitasLabel": "Lancar",
    "internalScore": 93,
    "breakdown": {
      "paymentHistory": 82,
      "income": 100,
      "debtToIncome": 100,
      "dtiRatio": 1.0
    },
    "recommendation": "Sangat baik: profil pembayaran lancar, layak diprioritaskan."
  }
}
```

## 🛠 Tech Stack

- **Language**: Kotlin
- **Dependency Injection**: Hilt
- **Networking**: Retrofit + Gson
- **Coroutines & Flow**: For asynchronous operations and reactive UI updates.
- **Jetpack Components**:
    - Navigation Component
    - ViewModel & LiveData/Flow
    - ViewBinding
    - Activity & Fragment KTX
- **Build System**: Gradle Kotlin DSL + Version Catalog (libs.versions.toml)

## 🏗 Setup & Installation

1. Clone the repository:
   ```bash
   git clone git@github.com:blasiusneri/CreditApp.git
   ```
2. Open the project in **Android Studio (Ladybug or newer)**.
3. Sync the project with Gradle files.
4. Run the app on an Emulator or physical device.

## 📝 Demo Notes

- The project uses a **Mock Repository** implementation by default. This allows you to experience the full flow without needing a live backend.
- To connect to a real server, simply update the `BASE_URL` in `NetworkModule.kt` and revert the mock implementation in `KreditRepositoryImpl.kt` to use the `LoanService`.

## 📸 Screenshots

- Loan List
<img width="308" height="679" alt="ListActivity" src="https://github.com/user-attachments/assets/ce8cdf79-5c83-4ec6-9a04-69434bd934e4" />

- Loan From Step 1
<img width="318" height="705" alt="LoanStep1" src="https://github.com/user-attachments/assets/f0db402b-3231-4501-888e-2b34b27b016e" />

- Loan From Step 2
<img width="316" height="704" alt="LoanStep2" src="https://github.com/user-attachments/assets/7cc495ec-8f98-486b-a938-beef8007703d" />

- Loan From Step 3
<img width="316" height="704" alt="LoanStep3" src="https://github.com/user-attachments/assets/50c957b0-a800-4607-b1d3-bfd5f3a07835" />

- Loan From Step 4
<img width="308" height="679" alt="LoanStep4" src="https://github.com/user-attachments/assets/86b7a262-937c-412d-9d24-37dd6c1f2e80" />



---
Developed by [Blasius Neri](https://github.com/blasiusneri)
