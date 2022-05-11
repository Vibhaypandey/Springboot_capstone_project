package foodbox.Capstone.repo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminTest {
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
    
    @Test(priority=0) public void login_Passadmin() {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("http://localhost:8080/login");
		 driver.findElement(By.name("email")).sendKeys("admin@gmail.com");
		 driver.findElement(By.name("password")).sendKeys("$2a$04$glGeZtNUJRQty6IvGTUgveoQGoTfe3wtYm.Cd6U/IF1bAjWpi1ine");
		  //Login Button
		  driver.findElement(By.xpath("/html/body/div/div/div/form/input")).click();
		  String actualUrl="http://localhost:8080";
		  String expectedUrl= driver.getCurrentUrl();
		  if(actualUrl.equalsIgnoreCase(expectedUrl)) {
		  System.out.println("admin login process successfully"); }
		  driver.manage().window().maximize();
}
}
