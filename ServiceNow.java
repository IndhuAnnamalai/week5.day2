package week5.day2.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow extends BaseClassServiceNow {

	@Test(dataProvider="sendData")
	public void incidentCreation(String desc) throws IOException {

		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("sysverb_new")).click();
		// WebElement frame3 =
		// driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		// driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']/span")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winList.get(1));
		driver.findElement(By.linkText("System Administrator")).click();
		driver.switchTo().window(winList.get(0));
		System.out.println("The title is: " + driver.getTitle());
		driver.switchTo().defaultContent();
		// Thread.sleep(1000);
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(desc);

		incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The incident number is: " + incidentNumber);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		System.out.println("Incident created successufully");
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/incident.png");
		FileUtils.copyFile(src, dst);
	}

	@DataProvider
	public String[][] sendData() throws IOException {
		return ReadExcelServiceNow.readExcel("ServiceNow");
	}

}
