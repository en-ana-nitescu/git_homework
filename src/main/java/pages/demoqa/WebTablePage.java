package pages.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends CommonPage {

    @FindBy(id = "addNewRecordButton")
    private WebElement addField;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "userEmail")
    private WebElement emailField;

    @FindBy(id = "age")
    private WebElement ageField;

    @FindBy(id = "salary")
    private WebElement salaryField;

    @FindBy(id = "department")
    private WebElement departmentField;

    @FindBy(id = "submit")
    private WebElement submitField;

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List<WebElement> tableRows;

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void addNewRecord() {
        elementMethods.clickElement(addField);
    }

    public void completeDetails(String firstNameValue, String lastNameValue, String emailValue, String ageValue, String salaryValue, String departmentValue) {
        elementMethods.fillElement(firstNameField, firstNameValue);
        elementMethods.fillElement(lastNameField, lastNameValue);
        elementMethods.fillElement(emailField, emailValue);
        elementMethods.fillElement(ageField, ageValue);
        elementMethods.fillElement(salaryField, salaryValue);
        elementMethods.fillElement(departmentField, departmentValue);
    }

    public void clickSubmit() {
        elementMethods.clickElement(submitField);
    }


    public int getTableSize() {
        return tableRows.size();
    }

    public String getTableRowText(int index) {
        return tableRows.get(index).getText();
    }
}
