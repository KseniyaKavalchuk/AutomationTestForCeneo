package selenium_maven_eclipse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CeneoTestHelper {

	private WebDriver driver;

	public CeneoTestHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void openCeneoPl() {
		driver.get("http://www.ceneo.pl/");
	}

	public void authorizationProcess() {
		driver.findElement(By.cssSelector(".my-account>a")).click();
		driver.findElement(By.cssSelector(".submenu-social-logo.account-ceneo-logo.js_ceneo-login-btn")).click();
		driver.findElement(By.name("Login")).sendKeys("kseni.k38@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("1testtest");
		driver.findElement(By.cssSelector(".btn.btn-info")).click();
	}

	public void search(String query) {
		driver.findElement(By.cssSelector("#form-head-search-q")).sendKeys(query);
		driver.findElement(By.cssSelector(".js_header-search-form-button")).click();
	}

	public void clickBuyButton() {
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-m.btn-cta.add-to-basket-no-popup.js_add-to-basket"))
				.click();
	}

	public void AddNewAddressProcess(String firstName, String lastName, String address, String postalCode, String town,
			String phoneNumber) {

		driver.findElement(By.className("js_toggle-form js_new-form")).click();
		driver.findElement(By.id("FirstName-new-address-form")).sendKeys(firstName);
		driver.findElement(By.id("LastName-new-address-form")).sendKeys(lastName);
		driver.findElement(By.id("StreetAndNumber-new-address-form")).sendKeys(address);
		driver.findElement(By.id("PostalCode-new-address-form")).sendKeys(postalCode);
		driver.findElement(By.id("City-new-address-form")).sendKeys(town);
		driver.findElement(By.id("PhoneNumber-new-address-form")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/section/div[3]/div[3]/form/div/input")).click();
	}

	public void EmptyBasketProcess() {
		driver.findElement(By.cssSelector(".js_change-offer-quantity.dotted-link.link--remove")).click();
		driver.findElement(By.cssSelector(".btn.btn-info.js_popup-ok")).click();
	}

}
