package mygroup.comerce;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HyperLinks {
	@Test(priority=3)
	void runHyperlinks(){
		System.setProperty("webdriver.chrome.driver", "D:\\pradeep\\MyProjects\\Selenium\\drivers\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Link.html");
		WebElement ri = driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(ri).perform();
		String ori = driver.getWindowHandle();
		driver.switchTo().window(ori);
		System.out.println(ori);
		String chord = Keys.chord(Keys.CONTROL,Keys.RETURN);
		ri.sendKeys(chord);
		Set<String> li = driver.getWindowHandles();
		System.out.println(li);
		for(String windo: driver.getWindowHandles()) {
			driver.switchTo().window(windo);
		}
		driver.switchTo().window(ori);
		String link = driver.findElement(By.xpath("//a[@link='blue'][contains(text(),'Find where')]")).getAttribute("href");
	System.out.println(link);
	List<WebElement> lis = driver.findElements(By.tagName("a"));
	for(WebElement str: lis) {
		String att = str.getAttribute("href");
		if(att==null||att.isEmpty()) {
			System.out.println("Broken link is present");
			continue;
		}
		try{HttpURLConnection huc=(HttpURLConnection)(new URL(att).openConnection());
		huc.connect();
		if(huc.getResponseCode()>=400) {
			System.out.println("The link is broken");
		}}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	System.out.println("The number of links in this page is:"+lis.size());
	driver.quit();
	}

}
