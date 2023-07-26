FROM openjdk:11
WORKDIR /app
ENV PORT 8080
EXPOSE 8080
ADD target/studentRegistrationApplication-0.0.1-SNAPSHOT.jar studentRegistrationApplication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "studentRegistrationApplication-0.0.1-SNAPSHOT.jar"]
