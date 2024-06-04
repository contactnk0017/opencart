package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration() throws InterruptedException
	{
		
		logger.info("starting TC_001");
		try {
			
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on account link");
		
		hp.clickRegister();
		logger.info("clicked on register link");
		
		logger.info("Entering customer details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		//regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		 regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("clicked on continue_btn");
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("validating expected msg..");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("test failed...");
			Assert.fail();
		}
		
		logger.info("finishing TC_001");
		
	}
	
	
	
	
}








