package am.karas.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseDeliveryCenter 
{
	@FindBy(id="Yerevan")
	private WebElement deliverycenter;
	
	public ChooseDeliveryCenter(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectDeliveryCenter()
	{
		deliverycenter.click();
	}
}
