FROM eclipse-temurin:17-jdk AS builder
WORKDIR /build

# 루트 프로젝트 파일 복사
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY gradlew ./
RUN chmod +x ./gradlew

# common 모듈 복사 (의존성)
COPY common ./common

# config 서비스 복사
COPY config ./config

# 빌드
RUN ./gradlew :config:clean :config:bootJar --no-daemon

# 실행 이미지
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /build/config/build/libs/*.jar app.jar

COPY config-repo /app/config-repo

EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]