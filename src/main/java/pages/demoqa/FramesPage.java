package pages.demoqa;

import logger.LoggerUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends CommonPage {

    @FindBy(id = "frame1")
    private WebElement firstFrameElement;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    @FindBy(id = "frame2")
    private WebElement secondFrameElement;

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public String getSampleHeadingText() {
        return sampleHeading.getText();
    }

    public void switchToFirstFrame() {
        elementMethods.switchToFrame(firstFrameElement);
        LoggerUtils.infoLog("The user switched to the first frame");
    }

    public void switchToSecondFrame() {
        elementMethods.switchToFrame(secondFrameElement);
        LoggerUtils.infoLog("The user switched to the second frame");
        jsMethods.scroll(100,100);
    }

    public void switchToMainContent() {
        elementMethods.switchToMain();
        LoggerUtils.infoLog("The user switched to default content");
    }
}
