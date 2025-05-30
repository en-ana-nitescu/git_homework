package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.demoqa.HomePage;
import pages.demoqa.PracticeFormPage;
import shared.SharedData;

import java.util.ArrayList;
import java.util.List;


public class PracticeFormTest extends SharedData {

    HomePage homePage;
    PracticeFormPage practiceFormPage;

    @Test
    public void automationMethod() {
        homePage = new HomePage(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());

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

        practiceFormPage.uploadPicture();
        practiceFormPage.completeStateCity("NCR", "Delhi");
        practiceFormPage.clickSubmitButton();
    }
}
