FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

COPY ../../settings.gradle ../../build.gradle ../../gradle.properties ./   # 루트 gradle 파일들
COPY ../../gradle ./gradle

COPY . .

RUN chmod +x ./gradlew && ./gradlew clean bootJar --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java","-XX:+UseContainerSupport","-XX:MaxRAMPercentage=75.0","-jar","/app/app.jar"]