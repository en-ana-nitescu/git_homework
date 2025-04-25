package pages.demoqa;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    WebDriver driver;
    ElementMethods elementMethods;
    public JSMethods jsMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods = new ElementMethods(driver);
        this.jsMethods = new JSMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> subMenuItems;

    public void goToMenu(String subMenuName) {
        jsMethods.scrollDown(400);
        elementMethods.selectElementByText(subMenuItems,subMenuName);
    }
}
