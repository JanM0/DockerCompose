FROM maven:3.6.3-openjdk-8 as builder
WORKDIR /usr/src/app
COPY src ./src
COPY pom.xml ./
RUN mvn clean package -Dmaven.test.skip=true
 
FROM openjdk:8-jdk-alpine
#WORKDIR /usr/src/app/
COPY --from=builder /usr/src/app/target/*.jar /usr/src/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/app.jar" ]