package com.itlearn.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;

public class LoginTest extends BaseTest {
	
	String fileName = System.getProperty("user.dir")+"\\TestData\\testInfo.xlsx";
	
	@Test(priority =1,dataProvider="LoginDataProvider")
	void verifyLogin(String userEmail,String userPwd) throws IOException{
		
		//We are extending BaseTest class so we have to pass driver in LoginPage object.
		//Once the value is passed to loginpage so it allows you to perform some task inside the loginpage i.e is help to automate the web element here 
		LoginPage lp = new LoginPage(driver);
		//String username ="Demo12";
		//String password = "Test123456$";
		lp.loginPortal(userEmail, userPwd);
		
		if(userEmail.equals("Demo12") && userPwd.equals("Test123456$"))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			lp.logout(); //there is no login button to do login again
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		
		
		int ttlRows= ReadExcelFile.getRowCount(fileName, "LoginData");
		int ttlColumns= ReadExcelFile.getColCount(fileName, "LoginData");
		
		String data[][]= new String[ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			}
		}
		return data;
	}

}
