package ru.colibri.ui.template.steps.ios;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.colibri.ui.core.settings.DriversSettings;
import ru.colibri.ui.steps.general.AbsServiceSteps;
import ru.colibri.ui.steps.general.ISystemButtonsClick;
import ru.colibri.ui.steps.general.PagesSteps;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class IOSServiceSteps extends AbsServiceSteps {
    @Autowired
    private DriversSettings driversSettings;

    @Autowired
    private PagesSteps pagesSteps;

    @Autowired
    @Qualifier("ios")
    private ISystemButtonsClick systemSteps;

    private String alertLocator = "//*[@name='Разрешить' or @name='OK']";


    @Step
    @Given("вернуться на \"$screenName\"")
    public void goToScreen(@Named("$screenName") String screenName) {
        goToMain(screenName);
    }

    @Override
    protected void returnCycle(String screenName) {
        boolean up = true;

        do {
            try {
                //проверяем что загружена главная
                pagesSteps.pageLoaded(screenName);
                up = false;
            } catch (Exception e) {
                try {
                    //если не загружена, пытаемся нажать кнопку "Назад"
                    getISystemButtonsClickBean().systemBackClick();
                } catch (Exception ignored) {
                    try {
                        //обрабатываем аллерт
                        finder.findWebElement(By.xpath(getAlertLocator())).click();
                    } catch (Exception ignored2) {
                    }
                }
            }

        }
        while (up);
    }

    @Override
    protected ISystemButtonsClick getISystemButtonsClickBean() {
        return systemSteps;
    }

    @Override
    protected String getAlertLocator() {
        return alertLocator;
    }

    @Override
    protected DriversSettings getDriversSettings() {
        return driversSettings;
    }
}
