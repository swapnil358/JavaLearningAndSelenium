package SeleniumTutorial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\n\\Desktop\\Swapnil\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com/index.html");

		driver.findElement(By.name("username")).sendKeys("naveenautomation");

		driver.findElement(By.name("password")).sendKeys("test@123");

		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();

		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.xpath("//a[contains(text(), 'Contact')]")).click();

		driver.switchTo().frame("leftpanel");

		driver.findElement(By.xpath(
				"//a[contains(text(),'abc test')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='c']"))
				.click();

//		driver.switchTo().parentFrame();				//for parent frame
//		driver.switchTo().defaultContent();				//for main frame
	
	}

}
