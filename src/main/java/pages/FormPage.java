package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class FormPage {

    WebDriver driver;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//textarea[@name='comments']")
    private WebElement comments;

    @FindBy(xpath = "//input[@value='cb2']")
    private WebElement checkbox2;

    @FindBy(xpath = "//input[@value='cb3']")
    private WebElement checkbox3;

    @FindBy(xpath = "//input[@value='rd1']")
    private WebElement radioButton1;

    @FindBy(name = "dropdown")
    private WebElement dropdownElement;

    @FindBy(xpath = "//input[@value='submit']")
    private WebElement submitButton;

    @FindBy(id = "back_to_form")
    private WebElement backToFormButton;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String usernameValue) {
        username.sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        username.sendKeys(passwordValue);
    }

    public void enterComments(String commentsValue) {
        comments.clear();
        comments.sendKeys(commentsValue);
    }

    public void uncheckCheckbox() {
        checkbox3.click();
    }

    public void selectCheckbox() {
        uncheckCheckbox();
        checkbox2.click();
    }

    public void clickRadioButton() {
        radioButton1.click();
    }

    public void selectDropdownValue() {
        String[] dropdownValues = {
                "Drop Down Item 1",
                "Drop Down Item 2",
                "Drop Down Item 3",
                "Drop Down Item 4",
                "Drop Down Item 5",
                "Drop Down Item 6"
        };
        Random random = new Random();
        int randomIndex = random.nextInt(dropdownValues.length);
        String randomValue = dropdownValues[randomIndex];
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(randomValue);
    }

    public void clickOnSubmit(){
        submitButton.click();
    }

    public boolean isBackButtonDisplayed() {
        return backToFormButton.isDisplayed();
    }
}
