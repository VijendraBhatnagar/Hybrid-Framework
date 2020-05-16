package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
		TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
//	@Test(priority=1)
//	public void verifyContactsPageLabel(){
//		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
//	}
//	
//	@Test(priority=2)
//	public void selectSingleContactsTest(){
//		contactsPage.selectContactsByName("Alley Yu");
//		contactsPage.selectContactsByName("Andra Hari");
//	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName,String company){
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(firstName, lastName, company);
		//	contactsPage.createNewContact("Mr.", "Larry", "Lan", "Google");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
