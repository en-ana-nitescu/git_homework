package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.demoqa.HomePage;
import pages.demoqa.WebTablePage;
import shared.SharedData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebTableTest extends SharedData {

    HomePage homePage;
    WebTablePage webTablePage;

    @Test
    public void automationMethod() throws InterruptedException {
        homePage = new HomePage(getDriver());
        webTablePage = new WebTablePage(getDriver());

        homePage.goToMenu(homePage.getMenuItems(), "Elements");
        homePage.goToMenu(homePage.getSubMenuItems(), "Web Tables");

        int initialSize = webTablePage.getTableSize();

        webTablePage.addNewRecord();

        String firstNameValue = "Jane";
        String lastNameValue = "Doe";
        String emailValue = "test@test.com";
        String ageValue = "25";
        String salaryValue = "1000";
        String departmentValue = "QA";
        webTablePage.completeDetails(firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue);

        webTablePage.clickSubmit();

        int newSize = webTablePage.getTableSize();
        assertEquals(initialSize + 1, newSize);

        String actualTableValue = webTablePage.getTableRowText(3);
        assertTrue(actualTableValue.contains(emailValue));
        assertTrue(actualTableValue.contains(ageValue));
        assertTrue(actualTableValue.contains(salaryValue));
        assertTrue(actualTableValue.contains(departmentValue));
        assertTrue(actualTableValue.contains(firstNameValue));
        assertTrue(actualTableValue.contains(lastNameValue));
    }
}
