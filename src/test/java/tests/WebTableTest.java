package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

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

    }
}
