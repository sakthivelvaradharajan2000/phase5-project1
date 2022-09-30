import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class logintest {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "D:\\\\Sakthi/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/login");
		
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement login = driver.findElement(By.id("submit"));
		
		username.clear();
		username.click();
		username.sendKeys("abc@gmail.com");
		
		password.clear();
		password.click();
		password.sendKeys("your_password");
		login.click();
		String actualUrl = "http://localhost:4200/home";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
  }
  
}
