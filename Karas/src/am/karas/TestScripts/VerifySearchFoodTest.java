package am.karas.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import am.karas.Pages.ChooseDeliveryCenter;
import am.karas.Pages.SearchFood;
import utils.ScreenshotMethod;

public class VerifySearchFoodTest extends Base
{
	@Test
	public void verifySearchFood() throws IOException
	{
		try
		{
			ChooseDeliveryCenter cdc = new ChooseDeliveryCenter(driver);
			SearchFood sf = new SearchFood(driver);
			
			cdc.selectDeliveryCenter();
			sf.searchFood("pizza");
			
			String actualText = sf.getConfirmationText();
			String expectedText = "pizza";
			
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
