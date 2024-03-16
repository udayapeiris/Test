package Cookies;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CookiesPage extends TestBase{
	By acceptCookies;
	
	public CookiesPage() {
		PageFactory.initElements(driver, this);
		acceptCookies=By.xpath("//*[@id='consent_prompt_submit']");


	}
	
	public void clickOnAcceptCookies()
	{
		driver.findElement(acceptCookies).click();
	}

}
