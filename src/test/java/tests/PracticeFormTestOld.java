package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class PracticeFormTestOld {

    public WebDriver driver;

    @Test
    public void automationMethod() {

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement formsField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsField.click();

        WebElement practiceFormField = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormField.click();

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Jane";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Doe";
        lastNameField.sendKeys(lastNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailValue = "test@test.com";
        emailField.sendKeys(emailValue);

        WebElement mobileField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileValue = "1234567890";
        mobileField.sendKeys(mobileValue);

        WebElement uploadFileField = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/bp1.jpg");
        uploadFileField.sendKeys(file.getAbsolutePath());

        WebElement maleGenderField = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleGenderField = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherGenderField = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue = "Female";

        if (maleGenderField.getText().equals(genderValue))
            maleGenderField.click();
        else if (femaleGenderField.getText().equals(genderValue))
            femaleGenderField.click();
        else otherGenderField.click();


        WebElement subjectsField = driver.findElement(By.id("subjectsInput"));
        String subjectsValue = "Social Studies";
        subjectsField.sendKeys(subjectsValue);
        subjectsField.sendKeys(Keys.ENTER);

        WebElement stateField = driver.findElement(By.id("react-select-3-input"));
        //stateField.click();
        js.executeScript("arguments[0].click();", stateField);
        stateField.sendKeys("NCR");
        stateField.sendKeys(Keys.ENTER);

        WebElement cityField = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();", cityField);
        cityField.sendKeys("Delhi");
        cityField.sendKeys(Keys.ENTER);

        WebElement submitButton = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitButton);

    }
}
