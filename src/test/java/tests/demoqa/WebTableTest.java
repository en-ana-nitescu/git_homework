package tests.demoqa;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoqa.HomePage;
import pages.demoqa.WebTablePage;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebTableTest {

    public WebDriver driver;
    ElementMethods elementMethods;
    JSMethods jsMethods;
    HomePage homePage;
    WebTablePage webTablePage;

    @Test
    public void automationMethod() throws InterruptedException {

        //open Chrome browser
        driver = new ChromeDriver();
        elementMethods = new ElementMethods(driver);
        jsMethods = new JSMethods(driver);
        homePage = new HomePage(driver);
        webTablePage = new WebTablePage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage.goToHomePage();

        homePage.goToMenu(homePage.getMenuItems(), "Elements");
        homePage.goToMenu(homePage.getSubMenuItems(), "Web Tables");

        int tableSize = webTablePage.getTableRows().size();

        elementMethods.clickElement(webTablePage.getAddField());

        String firstNameValue = "Jane";
        elementMethods.fillElement(webTablePage.getFirstNameField(), firstNameValue);

        String lastNameValue = "Doe";
        elementMethods.fillElement(webTablePage.getLastNameField(), lastNameValue);

        String emailValue = "test@test.com";
        elementMethods.fillElement(webTablePage.getEmailField(), emailValue);

        String ageValue = "25";
        elementMethods.fillElement(webTablePage.getAgeField(), ageValue);

        String salaryValue = "1000";
        elementMethods.fillElement(webTablePage.getSalaryField(), salaryValue);
        Thread.sleep(Duration.ofSeconds(2));

        String departmentValue = "QA";
        elementMethods.fillElement(webTablePage.getDepartmentField(), departmentValue);

        elementMethods.clickElement(webTablePage.getSubmitField());

        int expectedTableSize = tableSize + 1;

        List<WebElement> newTableRows = webTablePage.getTableRows();
        assertEquals(expectedTableSize, newTableRows.size());

        String actualTableValue = newTableRows.get(3).getText();
        assertTrue(actualTableValue.contains(emailValue));
        assertTrue(actualTableValue.contains(ageValue));
        assertTrue(actualTableValue.contains(salaryValue));
        assertTrue(actualTableValue.contains(departmentValue));
        assertTrue(actualTableValue.contains(firstNameValue));
        assertTrue(actualTableValue.contains(lastNameValue));

    }
}
