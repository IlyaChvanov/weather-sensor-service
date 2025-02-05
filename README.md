
# Weather Sensor Service

## Описание проекта
Этот проект представляет собой веб-сервис для управления сенсорами и измерениями погоды. Он позволяет сенсорам регистрироваться, а также отправлять данные о измерениях (например, дождливые дни) через API. Все запросы защищены с помощью JWT аутентификации.

## Инструкции по сборке и запуску через Docker

### Шаги для сборки и запуска через Docker:
1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/IlyaChvanov/weather-sensor-service.git
   cd weather-sensor-service
Соберите проект с помощью Gradle:

```bash

./gradlew build
```

Запустите контейнер с помощью Docker Compose:

```bash
docker-compose up
```
Теперь приложение доступно по адресу: http://localhost:8080

### Примеры использования API

Аутентификация
POST /sensors/sign-in
Сенсор аутентифицируется для получения JWT токена.

Request:
```json

{
  "name": "sensor_name",
  "password": "sensor_password"
}
```
Response:
```json

{
  "token": "your_jwt_token"
}
```

POST /sensors/registration
Регистрация нового сенсора.

Request:
```json

{
  "name": "new_sensor_name",
  "password": "new_sensor_password"
}
```
Response:
```json

{
  "message": "Sensor registered successfully"
}
```
Measurement Controller
POST /measurements/add

Добавить новое измерение.

Request Body:
```json

{
  "value": 0,
  "raining": true,
  "sensor": {
    "name": "sensor_name"
  }
}
```
Response:
```json

{
  "value": 0,
  "raining": true,
  "sensor": {
    "name": "sensor_name"
  }
}
```
GET /measurements
Получить все измерения.

GET /measurements/DaysCount
Получить количество дождливых дней.

### Схемы данных
SignInRequest — запрос на аутентификацию сенсора.
JwtAuthenticationResponse — ответ с JWT токеном.
SignUpRequest — запрос на регистрацию сенсора.
MeasurementDto — данные измерения.
SensorDto — данные сенсора.
Документация Swagger
Документация API доступна через Swagger UI по адресу: http://localhost:8080/swagger-ui.html.
