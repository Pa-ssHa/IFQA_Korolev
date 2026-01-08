# language: ru
Функционал: Проверка задачи TestSeleniumATHomework

  Структура сценария: Создание задачи и проверка деталей
    Когда я вхожу в систему с логином "<login>" и паролем "<password>"
    И перехожу в проект Test
    И создаю новую задачу
    Когда я ищу созданную задачу TestSeleniumATHomework
    И вижу имя задачи
    Тогда отображается статус задачи "<status>"
    Тогда отображается версия задачи "<version>"
    Примеры:
      | login | password  | status  | version     |
      | AT6   | Qwerty123 | СДЕЛАТЬ | Version 2.0 |