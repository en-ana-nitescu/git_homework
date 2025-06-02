package tests.eviltester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.eviltester.FormPage;

import static org.testng.Assert.assertTrue;


public class FormTest {

    static WebDriver driver;
    FormPage formPage;

    @BeforeClass
    public static void setUpClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
    }

    @BeforeTest
    public void setUp(){
        formPage = new FormPage(driver);
    }

    //@Test
    public void myFirstTest() {
        formPage.enterUsername("Ana");
        formPage.enterComments("test comments");
        formPage.selectCheckbox();
        formPage.clickRadioButton();
        formPage.selectDropdownValue();
        formPage.clickOnSubmit();
        assertTrue(formPage.isBackButtonDisplayed());
    }
}
