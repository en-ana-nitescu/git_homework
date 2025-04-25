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

        homePage.goToMenu(homePage.getMenuItems(), "Forms");
        homePage.goToMenu(homePage.getSubMenuItems(), "Practice Form");

        String firstNameValue = "Jane";
        String lastNameValue = "Doe";
        String emailValue = "test@test.com";
        String mobileValue = "1234567890";
        String genderValue = "Female";
        String subjectsValue = "Social Studies";

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

        jsMethods.forceClick(practiceFormPage.getStateField());
        elementMethods.fillElementAndEnter(practiceFormPage.getStateField(), "NCR");

        jsMethods.forceClick(practiceFormPage.getCityField());
        elementMethods.fillElementAndEnter(practiceFormPage.getCityField(), "Delhi");

        jsMethods.forceClick(practiceFormPage.getSubmitButton());

    }
}
