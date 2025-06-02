package tests.old;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class WebTableTest {

    public WebDriver driver;
    ElementMethods elementMethods;
    JSMethods jsMethods;

    //@Test
    public void automationMethod() {

        //open Chrome browser
        driver = new ChromeDriver();
        elementMethods = new ElementMethods(driver);
        jsMethods = new JSMethods(driver);

        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();

        jsMethods.scrollDown(400);

        List<WebElement> menuItems = driver.findElements(By.xpath("//h5"));
        elementMethods.selectElementByText(menuItems, "Elements");
        List<WebElement> subMenuItems = driver.findElements(By.xpath("//span[@class='text']"));
        elementMethods.selectElementByText(subMenuItems, "Web Tables");

        List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        int tableSize = tableRows.size();

        WebElement addField = driver.findElement(By.id("addNewRecordButton"));
        elementMethods.clickElement(addField);

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Jane";
        elementMethods.fillElement(firstNameField, firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Doe";
        elementMethods.fillElement(lastNameField, lastNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailValue = "test@test.com";
        elementMethods.fillElement(emailField, emailValue);

        WebElement ageField = driver.findElement(By.id("age"));
        String ageValue = "25";
        elementMethods.fillElementAndEnter(ageField, ageValue);

        WebElement salaryField = driver.findElement(By.id("salary"));
        String salaryValue = "1000";
        elementMethods.fillElementAndEnter(salaryField, salaryValue);

        WebElement departmentField = driver.findElement(By.id("department"));
        String departmentValue = "QA";
        elementMethods.fillElementAndEnter(departmentField, departmentValue);

        WebElement submitField = driver.findElement(By.id("submit"));
        elementMethods.clickElement(submitField);

        List<WebElement> newTableRows = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        int expectedTableSize = tableSize + 1;
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
