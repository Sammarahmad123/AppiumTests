import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ApiClasses.TestData.testData;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainPage {
IOSDriver<IOSElement> driver;
	
	//constructor to initialize MainPage Class with IOSDriver with pageFactory design pattern
	ProgrammesPage prog_page;
	public MainPage(IOSDriver<IOSElement> driver) {
	       this.driver = driver;
	      // PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	       PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	   }
	
	
	//This method verifies if program code is displayed after clicking a toolkit
	public boolean goToTrainings()
	{
		boolean element=true;
		prog_page=new ProgrammesPage(driver);
		Training_Guide_Btn.click();
		Training_Guide_Btn.click();
		
		/*MobileElement listItem=(MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
			      + ".scrollable(true)).scrollIntoView("
			      + "new UiSelector().text(\"Utoolkit-208\"))"));*/
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		
		//scrollObject.put("xpath", prog_page.program_code());
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
		js.executeScript("mobile: scroll", scrollObject);
		//js.executeScript("mobile: scroll", scrollObject);
		
		driver.findElement(By.name("New")).click();
		//prog_page.program_click().click();
		if(driver.findElementByAccessibilityId("10133").isDisplayed())
		{
			element=true;
		}
		else
		{
			element=false;
		}
			/*
		
		if(prog_page.program_code().isDisplayed())
		{
			element=true;
		}
		else
		{
			element=false;
		}*/
		return element;
		
		
	}
	
	
	
	
	




	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Training & Guides\"]")
    public MobileElement Training_Guide_Btn;
	
	
	@FindBy(xpath = "xpath	//XCUIElementTypeButton[@name=\"e-Checklists\"]")
    public MobileElement e_checklist_Btn;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Settings\"]")
    public MobileElement settings_Btn;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Notifications\"]")
    public MobileElement notification_Btn;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Refresh\"]")
    public MobileElement refresh_Btn;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Logout\"]")
    public MobileElement logout_Btn;
	
	@FindBy(xpath = "//XCUIElementTypeApplication[@name=\"Human Focus Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeImage")
    public MobileElement qr_code_image;
	
	@FindBy(xpath = "//XCUIElementTypeImage[@name=\"/var/containers/Bundle/Application/6D0791DF-F44F-41D9-A2D3-E6F7D85ECA53/MainApp.app/uploadPhoto.png\"]")
    public MobileElement user_image;
	

}
