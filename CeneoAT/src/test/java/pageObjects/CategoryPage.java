package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CategoryPage {
	
	private WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;}
	
	public List<WebElement> GetListOfPhones () {//category page
		List<WebElement> elements = driver.findElements(By.className("cat-prod-row-name"));
		return elements;
		}
	
	public void search(String query) {//Category page
		driver.findElement(By.cssSelector("#form-head-search-q")).sendKeys(query);
		driver.findElement(By.cssSelector(".js_header-search-form-button")).click();
	}
	
	public String selectProduct() {//category page - List after search
		driver.findElement(By.xpath(".//*[@id='body']/div[2]/div[2]/div/section/div[1]/div[1]/div/div[2]/strong/a")).click();
		String ProductTitle = driver.findElement(By.cssSelector(".product-name.js_product-h1-link.js_product-force-scroll")).getText();
		return ProductTitle;
	}
	

}
