package drem;
import com.microsoft.playwright.*;
public class AddSingleItem {
	public static void main(String[]args)throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.firefox();
		Browser browser =browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("firefox"));
		BrowserContext browserContext=browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.saucedemo.com/");
		Thread.sleep(2000);
		page.fill("#user-name", "standard_user");
		Thread.sleep(2000);
		page.fill("#password", "secret_sauce");
		Thread.sleep(2000);
		page.click("#login-button");
		Thread.sleep(2000);
		page.click("text=Add to cart"); 
		Thread.sleep(5000);
		String cartCount =page.textContent(".shopping_cart_badge");
		System.out.println("Cart count :"+cartCount);
		if("1".equals(cartCount)) {
			System.out.println("Single Item Added successfully :");
		}else {
			System.out.println(" X cart Validation failed : ");
		}
		
		System.out.println(page.title());
		browser.close();
		playwright.close();
	}

}
