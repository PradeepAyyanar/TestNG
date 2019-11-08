package mygroup.comerce;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Drops {
	@Test(priority=4)
	void runDrops(){
		System.setProperty("webdriver.chrome.driver", "D:\\pradeep\\MyProjects\\Selenium\\drivers\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://www.leafground.com/pages/Dropdown.html");
		WebElement gh = driver.findElement(By.xpath("//select[@multiple]"));
		Select iu = new Select(gh);
		List<WebElement> txt = iu.getOptions();
		System.out.println(txt.toString());
		//iu.selectByValue("Selenium");
		//iu.selectByVisibleText("Appium");
		iu.selectByIndex(2);
		iu.deselectByIndex(0);
		//iu.selectByValue("Selenium");
		WebElement two = driver.findElement(By.xpath("(//select)[5]"));
		Select emu = new Select(two);
		emu.selectByVisibleText("Appium");
		WebElement three = driver.findElement(By.xpath("(//select)[4]"));
		Select nu = new Select(three);
		nu.selectByVisibleText("Appium");
		WebElement ju = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select tu = new Select(ju);
		tu.selectByIndex(3);
		driver.close();
	}

}
