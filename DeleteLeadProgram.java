package week5.day2.Assignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadProgram extends BaseClass {

	@Test(dataProvider = "sendData")
	public void runDeleteLead(String Fname) throws InterruptedException {

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(Fname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(leadID);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();

		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}

	}

	@DataProvider
	public String[][] sendData() throws IOException {
		return ReadExcel.runReadExcel("DeleteLead");

	}

}
