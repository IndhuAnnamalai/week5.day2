package week5.day2.Assignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseClass {

	@Test(dataProvider = "sendData")
	public void runDuplicateLead(String Fname) throws InterruptedException {

		driver.findElement(By.linkText("Find Leads")).click();
		//driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath( "(//input[@name='firstName'])[3]")).sendKeys(Fname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String text2 = driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-firstName']/a"))
				.getText();

		driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
		String text3 = driver.findElement(By.linkText("Duplicate Lead")).getText();
		System.out.println("The text is: " + text3);
		// String title = driver.getTitle();
		if (text3.equals("Duplicate Lead")) {
			System.out.println("The title is correct");
		} else {
			System.out.println("Incorrect page");
		}

		String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("The ID is: " + text);
		System.out.println("The ID in text2 is: " + text2);
		if (text2.equals(text)) {
			System.out.println("The duplicated ID is same as captured ID");
		} else {
			System.out.println("The IDs are different");
		}
	}
	
	@DataProvider
	public String[][] sendData() throws IOException {
		return ReadExcel.runReadExcel("DuplicateLead");

	}

}
