package am.karas.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import am.karas.Pages.CheckFoodCart;
import am.karas.Pages.ChooseDeliveryCenter;
import am.karas.Pages.SearchFood;
import am.karas.Pages.SelectFood;
import utils.ScreenshotMethod;

public class VerifyFoodInFoodCartTest extends Base
{
	@Test
	public void verifyFoodInFoodCart() throws IOException
	{
		try 
		{
			
			ChooseDeliveryCenter cdc = new ChooseDeliveryCenter(driver);
			SearchFood sf = new SearchFood(driver);
			SelectFood slf = new SelectFood(driver);
			CheckFoodCart foodcart = new CheckFoodCart(driver);
					
			cdc.selectDeliveryCenter();
			sf.searchFood("pizza");
			
			String actualText = sf.getConfirmationText();
			String expectedText = "pizza";		
			Assert.assertEquals(actualText, expectedText);		
			
			slf.addFoodToFoodcart();
			
			foodcart.clickFoodCart();
			boolean orderExist = foodcart.isOrderExist();
			Assert.assertTrue(orderExist);					
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
