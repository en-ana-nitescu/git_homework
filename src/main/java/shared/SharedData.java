package shared;

import logger.LoggerUtils;
import org.openqa.selenium.WebDriver;
import shared.browser.BrowserFactory;

public class SharedData {

    private WebDriver driver;

    public void setUpBrowser() {
        driver = new BrowserFactory().getBrowser();
        LoggerUtils.infoLog("Browser created");
    }

    public void tearDownBrowser() {
        driver.quit();
        LoggerUtils.infoLog("Browser closed");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
