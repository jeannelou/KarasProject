package am.karas.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import am.karas.Pages.ChooseDeliveryCenter;
import am.karas.Pages.ClickHotDishes;
import utils.ScreenshotMethod;

public class VerifyHotDishesTest extends Base
{
	@Test
	public void verifyOffer() throws IOException
	{
		try
		{
			ChooseDeliveryCenter cdc = new ChooseDeliveryCenter(driver);
			ClickHotDishes hd = new ClickHotDishes(driver);
			
			cdc.selectDeliveryCenter();
			
			hd.selectHotDishes();	
			String actualText = hd.hotDishesText();
			String expectedText = "Hot dishes";				
			Assert.assertEquals(actualText, expectedText);	
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());			
		}
		
	}
	
	@AfterMethod	
	public void takeScreenshotOnFailure(ITestResult testResult) throws IOException
	{
		if(testResult.getStatus() == ITestResult.FAILURE)
		{
			ScreenshotMethod.takeScreenshot("D:\\QATesting\\FailedTestingScreenshots", driver, "screenshot");	
		}
	}
}
