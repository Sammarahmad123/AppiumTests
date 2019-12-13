import java.util.HashMap;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ApiClasses.TestData.testData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProgrammesPage {
	//constructor to initialize ProgrammesPage Class with IOSDriver with pageFactory design pattern
		IOSDriver<IOSElement> driver;
		public ProgrammesPage(IOSDriver<IOSElement> driver) {
		       this.driver = driver;
		      // PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		       PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		       
		   }
		
		
		//This method verifies program code on list of program page and program code after clicking a particular program
		public boolean verifyProgramCode()
		{
			boolean verify=false;
			String code_text=program_code().getText();
			String title_text=programme_title().getText();
			System.out.println("mjha click kar do");
			program_code().click();
			
			System.out.println("String code text: "+code_text);
			System.out.println("String title text: "+title_text);
			
			if(code_text.equals(program_code_match().getText()))
			{
				System.out.println("dfhdfhhd");
				if(title_text.equals(programme_title_match().getText()))
				{
					System.out.println("Both Matches");
					verify=true;
				}
				
			}
			else
			{
				System.out.println("Both not Matches");
				verify=false;
			}
			return verify;
		}
		
		
		//this method verifies that continue button is disabled for the first time 
		public boolean verifyContinueBtnDisable()
		{
			System.out.println("verify methed starts");
			program_code().click();
			System.out.println("Clicked");
			boolean verify=continue_btn.isEnabled();
			
			if(verify==false)
			{
				verify=true;
			}
			else
			{
				verify=false;
			}
			return verify;
			
		}
		
		//@SuppressWarnings("deprecation")
		public boolean verifyVideoNextBtnDIsable()
		{
			program_start_btn.click();
			boolean isElementPresent;
			isElementPresent = video_next_btn.isEnabled();
			
			if(isElementPresent==false)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public boolean verifyWatchView_ClickonNextBtn() throws InterruptedException 
		{
			boolean isElementPresent;
			video_click_btn.click();
			
			
			
				
				
				Thread.sleep(30000);
				isElementPresent = video_next_btn.isEnabled();
				if(isElementPresent==true)
				{
					return true;
				}
				else
				{
					System.out.println("Button cannot be clicked");
					return false;
				}
				
				
			
		}
		
		public boolean verifyDocumentPageNextButton() throws InterruptedException
		{
			video_next_btn.click();
			boolean isElementPresent;
			Thread.sleep(2000);
			isElementPresent=document_next_btn.isEnabled();
			
			if(isElementPresent==false)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		public boolean verifyViewDocument_NextBtn() throws InterruptedException
		{
			boolean isElementPresent;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			Thread.sleep(2000);
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			
			isElementPresent=document_next_btn.isEnabled();
			
			if(isElementPresent==true)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		
		public boolean verifyLastSectionName()
		{
			String text=second_section_name().getText();
			System.out.println(text);
			driver.navigate().back();
			exit_yes_btn.click();
			program_code().click();
			boolean isElementPresent=false;
			
			if(text.contains(second_section_name().getText()))
			{
				if(continue_btn.isEnabled())
				{
					isElementPresent=true;
				}
			}
			else
			{
				isElementPresent=false;
			}
			return isElementPresent;
			
			
		}
		
		public boolean verifyContinueBtnEnable()
		{
			boolean isElementFound=false;
			isElementFound=continue_btn.isEnabled();
			if(isElementFound==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public boolean verifyGoBackToSection() throws InterruptedException
		{
			String text=second_section_name().getText();
			continue_btn.click();
			boolean isElementFound;
			Thread.sleep(2000);
			if(text.contains(second_section_name().getText()))
			{
				isElementFound=true;
			}
			else
			{
				isElementFound=false;
			}
			return isElementFound;
		}
		
		public boolean verifyLastSectionNextBtnDisable() throws InterruptedException
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);

			document_next_btn.click();
			boolean isElementFound;
			Thread.sleep(2000);
			isElementFound=document_next_btn.isEnabled();
			if(isElementFound==false)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		
		
		public boolean verifyThirdSectionName()
		{
			String text=third_section_name().getText();
			driver.navigate().back();
			exit_yes_btn.click();
			program_code().click();
			
			
			boolean isElementPresent=false;
			
			if(text.contains(third_section_name().getText()))
			{
				if(continue_btn.isEnabled())
				{
					isElementPresent=true;
				}
			}
			else
			{
				isElementPresent=false;
			}
			return isElementPresent;
			
		}
		
		
		
		public boolean verifyFailWith0Score()
		{
			continue_btn.click();
			first_question_option_2.click();
			second_question_option_2.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			//scrollObject.put("name", "Our individual actions do not affect the environment");
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			third_question_option_3.click();
			third_question_option_4.click();
			
			document_next_btn.click();
			int totalQ=Integer.parseInt(total_questions.getText());
			
			int correctQ=Integer.parseInt(correct_questions_0.getText());
			
			int score=correctQ/totalQ ;
			score=score*100;
			String text=fail.getText();
			
			
			
			
			if(score==0 && text.contains("Fail"))
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		}
		
		public boolean verifyFailWith33Score() throws InterruptedException
		{
			retake_training_btn.click();
			video_click_btn.click();
			Thread.sleep(30000);
			video_next_btn.click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			document_next_btn.click();
			first_question_option_1.click();
			second_question_option_2.click();
			js.executeScript("mobile: scroll", scrollObject);
			third_question_option_3.click();
			third_question_option_4.click();
			
			document_next_btn.click();
			double totalQ=Double.parseDouble(total_questions.getText());
			
			double correctQ=Double.parseDouble(correct_questions_1.getText());
			
			double score=correctQ/totalQ ;
			
			score=score*100;
			String text=fail.getText();
			
			if(score==33.333 && text.contains("Fail"))
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		}
		
		public boolean verifyFailWith66Score() throws InterruptedException
		{
			retake_training_btn.click();
			video_click_btn.click();
			Thread.sleep(30000);
			video_next_btn.click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			document_next_btn.click();
			first_question_option_1.click();
			second_question_option_1.click();
			js.executeScript("mobile: scroll", scrollObject);
			third_question_option_3.click();
			third_question_option_4.click();
			
			document_next_btn.click();
			double totalQ=Double.parseDouble(total_questions.getText());
			
			double correctQ=Double.parseDouble(correct_questions_2.getText());
			
			double score=correctQ/totalQ ;
			
			score=score*100;
			String text=fail.getText();
			
			if(score==66.66 && text.contains("Fail"))
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		}
		
		/*public boolean verifyFailWith75Score() throws InterruptedException
		{
			retake_training_btn.click();
			video_click_btn.click();
			Thread.sleep(30000);
			video_next_btn.click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			document_next_btn.click();
			
			first_question_option_1.click();
			second_question_option_1.click();
			js.executeScript("mobile: scroll", scrollObject);
			third_question_option_3.click();
			third_question_option_4.click();
			fourth_question_option_1.click();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			fourth_question_option_4.click();
			document_next_btn.click();
			double totalQ=Double.parseDouble(total_questions.getText());
			
			double correctQ=Double.parseDouble(correct_questions_3.getText());
			
			double score=correctQ/totalQ ;
			
			score=score*100;
			String text=fail.getText();
			System.out.println(text);
			if(score==75 && text.contains("Fail"))
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		}*/
		
		public boolean verifyPasswith100Score() throws InterruptedException
		{
			
			retake_training_btn.click();
			video_click_btn.click();
			Thread.sleep(30000);
			video_next_btn.click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			document_next_btn.click();
			
			first_question_option_1.click();
			second_question_option_1.click();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			
			
			third_question_option_1.click();
			third_question_option_2.click();
			
			document_next_btn.click();
			double totalQ=Double.parseDouble(total_questions.getText());
			System.out.println(totalQ);
			double correctQ=Double.parseDouble(correct_questions_3.getText());
			System.out.println(correctQ);
			double score=correctQ/totalQ ;
			System.out.println(score);
			score=score*100;
			String text=pass.getText();
			System.out.println(text);
			if(score==100 && text.contains("Pass"))
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		}
		
		
		
		
		
			
			
		
			
			
			
		
		
		
		 public MobileElement program_click() {
         	//System.out.println(testData.ToolkitName);
         	//XCUIElementTypeStaticText[@name="IOS Test ToolKit ACTK68L"]

         	return this.driver.findElement(By.name(testData.ToolkitName));
         }

         public MobileElement program_code() {
         	String trCode=Integer.toString(testData.TrainingCode);
         	System.out.println("Program Code on previus page: "+testData.TrainingCode);
         	return this.driver.findElement(By.name(trCode));
         }
			
			
         public MobileElement program_code_match() {
         	String trCode=Integer.toString(testData.TrainingCode);
         	System.out.println("Match Code:"+testData.TrainingCode);
         	return this.driver.findElement(By.name(trCode));
         }
			
         public MobileElement programme_title() {
        	 
				System.out.println("Program title on previous page: "+testData.TrainingName);
         	return this.driver.findElement(By.name(testData.TrainingName));
         }
         
         public MobileElement programme_title_match() {
				System.out.println(testData.TrainingName);
      	return this.driver.findElement(By.name("Match Title: "+testData.TrainingName));
      }
        
         
         public MobileElement second_section_name() {
				System.out.println(testData.TrainingName);
				return this.driver.findElement(By.name("Document"));
   }
         
        
         
         public MobileElement third_section_name() {
					System.out.println(testData.TrainingName);
					return this.driver.findElement(By.name("Questions"));
         	}
         
		
		 /**
		    * All elements of this Page are identified below with their respective element locators 
		    * element locator like-> by.name , by,xpath, by.id etc
		    */
           
            
			@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
		    public MobileElement continue_btn;
			
			
			//@FindBy(name = "Environmental Protection In Offices - What Everyone Needs To Know")
		   // public MobileElement programme_title;
			
			//@FindBy(name = "Environmental Protection In Offices - What Everyone Needs To Know")
		    //public MobileElement programme_title_match;
			
			@FindBy(name = "Start")
		    public MobileElement program_start_btn;
			
			@FindBy(xpath = "//XCUIElementTypeButton[@name=\"baseline play circle outline w\"]")
		    public MobileElement video_click_btn;
			
			@FindBy(name = "Next")
		    public MobileElement video_next_btn;
			
			@FindBy(name = "Next")
		    public MobileElement document_next_btn;
			
			
			
			
			
			@FindBy(name = "Yes")
		    public MobileElement exit_yes_btn;
			
			@FindBy(name = "Next")
		    public MobileElement question_next_btn;
			
			//question1
			@FindBy(name = "one way")
		    public MobileElement first_question_option_1;
			
			@FindBy(name = "two way")
		    public MobileElement first_question_option_2;
			
			@FindBy(name = "three way")
		    public MobileElement first_question_option_3;
			
			
			//questions2 
			@FindBy(name = "Kashif")
		    public MobileElement second_question_option_1;
			
			@FindBy(name = "Murtaza")
		    public MobileElement second_question_option_2;
			
			@FindBy(name = "Bravo")
		    public MobileElement second_question_option_3;
			
			
			//question3
			@FindBy(name = "this way")
		    public MobileElement third_question_option_1;
			
			@FindBy(name = "that")
		    public MobileElement third_question_option_2;
			
			@FindBy(name = "not now")
		    public MobileElement third_question_option_3;
			
			@FindBy(name = "next day")
		    public MobileElement third_question_option_4;
			
			
			
			
			@FindBy(name = "3")
		    public MobileElement total_questions;
			
			@FindBy(name = "0")
		    public MobileElement correct_questions_0;
			
			@FindBy(name = "1")
		    public MobileElement correct_questions_1;
			
			@FindBy(name = "2")
		    public MobileElement correct_questions_2;
			
			@FindBy(name = "3")
		    public MobileElement correct_questions_3;
			
			
			
			@FindBy(name = "Fail")
		    public MobileElement fail;
			
			@FindBy(name = "Pass")
		    public MobileElement pass;
			
			@FindBy(name = "Retake Training")
		    public MobileElement retake_training_btn;
			
			
			
			
			
			
			
			
			
			

}
