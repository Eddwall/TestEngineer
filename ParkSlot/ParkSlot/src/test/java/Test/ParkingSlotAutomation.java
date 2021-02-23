package Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParkingSlotAutomation {

	private WebDriver driver;
	private static final String ExplorerDriver = "webdriver.chrome.driver";
	private static final String Path = "./src/test/resources/WebDriver/chromedriver.exe";
	private String UrlAddress = "http://www.shino.de/parkcalc/";
	
	
	@BeforeClass
	public static void OnlyOnce()
	{
		System.out.println("Test(s) Begins");
		System.setProperty(ExplorerDriver, Path);
	}
	
	@Before
	public void BeforeEachTestSetUp()
	{
		driver = new ChromeDriver();
		driver.get(UrlAddress);
	}
	
	@Test
	public void SetParkingInfo() throws InterruptedException
	{
		//WebElements
		String parkingType = "ParkingLot";
		String date1 = "StartingDate";
		String time1 = "StartingTime";
		String shift1 = "StartingTimeAMPM";
		String date2 = "LeavingDate";
		String time2 = "LeavingTime";
		String shift2 = "LeavingTimeAMPM";
		String submit = "Submit";
		
		Select ddParkingType = new Select (driver.findElement(By.name(parkingType)));
		ddParkingType.selectByVisibleText("Economy Parking");
				
		WebElement txtDate1 = driver.findElement(By.name(date1));
		txtDate1.clear();
		txtDate1.sendKeys("02/17/21");
		
		WebElement txtTime1 = driver.findElement(By.name(time1));
		txtTime1.clear();
		txtTime1.sendKeys("8:00");
		
		//EntryAMShift
		WebElement rbShift1 = driver.findElement(By.name(shift1));
		rbShift1.click();
		
		//EntryPMShift
		//WebElement rbShift1 = driver.findElement(By.cssSelector("tr:nth-child(2) input:nth-child(5)""));
		//rbShift1.click();
		
		WebElement txtDate2 = driver.findElement(By.name(date2));
		txtDate2.clear();
		txtDate2.sendKeys("02/17/21");
		
		WebElement txtTime2 = driver.findElement(By.name(time2));
		txtTime2.clear();
		txtTime2.sendKeys("4:00");
		
		//LeavingAMShift
		//WebElement rbShift2 = driver.findElement(By.name(shift2));
		//rbShift2.click();
		
		//LeavingPMShift
		WebElement rbShift2 = driver.findElement(By.cssSelector("tr:nth-child(3) input:nth-child(5)"));
		rbShift2.click();		
		
		WebElement btSubmit = driver.findElement(By.name(submit));
		btSubmit.click();		
		
		String valor = driver.findElement(By.cssSelector("b")).getText();
		System.out.println(valor);
		Thread.sleep(2000);
		Assert.assertTrue("Confirmando Tarifa", valor.contains("$ 9.00"));
		
	}
	
	@Test
	public void SetParkingInfo2() throws InterruptedException
	{
	//WebElements
		String parkingType = "ParkingLot";
		String date1 = "StartingDate";
		String time1 = "StartingTime";
		String shift1 = "StartingTimeAMPM";
		String date2 = "LeavingDate";
		String time2 = "LeavingTime";
		String shift2 = "LeavingTimeAMPM";
		String submit = "Submit";
		
		Select ddParkingType = new Select (driver.findElement(By.name(parkingType)));
		ddParkingType.selectByVisibleText("Long-Term Garage Parking");
		
		WebElement txtDate1 = driver.findElement(By.name(date1));
		txtDate1.clear();
		txtDate1.sendKeys("02/21/21");
		
		WebElement txtTime1 = driver.findElement(By.name(time1));
		txtTime1.clear();
		txtTime1.sendKeys("6:00");
		
		//EntryPMShift
		WebElement rbShift1 = driver.findElement(By.cssSelector("tr:nth-child(2) input:nth-child(5)"));
		rbShift1.click();
		
		WebElement txtDate2 = driver.findElement(By.name(date2));
		txtDate2.clear();
		txtDate2.sendKeys("02/22/21");
		
		WebElement txtTime2 = driver.findElement(By.name(time2));
		txtTime2.clear();
		txtTime2.sendKeys("8:00");
		
		//LeavingAMShift
	    WebElement rbShift2 = driver.findElement(By.name(shift2));
		rbShift2.click();
		
		WebElement btSubmit = driver.findElement(By.name(submit));
		btSubmit.click();		
		
		String valor = driver.findElement(By.cssSelector("b")).getText();
		System.out.println(valor);
		Thread.sleep(2000);
		Assert.assertTrue("Confirmando Tarifa", valor.contains("$ 36.00"));
		
		
	
	}
		
	@After
	public void AfterEachTest()
	{
		driver.quit();
	}
	
	@AfterClass
	public static void AfterTestsDone()
	{
		System.out.println("Test(s) Done");
	}
}
