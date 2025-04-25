FROM maven:3.9-eclipse-temurin-21-alpine as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-alpine
VOLUME /tmp
EXPOSE 8080
COPY --from=build /app/target/bluepoints-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]