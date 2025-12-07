package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class Dashboard_Page extends BaseClass{
	
	public Dashboard_Page(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public Prelogin_Page clickLogOutButton() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();	
		return new Prelogin_Page(driver);
	}
	
	public OpenNewAccount_Input_Screen clickOpenNewAccount()
	{
		WebElement click_Open_New_Account_Menu = driver.findElement(By.xpath("//a[text()='Open New Account']"));
		
		click_Open_New_Account_Menu.click();
		
		return new OpenNewAccount_Input_Screen(driver);
	}
	
	public Request_Loan_Input_Screen clickRequestLoan()
	{
		//click Request loan button
			driver.findElement(By.linkText("Request Loan")).click();
			
			return new Request_Loan_Input_Screen(driver);
	}
	
	
	public Transfer_Input_Screen clickTransferFundsOption() throws InterruptedException
	{
		Thread.sleep(3000);
		
		WebElement click_Transfer_Funds_Option = driver.findElement(By.xpath("//a[text()='Transfer Funds']"));
		
		click_Transfer_Funds_Option.click();
		
		return new Transfer_Input_Screen(driver);
	}

}
