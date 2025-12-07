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
		
		WebElement click_Account_Selection_Dropdown = driver.findElement(By.id("type"));
		
	//	click_Account_Selection_Dropdown.click();
		
		Select sel = new Select(click_Account_Selection_Dropdown);
		
		sel.selectByVisibleText(accountType);
		
		return this;
	}
	
	
	public OpenNewAccount_Input_Screen selectOpeningAccountAmount(String accountAmount)
	{
		WebElement select_Account_Amount = driver.findElement(By.id("fromAccountId"));
		
		Select sel1 = new Select(select_Account_Amount);
		
		sel1.selectByValue(accountAmount);
		
		return this;

		
	}
	
	
	public OpenNewAccount_Final_Screen clickOpenNewAccountOption() throws InterruptedException
	{
		WebElement click_Open_New_Account_Option = driver.findElement(By.xpath("//input[@value='Open New Account']"));
		
		click_Open_New_Account_Option.click();
		
		Thread.sleep(3000);
		
		return new OpenNewAccount_Final_Screen(driver);
	}
}
