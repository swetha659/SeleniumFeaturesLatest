import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeDriver driver=new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> deviceMetrics=new HashMap<String,Object>();
		deviceMetrics.put("latitude", 40);
		deviceMetrics.put("longitude", 3);
		deviceMetrics.put("accuracy", 1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", deviceMetrics);
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElement(By.cssSelector("a[ping^='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.netf'] > .DKV0Md.LC20lb.MBeuO")).click();
		String title=driver.findElement(By.cssSelector(".default-ltr-cache-jmnaey.euy28770")).getText();
		System.out.println(title);
	}

}
