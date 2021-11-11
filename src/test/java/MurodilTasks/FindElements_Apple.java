package MurodilTasks;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;

import java.util.List;

public class FindElements_Apple {

    /**
     * 1. Open Chrome browser
     * 2. Go to https://www.apple.com
     * 3. Click to iPhone
     * 4. Print out the texts of all links
     * 5. Print out how many link is missing text
     * 6. Print out how many link has text
     * 7. Print out how many total link
     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = " https://www.apple.com ";
        driver.get(url);
        WebElement iphone = driver.findElement(By.cssSelector("a[class='ac-gn-link ac-gn-link-iphone']"));
        iphone.click();
        List<WebElement> links = driver.findElements(By.tagName("script"));

        int countLinks=0;
        int emptyLinks=0;

        for(WebElement eachLink:links){
            System.out.println("link: " + eachLink.getAttribute("src"));
            if(eachLink.getAttribute("src").isEmpty()){
                emptyLinks++;
            }
            if(!eachLink.getAttribute("src").isEmpty()){
                countLinks++;
            }
        }
        System.out.println("Links total: "+ links.size());
        System.out.println("Links empty: "+ emptyLinks);
        System.out.println("Links with text: " + countLinks);

        driver.quit();
    }
}
