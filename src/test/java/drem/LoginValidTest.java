package drem;



import com.microsoft.playwright.*;

public class LoginValidTest {
    
    	public static void main(String[]args) throws InterruptedException {
			
			Playwright playwright = Playwright.create();
		      
		      BrowserType browserType = playwright.chromium();
		      
		      Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chromium"));
		      
		      BrowserContext browserContext = browser.newContext();
		      
		      Page page = browserContext.newPage();
		      
		      page.navigate("https://www.saucedemo.com/");
		      Thread.sleep(2000);
		      
		      page.fill("#user-name","problem_user");
		    
		      Thread.sleep(2000);
		      page.fill("#password", "secret_sauce");
		      Thread.sleep(2000);
		      page.click("#login-button");
		      Thread.sleep(20000);
		      
		      System.out.println(page.title());
		      if(page.isVisible(".title")) {
		    	  System.out.println("Login successfull, login page loaded : ");
		      }else {
		    	  System.out.println("Login faild :");
		      }
		    //  playwright.close();
		    //  browser.close();
		      
    	}
		    
    }