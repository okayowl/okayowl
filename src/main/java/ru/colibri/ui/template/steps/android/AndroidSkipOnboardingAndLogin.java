package ru.colibri.ui.template.steps.android;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.colibri.ui.steps.general.ButtonsSteps;
import ru.colibri.ui.steps.general.PagesSteps;
import ru.colibri.ui.steps.general.TextFieldSteps;
import ru.colibri.ui.steps.general.WaitSteps;
import ru.yandex.qatools.allure.annotations.Step;


@Component
@Qualifier("android")
public class AndroidSkipOnboardingAndLogin {

    private final String loginFieldName = "email";
    private final String passwordFieldName = "password";
    private final String submitButtonName = "Login";
    private final String skipButtonName = "skipButton";
    private final String loginButtonName = "loginButton";
    private final String pageName = "Onboarding";

    @Autowired
    private ButtonsSteps buttonsSteps;
    @Autowired
    private TextFieldSteps textFieldSteps;
    @Autowired
    private WaitSteps waitSteps;
    @Autowired
    private PagesSteps pagesSteps;

    @Step
    @When("войти с логином \"$login\" и паролем \"$password\"")
    public void loginToAppWithPassword(@Named("$login") String login, @Named("$password") String password) throws InterruptedException {
        skipOnboarding();
        textFieldSteps.sendKeys(loginFieldName, login);
        textFieldSteps.sendKeys(passwordFieldName, password);
        buttonsSteps.buttonClick(submitButtonName);
    }

    private void skipOnboarding() throws InterruptedException {
        pagesSteps.pageLoaded(pageName);
        pagesSteps.checkElement(skipButtonName);
        buttonsSteps.buttonClick(skipButtonName);
        waitSteps.waitSomeTime(1);
        buttonsSteps.buttonClick(skipButtonName);
        buttonsSteps.buttonClick(loginButtonName);
    }

}