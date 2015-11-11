package selenium_maven_eclipse;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import selenium.util.WebUtils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CommonCeneoTestMVN {
	public WebDriver driver = new FirefoxDriver();
	CeneoTestHelper ctHelper = new CeneoTestHelper(driver);

	@BeforeTest

	public void BeforeTest() {

		driver.get("http://www.ceneo.pl/");
	}

	
	@Test
	public void Auth(){	
		ctHelper.authorizationProcess();
		String avatarName = driver.findElement(By.cssSelector("div.avatar-label")).getText();
		Assert.assertEquals("Kseniya", avatarName);
		System.out.println("User is logged in successfully");
	}
	
	@Test
	public void selectCategory(){
		ctHelper.selectPhoneCategory();
		String catigoryTitle = driver.findElement(By.cssSelector(".breadcrumbs > dl:nth-child(1) > dd:nth-child(2) > strong:nth-child(2)")).getText();
		Assert.assertEquals("Telefony i akcesoria", catigoryTitle);
		System.out.println("Select category is successfully");
	}
	
	@Test
	public void searchProduct(){
		ctHelper.search("Lenovo");
		List<WebElement> elements = driver.findElements(By.className("cat-prod-row-name"));
		for(WebElement element:elements){
			String productName = element.getText();
			productName = productName.toLowerCase();
			Assert.assertTrue(productName.contains("lenovo"));
		}
		
	}
	
	@Test
	public void selectFilters(){
		ctHelper.selectAndApplyFilters();
		String numberOfElements = driver.findElement(By.cssSelector(".root-level > span:nth-child(1)")).getText();
		Assert.assertEquals("5", numberOfElements);
	}
	
	@Test(enabled=false)
	public void Login() {
		System.out.println("Search only 'Lenovo' phones - successfully");

		// *Filter: select od 359 do 799, select Krakow, click
		// Filtruj.
		
		System.out.println("Filter items - successfully");

		// * Select phone with id=38365518, Lenovo A7000 Czarny
		driver.findElement(By.xpath(".//*[@id='body']/div[2]/div[2]/div/section/div[1]/div/div")).click(); // *
																											// <--
																											// can't
																											// find
																											// locator
		System.out.println("Select one of phones - successfully");

		// *Click Buy button
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-m.btn-cta.add-to-basket-no-popup")).click();
		System.out.println("Click Buy and go to basket - successfully");

		// *Change existing address
		driver.findElement(By.cssSelector(".js_toggle-form.profile-addres-button")).click();
		driver.findElement(By.cssSelector("#FirstName-new-address-form")).sendKeys("Kseniya");
		driver.findElement(By.cssSelector("#LastName-new-address-form")).sendKeys("Test");
		driver.findElement(By.cssSelector("#StreetAndNumber-new-address-form")).sendKeys("Baszczowa 13");
		driver.findElement(By.cssSelector("#PostalCode-new-address-form")).sendKeys("31-866");
		driver.findElement(By.cssSelector("#City-new-address-form")).sendKeys("Krakow");
		driver.findElement(By.cssSelector("#PhoneNumber-new-address-form")).sendKeys("111111111");
		driver.findElement(By.cssSelector(
				"body > div.checkout-content > div > div > div > div > section > div.js_form-container.profile-addres-card.profile-card-anim > div.js_new-address-form.profile-addres-expanded.js_postback-container > form > div > input"))
				.click();
		System.out.println("Set address - successfully");

		// *Return to catalog and go to basket
		driver.findElement(By.cssSelector("body > div.checkout-navbar > div > a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[3]/a[2]")).click();
		System.out.println("Enter the basket - successfully");

		// *Delete all products from basket
		driver.findElement(By.cssSelector(
				"body > div.checkout-content > div > form > div.checkout-main-content > div.basket.js_shopOffers-container.js_scroll-top > div > div > div.basket-item__row.basket-details > div.basket-details__total.basket-details-total > a"))
				.click();

		// Confirm delete action
		driver.findElement(By.cssSelector("body > div.js_popup.popup > div > div > button")).click();
		System.out.println("Remove product from basket - successfully");

		// Check if basket is empty - check message about that
		System.out.println("Test passed");

	}


	



	@AfterTest
	public void AfterTest() {
		// *Close browser
		// *driver.close();
	}
}
