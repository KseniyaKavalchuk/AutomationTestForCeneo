package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {
	
	private WebDriver driver;

	public StartPage(WebDriver driver) {
		this.driver = driver;}
	
	public void authorizationProcess() {//Start
		driver.findElement(By.cssSelector(".my-account>a")).click();
		driver.findElement(By.cssSelector(".submenu-social-logo.account-ceneo-logo.js_ceneo-login-btn")).click();
		driver.findElement(By.name("Login")).sendKeys("kseni.k38@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("1testtest");
		driver.findElement(By.cssSelector(".btn.btn-info")).click();
	}
	
	public String getAvatarName() {//Start page
		return driver.findElement(By.cssSelector("div.avatar-label")).getText();
	}
	public void selectCategory() {//Start
		driver.findElement(By.cssSelector("#categories-menu > li:nth-child(24) > a")).click();
	}

}
