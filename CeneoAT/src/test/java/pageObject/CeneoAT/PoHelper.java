package pageObject.CeneoAT;

import org.openqa.selenium.WebDriver;

public class PoHelper {
	
	private WebDriver driver;

	public PoHelper(WebDriver driver) {
		this.driver = driver;}
	
	public void openCeneoPl() {
		driver.get("http://www.ceneo.pl/");
	}
	
	public void closeBrowser() {
		driver.close();
	}

}
