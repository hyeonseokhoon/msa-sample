FROM eclipse-temurin:21-jdk AS builder
WORKDIR /build

# 루트 프로젝트 파일 복사
COPY build.gradle settings.gradle gradle.properties ./
COPY gradle ./gradle
COPY gradlew ./
RUN chmod +x ./gradlew

# common 모듈 복사 (의존성)
COPY common ./common

# accommodation 서비스 복사
COPY accommodation ./accommodation

# 빌드
RUN ./gradlew :accommodation:clean :accommodation:bootJar --no-daemon

# 실행 이미지
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /build/accommodation/build/libs/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]