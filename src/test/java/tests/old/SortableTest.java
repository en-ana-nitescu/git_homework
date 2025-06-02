package tests.old;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.demoqa.HomePage;
import shared.SharedData;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortableTest extends SharedData {

    ElementMethods elementMethods;
    JSMethods jsMethods;
    HomePage homePage;

    //@Test
    public void automationMethod() throws InterruptedException {
        elementMethods = new ElementMethods(getDriver());
        jsMethods = new JSMethods(getDriver());
        homePage = new HomePage(getDriver());

        homePage.goToMenu(homePage.getMenuItems(), "Interactions");
        homePage.goToMenu(homePage.getSubMenuItems(), "Sortable");

        Actions actions = new Actions(getDriver());

        List<WebElement> list = getDriver().findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));

        for (int i = 0; i < list.size(); i++) {
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
