package shared;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import shared.browser.BrowserFactory;

public class SharedData {

    private WebDriver driver;

    @BeforeMethod
    public void setUpBrowser() {
/*        ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);

        driver = new ChromeDriver();
        //driver.get("https://demoqa.com/");
        driver.get(configurationNode.driverConfigNode.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/

        driver = new BrowserFactory().getBrowser();

    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
