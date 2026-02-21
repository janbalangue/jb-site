# ---- Build stage (native) ----
FROM ghcr.io/graalvm/native-image-community:21 AS build
WORKDIR /app
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw mvnw
RUN ./mvnw -q -DskipTests dependency:go-offline
COPY src ./src
RUN ./mvnw -q -Pnative -DskipTests native:compile


# ---- Run stage (native) ----
FROM debian:bookworm-slim
WORKDIR /app
RUN apt-get update \
  && apt-get install -y --no-install-recommends zlib1g ca-certificates \
  && rm -rf /var/lib/apt/lists/*

COPY --from=build /app/target/jb-site /app/jb-site
EXPOSE 8080
RUN useradd -r -u 10001 appuser && chown -R appuser:appuser /app
USER appuser
ENTRYPOINT ["/app/jb-site"]
