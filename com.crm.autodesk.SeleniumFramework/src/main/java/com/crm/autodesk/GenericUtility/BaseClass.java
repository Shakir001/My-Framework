package com.crm.autodesk.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public WebDriver driver=null;
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"smokeTest","regressionTest","integrationTest","functionalTest"})
	public void beforeSuite() {
		System.out.println("----------connect to data base----------");
	}
	
	@BeforeTest(groups = {"smokeTest","regressionTest","integrationTest","functionalTest"})
	public void beforeTest() {
		System.out.println("----------execute script in parallel mode----------");
	}
	
//	@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest","integrationTest","functionalTest"})
	public void beforeClass() throws Throwable {
		System.out.println("----------launch the browser----------");
		String browserName = fLib.getPropertyKeyValue("browser");
		String url = fLib.getPropertyKeyValue("url");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			throw new Exception("browser is not compatible");
		}
		wLib.getWindowMaximize(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(url);
		sDriver=driver;
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest","integrationTest","functionalTest"})
	public void beforeMethod() throws Throwable {
		System.out.println("----------login----------");
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(username, password);
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest","integrationTest","functionalTest"})
	public void afterMethod() {
		System.out.println("----------logout----------");
		HomePage homePage=new HomePage(driver);
		homePage.logout(driver);
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest","integrationTest","functionalTest"})
	public void afterClass() {
		System.out.println("----------close the browser----------");
		driver.quit();
	}
	
	@AfterTest(groups = {"smokeTest","regressionTest","integrationTest","functionalTest"})
	public void afterTest() {
		System.out.println("----------close parallel mode execution----------");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest","integrationTest","functionalTest"})
	public void afterSuite() {
		System.out.println("----------close data base connection----------");
	}
}
