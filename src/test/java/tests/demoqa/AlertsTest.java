package tests.demoqa;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import helperMethods.JSMethods;
import org.testng.annotations.Test;
import pages.demoqa.AlertsPage;
import pages.demoqa.HomePage;
import shared.Hooks;

import static org.testng.Assert.assertEquals;


public class AlertsTest extends Hooks {
    HomePage homePage;
    AlertsPage alertsPage;
    JSMethods jsMethods;

    @Test
    public void automationMethod() {
        homePage = new HomePage(getDriver());
        alertsPage = new AlertsPage(getDriver());
        jsMethods = new JSMethods(getDriver());

        homePage.goToMenu(homePage.getMenuItems(), "Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects Alerts, Frame & Windows");
        homePage.goToMenu(homePage.getSubMenuItems(), "Alerts");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects Alerts");
        jsMethods.scrollDown(200);

        alertsPage.clickAlertButton("OK");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects simple alert");

        alertsPage.clickTimerAlertButton("OK");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects timer alert");

        alertsPage.clickConfirmButton("Cancel");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects confirm alert");
        assertEquals("You selected Cancel", alertsPage.getConfirmResult());

        String alertText = "Jane";
        alertsPage.clickPromptButton(alertText);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects prompt alert");
        assertEquals("You entered " + alertText, alertsPage.getPromptResult());

    }
}
