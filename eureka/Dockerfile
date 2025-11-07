FROM eclipse-temurin:21-jdk AS builder
WORKDIR /build

# 루트 프로젝트 파일 복사
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY gradlew ./
RUN chmod +x ./gradlew

# common 모듈 복사 (의존성)
COPY common ./common

# eureka 서비스 복사
COPY eureka ./eureka

# 빌드
RUN ./gradlew :eureka:clean :eureka:bootJar --no-daemon

# 실행 이미지
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /build/eureka/build/libs/*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]