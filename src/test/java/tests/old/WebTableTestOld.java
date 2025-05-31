package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTableTestOld {

    public WebDriver driver;

    @Test
    public void automationMethod() {

        //open Chrome browser
        driver = new ChromeDriver();

        //access web page
        driver.get("https://demoqa.com/");

        //maximize browser
        driver.manage().window().maximize();

        //page scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //declare element
        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsField.click();

        WebElement webTablesField = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTablesField.click();

        List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        int tableSize = tableRows.size();

        WebElement addField = driver.findElement(By.id("addNewRecordButton"));
        addField.click();

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Jane";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Doe";
        lastNameField.sendKeys(lastNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailValue = "test@test.com";
        emailField.sendKeys(emailValue);

        WebElement ageField = driver.findElement(By.id("age"));
        String ageValue = "25";
        ageField.sendKeys(ageValue);

        WebElement salaryField = driver.findElement(By.id("salary"));
        String salaryValue = "1000";
        salaryField.sendKeys(salaryValue);

        WebElement departmentField = driver.findElement(By.id("department"));
        String departmentValue = "QA";
        departmentField.sendKeys(departmentValue);

        WebElement submitField = driver.findElement(By.id("submit"));
        submitField.click();

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
