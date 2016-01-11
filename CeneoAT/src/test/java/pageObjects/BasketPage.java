package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {
	
	private WebDriver driver;

	public BasketPage(WebDriver driver) {
		this.driver = driver;}
	
	public void AddNewAddressProcess(String firstName, String lastName, String address, String postalCode, String town,
			String phoneNumber) {//Basket
		driver.findElement(By.cssSelector(".js_toggle-form.js_new-form")).click();
		driver.findElement(By.id("FirstName-new-address-form")).sendKeys(firstName);
		driver.findElement(By.id("LastName-new-address-form")).sendKeys(lastName);
		driver.findElement(By.id("StreetAndNumber-new-address-form")).sendKeys(address);
		driver.findElement(By.id("PostalCode-new-address-form")).sendKeys(postalCode);
		driver.findElement(By.id("City-new-address-form")).sendKeys(town);
		driver.findElement(By.id("PhoneNumber-new-address-form")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/section/div[3]/div[3]/form/div/input")).click();

	}
	
	public void EmptyBasketProcess() {//Basket
		driver.findElement(By.cssSelector(".js_change-offer-quantity.dotted-link.link--remove")).click();
		driver.findElement(By.cssSelector(".btn.btn-info.js_popup-ok")).click();
	}
	
	public String getMessage () {//Basket
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-message>h2")));
		return driver.findElement(By.cssSelector(".alert.alert-message>h2")).getText();
		
	}
	

}
