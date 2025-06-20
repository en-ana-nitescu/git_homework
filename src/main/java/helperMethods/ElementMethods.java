package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ElementMethods {

    WebDriver driver;
    JavascriptExecutor js;
    Actions actions;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void fillElementAndEnter(WebElement element, String value) {
        fillElement(element, value);
        element.sendKeys(Keys.ENTER);
    }

    public void uploadPicture(WebElement element) {
        File file = new File("src/test/resources/bp1.jpg");
        fillElement(element, file.getAbsolutePath());
    }

    public void selectElementByText(List<WebElement> elements, String value) {
        for (WebElement element : elements) {
            if (element.getText().equals(value)) {
                clickElement(element);
                break;
            }
        }
    }

    private void printText(WebElement element) {
        System.out.println("Element text: " + element.getText());
    }

    public void checkTableSize(List<WebElement> list1, List<WebElement> list2) {
        Integer actualTableSize = list1.size();
        assertEquals(list2.size(), actualTableSize + 1);
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void changeElements(List<WebElement> elements) {
        for (int index = 0; index < elements.size(); index++) {
            WebElement element = elements.get(index);
            WebElement nextElement = elements.get(index++);
            printText(element);
            actions.clickAndHold(element)
                    .moveToElement(nextElement)
                    .release()
                    .build()
                    .perform();
        }
    }

    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillWithActions(WebElement webElement, String value) {
        actions.sendKeys(value).perform();
        waitForElementVisible(webElement);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void fillMultipleValues(WebElement element, List<String> values) {
        for (String value : values) {
            fillElementAndEnter(element, value);
        }
    }

    public void clickMultipleValues(List<WebElement> elements, List<String> values) {
        for (String value : values) {
            for (WebElement element : elements) {
                if (element.getText().equals(value)) {
                    clickElement(element);
                }
            }
        }
    }


    public String getElementText(WebElement element) {
        return element.getText();
    }

    public void switchToMain() {
        driver.switchTo().defaultContent();
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }
}
