package pages.demoqa;

import objectData.WebTableObject;
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

    public void completeDetails(WebTableObject webTableObject) {
        elementMethods.fillElement(firstNameField, webTableObject.getFirstName());
        elementMethods.fillElement(lastNameField, webTableObject.getLastName());
        elementMethods.fillElement(emailField, webTableObject.getEmail());
        elementMethods.fillElement(ageField, webTableObject.getAge());
        elementMethods.fillElement(salaryField, webTableObject.getSalary());
        elementMethods.fillElement(departmentField, webTableObject.getDepartment());
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
