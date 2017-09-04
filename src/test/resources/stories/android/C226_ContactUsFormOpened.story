Meta:
@regressCycle

Narrative:
Open app, skipp onboarding and login, open contact us form, check if contact us page is opened

Scenario: Contact us page is opened

Given приложение запущено
Then загружена страница "Booking"
When ожидаем 7 секунд
When выполнено нажатие на "MenuButton"
Then на экране есть "HelpItemMenu"
When выполнено нажатие на "HelpItemMenu"
Then загружена страница "Help"
When выполнено нажатие на "ContactUsButton"
Then на экране есть "DescriptionField"
Then загружена страница "ContactUs"
