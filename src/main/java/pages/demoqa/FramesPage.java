package pages.demoqa;

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

    public WebElement getFirstFrameElement() {
        return firstFrameElement;
    }

    public WebElement getSampleHeading() {
        return sampleHeading;
    }

    public WebElement getSecondFrameElement() {
        return secondFrameElement;
    }

    public void scrollBy(int x, int y) {
        jsMethods.scroll(x, y);
    }
}
