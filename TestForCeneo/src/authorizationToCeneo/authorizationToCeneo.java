package authorizationToCeneo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class authorizationToCeneo {

	public static void main(String[] args) {
			
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ceneo.pl/");
		
		//*LOGIN TO CENEO PL
		driver.findElement(By.cssSelector("body > div.page-body > header > div.preheader > div > ul > li > a")).click();
		driver.findElement(By.cssSelector("body > div.page-body > header > div.preheader > div > ul > li > div > div > div.submenu-unlogin-home > div.submenu-unlogin-content > table > tbody > tr:nth-child(2) > td:nth-child(1) > span.submenu-social-logo.account-ceneo-logo.js_ceneo-login-btn")).click();
		driver.findElement(By.name("Login")).sendKeys("kseni.k38@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("1testtest");
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/ul/li/div/div/div[4]/form/div[2]/input")).click();
		System.out.println ("User is logged in successfully");
		
		//*Go to category "Telefony i akcesori"
		driver.findElement(By.cssSelector("#categories-menu > li:nth-child(24) > a")).click();
		System.out.println ("Category 'Telefony i akcesori' is selected");
		
		//*Add criteria to Search and Click "Szukaj" button
		driver.findElement(By.cssSelector("#form-head-search-q")).sendKeys("Lenovo");
		driver.findElement(By.cssSelector("body > div.page-body > header > div.header-container > div > div.header-search > form > button > span.search-text")).click();
		System.out.println ("Search only 'Lenovo' phones - successfully");
		
		//*Filter: select od 359 do 799, check lenovo, select Krakow, click Filtruj.
		driver.findElement(By.cssSelector("#body > div:nth-child(2) > div.site-left-col.js_sidebar > form > section:nth-child(4) > div > div > ul > li:nth-child(2) > a")).click();
		driver.findElement(By.name("form-body-filters-multi")).click();
		driver.findElement(By.cssSelector("#body > div:nth-child(2) > div.site-left-col.js_sidebar > form > section:nth-child(6) > div > div.city-filter.js_city-filter > dl > dd:nth-child(2) > ul > li:nth-child(2) > a")).click();
		driver.findElement(By.cssSelector("#body > div:nth-child(2) > div.site-left-col.js_sidebar > form > div > input")).click();
		System.out.println ("Filter items - successfully");
		
		//* Select some phone
		driver.findElement(By.cssSelector("#body > div:nth-child(2) > div.site-left-content > div > section > div.category-list-body.js_category-list-body.js_search-results > div:nth-child(2) > div > div.cat-prod-row-desc > strong > a")).click();
		System.out.println ("Select one of phones - successfully");
		
		//* Return to previous page
		driver.navigate().back();
		driver.findElement(By.cssSelector("#body > div:nth-child(2) > div.site-left-content > div > section > div.category-list-body.js_category-list-body.js_search-results > div:nth-child(4) > div > div.cat-prod-row-desc > strong > a")).click();
		System.out.println ("Back and find another phone - successfully");
		
		//*Click Buy button
		driver.findElement(By.cssSelector("#body > div.no-banner > div > div > div:nth-child(1) > article > div.product-content > div.aggregate-offer > a.btn.btn-primary.btn-m.btn-cta.add-to-basket-no-popup")).click();
		System.out.println ("Click Buy and go to basket - successfully");
		
		// Add address
		driver.findElement(By.cssSelector("body > div.checkout-content > div > div > div > div > section > div.js_form-container.profile-addres-card.profile-addres-card-new > div.profile-new-container.js_new-address-form > div > button")).click();
		driver.findElement(By.cssSelector("#FirstName-new-address-form")).sendKeys("Kseniya");
		driver.findElement(By.cssSelector("#LastName-new-address-form")).sendKeys("Test");
		driver.findElement(By.cssSelector("#StreetAndNumber-new-address-form")).sendKeys("Baszczowa 13");
		driver.findElement(By.cssSelector("#PostalCode-new-address-form")).sendKeys("31-866");
		driver.findElement(By.cssSelector("#City-new-address-form")).sendKeys("Krakow");
		driver.findElement(By.cssSelector("#PhoneNumber-new-address-form")).sendKeys("111111111");
		driver.findElement(By.cssSelector("body > div.checkout-content > div > div > div > div > section > div.js_form-container.profile-addres-card.profile-card-anim > div.js_new-address-form.profile-addres-expanded.js_postback-container > form > div > input")).click();
		System.out.println ("Set address - successfully");
		
		//*Return to catalog and go to basket
		driver.findElement(By.cssSelector("body > div.checkout-navbar > div > a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[3]/a[2]")).click();
		System.out.println ("Enter the basket - successfully");
		
		//*Delete all products from basket
		driver.findElement(By.cssSelector("body > div.checkout-content > div > form > div.checkout-main-content > div.basket.js_shopOffers-container.js_scroll-top > div > div > div.basket-item__row.basket-details > div.basket-details__total.basket-details-total > a")).click();
		
		//Confirm delete action
		driver.findElement(By.cssSelector("body > div.js_popup.popup > div > div > button")).click();
		System.out.println ("Remove product from basket - successfully");
		
		//Check if basket is empty - check message about that
		System.out.println ("Test passed");
		
		//*Close browser
		//*driver.close();
		
	}

}
