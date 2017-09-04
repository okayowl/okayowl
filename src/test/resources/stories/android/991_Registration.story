Meta:
@smokeCycle

Narrative:
Здесь можно писать доп информацию о сценарии

Scenario: Авторизация в приложение

Given приложение запущено
Then загружена страница "Booking"
When ожидаем 7 секунд
When выполнено нажатие на "MenuButton"
Then на экране есть "LogoutItemMenu"
When выполнено нажатие на "LogoutItemMenu"
Then загружена страница "Onboarding"
When ожидаем 5 секунд
When выполнено нажатие на "SignUp"
When ожидаем 2 секунд
Then на экране есть "RegEmailField"
When выполнено нажатие на "RegEmailField"
When ожидаем 2 секунд
When поле "RegEmailField" заполняется значением "*username**@test.com"
When выполнено нажатие на "RegPhoneField"
When поле "RegPhoneField" заполняется значением "*phonenumber*"
When выполнено нажатие на "RegPassField"
When поле "RegPassField" заполняется значением "testUSER1"
When выполнено нажатие на "RegNext"