package week5.day2.Assignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseClass {

	@Test(dataProvider = "FetchData")
	public void runEditLead(String Fname,String Comp) throws InterruptedException {
		// TODO Auto-generated method stub

		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath( "(//input[@name='firstName'])[3]")).sendKeys(Fname);
	    driver.findElement(By.xpath( "//button[text()='Find Leads']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
	    
	    		driver.findElement(By.linkText("Edit")).click();
	    		String text = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
	    	    System.out.println("The title of the page is: " +text);
	    	    if(text.equals("Edit Lead")){
	    	    	System.out.println("The title is verified");
	    	    	
	    	    }else {
	    	    	System.out.println("The title is incorrect");
	    	    }
	    		driver.findElement(By.id("updateLeadForm_companyName")).clear();
	    		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(Comp);
	    		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
	}
	
	@DataProvider(name = "FetchData")
	public String[][] sendData() throws IOException {
		return ReadExcel.runReadExcel("EditLead");
	}

}
