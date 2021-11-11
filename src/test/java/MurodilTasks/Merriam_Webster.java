package MurodilTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;

import java.util.List;

public class Merriam_Webster {
    /**
     * 1. Open Chrome browser
     * 2. Go to https://www.merriam-webster.com/
     * 3. Print out the texts of all links
     * 4. Print out how many link is missing text
     * 5. Print out how many link has text
     * 6. Print out how many total link
     *
     */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = " https://www.merriam-webster.com/ ";
        driver.get(url);
        List<WebElement> links = driver.findElements(By.tagName("script"));

        System.out.println("There are : "+ links.size()+ " in the Website");

        int countLinks =0;
        for(WebElement eachLink: links){
            if(eachLink.getAttribute("src").isEmpty()){
                countLinks++;

            }
        }
        System.out.println("Missing text links: "+ countLinks);
    }
}
