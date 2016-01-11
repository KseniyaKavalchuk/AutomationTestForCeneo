package selenium_maven_eclipse;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


@Test
public class CommonCeneoMVNTest {
	public WebDriver driver = new FirefoxDriver();
	CeneoTestHelper ctHelper = new CeneoTestHelper(driver);
	
	@BeforeClass
	public void OpenWebSite () {
		ctHelper.openCeneoPl();
	}
	@AfterClass
	public void closeBrowser() {
		//*driver.close();
	}
	
	
	@Test(priority=0)
	public void Authorization(){	
		ctHelper.authorizationProcess();
		String avatarName = ctHelper.getAvatarName();
		Assert.assertEquals("Kseniya", avatarName);
	}

	@Test(priority=1)
	public void searchProduct(){
		List<WebElement> elements = ctHelper.GetListOfPhones();
		ctHelper.selectCategory();
		ctHelper.search("lenovo a6000");
		for(WebElement element:elements){
			String productName = element.getText();
			productName = productName.toLowerCase();
			Assert.assertTrue(productName.contains("lenovo"));
		}
	}
	@Test(priority=2)
	public void selectProduct() {
		String ProductTitle = ctHelper.selectProduct();
		Assert.assertTrue(ProductTitle.contains("Lenovo A6000"));
	}
	
	@Test(priority=3)
	public void addProductToBasket() {
		ctHelper.clickBuyButton();
		String ProductCount = ctHelper.clickBuyButton();
		Assert.assertEquals("1",ProductCount);
	}
	
	@Test(priority=4)
	public void ChangeDeliveryAddress() {
		ctHelper.AddNewAddressProcess("Kseniya", "Test", "Baszczowa 13", "31-866", "Krakow", "111111111");
	}
	
	@Test(priority=5)
	public void emptyBasket() {
		ctHelper.EmptyBasketProcess();
		String Message = ctHelper.getMessage();
		Assert.assertTrue(Message.contains("koszyk jest na razie pusty"));
	}
    
}
