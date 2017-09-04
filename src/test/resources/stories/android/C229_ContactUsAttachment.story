Meta:
@smokeCycle
Narrative:
Open app, proceed to Help > Contact us > Check for ability to add attachments

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
When выполнено нажатие на "AddAttachment"
Then на экране есть "TakePhotoText"
When ожидаем 1 секунд
Then на экране есть "ChooseExText"