package com.itlearn.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	//String fileName = System.getProperty("user.dir")+"\\TestData\\testInfo.xlsx";
	
	@Test
	void verifyLogin() throws IOException{
		
		//We are extending BaseTest class so we have to pass driver in LoginPage object.
		//Once the value is passed to loginpage so it allows you to perform some task inside the loginpage i.e is help to automate the web element here 
		LoginPage lp=new LoginPage(driver);
		String username ="Demo12";
		String password ="Test123456$";
		lp.loginPortal(username, password);
		
		if(username.equals("Demo12") && password.equals("Test123456$"))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
}
