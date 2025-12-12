package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class Transfer_Input_Screen extends BaseClass{
	
	public Transfer_Input_Screen(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public Transfer_Input_Screen enterTransferAmount(String transferAmount) throws InterruptedException
	{
		try {
			Thread.sleep(3000);
			WebElement enter_Amount = driver.findElement(By.id("amount"));
			enter_Amount.sendKeys(transferAmount);
			reportStep("Transfer Amount Is Entered", "Pass");
		} catch (InterruptedException e) {
			reportStep("Transfer Amount Is Not Entered", "Fail");
		}
		
		return this;
	}
	
	public Transfer_Input_Screen selectFromAccount(String fromAccount) throws InterruptedException
	{
		try {
			Thread.sleep(3000);	
			WebElement click_From_Account_Dropdown = driver.findElement(By.id("fromAccountId"));	
			Select select_From_Account = new Select(click_From_Account_Dropdown);	
			select_From_Account.selectByValue(fromAccount);
			reportStep("From Account Is Selected", "Pass");
		} catch (InterruptedException e) {
			reportStep("From Account Is Not Selected", "Fail");
		}
		
		return this;
	}
	
	public Transfer_Input_Screen selectToAccount(String toAccount) throws InterruptedException
	{
		try {
			Thread.sleep(3000);
			WebElement click_To_Account_Dropdown = driver.findElement(By.id("toAccountId"));
			Select select_To_Account = new Select(click_To_Account_Dropdown);
			select_To_Account.selectByValue(toAccount);
			reportStep("To Account Is Selected", "Pass");

		} catch (InterruptedException e) {
			reportStep("To Account Is Not Selected", "Fail");
		}
		
		return this;
	}
	
	public Transfer_Final_Screen clickTransferButton() throws InterruptedException
	{
		try {
			Thread.sleep(3000);	
			WebElement click_Transfer_Button = driver.findElement(By.xpath("//input[@value='Transfer']"));	
			click_Transfer_Button.click();
			reportStep("Tranfer Button Is Clicked", "Pass");
		} catch (InterruptedException e) {
			reportStep("Tranfer Button Is Not Clicked", "Fail");
		}
		
		return new Transfer_Final_Screen(driver);
		
	}

}
