package base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ReadExcelData;

public class BaseClass {

    public ChromeDriver driver;
    public String dataFile;
    public String testCaseName;

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
}
