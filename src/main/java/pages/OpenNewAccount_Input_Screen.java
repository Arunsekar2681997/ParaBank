package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class OpenNewAccount_Input_Screen extends BaseClass{



	public OpenNewAccount_Input_Screen(ChromeDriver driver) {
		this.driver = driver;
	}

	
	
	public OpenNewAccount_Input_Screen selectAccountType(String accountType) throws InterruptedException
	{
		Thread.sleep(3000);
		
		try {
			WebElement click_Account_Selection_Dropdown = driver.findElement(By.id("type"));	
			Select sel = new Select(click_Account_Selection_Dropdown);
			sel.selectByVisibleText(accountType);
			reportStep("Account Type Is Selected Open New Account Input Screen", "Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("Account Type Is Not Selected Open New Account Input Screen", "Fail");
		}
		
		return this;
	}
	
	
	public OpenNewAccount_Input_Screen selectOpeningAccountAmount(String accountAmount)
	{
		try {
			WebElement select_Account_Amount = driver.findElement(By.id("fromAccountId"));
			Select sel1 = new Select(select_Account_Amount);
			sel1.selectByValue(accountAmount);
			reportStep("Opening Account Amount Is Selected", "Pass");
		} catch (Exception e) {
			reportStep("Opening Account Amount Is Not Selected", "Pass");
		}
		
		return this;

		
	}
	
	
	public OpenNewAccount_Final_Screen clickOpenNewAccountOption() throws InterruptedException
	{
		try {
			WebElement click_Open_New_Account_Option = driver.findElement(By.xpath("//input[@value='Open New Account']"));
			click_Open_New_Account_Option.click();
			Thread.sleep(3000);
			reportStep("Open New Account Option Is Clicked", "Pass");
		} catch (InterruptedException e) {
			reportStep("Open New Account Option Is Clicked", "Pass");
		}
		
		return new OpenNewAccount_Final_Screen(driver);
	}
}
