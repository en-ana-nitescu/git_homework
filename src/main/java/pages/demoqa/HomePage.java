package pages.demoqa;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;
    ElementMethods elementMethods;
    public JSMethods jsMethods;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods = new ElementMethods(driver);
        this.jsMethods = new JSMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5")
    List<WebElement> menuItems;

    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> subMenuItems;

    public void goToHomePage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    public List<WebElement> getMenuItems() {
        return menuItems;
    }

    public List<WebElement> getSubMenuItems() {
        return subMenuItems;
    }

    public void goToMenu(List<WebElement> items, String menuName) {
        jsMethods.scrollDown(400);
        elementMethods.selectElementByText(items,menuName);
    }
}
