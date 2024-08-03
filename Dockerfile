FROM openjdk:17

RUN mkdir /app

COPY target/ /app

WORKDIR /app

CMD java -jar Capstone-Project-0.0.1-SNAPSHOT.jar --spring.config.name=application.properties