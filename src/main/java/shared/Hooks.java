package shared;

import logger.LoggerUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData {

    public String testName;

    @BeforeMethod
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        LoggerUtils.startTestCase(testName);
        setUpBrowser();
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            LoggerUtils.errorLog(result.getThrowable().getMessage());
        }
        tearDownBrowser();
        LoggerUtils.endTestCase(testName);
    }

    @AfterSuite
    public void finaliseLogFiles() {
        LoggerUtils.mergeLogFilesIntoOne();
    }
}
