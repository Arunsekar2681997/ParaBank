package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class Prelogin_Page extends BaseClass {
	
	public Prelogin_Page(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public Prelogin_Page enterUsername(String uName)
	{
		try {
			WebElement enter_Username = driver.findElement(By.xpath("//input[@name='username']"));		
			enter_Username.sendKeys(uName);
			reportStep("User Name Is Entered Successfully", "Pass");
		} catch (Exception e) {
			reportStep("User Name Is Not Entered", "Pass");
		}
		return this;
	}
	
	public Prelogin_Page enterPassword(String password)
	{
		try {
			WebElement enter_Password = driver.findElement(By.xpath("//input[@name='password']"));
			enter_Password.sendKeys(password);
			reportStep("Password Entered Successfully", "Pass");
		} catch (Exception e) {
			reportStep("Password Is Not Entered", "Fail");
		}	
		return this;
	}
	
	public Dashboard_Page clickLoginButton()
	{
		try {
			WebElement click_Login_Button = driver.findElement(By.xpath("//input[@value='Log In']"));		
			click_Login_Button.click();
			reportStep("Login Button Is Clicked", "Pass");
		} catch (Exception e) {
			reportStep("Login Button Is Not Clicked", "Fail");
		}	
		return new Dashboard_Page(driver);
	}
	
	
	public Prelogin_Page getPageTitle() throws InterruptedException
	{
		try {
			Thread.sleep(3000);
			String pageTitle = driver.getTitle();
			System.out.println("Page Title Is : "+pageTitle);
			if (pageTitle.contains("Welcome")) {
				System.out.println("Logout Success");
			} else {
				System.out.println("Logout Is Not Success");
			}
			reportStep("Logged In To The Application", "Pass");
		} catch (InterruptedException e) {
			reportStep("Login Is Not Successful", "Fail");
		}
		
		return this;
		
	}
	
}
		