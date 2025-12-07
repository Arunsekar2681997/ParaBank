package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class Transfer_Final_Screen extends BaseClass {
	
	public Transfer_Final_Screen(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	
	public Transfer_Final_Screen verifyTransferFinalScreen() throws InterruptedException
	{
		Thread.sleep(3000);
		
		WebElement transfer_Confirmation_Check = driver.findElement(By.xpath("//div[@id='showResult']/p"));
		
		String get_Message = transfer_Confirmation_Check.getText();
		
		if (get_Message.contains("transferred ")) {
			System.out.println("Transfer Success");		
		}
		else {
			System.out.println("Transfer Failed");
		}
		
		return this;
		
	}
	
}
