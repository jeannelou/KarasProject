package am.karas.TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base 
{
	RemoteWebDriver driver;
	
	@BeforeClass
	public void openApplication()
	{
		 try 
		  {	
			    ChromeOptions chromeOptions = new ChromeOptions();
			    chromeOptions.setAcceptInsecureCerts(true);
			    chromeOptions.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			    driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444"), chromeOptions);		
				  
				driver.get("https://karas.am/en/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		  } 
		 catch (MalformedURLException e) 
		 {
	       System.out.println("Invalid grid URL");
	       
		 } 
		 catch (Exception e) 
	     {
	       System.out.println(e.getMessage());
	     }			
	}
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
	}

}
