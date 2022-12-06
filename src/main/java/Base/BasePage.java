package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BasePage {

	static public WebDriver driver = null;
	static Properties prop = new Properties(); 
	public static String browser=System.getProperty("browser");
	public static String ENV=System.getProperty("env");
	protected static final Logger logger = LogManager.getLogger(BasePage.class);	
	

	
	@BeforeMethod
	public void setUp() {
		logger.info("Starting test - setup");
		logger.info("Test runned on :" + browser);
		logger.info("Test runned on the environnement  :" + ENV);
		String projectPath = System.getProperty("user.dir");
		switch (browser) {
		case "chrome":
			ChromeOptions optionsChrome = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			optionsChrome.addArguments("--window-size=1920,1200");
			driver = new ChromeDriver(optionsChrome);
			logger.info("Launching Chrome !!!");
			break;
		case "firefox":
			FirefoxOptions optionsfirefox = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			optionsfirefox.addArguments("--window-size=1920,1200");
			driver = new FirefoxDriver(optionsfirefox); 
			logger.info("Launching firefox !!!");
			break;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOptions);
			edgeOptions.addArguments("--window-size=1920,1200");
			logger.info("Launching edge !!!");
			break;

		default:
			ChromeOptions optionschrome = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			optionschrome.addArguments("--window-size=1920,1200");
			driver = new ChromeDriver(optionschrome);
			logger.info("Launching Chrome !!!");
			break;
		}
		driver.get(readPropertiesFile("URL"));
	}

	public static String readPropertiesFile(String property)  {
		String param = null;
		try {
			//renvoi le Workspace
			String projectPath =System.getProperty("user.dir");
			InputStream input = null;
			switch (ENV) {
			case "dev":
				input=new FileInputStream(projectPath+"/src/test/resources/Config/ConfigProperties-dev");
				break;
			case "preprod":
				input=new FileInputStream(projectPath+"/src/test/resources/Config/ConfigProperties-preprod");
				break;
			case "prod":
				input=new FileInputStream(projectPath+"/src/test/resources/Config/ConfigProperties-prod");
				break;
			case "qa":
				input=new FileInputStream(projectPath+"/src/test/resources/Config/ConfigProperties-qa");
				break;
			default:
				input=new FileInputStream(projectPath+"/src/test/resources/Config/ConfigProperties-qa");
				break;
			}
			
			prop.load(input);
			param=prop.getProperty(property);   
		} catch (Exception e) {
			logger.debug(e);
			e.printStackTrace();
		}
		return param;
	}

	public void waitVisiblityOfElement(By element){
		logger.debug("waiting visiblity for " + element);
		new WebDriverWait(driver, Duration.ofSeconds(20)).
		until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void waitClickableElement(By element){
		logger.debug("waiting visiblity for " + element);
		new WebDriverWait(driver, Duration.ofSeconds(20)).
		until(ExpectedConditions.elementToBeClickable(element));
	}
	public void ClickOnElement(By element){
		waitClickableElement(element);
		logger.debug("Click on " + element);
		driver.findElement(element).click();	
	}
	public void SendKey(String txt, By element){
		logger.debug("Send key to the " + element);
		waitClickableElement(element);
		driver.findElement(element).sendKeys(txt);
	}
	public String getText(By element){
		waitVisiblityOfElement(element);
		logger.debug("The text getted form " + element + "is " + driver.findElement(element).getText());
		return driver.findElement(element).getText();
	}


	@AfterMethod
	public void teadown()  {
		System.out.println("teadown");
		driver.quit();
	}
}
