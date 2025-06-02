package shared;

import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    @BeforeMethod
    public void setUpBrowser() {
        ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);

        driver = new ChromeDriver();
        //driver.get("https://demoqa.com/");
        driver.get(configurationNode.driverConfigNode.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
