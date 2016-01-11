package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	private WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;}
	
	public String clickBuyButton() {//Product page
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class~=js_add-to-basket]")));
		driver.findElement(By.cssSelector("[class~=js_add-to-basket]")).click();//* Have problem with selector
		String ProductCount = driver.findElement(By.cssSelector(".js_total-offers-count")).getText();
		return ProductCount;
	}

}
