package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver ;
	public LandingPage landingPage;
	public WebDriver InitializeDriver() throws IOException {
		
		// properties class
		
		Properties prop = new Properties();
		
		// to create input stream for the GlobalData file we used the below method.
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		// Now the value fis can be passed as an input stream to load function.
		prop.load(fis);
		 
		String browserNameString = System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser") ;
		//prop.getProperty("browser");
		
		if(browserNameString.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			if(browserNameString.contains("Headless")) {
				options.addArguments("headless");
			}
			 driver = new ChromeDriver(options);
			 driver.manage().window().setSize(new Dimension(1440,900)); // full screen for headless mode
					
		}
		else if(browserNameString.equalsIgnoreCase("firefox")){
			 driver = new FirefoxDriver();
		}
		else if(browserNameString.equalsIgnoreCase("edge")){
			 driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// Read Json to string 
		 String jsonContentString = FileUtils.readFileToString(new File(System.getProperty("user.dir")+filePath),StandardCharsets.UTF_8);
		 
		 // String to HashMap (Jackson databind)
		 
		 ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsonContentString, new TypeReference<List<HashMap<String,String>>>() {
		});
		 return data;
		 // {map,map}
		 
	}
	
	
	
	public String getScreenShot(String testCaseName , WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile =  ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(sourceFile, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = InitializeDriver();
		 landingPage = new LandingPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		landingPage.goTo();
		return landingPage;
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
