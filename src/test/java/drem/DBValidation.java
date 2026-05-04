package drem;
import com.microsoft.playwright.*;
import java.util.*;

public class DBValidation {
    public static void main(String[] args) throws InterruptedException {
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
        page.click("#add-to-cart-sauce-labs-bike-light");
        
        page.waitForSelector(".shopping_cart_badge");
        String cartCountUI = page.textContent(".shopping_cart_badge");
        
        System.out.println("Cart count (UI): " + cartCountUI);
        page.click(".shopping_cart_link");
        System.out.println("Cart page opened: " + page.textContent(".title"));
        
        List<String> cartItemsDB = new ArrayList<>();
        cartItemsDB.add("Sauce Labs Backpack");
        cartItemsDB.add("Sauce Labs Bike Light");

        System.out.println("Cart count (Simulated DB): " + cartItemsDB.size());

        if (Integer.parseInt(cartCountUI) == cartItemsDB.size()) {
            System.out.println(" Cart validation successful.");
        } else {
            System.out.println(" Cart validation failed.");
        }

        System.out.println("Page title: " + page.title());
        browser.close();
    }
}