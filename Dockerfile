FROM openjdk:17

WORKDIR /app

COPY build/libs/weather-sensor-service-1.0.0.jar weather-sensor-service.jar

CMD ["java", "-jar", "weather.jar"]