FROM eclipse-temurin:21-jdk AS builder
WORKDIR /build

COPY ../../build.gradle ../../settings.gradle ../../gradle.properties ./
COPY ../../gradle ./gradle

COPY . ./apps/eureka

# gradlew 복사 (루트에 있다고 가정)
COPY ../../gradlew ./gradlew
RUN chmod +x ./gradlew

# 멀티모듈 전체 빌드 중 reservation 모듈만 빌드
RUN ./gradlew :apps:eureka:clean :apps:eureka:bootJar --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java","-XX:+UseContainerSupport","-XX:MaxRAMPercentage=75.0","-jar","/app/app.jar"]