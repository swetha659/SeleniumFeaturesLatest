import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v128.network.Network;
import org.openqa.selenium.devtools.v128.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000,100000,Optional.of(ConnectionType.ETHERNET), Optional.empty(), Optional.empty(), Optional.empty()));
		//devTools.send(Network.emulateNetworkConditions(true, 3000, 20000,100000,Optional.of(ConnectionType.ETHERNET), Optional.empty(), Optional.empty(), Optional.empty()));
		/**devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		}
				);
		*/
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		driver.close();
	}

}
