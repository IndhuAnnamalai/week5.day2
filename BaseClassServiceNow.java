package week5.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServiceNow {

	public ChromeDriver driver;
	public static String incidentNumber;
	
	@Parameters({"url","username","password","filter"})
	@BeforeMethod
	public void beforeMethodBase(String url,String uName,String pwd,String filter) {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement frameElement = driver.findElement(By.xpath("(//iframe[@id='gsft_main'])[1]"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.id("user_name")).sendKeys(uName);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.id("sysverb_login")).click();
		//driver.switchTo().defaultContent();
		driver.findElement(By.id("filter")).sendKeys(filter,Keys.ENTER);
		//driver.findElement(By.id("filter")).sendKeys();
		driver.findElement(By.xpath("//ul[@aria-label='Modules for Application: Incident']/li[6]//div//a/div/div")).click();

	}
	
	@AfterMethod
	public void afterMethodBase() {
		driver.close();
	}
}
