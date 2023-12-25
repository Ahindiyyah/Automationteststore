package Automationteststore;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationTestToDoMultipleThings extends Parameter {

	@BeforeTest
	public void SetUp() {
		SetUpProcess();
	}

	@Test
	public void SignUp() {
		SignUpProcess();
	}

	@Test
	public void Login() {
		LoginProcess();
	}

	@Test(priority = 3)
	public void AddMenItem() throws InterruptedException {
		AddMenItemsAndDoAssertation();

	}

}
