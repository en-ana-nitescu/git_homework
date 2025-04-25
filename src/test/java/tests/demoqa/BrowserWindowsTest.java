package tests.demoqa;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import helper_methods.WindowMethods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoqa.HomePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowserWindowsTest {

    public WebDriver driver;
    public JSMethods jsMethods;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;
    HomePage homePage;

    @Test
    public void automationMethod() {
        driver = new ChromeDriver();
        jsMethods = new JSMethods(driver);
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        homePage = new HomePage(driver);

        homePage.goToHomePage();

        homePage.goToMenu(homePage.getMenuItems(),"Alerts, Frame & Windows");
        homePage.goToMenu(homePage.getSubMenuItems(),"Browser Windows");

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        elementMethods.clickElement(tabButton);

        //move to new tab
        windowMethods.switchToWindow(1);

        WebElement sampleHeadingTabElement = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", sampleHeadingTabElement.getText());

        //close current tab
        driver.close();

        windowMethods.switchToWindow(0);

        WebElement windowButton = driver.findElement(By.id("windowButton"));
        elementMethods.clickElement(windowButton);

        //move to new window
        windowMethods.switchToWindow(1);

        WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", sampleHeadingWindowElement.getText());

        driver.close();
        windowMethods.switchToWindow(0);
    }
}
