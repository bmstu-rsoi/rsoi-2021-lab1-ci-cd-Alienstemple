#FROM openjdk:11-jdk as builder
#WORKDIR application
#ARG JAR_FILE=target/lab1-cicd-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} application.jar
#RUN java -jar application.jar
##RUN java -Djarmode=layertools -jar application.jar extract
#
#FROM openjdk:11-jdk
#ENV PORT=8080
#WORKDIR application
#COPY --from=builder application/spring-boot-loader/ ./
#COPY --from=builder application/dependencies/ ./
#COPY --from=builder application/snapshot-dependencies/ ./
#COPY --from=builder application/application/ ./
#ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-Xmx512m", "-Xms512m", "org.springframework.boot.loader.JarLauncher"]

# Build stage
FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true
# TODO: add test

# Package stage
FROM openjdk:16-alpine3.13
COPY --from=build /home/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]