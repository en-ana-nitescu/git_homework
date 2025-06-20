package tests.demoqa;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.testng.annotations.Test;
import pages.demoqa.FramesPage;
import pages.demoqa.HomePage;
import shared.Hooks;

import static org.testng.Assert.assertEquals;

public class FramesTest extends Hooks {

    HomePage homePage;
    FramesPage framesPage;

    @Test
    public void automationMethod() {
        homePage = new HomePage(getDriver());
        framesPage = new FramesPage(getDriver());

        homePage.goToMenu(homePage.getMenuItems(), "Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects Alerts, Frame & Windows");
        homePage.goToMenu(homePage.getSubMenuItems(), "Frames");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects Frames sub -menu");

        framesPage.switchToFirstFrame();
        assertEquals(framesPage.getSampleHeadingText(), "This is a sample page");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects first iFrame");

        framesPage.switchToMainContent();

        framesPage.switchToSecondFrame();
    }
}
