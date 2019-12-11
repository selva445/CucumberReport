package Parallel;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
import com.vimalselvam.cucumber.listener.Reporter;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


//helloval

public class StepDefinitions {

	 static WebDriver driver;	
	 static ATUTestRecorder recorder;

		@Before
	    public static void setUp(Scenario scenario) {
		
		
			try {
					
				
				
				
				System.out.println(scenario.getName());
				 recorder = new ATUTestRecorder("C:\\Users\\selvakumar.c\\Downloads\\Recordings\\",scenario.getName(),false);			  
				 recorder.start();  
				// Reporter.addScenarioLog(scenario.getName());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }
		
		
		
		@After
	    public static void tearDown(Scenario scenario) throws ATUTestRecorderException, IOException {
			
				try {
					//System.out.println("FAIL " + scenario.getName());
					recorder.stop();				 
					TakesScreenshot scrShot =((TakesScreenshot)driver);
					// System.out.println("HERE1...");
					 	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				       
				        File DestFile=new File("C:\\Users\\selvakumar.c\\eclipse-workspace\\cucumber\\Reportfinal\\1.png");
				        FileUtils.copyFile(SrcFile, DestFile); 
				       // System.out.println("HERE2...");
				       // Reporter.addScreenCaptureFromPath(destination);
				        Reporter.addScreenCaptureFromPath(DestFile.getAbsolutePath());
				        if (driver!=null)
						{
							  driver.close();
						}
					
				}
				
				
				catch(Exception e)
				{
					
					Reporter.addScenarioLog(e.toString());
				}
	    }	
		
		@Given(".*[s|S]olera.*$")
		//@Given("Solera $|^Solera SYS URL is open|Open Solera|Open Solera Application|Solera|Open Solera|Opened Solera|Solera.*|.*Solera|$")
		//@Given("^Solera(?: | opened | open| is open| Open| OPEN| created |)$")
		


		public void the_Solera_SYS_URL_is_opened() throws Throwable {
			try {
				System.out.println("Here added");
				 // Write code here that turns the phrase above into concrete actions
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\selvakumar.c\\Downloads\\Fram6\\Fram6 - Copy\\src\\main\\java\\Jar\\chromedriver.exe");				 			
					ChromeOptions options = new ChromeOptions();				 			
					options.addArguments("--lang=en-AU");	
					options.setExperimentalOption("useAutomationExtension", false);
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("intl.accept_languages", "en-AU");
					options.setExperimentalOption("prefs", prefs);
				
					prefs.put("plugins.plugins_disabled", new String[] {
		                "Chrome PDF Viewer"
		            });
					prefs.put("plugins.always_open_pdf_externally", true);
					//String downloadFilepath = Constant.PDF_Download;
					//prefs.put("download.default_directory", downloadFilepath);
					options.setExperimentalOption("prefs", prefs);
					driver = new ChromeDriver(options);				 			
					System.out.println("Chrome Browser is selected");				 			
					
				    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				   
				    driver.get("https://audanet-cae.audatex.com.au/sso/login?service=https%3a%2f%2faudanet-cae.audatex.com.au%2fbre");
				    driver. manage(). window().maximize();
				  
				    Reporter.addStepLog("Solera URL is navigated via Chrome Browser");
				    System.out.println(driver.getTitle());
				    
				    
			}
			catch (Exception e)
			{
				 Reporter.addStepLog("Solera URL is NOT navigated via Chrome Browser");
				 System.out.println("Exception" + e.getMessage());
			}
		   
		}

		@When("^.*[O|o]fficer.*\"([^\"]*)\".*$")
		public void i_enter_the_Claims_officer_credentials_and_login(String arg1 ) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			try {
				
				Reporter.addStepLog(arg1 + " : Credentials are entered to login to Solera");
				System.out.println("USer Id for " + arg1);
				
				driver.findElement(By.id("ssousername")).clear();
				driver.findElement(By.id("ssousername")).sendKeys("155757");
				
				 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				driver.findElement(By.id("password")).clear();
				driver.findElement(By.id("password")).sendKeys("x7U2Nj33AN0B99EH");
				 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				driver.findElement(By.name("submit")).click();
				 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
			catch(Exception e)
			{
				 Reporter.addStepLog("Solera URL is navigated via Chrome Browser");
				 System.out.println("Exception" + e.getMessage());
			}
			
		}

		@Then("^.*[a|A]gency.*\"([^\"]*)\".*$")
		public void i_create_a_Case_with_Agency_as(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			
			try {
				Reporter.addStepLog("Agency is chosen as :" + arg1);
				System.out.println("Case for  " + arg1);
				driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Welcome back to AudaNet'])[1]/following::i[1]")).click();;
				
				driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", driver.findElement(By.id("btnAddCase")));
				
				
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
			 
				driver.switchTo().frame(driver.findElement(By.id("taskActionFrame")));
				
				
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
				
				
				Select select = new Select(driver.findElement(By.id("PreIntakeForm_root.task.assignmentItem")));	    		
				select.selectByVisibleText("Request for Quote/Onsite Inspection");
				
				driver.findElement(By.id("PreIntakeForm_root.task.claimNumber")).clear();
				driver.findElement(By.id("PreIntakeForm_root.task.claimNumber")).sendKeys("Claim 1234567" );
				
				 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				 
				 

				 Select select1 = new Select(driver.findElement(By.id("PreIntakeForm_root.task.basicClaimData.policyData.productText")));	    		
				 select1.selectByVisibleText(arg1);
				 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			

				driver.findElement(By.id("PreIntakeForm_root.task.basicClaimData.vehicle.vehicleAdmin.plateNumber")).clear();
				driver.findElement(By.id("PreIntakeForm_root.task.basicClaimData.vehicle.vehicleAdmin.plateNumber")).sendKeys("Rego 89124356" );
					
				
					 
				 
				 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					
					
					
					Select select3 = new Select(driver.findElement(By.id("PreIntakeForm_root.task.assessorAssignment.assessmentStatusText")));	    		
					select3.selectByVisibleText("Current");
					
					
					
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					
					
					
					Select select4 = new Select(driver.findElement(By.id("PreIntakeForm_root.task.basicClaimData.claimDescriptionVehicle.assignmentMessage")));	    		
					select4.selectByVisibleText("New Quote Request");
					
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					
					
					js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", driver.findElement(By.id("PreIntakeForm_submitButton")));
					
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
			
			catch(Exception e)
			{
				 Reporter.addStepLog("Agency creation failed");
					System.out.println("Exception" + e.getMessage());
			}
			
		}

		@Then("^.*[c|C]ase.*\"([^\"]*)\".*$")
		public void i_verify_the_Case_Created_status_as(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			
			try
			{	
				String strset = driver.findElement(By.id("BREForm_root.uicontrol.text.businessStatusKind")).getText();
				
				System.out.println(arg1);		
			
				
				assertEquals(strset,arg1);
				
				 Reporter.addStepLog("Case Status match - Expected :  " +  arg1 + " Actual : " +  strset );
			}
			catch(Exception e)
			{	
				
				if (driver!=null)
			{
				  driver.close();
			}
				 Reporter.addStepLog("Claim Status mismatch");
				System.out.println("Exception" + e.getMessage());
			
			}
			
		}


	@Then("^.*[C|c]lose.*|$")
	public void i_close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.close();

	}

    
}

