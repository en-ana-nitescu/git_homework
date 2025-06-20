package tests.demoqa;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
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
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects Forms");
        homePage.goToMenu(homePage.getSubMenuItems(), "Practice Form");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects Practice Form");

      /*  String subjectsValue = "Social Studies";
        practiceFormPage.completeSubject(subjectsValue);*/

        practiceFormPage.completeFirstRegion(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user completes first region");
        practiceFormPage.selectGender(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects gender");
        practiceFormPage.completeSubjectsList(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects subjects");
        practiceFormPage.completeHobbies(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects hobbies");
        practiceFormPage.uploadPicture();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user uploads picture");
        practiceFormPage.completeStateCity(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects state and city");
        practiceFormPage.clickSubmitButton();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user clicks on submit");
    }
}
