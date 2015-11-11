package selenium_maven_eclipse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CeneoTestHelper {

	private WebDriver driver;
	
	public CeneoTestHelper(WebDriver driver){
		this.driver = driver;
	}
	
	public void authorizationProcess() {
		driver.findElement(By.cssSelector(".my-account>a")).click();
		driver.findElement(By.cssSelector(".submenu-social-logo.account-ceneo-logo.js_ceneo-login-btn")).click();
		driver.findElement(By.name("Login")).sendKeys("kseni.k38@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("1testtest");
		driver.findElement(By.cssSelector(".btn.btn-info")).click();
	}
	

	public void selectPhoneCategory() {
		driver.findElement(By.xpath(".//*[@id='categories-menu']/li[24]/a")).click();
		System.out.println("Category 'Telefony i akcesori' is selected");
	}
	
	public void search(String query) {
		driver.findElement(By.cssSelector("#form-head-search-q")).sendKeys(query);
		driver.findElement(By.cssSelector(".js_header-search-form-button")).click();
	}
	
	//TODO: improve selectors in this method
	public void selectAndApplyFilters() {
		driver.findElement(By.xpath(".//*[@id='body']/div[2]/div[1]/form/section[2]/div/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='body']/div[2]/div[1]/form/section[4]/div/div[2]/dl/dd[1]/ul/li[2]/a"))
				.click();
		driver.findElement(By.cssSelector(".btn.btn-info")).click();
	}
	
	
	
}
