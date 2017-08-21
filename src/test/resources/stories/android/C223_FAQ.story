Meta:
@smokeCycle
@debugMode

Narrative:
Open app, skipp onboarding and login, open faq page

Scenario: FAQ screen

Given приложение запущено
When войти с логином "#userName#" и паролем "#password#"
Then загружена страница "Booking"
When ожидаем 7 секунд
When выполнено нажатие на "MenuButton"
Then на экране есть "HelpItemMenu"
When выполнено нажатие на "HelpItemMenu"
Then загружена страница "Help"
When выполнено нажатие на "FaqButton"
Then загружена страница "Faq"
Then на экране есть "FaqSearchInput"