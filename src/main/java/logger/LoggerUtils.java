package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class LoggerUtils {

    //path where the log files are saved
    private static final String suiteLogsPath = "target/logs/suite/";

    //path of the file that contains all logs
    private static final String regressionLogsPath = "target/logs/";

    private static final Logger logger = LogManager.getLogger();

    //method that verifies if the test started
    public static synchronized void startTestCase(String testName) {
        ThreadContext.put("threadName", testName);
        logger.info("========== Execution started: " + testName + " ==========");
    }

    //method that verifies if the test finished
    public static synchronized void endTestCase(String testName) {
        logger.info("========== Execution finished: " + testName + " ==========");
    }

    //method that verifies if an entry was added to log
    public static synchronized void infoLog(String message) {
        logger.info(Thread.currentThread().getName() + ":" + getCallInfo() + message);
    }

    //logs an error
    public static synchronized void errorLog(String message) {
        logger.error(Thread.currentThread().getName() + ":" + getCallInfo() + message);
    }

    //method that gives information about the current execution
    private static synchronized String getCallInfo() {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();

        return className + ":" + methodName + " ==> ";
    }

    //method that saves all the logs in a single file
    public static void mergeLogFilesIntoOne() {
        // create instance of directory
        File dir = new File(suiteLogsPath);

        // Get a list of all the files in the form of String Array
        String[] fileNames = dir.list();

        try {
            // create an object of PrintWriter for an output file
            PrintWriter pw = new PrintWriter(regressionLogsPath +"RegressionLogs.log");

            // loop for reading the contents of all the files in the directory
            for (String fileName : fileNames) {
                // create instance of a file from the name of the file stored in string Array
                File f = new File(dir, fileName);

                // create an object of BufferedReader
                BufferedReader br = new BufferedReader(new FileReader(f));
                pw.println("Contents of file " + fileName);

                // Read from the current file
                String line = br.readLine();
                while (line != null) {
                    // write to the output file
                    pw.println(line);
                    line = br.readLine();
                }
                pw.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
