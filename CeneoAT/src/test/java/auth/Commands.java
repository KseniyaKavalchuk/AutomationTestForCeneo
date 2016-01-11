package auth;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class Commands {

	public WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	public void openCeneoPl() throws ClientProtocolException, IOException {
		driver.get("http://codingbat.com/");
		AuthHelper helper = new AuthHelper();
		Cookie cookie = helper.codingbatGetAuthCookie();
		System.out.println(cookie);
		driver.manage().deleteAllCookies();
		driver.manage().addCookie(cookie);
		driver.get("http://codingbat.com/java/String-1");
	}
	@Test
	public void checkAuthorization () throws ClientProtocolException, IOException{
		

		String name = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[2]/td/b")).getText();
		Assert.assertTrue(name.contains("ksuha"));
	}

}
