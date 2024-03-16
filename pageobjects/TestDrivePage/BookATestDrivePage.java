package TestDrivePage;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import resources.JsonFileReader;

public class BookATestDrivePage extends TestBase{
	
By firstName;
By lastName;
By email;
By phone;
By calender;
By pDate;
By timeDrop;
By pTime;
By paxDrop;
By pax;
By country;
By pCountry;
By check1;
By check2;
By check3;
By check4;
By driveDrop;
By drive;
By modelDrop;
By model=By.xpath("//div[@data-value='NX 350h']");;
By body;
By submitBtn;	
	public BookATestDrivePage() throws IOException, Exception  {
		String fileName = "assignment.json";
		JsonFileReader.readJsonFile(fileName, "TestData");
		String counPhone = (String) JsonFileReader.readJsonFile().get("counPhone");
		String nofPax = (String) JsonFileReader.readJsonFile().get("pax");
		String driveOption = (String) JsonFileReader.readJsonFile().get("driveOption");
		String uTime = (String) JsonFileReader.readJsonFile().get("time");

		
		PageFactory.initElements(driver, this);
		firstName=By.xpath("//*[@id='input_first_name']");
		lastName=By.xpath("//*[@id='input_last_name']");
		email=By.xpath("//*[@id='input_email_address']");
		phone=By.xpath("//*[@id='input_phone_number']");
		calender=By.xpath("//*[@id='datepicker_preferred_date']");
		pDate=By.xpath("//span[contains(@class, 'today')]");
		timeDrop=By.xpath("//label[text()='Preferred time']/following::div[1]");
		pTime=By.xpath("//div[@data-value='"+uTime+"']");
		country=By.xpath("//div[@class='iti__selected-flag']");
		pCountry=By.xpath("//li[@data-dial-code='"+counPhone+"']");
		paxDrop=By.xpath("//label[text()='Number of pax ']/following::div[1]");
		pax=By.xpath("//div[@data-value='"+nofPax+"']");
		check1=By.xpath("//*[@id='checkbox_privacy_policy']");
		check2=By.xpath("//*[@id='checkbox_marketing']");
		check3=By.xpath("//*[@id='checkbox_driving_license']");
		check4=By.xpath("//*[@id='checkbox_terms_conditions']");
		driveDrop=By.xpath("//div[text()='Select a test drive option']");
		drive=By.xpath("//div[@data-value='"+driveOption+"']");
		submitBtn=By.xpath("//button[@data-role='submit']")	;	
	}
	
	public void enterFirstName(String fname)
	{
		driver.findElement(firstName).sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		driver.findElement(lastName).sendKeys(lname);
	}
	
	public void enterEmail(String uemail)
	{
		driver.findElement(email).sendKeys(uemail);
	}
	
	public void enterPhone(String uphone)
	{
		driver.findElement(phone).sendKeys(uphone);
	}

	public void enterDate()
	{
		driver.findElement(calender).click();
		driver.findElement(pDate).click();
	}
	
	public void enterTime()
	{
		driver.findElement(timeDrop).click();
		driver.findElement(pTime).click();
	}
	
	public void enterPax()
	{
		driver.findElement(paxDrop).click();
		driver.findElement(pax).click();
	}
	
	public void enterCheck1()
	{
		driver.findElement(check1).click();
	}
	
	public void enterCheck2()
	{
		driver.findElement(check2).click();
	}
	public void enterCheck3()
	{
		driver.findElement(check3).click();
	}
	public void enterCheck4()
	{
		driver.findElement(check4).click();
	}
	
	public void enterCountry()
	{
		driver.findElement(country).click();
		driver.findElement(pCountry).click();
	}
	
	public void enterOption()
	{
	      
		driver.findElement(driveDrop).click();
		driver.findElement(drive).click();
	}
	
	public String getButtonState() {
	
  	String btnState = driver.findElement(submitBtn).getAttribute("class");
  	return btnState;
	}

	
	//Select one or more models
}
