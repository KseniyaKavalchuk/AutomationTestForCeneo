package selenium_maven_eclipse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CeneoTestHelper {

	private WebDriver driver;

	public CeneoTestHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void openCeneoPl() {
		driver.get("http://www.ceneo.pl/");
	}

	public void authorizationProcess() {//Start
		driver.findElement(By.cssSelector(".my-account>a")).click();
		driver.findElement(By.cssSelector(".submenu-social-logo.account-ceneo-logo.js_ceneo-login-btn")).click();
		driver.findElement(By.name("Login")).sendKeys("kseni.k38@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("1testtest");
		driver.findElement(By.cssSelector(".btn.btn-info")).click();
	}
	
	public void search(String query) {//Category page
		driver.findElement(By.cssSelector("#form-head-search-q")).sendKeys(query);
		driver.findElement(By.cssSelector(".js_header-search-form-button")).click();
	}
	
	public List<WebElement> GetListOfPhones () {//category page - List after search
	List<WebElement> elements = driver.findElements(By.className("cat-prod-row-name"));
	return elements;
	}
	
	public void selectCategory() {//Start
		driver.findElement(By.cssSelector("#categories-menu > li:nth-child(24) > a")).click();
	}
	
	public String selectProduct() {//category page - List after search
		driver.findElement(By.xpath(".//*[@id='body']/div[2]/div[2]/div/section/div[1]/div[1]/div/div[2]/strong/a")).click();
		String ProductTitle = driver.findElement(By.cssSelector(".product-name.js_product-h1-link.js_product-force-scroll")).getText();
		return ProductTitle;
	}
	
	public String getAvatarName() {//Start page
		return driver.findElement(By.cssSelector("div.avatar-label")).getText();
	}
	
	public String clickBuyButton() {//Product page
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class~=js_add-to-basket]")));
		driver.findElement(By.cssSelector("[class~=js_add-to-basket]")).click();//* Have problem with selector
		String ProductCount = driver.findElement(By.cssSelector(".js_total-offers-count")).getText();
		return ProductCount;
	}
	
	
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
	
	public String getMessage () {//Basket
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-message>h2")));
		return driver.findElement(By.cssSelector(".alert.alert-message>h2")).getText();
		
	}

	public void EmptyBasketProcess() {//Basket
		driver.findElement(By.cssSelector(".js_change-offer-quantity.dotted-link.link--remove")).click();
		driver.findElement(By.cssSelector(".btn.btn-info.js_popup-ok")).click();
	}

}
