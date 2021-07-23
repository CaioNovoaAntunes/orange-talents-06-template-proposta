FROM openjdk:11
WORKDIR app
EXPOSE 8080
ADD target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]