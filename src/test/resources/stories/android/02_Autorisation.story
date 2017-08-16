Meta:
@smokeCycle
@debugMode

Narrative:
Open app, skipp onboarding and login

Scenario: Authorisation

Given приложение запущено
Then загружена страница "Onboarding"
When выполнено нажатие на "skipButton"
And выполнено нажатие на "skipButton"
And выполнено нажатие на "loginButton"
And поле "email" заполняется значением "#userName#"
And поле "password" заполняется значением "#password#"
When выполнено нажатие на "Login"
Then загружена страница "Booking"
