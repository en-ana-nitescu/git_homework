package pages.demoqa;

import helper_methods.AlertMethods;
import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import helper_methods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    protected WebDriver driver;
    protected ElementMethods elementMethods;
    protected JSMethods jsMethods;
    protected AlertMethods alertMethods;
    protected WindowMethods windowMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods = new ElementMethods(driver);
        this.jsMethods = new JSMethods(driver);
        this.alertMethods = new AlertMethods(driver);
        this.windowMethods = new WindowMethods(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='text']")
    private List<WebElement> subMenuItems;

    public void goToMenu(String subMenuName) {
        jsMethods.scrollDown(400);
        elementMethods.selectElementByText(subMenuItems,subMenuName);
    }
}
