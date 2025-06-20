package shared;

import extentUtility.ExtentUtility;
import logger.LoggerUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Hooks extends SharedData {

    public String testName;

    @BeforeSuite
    public void initializeTestReport() {
        ExtentUtility.initializeReport();
    }

    @BeforeMethod
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        LoggerUtils.startTestCase(testName);
        ExtentUtility.createTest(testName);
        setUpBrowser();
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String errorMessage = result.getThrowable().getMessage();
            LoggerUtils.errorLog(errorMessage);
            ExtentUtility.attachLog(testName, errorMessage, getDriver());
        }
        tearDownBrowser();
        LoggerUtils.endTestCase(testName);
        ExtentUtility.finishTest(testName);
    }

    @AfterSuite
    public void finaliseLogFiles() {
        LoggerUtils.mergeLogFilesIntoOne();
        ExtentUtility.generateReport();
    }
}
