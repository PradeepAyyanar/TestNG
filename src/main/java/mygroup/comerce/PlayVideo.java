package mygroup.comerce;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayVideo {
	@Test(priority=1,dataProvider="fetching")
	
	void runVideo(String search) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\\\pradeep\\\\MyProjects\\\\Selenium\\\\drivers\\\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.youtube.com/");
		driver.findElement(By.tagName("input")).sendKeys(search);
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		driver.findElement(By.xpath("(//div[@id='title-wrapper']/h3/a)[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.wait(20);
		//Thread.sleep(20000);
		try{wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ytd-button-renderer/a/paper-button)[5]")));
		driver.findElement(By.xpath("(//ytd-button-renderer/a/paper-button)[5]")).click();}
		catch(Exception e) {
			System.out.println("Not appeared!");;
		}
		driver.close();

	}
	@DataProvider(name="fetching")
	public Object[][] setUpData() throws IOException{
		String ExcelFileName = "Book1";
		Object[][] data = ExcelUtil.readExcelData(ExcelFileName);
		return data;
	}

}
