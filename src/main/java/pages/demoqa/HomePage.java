package pages.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPage {

    @FindBy(xpath = "//h5")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//span[@class='text']")
    private List<WebElement> subMenuItems;

    @FindBy(xpath = "//p[text()='Consent']")
    private WebElement consentElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }


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
        //elementMethods.clickElement(consentElement);
        jsMethods.scrollDown(400);
        elementMethods.selectElementByText(items, menuName);
    }
}
