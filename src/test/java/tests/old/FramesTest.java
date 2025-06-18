package tests.old;

import helperMethods.ElementMethods;
import helperMethods.JSMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class FramesTest {

    public WebDriver driver;
    public JSMethods jsMethods;
    public ElementMethods elementMethods;

    //@Test
    public void automationMethod() {
        driver = new ChromeDriver();
        jsMethods = new JSMethods(driver);
        elementMethods = new ElementMethods(driver);

        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();

        jsMethods.scrollDown(400);

       /* WebElement alertFrameWindowMenuElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElement(alertFrameWindowMenuElement);
        WebElement frameMenuElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementMethods.clickElement(frameMenuElement);*/

        List<WebElement> menuItems = driver.findElements(By.xpath("//h5"));
        elementMethods.selectElementByText(menuItems, "Alerts, Frame & Windows");
        List<WebElement> subMenuItems = driver.findElements(By.xpath("//span[@class='text']"));
        elementMethods.selectElementByText(subMenuItems, "Frames");

        WebElement firstFrameElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(firstFrameElement);

        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", sampleHeadingFrameElement.getText());

        driver.switchTo().defaultContent();

        WebElement secondFrameElement = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(secondFrameElement);

        jsMethods.scroll(100, 100);
    }
}
