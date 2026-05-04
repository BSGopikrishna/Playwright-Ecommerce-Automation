package drem;
import com.microsoft.playwright.*;
public class AddMultipleItem {
	public static void main(String[]args)throws InterruptedException{
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.firefox();
		Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("firefox"));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.saucedemo.com/");
		Thread.sleep(2000);
		page.fill("#user-name", "standard_user");
		Thread.sleep(2000);
		page.fill("#password","secret_sauce" );
		Thread.sleep(2000);
		page.click("#login-button");
		Thread.sleep(2000);
		
		page.click("#add-to-cart-sauce-labs-backpack");
		Thread.sleep(2000);
		page.click("#add-to-cart-sauce-labs-bike-light");
		Thread.sleep(2000);
		page.click("#add-to-cart-sauce-labs-bolt-t-shirt");
		Thread.sleep(5000);
		
		String cartCount = page.textContent(".shopping_cart_badge");
		System.out.println("Cart count :"+cartCount);
		
		if("3".equals(cartCount)) {
			System.out.println("Multiple items added successfully :");
		}else {
			System.out.println(" cart Validation faild :");
		}
		
		
		
		System.out.println(page.title());
	//	Thread.sleep(2000);
	//	playwright.close();
		browser.close();
	}

}
