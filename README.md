## Конфигурация
- Java
- Selenide
- Allure
- TestNG
- AssertJ
- Gradle

Для корректной работы автотестов нужно в файл ``src/test/resources/conf.properties`` записать логин и пароль существующего тестовго пользователя

Пример:
* user_login=test_login@test.com
* user_password=test_password
## Тестовая среда

UI тесты запускаются на локальном стенде html файла:
``src/test/resources/qa-test.html``

# Запуск автотестов

* Для запуска автотестов в консоли нужно ввести команду:
``./gradlew clean test -DtestSuite=RegressionSuite``
* Для генерации allure отчета, после прогона автотестов, в консоли нужно ввести команду:
``allure serve build/allure-results``

### Проект демонстрирует:
- Page Object Model 
- Component-based архитектура 
- Fluent API для читаемости тестов 
- Data-driven testing 
- Soft assertions 
- Переиспользуемые UI-компоненты