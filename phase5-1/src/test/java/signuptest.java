import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class signuptest {
  @Test
  public void f() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "D:\\\\Sakthi/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/login/signUp");
		
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement submit = driver.findElement(By.id("submit"));
		
		username.clear();
		username.click();
		username.sendKeys("abc@gmail.com");
		
		password.clear();
		password.click();
		password.sendKeys("your_password");
		this.takeSnapShot(driver, "C:\\Users\\sakth\\eclipse-workspace\\phase5-1\\src\\test\\java//result1.png") ;
		submit.click();
		
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/login");
		
		WebElement uname = driver.findElement(By.id("email"));
		WebElement pword = driver.findElement(By.id("pass"));
		WebElement login = driver.findElement(By.id("submit"));
		
		uname.clear();
		uname.click();
		uname.sendKeys("abc@gmail.com");
		
		pword.clear();
		pword.click();
		pword.sendKeys("your_password");
		this.takeSnapShot(driver, "C:\\Users\\sakth\\eclipse-workspace\\phase5-1\\src\\test\\java//result2.png") ;
		login.click();
		this.takeSnapShot(driver, "C:\\Users\\sakth\\eclipse-workspace\\phase5-1\\src\\test\\java//result3.png") ;
		String actualUrl = "http://localhost:4200/home";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
  }
  public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
		}

