
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;



import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

//@TestMethodOrder(OrderAnnotation.class)
public class TesClass {
	 String appiumPort ="4723";
     String serverIp ="0.0.0.0";
	 //static IOSDriver<IOSElement> driver;
     public static IOSDriver<IOSElement> driver;
	 ApiHelper api=new ApiHelper();
	 LoginPage lPage=null;
	 DesiredCapabilities cap;
	 ProgrammesPage p_page=null;
	 MainPage mPage=null;
	 public static String toolKitName=null;
	 static int trainingCode;
	 
	 public static String accessKey = "PaScwtgzrnYUvwMYDH2i";
	  public static String userName = "tygriffith1";

	 public static URL url;

	 
	 
	 
	 
	
	 
	 /*
	  * Order is the priority of the test case
	  * this is the first test case in this class
	  * This is responsible for creating connection with the appium server
	  * this sets basic capabilities and some advance capabilities 
	  * to run the test cases on a real Ios device
	  * 
	  */
	 
	 @Test(priority=1)
	//@Order(1)
	// @DisplayName("Verify that all three  text fields and login button is present in the login page")
	public void verify() throws MalformedURLException, JsonProcessingException  {
		 
		 
		/*
		
		    api.CreateToolKitAPIRequest();
		    api.CreateTrainingAPIRequest();
			api.InsertModuleAPIReqeust("Document",1,2);
			api.InsertModuleAPIReqeust("Questions",2,3);
			api.getContentBuilderOverViewModelAPiCall();
			api.publishToolKit();*/
	 
			
		  cap= new DesiredCapabilities();
	      
	      
	      cap.setCapability("deviceName", "Muhammad’s iPhone");
	      cap.setCapability("platformName", "iOS");
	      cap.setCapability("platformVersion","12.1.2");
	      cap.setCapability("automationName", "XCUITest");
	      cap.setCapability("app", "/Users/ahmsam/Downloads/MainApp (4).ipa");
	      cap.setCapability("xcodeOrgId","BNL4VQ2576");
	      cap.setCapability("useNewWDA", true);
		  cap.setCapability("xcodeSigningId","iPhone Developer");
		  cap.setCapability("udid","240476512a6dd29a2f82fc8211ef4ea1bf6b5891");
		  
		//  cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 800);

		 // cap.setCapability("udid","3c7ad82d510561a572d459cab855154cd578e3da");
		  cap.setCapability("updateWDABundleId","5SN9XXLNWB.uk.org.humanfocus.WildCard.Dev");
		  //cap.setCapability("updateWDABundleId","uk.org.humanfocus.WildCard.UK2");
	      
	      String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";
	     
	      driver = new IOSDriver<IOSElement>(new URL(serverUrl), cap);
		  
		  
		/*  cap.setCapability("device", "iPhone 8 Plus");
		  cap.setCapability("os_version", "11");
		  cap.setCapability("app", "bs://0d958b4a7f019138a7033d250ef81120200e1b66");
		      

		      IOSDriver driver = new IOSDriver(new URL("http://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), cap);*/
		  
		  
	      driver.manage().timeouts().implicitlyWait(55,TimeUnit.SECONDS);
		
	      lPage=new LoginPage(driver);
	      lPage.firstThreePopoClick();
	      boolean check= lPage.validateLoginpage();

	     // = lPage.loginTestCase();
	     
	     Assert.assertTrue(check); 
		 //fail("Not yet implemented");
	}

	 @Test(priority=2)
	 //@Order(2)
	// @DisplayName("Verify that user successfully logins with correct credentials")
	 public void test1() 
		{
		 	lPage=new LoginPage(driver);
			
			boolean check1=lPage.TestdoLoginWIthValues();
			
			Assert.assertTrue(check1==true);
			
		}

	 @Test(priority=3)
	 //@Order(3)
	// @DisplayName("Verify that after successfully login user can see the pop up")
	 public void test3() 
		{
		 	lPage=new LoginPage(driver);
			
			boolean check1=lPage.loginTestCase();
			
			Assert.assertTrue(check1==true);
			
		}

	 @Test(priority=4)
	// @Order(4)
	// @DisplayName("Verify that Dashboard Page is displayed succesfully")
	 public void test4() 
		{
		 	lPage=new LoginPage(driver);
			
			boolean check1=lPage.TestGotoHomePage();
		
			Assert.assertTrue(check1==true);
			
		}
	 

	 @Test(priority=5)
	// @Order(5)
	// @DisplayName("Verify that after selecting a particular toolkit user can see the program code")
	 public void test5() 
		{
		 	mPage=new MainPage(driver);
		 	
			
			boolean check1=mPage.goToTrainings();
			
			Assert.assertTrue(check1);
			
		}

	 @Test(priority=6)
	// @Order(6)
	 //@DisplayName("Verify that user see the same program code on the program list and program code appearing on a popup after clicking a particular program")
	 public void test6() 
		{
		 	p_page=new ProgrammesPage(driver);
		 	
			
			boolean check1=p_page.verifyProgramCode();
			
			Assert.assertTrue(check1);
			
		}
	 
	 

	 @Test(priority=7)
	// @Order(7)
	// @DisplayName("Verify that the continue button is not clickable at the first time to start a training")
	 public void test7() 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyContinueBtnDisable();
			
			Assert.assertTrue(check1);
			
		}

	 @Test(priority=8)
	// @Order(8)
	// @DisplayName("Verify that after starting a training the Next button is by default disable in the first section")
	 public void test8() 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyVideoNextBtnDIsable();
			
			Assert.assertTrue(check1);
			
		}

	 @Test(priority=9)
	// @Order(9)
	// @DisplayName("Verify that after watching the video content complete the Next button becomes clickable")
	 public void test9() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyWatchView_ClickonNextBtn();
			
			Assert.assertTrue(check1);
			
		}

	 @Test(priority=10)
	 //@Order(10)
	// @DisplayName("Verify that the Next button on the document is Not Clickable without viewing the document")
	 public void test10() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyDocumentPageNextButton();
			
			Assert.assertTrue(check1);
			
		}

	 @Test(priority=11)
	// @Order(11)
	// @DisplayName("Verify that after viewing the document the Next button is clikable")
	 public void test11() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyViewDocument_NextBtn();
			
			Assert.assertTrue(check1);
			
		}

	 @Test(priority=12)
	// @Order(12)
	// @DisplayName("Verify that section name for Docu")
	 public void test12() 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyLastSectionName();
			
			Assert.assertTrue(check1);
			
		}
	
	 @Test(priority=13)
	/// @Order(13)
	// @DisplayName("Verify that continue button is clickable")
	 public void test13() 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyContinueBtnEnable();
			
			Assert.assertTrue(check1);
			
		}

	 @Test(priority=14)
	 //@Order(14)
	// @DisplayName("Verify that user is redirected to that section which he left earlier after clicking the continue button")
	 public void test14() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyGoBackToSection();
			
			Assert.assertTrue(check1);
			
		}
	 
	 
	 @Test(priority=15)
	// @Order(15)
	// @DisplayName("Verify that next button is not clickable when you are redirected to that section")
	 public void test15() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyLastSectionNextBtnDisable();
			
			Assert.assertTrue(check1);
			
		}

	 @Test(priority=16)
	// @Order(16)
	// @DisplayName("Verify that ")
	 public void test16() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyThirdSectionName();
			Assert.assertTrue(check1);
			
		}
	 
	 @Test(priority=17)
	// @Order(17)
	// @DisplayName("Verify that after giving all wrong answers to the knowledge test, user is failing the test with  zero score")
	 public void test17() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyFailWith0Score();
			Assert.assertTrue(check1);
			
		}
	   
	 @Test(priority=18)
	// @Order(18)
	 //@DisplayName("Verify that after giving one correct answer out of 4 in the knowledge test ,user is failing the test with 25 score")
	 public void test18() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyFailWith33Score();
			Assert.assertTrue(check1);
			
		}
	 
	 @Test(priority=19)
	// @Order(19)
	// @DisplayName("Verify that after giving two correct answers out of 4 in the knowledge test, user is failing the test with 50 score")
	 public void test19() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyFailWith66Score();
			Assert.assertTrue(check1);
			
		}
	 
	/* @Test(priority=20)
	 //@Order(20)
	// @DisplayName("Verify that after giving three correct answers out of 4 in the knowledge test, user is failing the test with 75 score")
	 public void test20() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyFailWith75Score();
			Assert.assertTrue(check1);
			
		}*/
	
	 @Test(priority=21)
	// @Order(21)
	// @DisplayName("Verify that after giving three correct answers out of 4 in the knowledge test, user is failing the test with 75 score")
	 public void test21() throws InterruptedException 
		{
		 	p_page=new ProgrammesPage(driver);
			boolean check1=p_page.verifyPasswith100Score();
		//	Assert.assertTrue(check1);*/
			
		}
	
	
	
	
	
	
	

}
