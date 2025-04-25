package tests.eviltester;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.eviltester.FormPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormTest {

    static WebDriver driver;
    FormPage formPage;

    @BeforeAll
    public static void setUpClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
    }

    @BeforeEach
    public void setUp(){
        formPage = new FormPage(driver);
    }

    @Test
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
