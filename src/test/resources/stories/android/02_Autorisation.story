Meta:
@smokeCycle
@debugMode

Narrative:
Open app, skipp onboarding and login

Scenario: Authorisation

Given приложение запущено
When войти с логином "#userName#" и паролем "#password#"
Then загружена страница "Booking"
