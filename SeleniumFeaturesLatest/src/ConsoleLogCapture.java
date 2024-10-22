import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogCapture {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.className("add-to-cart")).click();
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		LogEntries entry=driver.manage().logs().get(LogType.BROWSER); //Get LogEntries object
		List<LogEntry> logs=entry.getAll(); // LogEntryObject - get all method return all the logs in the list
		
		for(LogEntry e : logs) // iterating through the list and printing each log message
		{
			System.out.println(e.getMessage());
		}
		driver.close();
		
		
		

	}

}
