package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void interactWithAlertOK(String value) {
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        if(value.equals("OK")) {
            alert.accept();
        } else if(value.equals("Cancel")) {
            alert.dismiss();
        } else {
            alert.sendKeys(value);
            alert.accept();
        }
    }
}
