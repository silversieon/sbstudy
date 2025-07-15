# 1단계: JAR 파일 복사
FROM openjdk:21-jdk-slim AS builder
WORKDIR /app
COPY build/libs/*SNAPSHOT.jar app.jar

# 2단계: 실제 실행
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/app.jar app.jar
ENTRYPOINT ["/bin/bash", "-c", "sleep 5000"]