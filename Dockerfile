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
FROM gcr.io/distroless/base-debian12:nonroot
WORKDIR /app
COPY --from=build /app/target/jb-site /app/jb-site
EXPOSE 8080
USER nonroot:nonroot
ENTRYPOINT ["/app/jb-site"]
