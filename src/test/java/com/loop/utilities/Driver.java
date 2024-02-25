package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class Driver {
    /*
    Creating the private constructor so this class's Object is not reachable from outside
     */
    private Driver(){

    }

    /*
    making driver instance private
    static - run before everything else and also use in static method
     */

    private static WebDriver driver;

    private static ChromeOptions chromeOptions;

    /*
    reusable method that will return the same driver instance every time called
     */
    /**
     * singleton pattern
     * @return driver
     * @author anna
     */

    public static WebDriver getDriver(){
        if(driver==null){
           String browserType = ConfigurationReader.getProperty("browser");
           switch(browserType.toLowerCase()){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver();
                   break;
               case "chrome-linux":
                   WebDriverManager.chromedriver().setup();
                   chromeOptions = new ChromeOptions();
                   chromeOptions.addArguments("--headless");
                   chromeOptions.addArguments("--no-sandbox");
                   chromeOptions.addArguments("--disable-dev-shm-usage");
                   driver = new ChromeDriver(chromeOptions);
                   break;
           }
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return  driver;
    }

    /**
     * closing driver
     * @author anna
     */
    public static void closeDriver(){
        if (driver!= null){
            driver.quit();
            driver = null;
        }
    }



}
