package pages.demoqa;

import logger.LoggerUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends CommonPage {

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "confirmResult")
    private WebElement confirmResult;

    @FindBy(id = "promtButton")
    private WebElement promptButton;

    @FindBy(id = "promptResult")
    private WebElement promptResult;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAlertButton(String alertText) {
        LoggerUtils.infoLog("The user interacts with alert");
        elementMethods.clickElement(alertButton);
        alertMethods.interactWithAlertOK(alertText);
    }

    public void clickTimerAlertButton(String alertText) {
        LoggerUtils.infoLog("The user interacts with timer alert");
        elementMethods.clickElement(timerAlertButton);
        alertMethods.interactWithAlertOK(alertText);
    }

    public void clickConfirmButton(String alertText) {
        elementMethods.clickElement(confirmButton);
        alertMethods.interactWithAlertOK(alertText);
    }

    public String getConfirmResult() {
        return elementMethods.getElementText(confirmResult);
    }

    public void clickPromptButton(String alertText) {
        LoggerUtils.infoLog("The user interacts with prompt alert");
        elementMethods.clickElement(promptButton);
        alertMethods.interactWithAlertOK(alertText);
    }

    public String getPromptResult() {
        return elementMethods.getElementText(promptResult);
    }

}
