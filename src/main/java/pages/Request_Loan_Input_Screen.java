package pages;

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

	public Request_Loan_Input_Screen enterLoanAmount(String loanAmount)
	{
		//enter loan amount
		driver.findElement(By.id("amount")).sendKeys(loanAmount);
		return this;
	}
	
	public Request_Loan_Input_Screen enterDownPaymentAmount(String downPaymentAmount)
	{
		//enter down payment amount
		driver.findElement(By.id("downPayment")).sendKeys(downPaymentAmount);
		return this;		
	}
	
	public Request_Loan_Input_Screen selectFromAccount(String fromAccount)
	{
		//select the from account
		WebElement findFromAccount = driver.findElement(By.id("fromAccountId"));
		Select sel = new Select(findFromAccount);
		sel.selectByVisibleText(fromAccount);
		return this;
	}
	
	public Request_Loan_Final_Screen clickLoanApplyNowButton()
	{
		//click the Apply Now button
		driver.findElement(By.xpath("//input[@value='Apply Now']")).click();
		return new Request_Loan_Final_Screen(driver);
	}
	
}
