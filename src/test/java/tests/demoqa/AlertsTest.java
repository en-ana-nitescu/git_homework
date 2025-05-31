package tests.demoqa;

import org.testng.annotations.Test;
import pages.demoqa.AlertsPage;
import pages.demoqa.HomePage;
import shared.SharedData;

import static org.testng.Assert.assertEquals;


public class AlertsTest extends SharedData {
    HomePage homePage;
    AlertsPage alertsPage;

    @Test
    public void automationMethod() {
        homePage = new HomePage(getDriver());
        alertsPage = new AlertsPage(getDriver());

        homePage.goToMenu(homePage.getMenuItems(), "Alerts, Frame & Windows");
        homePage.goToMenu(homePage.getSubMenuItems(), "Alerts");

        alertsPage.clickAlertButton("OK");

        alertsPage.clickTimerAlertButton("OK");

        alertsPage.clickConfirmButton("Cancel");
        assertEquals("You selected Cancel", alertsPage.getConfirmResult());

        String alertText = "Jane";
        alertsPage.clickPromptButton(alertText);
        assertEquals("You entered " + alertText, alertsPage.getPromptResult());

    }
}
