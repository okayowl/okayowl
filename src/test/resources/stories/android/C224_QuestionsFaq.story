Meta:
@smokeCycle

Narrative:
Open app, skipp onboarding and login, open faq page

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
When выполнено нажатие на "QuestionsButton"
Then количество найденных элементов "QuestionsSections" равно "4"