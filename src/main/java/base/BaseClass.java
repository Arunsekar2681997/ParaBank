package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
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

import utils.ReadExcelData;

public class BaseClass {
	
	public String tcName,tcDetails,testAuthor,testingType;
    public static ChromeDriver driver;
    public String dataFile,testCaseName;
    public static ExtentReports extent;
    public static ExtentTest test;

    @DataProvider(name="getData")
    public Object[][] sendData(Method method) throws IOException {
        Object[][] data = ReadExcelData.readData(dataFile, testCaseName);
        System.out.println("Data for " + testCaseName + ": " + Arrays.deepToString(data));
        return data;
    }


    @BeforeMethod
    public void preCond() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void postCond() {
       
            driver.quit();
        
    }
    
    @BeforeSuite
    public void reportsGenerate()
    {
    	ExtentHtmlReporter reports = new ExtentHtmlReporter("./reports/result.html");
    	reports.setAppendExisting(true);		
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

        String screenshot = "../snapshot/" + takeScreenshot() + ".png";

        if (status.equalsIgnoreCase("Pass")) {
            test.pass(msg,
                MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
        } 
        else if (status.equalsIgnoreCase("Fail")) {
            test.fail(msg,
                MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
        }
    }

    
    public String takeScreenshot() throws IOException {
        String screenshotName = "img_" + System.currentTimeMillis();
        File src = driver.getScreenshotAs(OutputType.FILE);
        File dst = new File("./snapshot/" + screenshotName + ".png");
        FileUtils.copyFile(src, dst);
        return screenshotName;
    }

}
