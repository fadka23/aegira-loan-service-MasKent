# # Build stage
# FROM maven:3.8.8-eclipse-temurin-8 AS build
# WORKDIR /app
# COPY pom.xml .
# COPY src ./src
# RUN mvn -B -DskipTests clean package

# # Runtime stage
# FROM eclipse-temurin:8-jre-alpine
# WORKDIR /app
# COPY --from=build /app/target/*.jar app.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "app.jar"]

FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]