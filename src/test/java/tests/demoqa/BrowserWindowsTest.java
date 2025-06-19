package tests.demoqa;

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
