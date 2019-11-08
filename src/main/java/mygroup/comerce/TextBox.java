package mygroup.comerce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TextBox {
	@Test(priority=2)
	void runTextBox(){
		System.setProperty("webdriver.chrome.driver", "D:\\pradeep\\MyProjects\\Selenium\\drivers\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://www.leafground.com/pages/Edit.html");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pr@email.com");
		driver.findElement(By.xpath("//input[@style='width:350px'][@value='Append ']")).sendKeys("appended");
		String txt = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getText();
		System.out.println(txt);
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		boolean enabled = driver.findElement(By.xpath("//input[@style='width:350px;background-color:LightGrey;']")).isEnabled();
		System.out.println(enabled);
		driver.close();
	}

}
