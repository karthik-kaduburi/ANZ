package utils;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;
 
    //initialize webdriver
    private static WebDriver driver;
    
    //initialize timeouts
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;
    public static WebDriverWait wait;
    
    private  SeleniumDriver() {

       
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10);
        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        String window=driver.getWindowHandle();
        System.out.println("Window ->"+window);
       
    }

    /**
     * @param url
     * Navigates to the url
     */
    public static void openPage(String url) {
    	System.out.println(url);
    	System.out.println(driver);
        driver.get(url);
        SeleniumDriver.waitForPageToLoad();
    }

    /**
     * @return
     * get driver instance
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * set driver instance
     */
    public static void setUpDriver() {
       if (seleniumDriver == null)
            seleniumDriver = new SeleniumDriver();
      
    }

    /**
     * closes the driver instance
     */
    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }
    /**
     * waits for the page to load
     */
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * @param element
     * waits for visibility of element
     */
    public static void waitForElement(By element)
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    /**
     * @param sec
     * implicitly waits for the given time(seconds)
     */
    public static void waitForSeconds(int sec)
    {
    	driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }
}
