package drem;
import com.microsoft.playwright.*;
public class RemoveItem {
	public static void main(String[]args)throws InterruptedException {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.firefox();
		Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("firefox").setSlowMo(1000));
		BrowserContext browserContext = browser.newContext();
		Page page =browserContext.newPage();
		page.navigate("https://www.saucedemo.com/");
		Thread.sleep(2000);
		page.fill("#user-name", "standard_user");
		Thread.sleep(2000);
		page.fill("#password","secret_sauce");
		Thread.sleep(2000);
		page.click("#login-button");
		Thread.sleep(2000);
		page.click("#add-to-cart-sauce-labs-backpack");
		Thread.sleep(2000);
		page.click("#add-to-cart-sauce-labs-bike-light");
		Thread.sleep(2000);
		page.click("#add-to-cart-sauce-labs-bolt-t-shirt");
		Thread.sleep(2000);
		page.click(".shopping_cart_link");
		Thread.sleep(2000);
		page.click("#remove-sauce-labs-backpack");
		Thread.sleep(2000);
		page.click("#remove-sauce-labs-bike-light");
		Thread.sleep(2000);
		if(page.isVisible(".shopping_cart_badge")) {
			String cartCount =page.textContent(".shopping_cart_badge");
			System.out.println("Cart count after removel :"+cartCount);
		}else {
			System.out.println("Cart is empty after removel : ");
		}
		
		System.out.println(page.title());
		browser.close();
		playwright.close();
	}

}
