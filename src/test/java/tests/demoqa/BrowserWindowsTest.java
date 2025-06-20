package tests.demoqa;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.testng.annotations.Test;
import pages.demoqa.BrowserWindowsPage;
import pages.demoqa.HomePage;
import shared.Hooks;

import static org.testng.Assert.assertEquals;


public class BrowserWindowsTest extends Hooks {

    HomePage homePage;
    BrowserWindowsPage browserWindowsPage;

    @Test
    public void automationMethod() {
        homePage = new HomePage(getDriver());
        browserWindowsPage = new BrowserWindowsPage(getDriver());

        homePage.goToMenu(homePage.getMenuItems(), "Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects Alerts, Frame & Windows");
        homePage.goToMenu(homePage.getSubMenuItems(), "Browser Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects Browser Windows");

        browserWindowsPage.clickTabButton();
        //move to new tab
        browserWindowsPage.switchToWindow(1);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user moves to the opened tab");
        assertEquals("This is a sample page", browserWindowsPage.getSampleHeading());
        //close current tab
        getDriver().close();
        browserWindowsPage.switchToWindow(0);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user moves to main window");

        browserWindowsPage.clickWindowButton();
        //move to new window
        browserWindowsPage.switchToWindow(1);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user moves to the new window");
        assertEquals("This is a sample page", browserWindowsPage.getSampleHeading());
        getDriver().close();
        browserWindowsPage.switchToWindow(0);
    }
}
