# UI автотесты (Selenide + JUnit + Allure)

Проект содержит UI-автотесты для https://edujira.ifellow.ru с генерацией отчетов через **Allure**.

---

## Стек технологий
- Java 21
- Maven
- JUnit 
- Selenide
- Allure Report

---

## Команды для запуска тестов
### Сбор тестов через maven
Очистка проекта и запуск всех тестов
```bash
mvn clean test
```
### Работа с Allure
Создание отчета  
```bash
mvn allure:report
```
Создание отчета и его открытие  
```bash
mvn allure:serve
```