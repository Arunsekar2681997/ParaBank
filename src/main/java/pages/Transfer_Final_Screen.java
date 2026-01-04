package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.BaseClass;

public class Transfer_Final_Screen extends BaseClass {
	
	public Transfer_Final_Screen(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	
	public Transfer_Final_Screen verifyTransferFinalScreen() throws InterruptedException, IOException
	{
		try {
			Thread.sleep(3000);
			WebElement transfer_Confirmation_Check = driver.findElement(By.xpath("//div[@id='showResult']/p"));
			String get_Message = transfer_Confirmation_Check.getText();
			if (get_Message.contains("transferred ")) {
				System.out.println("Transfer Success");	
				Assert.assertTrue(true);
				}
			else {
				System.out.println("Transfer Failed");
				Assert.fail("Transfer Failed For Some Reason");
			}
			reportStep("Transfer Final Screen Content Is Verified", "Pass");
		} catch (InterruptedException e) {
			reportStep("Transfer Final Screen Content Is Not Verified", "Fail");
		}
		
		return this;
		
	}
	
}
