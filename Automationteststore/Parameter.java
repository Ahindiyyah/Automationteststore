package Automationteststore;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Parameter {
	WebDriver driver = new ChromeDriver();
	String WebSite = "https://automationteststore.com/";
	String Name = "";
	String LastName = "";
	String EmailAddress = "";
	String TeleNumber = "";
	String FaxNumber = "";
	String CompanyName = "";
	String AddressName = "";
	String CityName = "";
	String PostcodeNum = "";
	String LoginNameId = "";
	String Password = "";

	@BeforeTest
	public void SetUpProcess() {
		driver.get(WebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}

	@Test(priority = 1, enabled = false)
	public void SignUpProcess() {
		WebElement TheSinIn = driver.findElement(By.xpath("//a[normalize-space()='Login or register']"));
		TheSinIn.click();
		WebElement Continue = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
		Continue.click();
		WebElement IdName = driver.findElement(By.id("AccountFrm_firstname"));
		IdName.sendKeys(Name);
		WebElement IdLastName = driver.findElement(By.id("AccountFrm_lastname"));
		IdLastName.sendKeys(LastName);
		WebElement Email = driver.findElement(By.id("AccountFrm_email"));
		Email.sendKeys(EmailAddress);
		WebElement Tele = driver.findElement(By.id("AccountFrm_telephone"));
		Tele.sendKeys(TeleNumber);
		WebElement Fax = driver.findElement(By.id("AccountFrm_fax"));
		Fax.sendKeys(FaxNumber);
		WebElement Company = driver.findElement(By.id("AccountFrm_company"));
		Company.sendKeys(CompanyName);
		WebElement address = driver.findElement(By.id("AccountFrm_address_1"));
		address.sendKeys(AddressName);
		WebElement city = driver.findElement(By.id("AccountFrm_city"));
		city.sendKeys(CityName);
		WebElement postcode = driver.findElement(By.id("AccountFrm_postcode"));
		postcode.sendKeys(PostcodeNum);
		WebElement country = driver.findElement(By.id("AccountFrm_country_id"));
		country.click();
		WebElement Choose = driver.findElement(By.xpath("//*[@id=\"AccountFrm_country_id\"]/option[2]"));
		Choose.click();
		WebElement loginName = driver.findElement(By.id("AccountFrm_loginname"));
		loginName.sendKeys(LoginNameId);
		WebElement password = driver.findElement(By.id("AccountFrm_password"));
		password.sendKeys(Password);
		WebElement Confirmpassword = driver.findElement(By.id("AccountFrm_confirm"));
		Confirmpassword.sendKeys(Password);
		WebElement zone = driver.findElement(By.id("AccountFrm_zone_id"));
		zone.click();
		WebElement Chosse1 = driver.findElement(By.xpath("//*[@id=\"AccountFrm_zone_id\"]/option[2]"));
		Chosse1.click();
		WebElement NewsLetter = driver.findElement(By.xpath("//*[@id=\"AccountFrm_newsletter0\"]"));
		NewsLetter.click();
		WebElement Agree = driver.findElement(By.id("AccountFrm_agree"));
		Agree.click();
		WebElement ClickTheButton = driver.findElement(By.xpath("//*[@id=\"AccountFrm\"]/div[5]/div/div/button"));
		ClickTheButton.click();
	}

	@Test(priority = 2)
	public void LoginProcess() {
		WebElement TheSinIn = driver.findElement(By.xpath("//a[normalize-space()='Login or register']"));
		TheSinIn.click();
		WebElement loginName = driver.findElement(By.id("loginFrm_loginname"));
		loginName.sendKeys(LoginNameId);
		WebElement password = driver.findElement(By.id("loginFrm_password"));
		password.sendKeys(Password);
		WebElement loginClick = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		loginClick.click();
	}

	@Test(priority = 3)
	public void AddMenItemsAndDoAssertation() throws InterruptedException {
		WebElement Men = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[6]/a"));
		Men.click();
		List<WebElement> TheListOfItem = driver.findElements(By.xpath("//div[@class=\"col-md-3 col-sm-6 col-xs-12\"]"));
		for (int i = 0; i < TheListOfItem.size(); i++) {
			WebElement Item = TheListOfItem.get(i);
			Item.click();
			Thread.sleep(2000);
			WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div/ul/li/a"));
			AddToCartButton.click();
			Thread.sleep(2000);
			if (i != 3) {
				driver.navigate().back();
				driver.navigate().back();
			}
			TheListOfItem = driver.findElements(By.xpath("//div[@class=\"col-md-3 col-sm-6 col-xs-12\"]"));
		}
		WebElement TheNumberOfTheItems = driver
				.findElement(By.xpath("/html/body/div/header/div[2]/div/div[3]/ul/li/a/span[1]"));
		String TheActualNumberOfTheItems = TheNumberOfTheItems.getText();
		Assert.assertEquals(TheActualNumberOfTheItems, "4");
	}
}
