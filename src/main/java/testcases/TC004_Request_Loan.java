package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Prelogin_Page;

public class TC004_Request_Loan extends BaseClass {

    @BeforeTest
    public void setData() {
        dataFile = "Test Data";                // Excel filename
        testCaseName = "TC004_Request_Loan";  // Testcase name in Excel
    }

    @Test(dataProvider = "getData",groups = "requestLoanFlow",dependsOnGroups = "openNewAccountFlow")
    public void requestLoanFlow(String userName, String password, String loanAmount, String downPayment, String fromAccount,String loanStatus) throws InterruptedException {
        Prelogin_Page pl = new Prelogin_Page(driver);
        pl.enterUsername(userName)
          .enterPassword(password)
          .clickLoginButton()
          .clickRequestLoan()
          .enterLoanAmount(loanAmount)
          .enterDownPaymentAmount(downPayment)
          .selectFromAccount(fromAccount)
          .clickLoanApplyNowButton()
          .verifyLoanApplyFinalScreen(loanStatus);
    }
}
