package tests.demoqa;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.WebTableObject;
import org.testng.annotations.Test;
import pages.demoqa.HomePage;
import pages.demoqa.WebTablePage;
import shared.Hooks;
import utils.PropertyUtils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class WebTableTest extends Hooks {

    HomePage homePage;
    WebTablePage webTablePage;
    PropertyUtils propertyUtils;
    WebTableObject webTableObject;

    @Test
    public void automationMethod() throws InterruptedException {
        homePage = new HomePage(getDriver());
        webTablePage = new WebTablePage(getDriver());
        propertyUtils = new PropertyUtils("WebTableTest");
        webTableObject = new WebTableObject(propertyUtils.getData());

        homePage.goToMenu(homePage.getMenuItems(), "Elements");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects Elements");
        homePage.goToMenu(homePage.getSubMenuItems(), "Web Tables");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects Web Tables");

        int initialSize = webTablePage.getTableSize();

        webTablePage.addNewRecord();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user adds new row");

        webTablePage.completeDetails(webTableObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user completes all the details");

        webTablePage.clickSubmit();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user clicks on submit");

        int newSize = webTablePage.getTableSize();
        assertEquals(initialSize + 1, newSize);

        String actualTableValue = webTablePage.getTableRowText(3);
        assertTrue(actualTableValue.contains(webTableObject.getEmail()));
        assertTrue(actualTableValue.contains(webTableObject.getAge()));
        assertTrue(actualTableValue.contains(webTableObject.getSalary()));
        assertTrue(actualTableValue.contains(webTableObject.getDepartment()));
        assertTrue(actualTableValue.contains(webTableObject.getFirstName()));
        assertTrue(actualTableValue.contains(webTableObject.getLastName()));
    }
}
