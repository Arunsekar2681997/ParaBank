package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class Request_Loan_Input_Screen extends BaseClass{
	
	public Request_Loan_Input_Screen(ChromeDriver driver)
	{
		this.driver = driver;
	}

	public Request_Loan_Input_Screen enterLoanAmount(String loanAmount) throws IOException
	{
		//enter loan amount
		try {
			driver.findElement(By.id("amount")).sendKeys(loanAmount);
			reportStep("Loan Amount Is Entered", "Pass");
		} catch (Exception e) {
			reportStep("Loan Amount Is Not Entered", "Fail");
		}
		return this;
	}
	
	public Request_Loan_Input_Screen enterDownPaymentAmount(String downPaymentAmount) throws IOException
	{
		//enter down payment amount
		try {
			driver.findElement(By.id("downPayment")).sendKeys(downPaymentAmount);
			reportStep("Down Payment Amount Is Entered", "Pass");
		} catch (Exception e) {
			reportStep("Down Payment Amount Is Not Entered", "Fail");
		}
		return this;		
	}
	
	public Request_Loan_Input_Screen selectFromAccount(String fromAccount) throws IOException
	{
		//select the from account
		try {
			WebElement findFromAccount = driver.findElement(By.id("fromAccountId"));
			Select sel = new Select(findFromAccount);
			sel.selectByVisibleText(fromAccount);
			reportStep("Loan From Amount Is Selected", "Pass");
		} catch (Exception e) {
			reportStep("Loan From Amount Is Not Selected", "Fail");

		}
		return this;
	}
	
	public Request_Loan_Final_Screen clickLoanApplyNowButton() throws IOException
	{
		try {
			//click the Apply Now button
			driver.findElement(By.xpath("//input[@value='Apply Now']")).click();
			reportStep("Loan Apply Now Button Is Clicked", "Pass");
		} catch (Exception e) {
			reportStep("Loan Apply Now Button Is Not Clicked", "Fail");
		}
		return new Request_Loan_Final_Screen(driver);
	}
	
}
