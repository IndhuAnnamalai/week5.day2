package week5.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident extends ServiceNow {

	@Test
	public void deleteIncident() throws InterruptedException {
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame);
		System.out.println("Inside the frame");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
		//driver.findElement(By.xpath("//button[@onclick='return ok()']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber, Keys.ENTER);
		String text = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		if (text.contains("No record")) {
			System.out.println("Incident deleted");
		} else {
			System.out.println("Incident not deleted");
		}
	}
}
