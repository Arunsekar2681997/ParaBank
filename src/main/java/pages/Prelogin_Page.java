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
		WebElement enter_Username = driver.findElement(By.xpath("//input[@name='username']"));		
		enter_Username.sendKeys(uName);
		return this;
	}
	
	public Prelogin_Page enterPassword(String password)
	{
		WebElement enter_Password = driver.findElement(By.xpath("//input[@name='password']"));
		enter_Password.sendKeys(password);	
		return this;
	}
	
	public Dashboard_Page clickLoginButton()
	{
		WebElement click_Login_Button = driver.findElement(By.xpath("//input[@value='Log In']"));		
		click_Login_Button.click();	
		return new Dashboard_Page(driver);
	}
	
	
	public Prelogin_Page getPageTitle() throws InterruptedException
	{
		Thread.sleep(3000);
		String pageTitle = driver.getTitle();
		System.out.println("Page Title Is : "+pageTitle);
		if (pageTitle.contains("Welcome")) {
			System.out.println("Logout Success");
		} else {
			System.out.println("Logout Is Not Success");
		}
		
		return this;
		
	}
	
}
		