import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	IOSDriver<IOSElement> driver;
	MainPage mPage;
	
	
	//constructor to initialize LoginPage Class with IOSDriver with pageFactory design pattern
	
	   public LoginPage(IOSDriver<IOSElement> driver) {
	       this.driver = driver;
	      // PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	       PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	   }	
	
	   
	   
	   //check if all fields of login page are displayed
	public boolean validateLoginpage(){
        boolean elements = false;
        if(organizationIdentifier.isDisplayed()){
            if(personIdentifier.isDisplayed()){
                if(password.isDisplayed()){
                    if(loginButton.isDisplayed()){
                        elements = true;
                    }
                }
            }
        }
        else{
            elements = false;
        }
        return elements;


    }

	
	//click three pop ups before login 
	public void  firstThreePopoClick()
	{
		
		firstPopUp.click();
		secondPopUp.click();
		thirdPopUp.click();
		
			
		//OKPopupBtn.click();
	}
	
	
	//entering values to login and check if wheel is displayed
	public boolean TestdoLoginWIthValues()
	{
		organizationIdentifier.sendKeys("testauto");
		personIdentifier.sendKeys("manager");
		password.sendKeys("123456");
		boolean element=false;
		
		loginButton.click();
		if(logoutDoneButtonWheel.isDisplayed())
		{
			element=true;
		}
		
		return element;
	}
	
	//accept popup to check successfull login
	public boolean loginTestCase()
	{
		logoutDoneButtonWheel.click();
		boolean check=false;
		if(acceptPopupBtn.isDisplayed())
		{
			check=true;
			
		}
		else
		{
			check=false;
			
			
		}
		return check;
	}
	
	//check if HomePage is displayed
	public boolean TestGotoHomePage()
	{
		boolean element=false;
		acceptPopupBtn.click();
		OKPopupBtn.click();
		mPage=new MainPage(driver);
		
		if(mPage.Training_Guide_Btn.isDisplayed())
		{
			element=true;
		}
		else
		{
			element=false;
		}
		
		return element;
		
		
	}
	
	
	
   /**
    * All elements of this Page are identified below with their respective element locators 
    * element locator like-> by.name , by,xpath, by.id etc
    */
	
	
		

		@FindBy(name = "Allow")
		public MobileElement firstPopUp;
        //@CacheLookup
       // @FindBy(name = "Allow")
       

        
        @FindBy(name = "OK")
        public MobileElement secondPopUp;
        
        
        @FindBy(name = "Ok")
        public MobileElement thirdPopUp;
        
      

        @FindBy(name = "Enter Organisation Identifier")
        public MobileElement organizationIdentifier;
       
        @FindBy(name = "Enter Person Identifier")
        public MobileElement personIdentifier;
        
       
        @FindBy(name = "Enter Password")
        public MobileElement password;
        
        
        @FindBy(id =  "Login")
        public MobileElement loginButton;
        
       
        @FindBy(xpath =  "//XCUIElementTypeButton[@name=\"Done\"]")
        public MobileElement logoutDoneButtonWheel;
        
        
        
        @FindBy(name =  "Accept")
        public MobileElement acceptPopupBtn;
        
        
        @CacheLookup
        @FindBy(name =  "Ok")
        public MobileElement OKPopupBtn;
        

}
