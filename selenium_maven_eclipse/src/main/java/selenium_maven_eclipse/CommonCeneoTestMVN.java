package selenium_maven_eclipse;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CommonCeneoTestMVN {
	public WebDriver driver = new FirefoxDriver();
	CeneoTestHelper ctHelper = new CeneoTestHelper(driver);
	
	@BeforeClass
	public void OpenWebSite () {
		ctHelper.openCeneoPl();
	}
	
	@Test
	public void Authorization(){	
		ctHelper.authorizationProcess();
		String avatarName = driver.findElement(By.cssSelector("div.avatar-label")).getText();
		Assert.assertEquals("Kseniya", avatarName);
		System.out.println("User is logged in successfully");
	}

	@Test
	public void searchProduct(){
		ctHelper.search("lenovo a6000");
		List<WebElement> elements = driver.findElements(By.className("cat-prod-row-name"));
		for(WebElement element:elements){
			String productName = element.getText();
			productName = productName.toLowerCase();
			Assert.assertTrue(productName.contains("lenovo"));
			Assert.assertTrue(productName.contains("a6000"));
		}
	}
	@Test
	public void selectProduct() {
		WebElement link = driver.findElement(By.xpath(".//*[@id='body']/div[2]/div[2]/div/section/div[1]/div[1]/div/div[2]/strong/a"));
		link.click();
		String linkLocation = link.getAttribute("href");
		Assert.assertTrue(linkLocation.contains("39820599"));
	}
	@Test
	public void addProductToBasket() {
		ctHelper.clickBuyButton();
		String productPrice = driver.findElement(By.className("price")).getText();
		String totalPrice = driver.findElement(By.className("price js_total-price")).getText();
		Assert.assertEquals(totalPrice, productPrice);
	}
	@Test
	public void setNewDeliveryAddress() {
		
		ctHelper.AddNewAddressProcess("Kseniya", "Test", "Baszczowa 13", "31-866", "Krakow", "111111111");
	
	}
	@Test
	public void DeleteAddress() {
	driver.findElement(By.cssSelector(".profile-addres-button.js_delete-form")).click();
	driver.findElement(By.cssSelector(".btn.btn-info.js_popup-ok")).click();
	}
	
	@Test
	public void emptyBasket() {
		ctHelper.EmptyBasketProcess();	
		String Message = driver.findElement(By.cssSelector(".alert.alert-message>h2")).getText();
		Assert.assertTrue(Message.contains("koszyk jest na razie pusty"));
	}
    
	@AfterClass
	public void closeBrowser() {
		//*driver.close();
	}
}
