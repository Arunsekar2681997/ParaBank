package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class OpenNewAccount_Final_Screen extends BaseClass {

	public OpenNewAccount_Final_Screen(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public void verifyOpenNewAccountOpening() throws InterruptedException
	{
		Thread.sleep(3000);

		try {
			WebElement verify_Confirmation_Message = driver.findElement(
				    By.xpath("//p[contains(text(),'Congratulations')]")
				);

			String confirmation_Message = verify_Confirmation_Message.getText();
			System.out.println("Captured text: " + confirmation_Message);
			
			if (confirmation_Message.contains("Congratulations")) {
				System.out.println("Account Is Created");
			}
			else {
				System.out.println("Account Is Not Created");
			}
			reportStep("Application navigated to Confirmation Screen", "Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("Application Not Navigated to Confirmation Screen", "Fail");
		}
	}


	
}
