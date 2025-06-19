package tests.demoqa;

import objectData.PracticeFormObject;
import org.testng.annotations.Test;
import pages.demoqa.HomePage;
import pages.demoqa.PracticeFormPage;
import shared.Hooks;
import utils.PropertyUtils;


public class PracticeFormTest extends Hooks {

    HomePage homePage;
    PracticeFormPage practiceFormPage;
    PropertyUtils propertyUtils;
    PracticeFormObject practiceFormObject;

    @Test
    public void automationMethod() {
        homePage = new HomePage(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());
        propertyUtils = new PropertyUtils("PracticeFormTest");
        practiceFormObject = new PracticeFormObject(propertyUtils.getData());

        homePage.goToMenu(homePage.getMenuItems(), "Forms");
        homePage.goToMenu(homePage.getSubMenuItems(), "Practice Form");

      /*  String subjectsValue = "Social Studies";
        practiceFormPage.completeSubject(subjectsValue);*/

        practiceFormPage.completeFirstRegion(practiceFormObject);
        practiceFormPage.selectGender(practiceFormObject);
        practiceFormPage.completeSubjectsList(practiceFormObject);
        practiceFormPage.completeHobbies(practiceFormObject);
        practiceFormPage.uploadPicture();
        practiceFormPage.completeStateCity(practiceFormObject);
        practiceFormPage.clickSubmitButton();
    }
}
