package foodbox.Capstone.repo;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.web.server.WebServer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class NewTest {
	
	public String baseUrl = "http://localhost:8080";
   
    String driverPath = "C:\\Users\\hp\\Downloads\\Capstone\\target\\Driver\\chromedriver.exe";
    public WebDriver driver ;
   
    @BeforeTest
    public void launchBrowser() {

        System.out.println("Launching chrome Browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    @Test(priority=0) public void login_Pass() {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("http://localhost:8080/login");
		 driver.findElement(By.name("email")).sendKeys("pragati@gmail.com");
		  driver.findElement(By.name("password")).sendKeys("$2a$10$yIQNKpTvnl0LHCHrxfklXO0ySSK58MSsV8Z1G0xOwvM/ZBsT/uoVm");
		  //Login Button
		  driver.findElement(By.xpath("/html/body/div/div/div/form/input")).click();
		  String actualUrl="http://localhost:8080";
		  String expectedUrl= driver.getCurrentUrl();
		  if(actualUrl.equalsIgnoreCase(expectedUrl)) {
		  System.out.println("Login Successful"); }
		  driver.manage().window().maximize();
}
    @Test(priority=1) public void viewProduct() {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("http://localhost:8080");
		 //view product Button
		  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/a")).click();
		  String actualUrl="http://localhost:8080/shop/viewproduct/";
		  String expectedUrl= driver.getCurrentUrl();
		  if(actualUrl.equalsIgnoreCase(expectedUrl)) {
		  System.out.println("Product is viewed"); }
		  driver.manage().window().maximize();
}
    @Test(priority=2) public void AddProduct() {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("http://localhost:8080/shop/viewproduct/8");
		 
		  //view product Button
		  driver.findElement(By.xpath("/html/body/div/div/div[2]/a")).click();
		  String actualUrl="http://localhost:8080/shop";
		  String expectedUrl= driver.getCurrentUrl();
		  if(actualUrl.equalsIgnoreCase(expectedUrl)) {
		  System.out.println("Product has added on the cart"); }
		  driver.manage().window().maximize();
}
    @Test(priority=3) public void register_Pass() {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("http://localhost:8080/register");
		 driver.findElement(By.name("firstName")).sendKeys("Sachin");
		  driver.findElement(By.name("lastName")).sendKeys("pandey");
		  driver.findElement(By.name("email")).sendKeys("pandeyvibhay1999@gmail.com");
		  driver.findElement(By.name("password")).sendKeys("112233");
		  
		 		  //register Button
		  driver.findElement(By.xpath("/html/body/div/div/form/input")).click();
		  String actualUrl="http://localhost:8080";
		  String expectedUrl= driver.getCurrentUrl();
		  if(actualUrl.equalsIgnoreCase(expectedUrl)) {
		  System.out.println("register Successful"); }
		  driver.manage().window().maximize();
}
    
    @Test(priority=4) public void searchThroughKeyword() {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("http://localhost:8080");
		 driver.findElement(By.name("keyword")).sendKeys("jale");
		  
		  
		 		  //register Button
		  driver.findElement(By.xpath("/html/body/div[1]/form/button")).click();
		  String actualUrl="http://localhost:8080/?keyword=jale";
		  String expectedUrl= driver.getCurrentUrl();
		  if(actualUrl.equalsIgnoreCase(expectedUrl)) {
		  System.out.println("search is working "); }
		  driver.manage().window().maximize();
}
    
    @Test(priority=4) public void loginAndlogout() {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("http://localhost:8080/login");
		 driver.findElement(By.name("email")).sendKeys("pragati@gmail.com");
		  driver.findElement(By.name("password")).sendKeys("$2a$10$yIQNKpTvnl0LHCHrxfklXO0ySSK58MSsV8Z1G0xOwvM/ZBsT/uoVm");
		  //Login Button
		  driver.findElement(By.xpath("/html/body/div/div/div/form/input")).click();
		  String actualUrl="http://localhost:8080";
		  String expectedUrl= driver.getCurrentUrl();
		  if(actualUrl.equalsIgnoreCase(expectedUrl)) {
		  System.out.println("Login Successful"); }
		  driver.manage().window().maximize();
}
    
  }
