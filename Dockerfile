FROM openjdk:17

WORKDIR /app

COPY ./target/loglemon-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "loglemon-0.0.1-SNAPSHOT.jar"]