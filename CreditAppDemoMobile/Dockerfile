FROM ghcr.io/cirruslabs/android-sdk:35

WORKDIR /workspace

COPY gradle gradle
COPY gradlew gradlew
COPY gradle.properties settings.gradle.kts build.gradle.kts ./
COPY app app

RUN chmod +x gradlew

CMD ["./gradlew", "--no-daemon", "testDebugUnitTest", "assembleDebug"]