package tests.old;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTestOld {
    public WebDriver driver;

    @Test
    public void automationMethod() {
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/");

        //define implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertFrameWindowMenuElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowMenuElement.click();
        WebElement alertsMenuElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsMenuElement.click();

        WebElement alertOkButton = driver.findElement(By.id("alertButton"));
        alertOkButton.click();
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert timerAlert = driver.switchTo().alert();
        timerAlert.accept();

        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        assertEquals("You selected Cancel", confirmResult.getText());

        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();
        Alert promtAlert = driver.switchTo().alert();
        promtAlert.sendKeys("Jane");
        promtAlert.accept();
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        assertEquals("You entered Jane", promptResult.getText());

    }
}
