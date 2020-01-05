package com.assignment.testleaf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentThree {

	public static void main(String[] args) throws InterruptedException {
		String exePath = "E:\\Selenium\\Drivers\\chromedriver.exe";
		 System.setProperty("webdriver.chrome.driver", exePath);
		 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().window().maximize();
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kumar.testleaf@gmail.com");
		email.sendKeys(Keys.TAB);
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("leaf@12");
		
		WebElement loginButton = driver.findElement(By.id("buttonLogin"));
		loginButton.click();
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
		WebElement invoice = driver.findElement(By.xpath("//button[text()=' Invoices']"));
		action.moveToElement(invoice).perform();
		
		Thread.sleep(2000);
		
		WebElement searchInvoices = driver.findElement(By.xpath("//a[contains(text(),'Search for Invoice')]"));
		wait.until(ExpectedConditions.elementToBeClickable(searchInvoices));
		searchInvoices.click();
		//action.moveToElement(searchInvoices).perform();

		WebElement vendorTaxID = driver.findElement(By.id("vendorTaxID"));
		wait.until(ExpectedConditions.elementToBeClickable(vendorTaxID));
		vendorTaxID.sendKeys("FR121212");
		
		WebElement searchButton = driver.findElement(By.id("buttonSearch"));
		searchButton.click();
		
		//Find the invoice numbers of the Invoice Item IT Support and print

		List<WebElement> allColoumn = driver.findElements(By.xpath("\r\n" + 
				"//table[@class='table']/tbody/tr/td[text()='IT Support']/../td[1]"));
		for(WebElement e : allColoumn) {
			System.out.println(e.getText());
		}

		WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
		logoutButton.click();
		
		driver.close();
		
		
	}

}
