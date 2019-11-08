package mygroup.comerce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Buttons {
	@Test(priority=5)
	void runButtons(){
		System.setProperty("webdriver.chrome.driver", "D:\\pradeep\\MyProjects\\Selenium\\drivers\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Button.html");
		WebElement ri = driver.findElement(By.xpath("//button[@id='home']"));
		WebElement clic = driver.findElement(By.xpath("//button[@id='position']"));
		Point location = clic.getLocation();
		String loc = location.toString();
		System.out.println(loc);
		int xpoint = location.getX();
		int ypoint = location.getY();
		System.out.println("X&Y :"+xpoint+","+ypoint);
		String cssValue = driver.findElement(By.xpath("//button[@id='color']")).getCssValue("background-color");
		System.out.println("The color of the button: "+cssValue);
		ri.click();
		driver.close();
	}

}
