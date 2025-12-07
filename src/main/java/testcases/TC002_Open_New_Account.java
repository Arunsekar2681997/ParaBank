package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.Prelogin_Page;

public class TC002_Open_New_Account extends BaseClass {

    @BeforeTest
    public void setData() {
        dataFile = "Test Data";              // Excel file name without extension
        testCaseName = "TC002_OpenNewAccount"; // EXACT match with Excel Testcase column
    }

    @Test(dataProvider = "getData")
    public void openNewAccountFlow(String userName, String password, String accountType, String accountAmount) throws InterruptedException {

        Prelogin_Page pl = new Prelogin_Page(driver);

        pl.enterUsername(userName)
          .enterPassword(password)
          .clickLoginButton()
          .clickOpenNewAccount()
          .selectAccountType(accountType)
          .selectOpeningAccountAmount(accountAmount)
          .clickOpenNewAccountOption()
          .verifyOpenNewAccountOpening();
    }
}
