package ru.colibri.ui.template.steps.ios;

import io.appium.java_client.ios.IOSElement;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.colibri.ui.core.fields.IElement;
import ru.colibri.ui.core.steps.AbsSteps;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

@Component
public class IOSHorizontalSwipe extends AbsSteps {

    @Step
    @When("горизонтальный свайп \"$elementName\" влево ios")
    public void swipingLeft(@Named("elementName") String elementName) {
        IElement element = getCurrentPage().getElementByName(elementName);
        WebElement webElement = finder.findWebElement(element);

        HashMap<String, String> map = new HashMap<>();
        map.put("direction", "left");
        map.put("element", ((IOSElement) webElement).getId());

        driver.executeScript("mobile: swipe", map);
    }

    @Step
    @When("горизонтальный свайп \"$elementName\" вправо ios")
    public void swipingRight(@Named("elementName") String elementName) {
        IElement element = getCurrentPage().getElementByName(elementName);
        WebElement webElement = finder.findWebElement(element);

        HashMap<String, String> map = new HashMap<>();
        map.put("direction", "right");
        map.put("element", ((IOSElement) webElement).getId());

        driver.executeScript("mobile: swipe", map);
    }
}
