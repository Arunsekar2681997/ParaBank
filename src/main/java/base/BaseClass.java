package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.ExcelUtils;

public class BaseClass {
	
	public String tcName,tcDetails,testAuthor,testingType;
    public static ChromeDriver driver;
    public String dataFile,testCaseName;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static String reportFolder;
    public static String screenshotFolder;


    @DataProvider(name="getData")
    public Object[][] sendData(Method method) throws IOException {
        Object[][] data = ExcelUtils.readData(dataFile, testCaseName);
        System.out.println("Data for " + testCaseName + ": " + Arrays.deepToString(data));
        return data;
    }

    @BeforeMethod
    public void preCond() {
        ChromeOptions options = new ChromeOptions();

      
        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu"); // Windows fix for Chrome

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }


    @AfterMethod
    public void postCond() {
       
            driver.quit();
        
    }
    
    @BeforeSuite
    public void reportsGenerate() throws IOException {

        String timestamp = String.valueOf(System.currentTimeMillis());
        reportFolder = "./reports/Run_" + timestamp;
        screenshotFolder = reportFolder + "/screenshots";

        // Create folders
        Files.createDirectories(Paths.get(screenshotFolder));

        // Create report inside same folder
        ExtentHtmlReporter reports =
                new ExtentHtmlReporter(reportFolder + "/result.html");

        reports.setAppendExisting(false); // overwrite
        extent = new ExtentReports();
        extent.attachReporter(reports);
    }

    
    @AfterSuite
    public void closeReport()
    {
    	extent.flush();
    }
    
    @BeforeClass
    public void testcaseDetails()
    {
    	test = extent.createTest(tcName, tcDetails);
		test.assignAuthor(testAuthor);
		test.assignCategory(testingType);
    }
    
    
    public void reportStep(String msg, String status) throws IOException {

        String screenshotPath = "screenshots/" + takeScreenshot() + ".png";

        if (status.equalsIgnoreCase("Pass")) {
            test.pass(msg,
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } 
        else if (status.equalsIgnoreCase("Fail")) {
            test.fail(msg,
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    
    public String takeScreenshot() throws IOException {
        String screenshotName = "img_" + System.currentTimeMillis();
        File src = driver.getScreenshotAs(OutputType.FILE);
        File dst = new File(screenshotFolder + "/" + screenshotName + ".png");
        FileUtils.copyFile(src, dst);
        return screenshotName;
    }


}
