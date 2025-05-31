package tests.old;

import helper_methods.ElementMethods;
import helper_methods.JSMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;


public class PracticeFormTest {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public JSMethods jsMethods;

    @Test
    public void automationMethod() {

        driver = new ChromeDriver();
        elementMethods = new ElementMethods(driver);
        jsMethods = new JSMethods(driver);

        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();

        jsMethods.scrollDown(400);

      /*  WebElement formsField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementMethods.clickElement(formsField);

        WebElement practiceFormField = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethods.clickElement(practiceFormField);*/

        List<WebElement> menuItems = driver.findElements(By.xpath("//h5"));
        elementMethods.selectElementByText(menuItems,"Forms");
        List<WebElement> subMenuItems = driver.findElements(By.xpath("//span[@class='text']"));
        elementMethods.selectElementByText(subMenuItems,"Practice Form");

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Jane";
        elementMethods.fillElement(firstNameField, firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Doe";
        elementMethods.fillElement(lastNameField, lastNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailValue = "test@test.com";
        elementMethods.fillElement(emailField, emailValue);

        WebElement mobileField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileValue = "1234567890";
        elementMethods.fillElement(mobileField, mobileValue);

        WebElement uploadFileField = driver.findElement(By.id("uploadPicture"));
        elementMethods.uploadPicture(uploadFileField);

       /* WebElement maleGenderField = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleGenderField = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherGenderField = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        List<WebElement> genderFields = new ArrayList<>();
        genderFields.add(maleGenderField);
        genderFields.add(femaleGenderField);
        genderFields.add(otherGenderField);*/

        List<WebElement> genderFields = driver.findElements(By.xpath("//label[starts-with(@for,'gender-radio')]"));
        String genderValue = "Female";
        elementMethods.selectElementByText(genderFields, genderValue);

        WebElement subjectsField = driver.findElement(By.id("subjectsInput"));
        String subjectsValue = "Social Studies";
        elementMethods.fillElementAndEnter(subjectsField, subjectsValue);

        WebElement stateField = driver.findElement(By.id("react-select-3-input"));
        //stateField.click();
        jsMethods.forceClick(stateField);
        elementMethods.fillElementAndEnter(stateField, "NCR");

        WebElement cityField = driver.findElement(By.id("react-select-4-input"));
        jsMethods.forceClick(cityField);
        elementMethods.fillElementAndEnter(cityField, "Delhi");

        WebElement submitButton = driver.findElement(By.id("submit"));
        jsMethods.forceClick(submitButton);

    }
}
