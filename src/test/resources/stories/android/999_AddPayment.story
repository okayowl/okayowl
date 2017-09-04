Meta:
@smokeCycle
@debugMode

Narrative:
App opens, a new online card adds to payments

Scenario: Авторизация в приложение

Given приложение запущено
Then загружена страница "Booking"
When ожидаем 8 секунд
When выполнено нажатие на "MenuButton"
Then на экране есть "PaymentItemMenu"
When выполнено нажатие на "PaymentItemMenu"
Then загружена страница "PaymentList"
When ожидаем 3 секунд
When выполнено нажатие на "AddNewCard"
Then загружена страница "Payment"
Then на экране есть "EnterCardNumber"
When поле "EnterCardNumber" заполняется значением "4242424242424242"
Then на экране есть "Expiry"
When поле "Expiry" заполняется значением "*DD/MM*"
Then на экране есть "CVV"
When поле "CVV" заполняется значением "*CVV*"
Then на экране есть "Postcode"
When поле "Postcode" заполняется значением "*Postcode*"
When выполнено нажатие на "NewCardConfirm"
When ожидаем 5 секунд