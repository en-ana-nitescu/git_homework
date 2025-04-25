package tests.demoqa;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoqa.HomePage;
import pages.demoqa.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;


public class PracticeFormTest {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public JSMethods jsMethods;
    HomePage homePage;
    PracticeFormPage practiceFormPage;

    @Test
    public void automationMethod() {

        driver = new ChromeDriver();
        elementMethods = new ElementMethods(driver);
        jsMethods = new JSMethods(driver);
        homePage = new HomePage(driver);
        practiceFormPage = new PracticeFormPage(driver);

        homePage.goToHomePage();

        homePage.goToMenu(homePage.getMenuItems(),"Forms");
        homePage.goToMenu(homePage.getSubMenuItems(),"Practice Form");

        //WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Jane";
        //elementMethods.fillElement(firstNameField, firstNameValue);

        //WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Doe";
        //elementMethods.fillElement(lastNameField, lastNameValue);

        //WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailValue = "test@test.com";
        //elementMethods.fillElement(emailField, emailValue);

        //WebElement mobileField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileValue = "1234567890";
        //elementMethods.fillElement(mobileField, mobileValue);

        //List<WebElement> genderFields = driver.findElements(By.xpath("//label[starts-with(@for,'gender-radio')]"));
        String genderValue = "Female";
        //elementMethods.selectElementByText(genderFields, genderValue);

        //WebElement subjectsField = driver.findElement(By.id("subjectsInput"));
        String subjectsValue = "Social Studies";
        //elementMethods.fillElementAndEnter(subjectsField, subjectsValue);

        List<String> subjectsList = new ArrayList<String>();
        subjectsList.add("Maths");
        subjectsList.add("Social Studies");

        practiceFormPage.completeFirstRegion(firstNameValue, lastNameValue, emailValue, "str Principala nr 1", mobileValue);
        practiceFormPage.selectGender(genderValue);
        //practiceFormPage.completeSubject(subjectsValue);
        practiceFormPage.completeSubjectsList(subjectsList);

        List<String> hobbiesList = new ArrayList<String>();
        hobbiesList.add("Sports");
        hobbiesList.add("Music");
        hobbiesList.add("Reading");
        practiceFormPage.completeHobbies(hobbiesList);

        WebElement uploadFileField = driver.findElement(By.id("uploadPicture"));
        elementMethods.uploadPicture(uploadFileField);

        WebElement stateField = driver.findElement(By.id("react-select-3-input"));
        //stateField.click();
        jsMethods.forceClick(stateField);
        elementMethods.fillElementAndEnter(stateField, "NCR");

        WebElement cityField = driver.findElement(By.id("react-select-4-input"));
        jsMethods.forceClick(cityField);
        elementMethods.fillElementAndEnter(cityField, "Delhi");

        WebElement submitButton = driver.findElement(By.id("submit"));
        jsMethods.forceClick(submitButton);

    }
}
