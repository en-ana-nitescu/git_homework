package tests.demoqa;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoqa.HomePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FramesTest {

    public WebDriver driver;
    public JSMethods jsMethods;
    public ElementMethods elementMethods;
    HomePage homePage;

    @Test
    public void automationMethod() {
        driver = new ChromeDriver();
        jsMethods = new JSMethods(driver);
        elementMethods = new ElementMethods(driver);
        homePage = new HomePage(driver);

        homePage.goToHomePage();

        homePage.goToMenu(homePage.getMenuItems(), "Alerts, Frame & Windows");
        homePage.goToMenu(homePage.getSubMenuItems(), "Frames");

        WebElement firstFrameElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(firstFrameElement);

        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", sampleHeadingFrameElement.getText());

        driver.switchTo().defaultContent();

        WebElement secondFrameElement = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(secondFrameElement);

        jsMethods.scroll(100, 100);
    }
}
