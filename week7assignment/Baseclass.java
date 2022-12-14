package week7assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass  {
	public 	ChromeDriver driver;
	String excell;
	@Parameters({"url","username","password"})
	@BeforeMethod
public  void launchBrowser(String urllink,@Optional("DemoCSR") String uname,String pword) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get(urllink);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		}
	   // private static void get(String string) {
		// TODO Auto-generated method stub
		
		@AfterMethod
	public void tearDown() {
	    	
			driver.close();
	}
		
		@DataProvider(name="integrate")
		public String[][] data() throws IOException  {
		String[][] readData = Readxl.readData(excell);
		return readData;
		
		
		
		
		}
	
	
	
}

