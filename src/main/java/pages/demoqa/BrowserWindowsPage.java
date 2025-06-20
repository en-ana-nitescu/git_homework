package pages.demoqa;

import logger.LoggerUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends CommonPage {

    @FindBy(id = "tabButton")
    private WebElement tabButton;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    @FindBy(id = "windowButton")
    private WebElement windowButton;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickTabButton() {
        elementMethods.clickElement(tabButton);
    }

    public void switchToWindow(int index) {
        LoggerUtils.infoLog("The user switches to new window");
        windowMethods.switchToWindow(index);
    }

    public String getSampleHeading() {
        return elementMethods.getElementText(sampleHeading);
    }

    public void clickWindowButton() {
        LoggerUtils.infoLog("The user clicks window button");
        elementMethods.clickElement(windowButton);
    }

    public void displayedTextFromNewTab() {
        elementMethods.clickElement(tabButton);
        windowMethods.switchToOpenedTab();
        elementMethods.getElementText(sampleHeading);
        windowMethods.switchToMainTab();
    }
}
