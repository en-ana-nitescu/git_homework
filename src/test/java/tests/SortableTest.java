package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortableTest {

    public WebDriver driver;

    @Test
    public void automationMethod() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        //page scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        List<WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));

        for (int i=0; i<list.size(); i++) {
            WebElement currentElement = list.get(i);
            WebElement nextElement = list.get(i++);
            System.out.println("Element number is " + currentElement.getText());

            //Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(1);
            actions.clickAndHold(currentElement)
                    .moveToElement(nextElement)
                    .release()
                    .build()
                    .perform();
        }
    }
}
