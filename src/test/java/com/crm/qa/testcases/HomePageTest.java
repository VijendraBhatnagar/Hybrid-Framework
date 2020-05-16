package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	//test case should be independent of each other.
	//before each test case -- launch the browser and login
	//@test-- execute test case
	//after each test case --- close browser
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	//	Assert.assertEquals("User: Demo User", "User: Demo User");
	}
	
	@Test(priority=2)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
	//	contactsPage = homePage.clickOnContactsLink();
		homePage.clickOnNewContactLink();
	}
	
	@Test(priority=3)
	public void verifyDealsLinkTest() {
		testUtil.switchToFrame();
		dealsPage=homePage.clickOnDealsLink();
	}
	
	@Test(priority=4)
	public void verifyTasksLinkTest() {
		testUtil.switchToFrame();
		tasksPage=homePage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
