package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.demoqa.BrowserWindowsPage;
import pages.demoqa.HomePage;
import shared.SharedData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowserWindowsTest extends SharedData {

    HomePage homePage;
    BrowserWindowsPage browserWindowsPage;

    @Test
    public void automationMethod() {
        homePage = new HomePage(getDriver());
        browserWindowsPage = new BrowserWindowsPage(getDriver());

        homePage.goToMenu(homePage.getMenuItems(), "Alerts, Frame & Windows");
        homePage.goToMenu(homePage.getSubMenuItems(), "Browser Windows");

        browserWindowsPage.clickTabButton();
        //move to new tab
        browserWindowsPage.switchToWindow(1);
        assertEquals("This is a sample page", browserWindowsPage.getSampleHeading());
        //close current tab
        getDriver().close();
        browserWindowsPage.switchToWindow(0);

        browserWindowsPage.clickWindowButton();
        //move to new window
        browserWindowsPage.switchToWindow(1);
        assertEquals("This is a sample page", browserWindowsPage.getSampleHeading());
        getDriver().close();
        browserWindowsPage.switchToWindow(0);
    }
}
