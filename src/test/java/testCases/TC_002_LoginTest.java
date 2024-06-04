package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
  
	
  @Test(groups= {"sanity","master"})
  public void verify_login()
  {
	  logger.info("Starting TC_002_LOGIN TEST");
	  logger.debug("Capturing application debug logs");
	  
	  try {
	  //Home Page
	  HomePage hp=new HomePage(driver);
	  hp.clickMyAccount();
	  logger.info("clicked on myaccount link.. ");
	  hp.clickLogin();  //Login link from home page
	  logger.info("click on login link..");
	  
	  //Login Page
	  
	  LoginPage lp=new LoginPage(driver);
	  
	  logger.info("Entering valid email and password...");
	  
	  lp.setEmail(p.getProperty("email"));
	
	  
	  lp.setPassword(p.getProperty("password"));
      
	  lp.clickLogin(); //login from login page
	  logger.info("click on login button in login page...");
	  
	  //MyAccountPage
	   MyAccountPage macc=new MyAccountPage(driver);
	   boolean targetpage=macc.isMyAccountPageExists();
	   if(targetpage==true)
	   {
		   logger.info("Login test passed");
		 Assert.assertTrue(true);
	   }
	   else
	   {
		   logger.error("login test failed");
		   Assert.fail();
	   }
	   
	  }
	  catch(Exception e)
	  {
		  Assert.fail();
	  }
	   logger.info(".....Finished TC_002 TESTCASE");
	   
  }
	
}
