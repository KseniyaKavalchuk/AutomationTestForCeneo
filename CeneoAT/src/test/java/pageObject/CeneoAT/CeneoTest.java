package pageObject.CeneoAT;

import java.util.List;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.BasketPage;
import pageObjects.CategoryPage;
import pageObjects.ProductPage;
import pageObjects.StartPage;

public class CeneoTest {
	public WebDriver driver = new FirefoxDriver();
	PoHelper poHelper = new PoHelper(driver);
	StartPage startP = new StartPage(driver);
	CategoryPage categoryP = new CategoryPage(driver);
	ProductPage productP = new ProductPage(driver);
	BasketPage basketP = new BasketPage(driver);

	
	@BeforeClass
	public void openWebSite () {
		poHelper.openCeneoPl();
		
	}
	
	@AfterClass
	public void closeBrowser() {
		//poHelper.closeBrowser();
	}
	
	@Test(priority=0)
	public void authorization(){
		startP.authorizationProcess();
		String avatarName = startP.getAvatarName();
		Assert.assertEquals("Kseniya", avatarName);
	}
	
	@Test(priority=1)
	public void searchProduct(){
		List<WebElement> elements = categoryP.GetListOfPhones();
		startP.selectCategory();
		categoryP.search("lenovo a6000");
		for(WebElement element:elements){
			String productName = element.getText();
			productName = productName.toLowerCase();
			Assert.assertTrue(productName.contains("lenovo"));
		}
	}
		
	@Test(priority=2)
	public void selectPhone(){
		String ProductTitle = categoryP.selectProduct();
		Assert.assertTrue(ProductTitle.contains("Lenovo A6000"));
	}
	
	@Test(priority=3)
	public void addProductToBasket() {
		productP.clickBuyButton();
		String ProductCount = productP.clickBuyButton();
		Assert.assertEquals("1",ProductCount);
	}
	
	@Test(priority=4)
	public void ChangeDeliveryAddress() {
		basketP.AddNewAddressProcess("Kseniya", "Test", "Baszczowa 13", "31-866", "Krakow", "111111111");
	}
	
	@Test(priority=5)
	public void emptyBasket() {
		basketP.EmptyBasketProcess();
		String Message = basketP.getMessage();
		Assert.assertTrue(Message.contains("koszyk jest na razie pusty"));
	}
    
	
}
