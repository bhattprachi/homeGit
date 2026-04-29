package homeGIT;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Saucedemo_homepage {
	  public  WebDriver driver;
	 @BeforeTest
	  public void beforeTest() {
		 		 ChromeOptions options = new ChromeOptions();

		 Map<String, Object> prefs = new HashMap<String, Object>();

		 prefs.put("credentials_enable_service", false);

		 prefs.put("profile.password_manager_enabled", false);

		 prefs.put("profile.password_manager_leak_detection", false);

		 options.setExperimentalOption("prefs", prefs);

		 driver = new ChromeDriver(options);


		 driver.manage().window().maximize();
		 driver.get("https://www.saucedemo.com/");
		 
	  }

  @Test (priority=0) 
  public void login() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	  Thread.sleep(3000);
  }
  @Test (priority=1)  
   public void verify() {
	   String actual_message =driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
	   String expect_message="Products";
	   Assert.assertEquals(actual_message,expect_message);
 
   }
   @Test (priority=2)
   public void verify1() {
	   String actual_message=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
	   String expect_message="Sauce Labs Backpack";
	   Assert.assertEquals(actual_message,expect_message);

    }
    @Test (priority=3)
    public void addcart() {
    	driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    	driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    	 
    	String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
    	String expect_message="Your Cart";
    	Assert.assertEquals(actual_message,expect_message);
    }
    @Test (priority=4)
    public void verify2() {
    	String actual_message=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
    	String expect_message="Sauce Labs Backpack";
    	Assert.assertEquals(actual_message,expect_message);
    	
    	driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }
    @Test (priority=5)
    public void checkout() {
    	String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
    	String expect_message="Checkout: Your Information";
    	Assert.assertEquals(actual_message,expect_message);
    	
    	driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("abcd");
    	driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("xyz");
    	driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("123456");
    	driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    	
    }
    @Test (priority=6)
    public void verify3() {
    	String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
    	String expect_message="Checkout: Overview";
    	Assert.assertEquals(actual_message,expect_message);
    	
    	String actual_message1=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
    	String expect_message1="Sauce Labs Backpack";
    	Assert.assertEquals(actual_message1,expect_message1);
    	
    	driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    	
    }
    @Test (priority=7)
    public void verify4() {
    	String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
    	String expect_message="Checkout: Complete!";
    	Assert.assertEquals(actual_message,expect_message);
    	
    	String actual_message1=driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
    	String expect_message1="Thank you for your order!";
    	Assert.assertEquals(actual_message1,expect_message1);
    	
    	driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
    }
    @Test (priority=8)
    public void logout() throws InterruptedException {
    	String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
    	String expect_message="Products";
    	Assert.assertEquals(actual_message,expect_message);
    	
    	driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
    	
    }
  
 
  
  @AfterTest
  public void afterTest() {
  }

}
