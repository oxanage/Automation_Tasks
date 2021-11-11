package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    /**
     WebDriverFactory class:
     is used to create WebDriver(Selenium)object and return it
     It will open the browser and maximize it
     method:
     getDriver(String browserType)
     It will check browser type and returns object:
     if browser is "chrome"
     it will set up chrome driver, and return new ChromeDriver
     if browserType is "firefox":
     it will set up firefox driver,and return new FirefoxDriver

     */
    public static WebDriver getDriver (String browserType){
        if(browserType.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }else{
            System.out.println("invalid browser type = "+ browserType);
            return null;
        }

    }
}
