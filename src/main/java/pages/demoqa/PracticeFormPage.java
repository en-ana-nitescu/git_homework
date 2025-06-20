package pages.demoqa;

import logger.LoggerUtils;
import objectData.PracticeFormObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends CommonPage {

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "userEmail")
    private WebElement emailField;

    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileField;

    @FindBy(id = "uploadPicture")
    private WebElement uploadFileField;

    @FindBy(xpath = "//label[starts-with(@for,'gender-radio')]")
    private WebElement genderFields;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGenderField;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleGenderField;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement otherGenderField;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsField;

    @FindBy(xpath = "//div[@id='subjectsContainer']")
    private WebElement subjectsContainer;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;

    @FindBy(id = "react-select-3-input")
    private WebElement stateField;

    @FindBy(id = "react-select-4-input")
    private WebElement cityField;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement sportHobbyField;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement readingHobbyField;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement musicHobbyField;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void completeFirstRegion(PracticeFormObject practiceFormObject) {
        elementMethods.fillElementAndEnter(firstNameField, practiceFormObject.getFirstName());
        LoggerUtils.infoLog("The user completes first name");
        elementMethods.fillElementAndEnter(lastNameField, practiceFormObject.getLastName());
        LoggerUtils.infoLog("The user completes last name");
        elementMethods.fillElementAndEnter(emailField, practiceFormObject.getEmail());
        LoggerUtils.infoLog("The user completes email");
        elementMethods.fillElementAndEnter(currentAddressField, practiceFormObject.getAddress());
        LoggerUtils.infoLog("The user completes address");
        elementMethods.fillElementAndEnter(mobileField, practiceFormObject.getMobile());
        LoggerUtils.infoLog("The user completes mobile");
    }

    public void selectGender(PracticeFormObject practiceFormObject) {
        switch (practiceFormObject.getGender()) {
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

    public void completeSubjectsList(PracticeFormObject practiceFormObject) {
        elementMethods.clickElement(subjectsField);
        elementMethods.fillMultipleValues(subjectsField, practiceFormObject.getSubjects());
    }

    public void completeHobbies(PracticeFormObject practiceFormObject) {
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyField);
        hobbiesElement.add(readingHobbyField);
        hobbiesElement.add(musicHobbyField);
        elementMethods.clickMultipleValues(hobbiesElement, practiceFormObject.getHobbies());
    }

    public void uploadPicture() {
        elementMethods.uploadPicture(uploadPicture);
    }

    public void completeStateCity(PracticeFormObject practiceFormObject){
        jsMethods.forceClick(stateField);
        elementMethods.waitForElementVisible(stateField);
        elementMethods.fillElementAndEnter(stateField, practiceFormObject.getState());

        jsMethods.forceClick(cityField);
        elementMethods.waitForElementVisible(cityField);
        elementMethods.fillElementAndEnter(cityField, practiceFormObject.getCity());
    }

    public void clickSubmitButton() {
        jsMethods.forceClick(submitButton);
    }
}
