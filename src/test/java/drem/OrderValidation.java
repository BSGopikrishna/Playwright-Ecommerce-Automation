package drem;
import com.microsoft.playwright.*;
import java.util.*;

public class OrderValidation {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser = browserType.launch(
            new BrowserType.LaunchOptions().setHeadless(false).setChannel("chromium").setSlowMo(2000));
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
        page.fill("#last-name", "Don");
        page.fill("#postal-code", "560001"); 
        page.click("#continue");
        page.click("#finish");
        
        if (page.isVisible(".complete-header")) {
            String message = page.textContent(".complete-header");
            System.out.println(" Order placed successfully: " + message);

           
            List<String> ordersDB = new ArrayList<>();
            ordersDB.add("Order: Sauce Labs Backpack");

            System.out.println("Orders in simulated DB: " + ordersDB.size());
            System.out.println("Latest order: " + ordersDB.get(0));
        } else {
            System.out.println(" Order placement failed.");
        }

        System.out.println("Page title: " + page.title());
        browser.close();
    }
}