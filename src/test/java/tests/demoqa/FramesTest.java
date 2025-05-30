package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.demoqa.FramesPage;
import pages.demoqa.HomePage;
import shared.SharedData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FramesTest extends SharedData {

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
