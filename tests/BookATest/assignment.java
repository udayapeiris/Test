package BookATest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Cookies.CookiesPage;
import TestDrivePage.BookATestDrivePage;
import base.TestBase;
import resources.JsonFileReader;

public class assignment extends TestBase {
	CookiesPage cookiesPage;
	BookATestDrivePage bookATestDrivePage;

public assignment() {
	super();
}

@BeforeMethod
public void setUp() throws IOException, Exception {
	initialization();
	cookiesPage = new CookiesPage();
	bookATestDrivePage = new BookATestDrivePage();
	
}

@SuppressWarnings("restriction")
@Test
public void testAssignment() throws IOException, Exception {
	String fileName = "assignment.json";
	JsonFileReader.readJsonFile(fileName, "TestData");
	String fName = (String) JsonFileReader.readJsonFile().get("fName");
	String lName = (String) JsonFileReader.readJsonFile().get("lName");
	String email = (String) JsonFileReader.readJsonFile().get("email");
	String phone = (String) JsonFileReader.readJsonFile().get("phone");

	cookiesPage.clickOnAcceptCookies();
	bookATestDrivePage.enterFirstName(fName);
	bookATestDrivePage.enterLastName(lName);
	bookATestDrivePage.enterEmail(email);
	bookATestDrivePage.enterCountry();
	bookATestDrivePage.enterPhone(phone);
	bookATestDrivePage.enterDate();
	bookATestDrivePage.enterTime();
	bookATestDrivePage.enterPax();
	Waiting_Time_SMALL();
	bookATestDrivePage.enterOption();
	bookATestDrivePage.enterCheck1();
	bookATestDrivePage.enterCheck2();
	bookATestDrivePage.enterCheck3();
	bookATestDrivePage.enterCheck4();
	String buttonState=bookATestDrivePage.getButtonState();
	System.out.println("Button State is : " + buttonState);
	
	String expectedString = "is_disabled";
    assertFalse(buttonState.contains(expectedString));


	
	
}
}