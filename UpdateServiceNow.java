package week5.day2.Assignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateServiceNow extends ServiceNow{

	@Test(dataProvider="sendData")
	public void incidentUpdation(String priority,String state) throws InterruptedException {
		
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame);
		System.out.println("Inside the frame");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber,Keys.ENTER);
		//driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys();
		System.out.println("Search successful");
		driver.findElement(By.linkText(incidentNumber)).click();
		
		
		WebElement priority1 = driver.findElement(By.id("incident.urgency"));
		Select dropdown = new Select(priority1);
		dropdown.selectByVisibleText(priority);
		System.out.println("Priority success");
		WebElement state1 = driver.findElement(By.id("incident.state"));
		Select dropdown1 =new Select(state1);
		dropdown1.selectByVisibleText(state);
		System.out.println("State success");

		driver.findElement(By.id("sysverb_update")).click();
		
	}
	
	@DataProvider
	public String[][] sendData() throws IOException {
		
		return ReadExcelServiceNow.readExcel("UpdateService");
	}
}
