package drem;
import com.microsoft.playwright.*;
public class ValidPayment {
	public static void main(String[]args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chromium").setSlowMo(2000));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.saucedemo.com/");
		page.fill("#user-name", "standard_user");
		page.fill("#password","secret_sauce");
		page.click("#login-button");
		page.click("#add-to-cart-sauce-labs-backpack");
		page.click(".shopping_cart_link");
		page.click("#checkout");
		page.fill("#first-name", "JOhn");
		page.fill("#last-name", "Don");
		page.fill("#postal-code", "5600001");
		page.click("#continue");
		page.click("#finish");
		if(page.isVisible(".complete-header")) {
			String message = page.textContent(".complete-header");
			System.out.println("checkout successfull : "+message);
		}else {
			System.out.println("checkout failed : ");
		}
		System.out.println(page.title());
		browser.close();
		
		
	}

}
