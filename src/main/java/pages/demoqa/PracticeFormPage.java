package pages.demoqa;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage {

    WebDriver driver;
    ElementMethods elementMethods;
    JSMethods jsMethods;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        this.jsMethods = new JSMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement emailField;

    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement mobileField;

    @FindBy(id = "uploadPicture")
    WebElement uploadFileField;

    @FindBy(xpath = "//label[starts-with(@for,'gender-radio')]")
    WebElement genderFields;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleGenderField;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleGenderField;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherGenderField;

    @FindBy(id = "subjectsInput")
    WebElement subjectsField;

    @FindBy(xpath = "//div[@id='subjectsContainer']")
    WebElement subjectsContainer;

    @FindBy(id = "currentAddress")
    WebElement currentAddressField;

    @FindBy(id = "react-select-3-input")
    WebElement stateField;

    @FindBy(id = "react-select-4-input")
    WebElement cityField;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportHobbyField;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readingHobbyField;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicHobbyField;

    @FindBy(id = "submit")
    WebElement submitButton;

    public void completeFirstRegion(String firstName, String lastName, String email, String address, String mobileNo) {
        elementMethods.fillElementAndEnter(firstNameField, firstName);
        elementMethods.fillElementAndEnter(lastNameField, lastName);
        elementMethods.fillElementAndEnter(emailField, email);
        elementMethods.fillElementAndEnter(currentAddressField, address);
        elementMethods.fillElementAndEnter(mobileField, mobileNo);
    }

    public void selectGender(String gender) {
        switch (gender) {
            case "Male":
                elementMethods.clickElement(maleGenderField);
                break;
            case "Female":
                elementMethods.clickElement(femaleGenderField);
                break;
            case "Other":
                elementMethods.clickElement(otherGenderField);
                break;
        }

    }

    public void completeSubject(String subject) {
        elementMethods.clickElement(subjectsContainer);
        elementMethods.fillWithActions(subjectsContainer, subject);
    }

    public void completeSubjectsList(List<String> subjectsList) {
        elementMethods.clickElement(subjectsField);
        elementMethods.fillMultipleValues(subjectsField, subjectsList);
    }

    public void completeHobbies(List<String> hobbiesList) {
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyField);
        hobbiesElement.add(readingHobbyField);
        hobbiesElement.add(musicHobbyField);
        elementMethods.clickMultipleValues(hobbiesElement,hobbiesList);
    }
}
