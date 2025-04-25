package helper_methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSMethods {

    WebDriver driver;
    JavascriptExecutor js;

    public JSMethods(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void scroll(int x, int y) {
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void scrollDown(int y) {
        scroll(0,y);
    }

    public void forceClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }
}
