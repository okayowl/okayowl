package ru.colibri.ui.template.steps.android;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.colibri.ui.steps.general.ButtonsSteps;
import ru.colibri.ui.steps.general.TextFieldSteps;
import ru.yandex.qatools.allure.annotations.Step;


@Component
@Qualifier("android")
public class AndroidCompositeStepsTemplate {

    private final String loginFieldName = "email";
    private final String passwordFieldName = "password";
    private final String submitButtonName = "Login";
    @Autowired
    private ButtonsSteps buttonsSteps;
    @Autowired
    private TextFieldSteps textFieldSteps;

    @Step
    @When("1войти с логином \"$login\" и паролем \"$password\"")
    public void loginToAppWithPassword(@Named("$login") String login, @Named("$password") String password) {
        textFieldSteps.sendKeys(loginFieldName, login);
        textFieldSteps.sendKeys(passwordFieldName, password);
        buttonsSteps.buttonClick(submitButtonName);
    }

}