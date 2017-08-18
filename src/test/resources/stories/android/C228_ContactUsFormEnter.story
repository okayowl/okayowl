Meta:
@smokeCycle
@debugMode

Narrative:
Open app, skipp onboarding and login, open contact us form

Scenario: Description (iOS) / Describe the issue you are having (Android)

Given приложение запущено
When войти с логином "#userName#" и паролем "#password#"
Then загружена страница "Booking"
When выполнено нажатие на "MenuButton"
Then на экране есть "HelpItemMenu"
When выполнено нажатие на "HelpItemMenu"
Then загружена страница "Help"
And на экране есть "DescriptionField"