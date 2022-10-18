package com.mypro.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.*;
import org.testng.annotations.DataProvider;
import com.mypro.actiondriver.Action;
import com.mypro.utility.FileLib;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public FileLib fil=new FileLib();

	
	/*public void loadConfig() {
		try {
			prop = new Properties();
			String propath="Configuration\\config.properties";
			FileInputStream ip = new FileInputStream(propath);
					//System.getProperty("user.dir") + "//Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} */
	

	public WebDriver launchApp() throws IOException {
		 prop=new Properties();
		 String propath="Configuration\\config.properties"; //String propath= "src\\main\\resources\\config.properties";
		FileInputStream fis=new FileInputStream(propath);
		prop.load(fis);
	
		//String browsername=prop.getProperty("browser");
		
		//ResourceBundle rb=ResourceBundle.getBundle("config");
		//String browsername=rb.getString("browser");
		 
			String browsername=prop.getProperty("browser");
			Action action=new Action();
			
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); //This can be used as generic() as its used in all 3 cases 
			driver=new ChromeDriver();	
		}
		else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		action.implicitWait(driver, 10);
		action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	@DataProvider
	public Object [][] signInTest() throws EncryptedDocumentException, IOException {
		
		return fil.getExcelData("E:\\Eclipse2\\myproject\\src\\test\\resources\\TestData\\Test.xlsx", "Sheet1");
	}
		
}
