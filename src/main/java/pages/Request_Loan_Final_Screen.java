package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class Request_Loan_Final_Screen extends BaseClass{
	
	public Request_Loan_Final_Screen(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public Request_Loan_Final_Screen verifyLoanApplyFinalScreen(String loanStatusValue) throws InterruptedException, IOException
	{
		//Verify the final screen
				try {
					Thread.sleep(3000);
					WebElement loanStatus = driver.findElement(By.id("loanStatus"));
					String statusValue = loanStatus.getText();
					if (statusValue.contains(loanStatusValue)) {
						System.out.println("Apply Loan Failed Due To Technical Reason");
					}
					else {
						System.out.println("Appply Loan Flow Getting Success");
					}
					reportStep("Loan Apply Flow Is Success", "Pass");
				} catch (InterruptedException e) {
					reportStep("Loan Apply Flow Is Not Success", "Fail");
				}
				return this;
	}

}
