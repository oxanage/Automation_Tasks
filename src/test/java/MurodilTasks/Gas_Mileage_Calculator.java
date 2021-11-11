package MurodilTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;

public class Gas_Mileage_Calculator {

    /*
    - Add a new class GasMileageCalculatorTest
- Goto https://www.calculator.net
- Search for “gas mileage” using search box
- Click on the “Gas Mileage Calculator” link
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = " https://www.calculator.net";
        driver.get(url);

        WebElement searchBox = driver.findElement(By.xpath("//input[@type ='text']"));
        searchBox.sendKeys("gas mileage");
        /**
         *click on the "Gas mileage calculator link */

        WebElement link = driver.findElement(By.linkText("Gas Mileage Calculator"));
        link.click();
        /**On Next page verify:
         o Title equals: “Gas Mileage Calculator”
         o “Gas Mileage Calculator” label is displayed
         */
        String expectedTitle = "Gas Mileage Calculator";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title equals: “Gas Mileage Calculator");
        }else{
            System.out.println("Gas Mileage Calculator” label is displayed");
        }

        WebElement label = driver.findElement(By.tagName("h1"));
        System.out.println( "Gas Mileage Calculator is displayed : " + label.isDisplayed());

        /**
         *   Locate, clear and type “7925” into “Current odometer” field
         * - Locate, clear and type “7550” into “Previous odometer” field
         * - Locate, clear and type “16” into “Gas added” field
         * - Locate, clear and type “3.55” into “Gas price” field and Click on Calculate button
         */
        WebElement currentOdometerField = driver.findElement(By.cssSelector("input[name='uscodreading']"));
        currentOdometerField.clear();
        currentOdometerField.sendKeys("7925");
        WebElement previousOdometerField =driver.findElement(By.cssSelector("input[id='uspodreading']"));
        previousOdometerField .clear();
        previousOdometerField.sendKeys("7550");
        WebElement gasAddedField = driver.findElement(By.cssSelector("input[name='usgasputin']"));
        gasAddedField.clear();
        gasAddedField.sendKeys("16");
        WebElement gasPriceField =driver.findElement(By.cssSelector("input[id='usgasprice']"));
        gasPriceField.clear();
        gasPriceField.sendKeys("3.55");

        WebElement calculateButton = driver.findElement(By.cssSelector("input[value='Calculate']"));
        Thread.sleep(2000);
        calculateButton.click();
        /**
         * Locate and print the mpg value
         */
        WebElement value = driver.findElement(By.tagName("b"));

        System.out.println("The mpg value is: " + value.getText());

        driver.quit();
    }

}