package tests.demoqa;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.demoqa.HomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortableTest {

    public WebDriver driver;
    ElementMethods elementMethods;
    JSMethods jsMethods;
    HomePage homePage;

    @Test
    public void automationMethod() throws InterruptedException {

        driver = new ChromeDriver();
        elementMethods = new ElementMethods(driver);
        jsMethods = new JSMethods(driver);
        homePage = new HomePage(driver);

        homePage.goToHomePage();

        homePage.goToMenu(homePage.getMenuItems(), "Interactions");
        homePage.goToMenu(homePage.getSubMenuItems(), "Sortable");

        Actions actions = new Actions(driver);

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
