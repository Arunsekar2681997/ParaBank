package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Prelogin_Page;

public class TC003_Transfer_Funds extends BaseClass {

    @BeforeTest
    public void setData() {
        dataFile = "Test Data";                 // Excel filename
        testCaseName = "TC003_Transfer_Funds"; // Testcase name in Excel
        tcName="Transfer Flow";
		tcDetails = "Verify the transfer functionality";
		testAuthor = "ArunSekar";
		testingType = "Regression Testing";
    }

    @Test(dataProvider = "getData",groups = "transferFundsFlow",dependsOnGroups = "logoutApplication")
    public void transferFundsFlow(String userName, String password,String transferAmount, String fromAccount, String toAccount ) throws InterruptedException {
        Prelogin_Page pl = new Prelogin_Page(driver);
        pl.enterUsername(userName)
          .enterPassword(password)
          .clickLoginButton()
          .clickTransferFundsOption()
          .enterTransferAmount(transferAmount)
          .selectFromAccount(fromAccount)
          .selectToAccount(toAccount)
          .clickTransferButton()
          .verifyTransferFinalScreen();
    }
}
