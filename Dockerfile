FROM maven:3.8.2-jdk-11-slim
WORKDIR /.
ENV PORT 8080
EXPOSE 8080
COPY . .
CMD sleep 15
RUN mvn clean install
CMD mvn spring-boot:run
