# Colibri-ui-template

## Папки проекта:
* *enviroment* - содержит описания девайсов и нод для запуска фреймворка на устройствах
* *pages* - содержит описания экранов приложений 
* *planTestCycle* - содержит перечень флагов для фильтрации story по meta-данным
```
плюс <имя метки> - добавить story в выборку
минус <имя метки> - исключить story в выборку
```
* *stories* - папка для размещения сценариев
* *users* - описание юзеров

## Локальный запуск и запуск на CI

Локальный запуск осуществляется на порту 4723.
Запуск на CI в конфигурации с хабом запускается на порту хаба - 5566.

Selenium Server Standalone надо разместить по адресу /scripts/selenium-server-standalone-3.0.1.jar
Порт общения с девайсом задается в файлах /environment/def/environment*.properties


## Для запуска хаба:
1) заходим в корень проекта, папка в которой лежит build.gradle;
2) в консоли выполняем
```
sh scripts/start_hub.sh
```

Результат удачного запуска: появился файл seleniumhub.pid в папке scripts и соответствующие логи в консоли

## Для запуска ноды:
1) заходим в корень проекта, папка в которой лежит build.gradle;
2) в консоли выполняем 'sh scripts/start_node.sh &lt;запускаемая_платформа&gt; &lt;порт&gt;'
Например,
```
sh scripts/start_node.sh ios10 4726
sh scripts/start_node.sh android5 4721
```

Результат удачного запуска: появился файл appium.pid в папке ресурсов соответствующей платформы и логи в консоли

## Для остановки ноды (пока не работает):
1) заходим в корень проекта, папка в которой лежит build.gradle;
2) в консоли выполняем 
```
sh scripts/stop.sh &lt;платформа&gt;
```

Результат удачного запуска: исчез файл appium.pid в папке ресурсов соответствующей платформы и есть логи в консоли об остановке процесса

## Пример команды для запуска проекта на локальном ПК (MAC):
```
1) ./gradlew --info clean test --tests "*AndroidStories*" -Dorg.gradle.project.platform=android5 -Dorg.gradle.project.user=6016680 -Dorg.gradle.project.testType=smoke -Dorg.gradle.project.buildVersion=8.4.0.0-SNAPSHOT
2) ./gradlew --info clean test --tests "*AndroidStories*" -Dorg.gradle.project.platform=android4 -Dorg.gradle.project.user=5773935 -Dorg.gradle.project.testType=smoke -Dorg.gradle.project.buildVersion=8.4.0.0-SNAPSHOT
3) ./gradlew --info clean test --tests "*IOSStories*" -Dorg.gradle.project.platform=ios10.2 -Dorg.gradle.project.user=1907306 -Dorg.gradle.project.testType=regress -Dorg.gradle.project.buildVersion=8.3_7426
```
## Команды для быстрого уничтожения кластера в системе 
kill seleniumhub.pid
kill appium.pid

## Добавление устройства

Для автотестирования на новом (который не был добавлен ранее) устройстве, добавьте новую папку в раздел проекта по аналогии с существующими
```
/src/test/resources/environment
```
В файле device.properties нужно прописать имя устройства, его udid и порт. первые два параметра можно найти в окне Window->Devices в Xcode для iOS-устройств. Порт присваивается икрементально от последнего добавленного.
Стоит обратить внимание, что добавленное устройство iOS также должно быть добавлено в сертификат разработки - добавить могут ios-разработчики команды. 



## Подпись драйвера Appium (iOS)

В случае ios, нужно переподписать приложение драйвера и раннера appium-а сертификатом разработчика. Для этого нужно быть добавленным сертификат разработчиков - добавить могут ios-разработчики команды. 
По данном адресу
/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/
Необходимо открыть при помощи xcode файл с расширением .xcodeproj, выбрать верхний пункт в левой панели и установить Team в двух элементах из раздела Targets - WebDriverAgentLib и WebDriverAgentRunner. В выпадающем списке выберите любой сертификат разработчика с возможностью установки приложения на реальный девайс.
Для работы с симулятором подобный сертификат не обязателен.


###  FAQ по написаию тестов
##### Чтобы найти Activity:
1) подключаем телефон через usb
2) запускаем приложеньку и переходим на интересующий нас экран
3) команду в терминале

```
adb shell dumpsys window windows | grep -E 'mCurrentFocus'
```
##### Чтобы узнать UUID подключенного девайса

Android
```
adb devices
```

iOS
```
железки (все кроме симуляторов и текущего бука)
instruments -s devices | grep -v (Simulator|$(id -un))

симуляторы
instruments -s devices | grep Simulator
```

##### Монитор для андроида

```open ~/Library/Android/sdk/tools/monitor```

##### Остановить все процессы
```
pkill -f selenium
pkill -f appium
```

# Генерация отчета allure
Вначале cd в корень проекта
```
allure generate target/allure-results -clean
ПУТЬ_ДО_КОРНЯ_ПРОЕКТА/build/reports/allure-report/index.html#
```

# Локальный запуск в IDE

1. Запускаем appium в консоли. `appium`
2. В файлах environmentAndroid/environmentIOS меняем порт с 5566 на 4723
3. Заходим в Edit Configuration и настраиваем значения в Environment variables устанавливаем значение, например `platform=ios10sim;user=1907306;testType=debugMode;buildVersion=9.1_8361`. Аналогично каждый параметр можно выставаить в табличном виде, нажав на три точки в конце этой строки.

# Usefull scripts
##### Показать клаву (изменить на нативную)
```
adb shell ime set com.android.inputmethod.latin/.LatinIME
```