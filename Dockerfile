# ---- Build stage: compile the Spring Boot jar with Maven + JDK 21 ----
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /build

# Copy the POM first and pre-fetch dependencies so this layer is cached
# and only re-runs when pom.xml changes (not on every source edit).
COPY pom.xml .
RUN mvn -q -B dependency:go-offline

# Now copy sources and build the jar (skip tests — they run in CI/locally).
COPY src ./src
RUN mvn -q -B clean package -DskipTests

# ---- Run stage: small JRE image that just runs the jar ----
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the built jar (wildcard keeps this version-agnostic).
COPY --from=build /build/target/*.jar app.jar

# Documentation only; the real port comes from $PORT at runtime.
EXPOSE 8080

# Bind to the platform's injected $PORT (Render/railway/etc.), falling back
# to 8080 locally. This is why no change to application.properties is needed.
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
