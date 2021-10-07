package week5.day2.Assignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {

	@Test(dataProvider = "sendData")
	public void runCreateLead(String Comp, String Fname, String Lname, String ID, String Phone, String dept,
			String desc, String Country, String State) {

		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Comp);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(Fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Lname);

		WebElement dropdown1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select drop1 = new Select(dropdown1);
		drop1.selectByVisibleText(ID);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(Phone);
		// driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("06/02/86");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(dept);
		driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
		driver.findElement(By.id("createLeadForm_generalCountryGeoId")).sendKeys(Country);
		driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")).sendKeys(State);

		driver.findElement(By.name("submitButton")).click();

	}

	@DataProvider
	public String[][] sendData() throws IOException {
		return ReadExcel.runReadExcel("CreateLead");

	}

}
