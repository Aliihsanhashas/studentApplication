# Build stage
FROM openjdk:11-jdk-slim AS build
WORKDIR /app
COPY . .
RUN ./mvnw -DskipTests clean package

# Final stage
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/studentRegistrationApplication-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]