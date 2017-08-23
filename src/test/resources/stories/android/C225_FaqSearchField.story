Meta:
@smokeCycle

Narrative:
Open app, skipp onboarding and login, open faq page, search for %any_element% , make sure search returns correct data

Scenario: FAQ screen

Given приложение запущено
Then загружена страница "Booking"
When ожидаем 7 секунд
When выполнено нажатие на "MenuButton"
Then на экране есть "HelpItemMenu"
When выполнено нажатие на "HelpItemMenu"
Then загружена страница "Help"
When выполнено нажатие на "FaqButton"
Then загружена страница "Faq"
Then на экране есть "FaqSearchInput"
When ожидаем 2 секунд
When выполнено нажатие на "FaqSearchInput"
When поле "FaqSearchInput" заполняется значением "Edit my profile"
When выполнено нажатие на Enter
Then значение элемента "SearchTitle" содержит "Edit my profile"