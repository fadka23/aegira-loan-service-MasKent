# # Build stage
# FROM eclipse-temurin:17-jdk-alpine AS builder
# WORKDIR /app

# # Copy Maven wrapper and pom
# COPY mvnw pom.xml ./
# COPY .mvn .mvn

# # Download dependencies (cached layer)
# RUN ./mvnw dependency:go-offline -B

# # Copy source and build
# COPY src ./src
# RUN ./mvnw clean package -DskipTests -B

# # Runtime stage
# FROM eclipse-temurin:17-jre-alpine
# WORKDIR /app

# # Copy the built JAR from builder
# COPY --from=builder /app/target/*.jar app.jar

# EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "app.jar"]

FROM myoung34/github-runner:latest
USER root
RUN apt-get update && \
    apt-get install -y \
    openjdk-17-jdk \
    maven \
    curl \
    git
RUN curl -fsSL https://deb.nodesource.com/setup_20.x | bash - && \
    apt-get install -y nodejs
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH
USER root