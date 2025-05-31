package tests.old;

import helper_methods.AlertMethods;
import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class AlertsTest {
    public WebDriver driver;
    ElementMethods elementMethods;
    AlertMethods alertMethods;
    JSMethods jsMethods;

    @Test
    public void automationMethod() {
        driver = new ChromeDriver();
        elementMethods = new ElementMethods(driver);
        alertMethods = new AlertMethods(driver);
        jsMethods = new JSMethods(driver);

        driver.get("https://demoqa.com/");

        //define implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        jsMethods.scrollDown(400);

        /*WebElement alertFrameWindowMenuElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElement(alertFrameWindowMenuElement);
        WebElement alertsMenuElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementMethods.clickElement(alertsMenuElement);*/

        List<WebElement> menuItems = driver.findElements(By.xpath("//h5"));
        elementMethods.selectElementByText(menuItems, "Alerts, Frame & Windows");
        List<WebElement> subMenuItems = driver.findElements(By.xpath("//span[@class='text']"));
        elementMethods.selectElementByText(subMenuItems, "Alerts");

        WebElement alertOkButton = driver.findElement(By.id("alertButton"));
        elementMethods.clickElement(alertOkButton);
        alertMethods.interactWithAlertOK("OK");

        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickElement(timerAlertButton);
        alertMethods.interactWithAlertOK("OK");

        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        elementMethods.clickElement(confirmButton);
        alertMethods.interactWithAlertOK("Cancel");
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        assertEquals("You selected Cancel", confirmResult.getText());

        WebElement promtButton = driver.findElement(By.id("promtButton"));
        elementMethods.clickElement(promtButton);
        String alertText = "Jane";
        alertMethods.interactWithAlertOK(alertText);
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        assertEquals("You entered " + alertText, promptResult.getText());

    }
}
