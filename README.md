# API автотесты (Rest Assured + Cucumber + Allure)

Проект содержит API-автотесты для проверки регистрации, авторизации, выхода из системы
и публичного API Rick and Morty с Cucumber и генерацией отчетов через Allure.

---

## Стек технологий

* Java 17
* Maven
* JUnit 5
* Cucumber 
* Rest Assured
* Allure Report


---

## Запуск тестов

### Запуск всех тестов через Maven

Очистка проекта и выполнение всех Cucumber-сценариев:

```bash
mvn clean test
```

---

## Работа с Allure

### Генерация отчета

```bash
mvn allure:report
```

### Генерация и открытие отчета в браузере

```bash
mvn allure:serve
```

---

## Конфигурация

Основные параметры проекта задаются в файле:

```
src/test/resources/application.properties
```

В нем настраиваются:

* базовые URL API
* учетные данные пользователя
* пути к файлам с credentials

---


