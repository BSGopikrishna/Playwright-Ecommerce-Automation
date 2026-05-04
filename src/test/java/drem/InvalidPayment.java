package drem;
import com.microsoft.playwright.*;
public class InvalidPayment {
	public static void main(String[]args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.webkit();
		Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("webkit").setSlowMo(2000));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.saucedemo.com/");
		page.fill("#user-name", "standard_user");
		page.fill("#password", "secret_sauce");
		page.click("#login-button");
		page.click("#add-to-cart-sauce-labs-backpack");
		page.click(".shopping_cart_link");
		page.click("#checkout");
		page.fill("#first-name", "John");
		page.fill("#last-name","Don");
		page.click("#continue");
		Thread.
		sleep(3000);
		if(page.isVisible("h3[data-test='error']")) {
		String error=page.textContent("h3[data-test='error']");
		System.out.println("Erroe Displayed : "+error);
		}else {
			
			System.out.println(" No Erroe message found : ");
		}
		System.out.println(page.title());
		browser.close();
		
		
	}

}
