Meta:
@regressCycle

Narrative:
Open app, skipp onboarding and login, open contact us form

Scenario: Description (iOS) / Describe the issue you are having (Android)

Given приложение запущено
Then загружена страница "Booking"
When ожидаем 7 секунд
When выполнено нажатие на "MenuButton"
Then на экране есть "HelpItemMenu"
When выполнено нажатие на "HelpItemMenu"
Then загружена страница "Help"
When выполнено нажатие на "ContactUsButton"
Then на экране есть "DescriptionField"