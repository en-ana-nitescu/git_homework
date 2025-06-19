package tests.demoqa;

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
        homePage.goToMenu(homePage.getSubMenuItems(), "Frames");

        getDriver().switchTo().frame(framesPage.getFirstFrameElement());

        assertEquals("This is a sample page", framesPage.getSampleHeading().getText());

        getDriver().switchTo().defaultContent();

        getDriver().switchTo().frame(framesPage.getSecondFrameElement());

        framesPage.scrollBy(100, 100);
    }
}
