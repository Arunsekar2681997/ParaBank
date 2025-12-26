package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class Dashboard_Page extends BaseClass{
	
	public Dashboard_Page(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public Prelogin_Page clickLogOutButton() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			reportStep("Clicked Logout Button", "Pass");
		} catch (Exception e) {
			reportStep("Unable to Click Logout Button", "Fail");
		}	
		return new Prelogin_Page(driver);
	}
	
	public OpenNewAccount_Input_Screen clickOpenNewAccount() throws IOException
	{
		try {
			WebElement click_Open_New_Account_Menu = driver.findElement(By.xpath("//a[text()='Open New Account']"));
			click_Open_New_Account_Menu.click();
			reportStep("Clicked Open New Account Option", "Pass");
		} catch (Exception e) {
			
			reportStep("Unable to Click Open New Account Option", "Fail");
		}
		
		return new OpenNewAccount_Input_Screen(driver);
	}
	
	public Request_Loan_Input_Screen clickRequestLoan() throws IOException
	{
		//click Request loan button
			try {
				driver.findElement(By.linkText("Request Loan")).click();
				reportStep("Click The Request Loan Option", "Pass");
			} catch (Exception e) {
			
				reportStep("Unable to Click The Request Loan Option", "Fail");
			}
			
			return new Request_Loan_Input_Screen(driver);
	}
	
	
	public Transfer_Input_Screen clickTransferFundsOption() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		
		try {
			WebElement click_Transfer_Funds_Option = driver.findElement(By.xpath("//a[text()='Transfer Funds']"));			
			click_Transfer_Funds_Option.click();
			reportStep("Clicked The Transfer Funds Option", "Pass");
		} catch (Exception e) {
			reportStep("Unable to Click The Transfer Funds Option", "Fail");
		}
		
		return new Transfer_Input_Screen(driver);
	}
	
	

}
