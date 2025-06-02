package tests.old;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import helper_methods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class BrowserWindowsTest {

    public WebDriver driver;
    public JSMethods jsMethods;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;

    //@Test
    public void automationMethod() {
        driver = new ChromeDriver();
        jsMethods = new JSMethods(driver);
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);

        driver.get("https://demoqa.com/");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        jsMethods.scrollDown(400);

        /*WebElement alertFrameWindowMenuElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElement(alertFrameWindowMenuElement);
        WebElement browserWindowsMenuElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementMethods.clickElement(browserWindowsMenuElement);*/

        List<WebElement> menuItems = driver.findElements(By.xpath("//h5"));
        elementMethods.selectElementByText(menuItems, "Alerts, Frame & Windows");
        List<WebElement> subMenuItems = driver.findElements(By.xpath("//span[@class='text']"));
        elementMethods.selectElementByText(subMenuItems, "Browser Windows");

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
