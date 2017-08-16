package ru.colibri.ui.template.steps.android;

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
public class AndroidServiceSteps extends AbsServiceSteps {
    @Autowired
    private DriversSettings driversSettings;

    @Autowired
    private PagesSteps pagesSteps;

    @Autowired
    @Qualifier("android")
    private ISystemButtonsClick systemButtonsClick;


    private String alertLocator = "//*[@text='Закрыть']";


    @Override
    protected ISystemButtonsClick getISystemButtonsClickBean() {
        return systemButtonsClick;
    }


    @Override
    protected DriversSettings getDriversSettings() {
        return driversSettings;
    }

    @Override
    protected String getAlertLocator() {
        return alertLocator;
    }

    @Step
    @Given("вернуться на \"$screenName\"")
    public void goToScreen(@Named("$screenName") String screenName) {
        goToMain(screenName);
    }

    protected void returnCycle(String screenName) {
        boolean up = true;

        do {
            try {
                //обрабатываем аллерт
                finder.findWebElement(By.xpath(getAlertLocator())).click();
            } catch (Exception ignored) {
            }
            try {
                //проверяем что загружена главная
                pagesSteps.pageLoaded(screenName);
                up = false;
            } catch (Exception e) {
                try {
                    //если не загружена, пытаемся нажать кнопку "Назад"
                    getISystemButtonsClickBean().systemBackClick();
                } catch (Exception ignored) {

                }
            }

        }
        while (up);
    }
}
