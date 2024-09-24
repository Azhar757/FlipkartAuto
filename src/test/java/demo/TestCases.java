package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;


// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

Wrappers wrappers = new Wrappers();


    @Test
 public void  testCase01() throws InterruptedException{ 

driver.get("https://www.flipkart.com/");

wrappers.SearchMain(driver, "Washing Machine");
driver.findElement(By.xpath("//div[text()='Popularity']")).click();
// List<WebElement>rating =driver.findElements(By.xpath("(//span[contains(@id,'productRating_LSTWM')]/div)[24]"));
wrappers.scrollToEndOfPage(driver);
Thread.sleep(1000);

int count = 0;
for(int i=1; i<=23; i++){

String rate=driver.findElement(By.xpath("(//span[contains(@id,'productRating_LSTWM')]/div)["+i+"]")).getText();

//System.out.println(rate);
count++;
System.out.println("count = "+count);
Double rateint= Double.parseDouble(rate);
if(rateint<=4){

    System.out.println(rate);
}



}


}

@Test
public void  testCase02() throws InterruptedException{ 
  


    driver.get("https://www.flipkart.com/");
    Thread.sleep(3000);
    try {
    
        driver.findElement(By.xpath("//div[@class='JFPqaw']/span"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='JFPqaw']/span")).click();
    } catch (Exception e) {
        System.out.println("Login Alert Box Appared");
        // TODO: handle exception
    }
    wrappers.SearchMain(driver, "iPhone");

    wrappers.scrollToEndOfPage(driver);
    Thread.sleep(1000);
int count1= 0;

    for(int i=1; i<=24;i++){
 
try{


        WebElement IphonPercentage = driver.findElement(By.xpath("(//div[@class='yKfJKb row'])["+i+"]//div[@class='UkUFwK']"));
      String Discount =  IphonPercentage.getText();
// Use regex to extract the numeric part from the string
String discountNumber = Discount.replaceAll("\\D+", "");  // This will remove all non-digit characters

// Convert the extracted number to an integer
int discountInt = Integer.parseInt(discountNumber);


      if(discountInt>6){

      WebElement  IphoneTitel = driver.findElement(By.xpath("(//div[@class='yKfJKb row'])["+i+"]//div[@class='KzDlHZ']"));
         String IphonT=IphoneTitel.getText();

        System.out.println(IphonT +" " + " " + discountInt);
      }


    } catch (NoSuchElementException e) {
count1++;       
 //System.out.println("NoSuchElementException = "+count1 );
        // TODO: handle exception
    }


    }
    
    System.out.println("Count of Iphone which are not having discount > expected = "+count1 );






}
@Test
public void testCase03()throws InterruptedException{


    driver.get("https://www.flipkart.com/");
    Thread.sleep(3000);
    try {
    
        driver.findElement(By.xpath("//div[@class='JFPqaw']/span"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='JFPqaw']/span")).click();
    } catch (Exception e) {
        System.out.println("Login Alert Box Appared");
        // TODO: handle exception
    }
    wrappers.SearchMain(driver, "Coffee Mug");
    WebElement check =driver.findElement(By.xpath("//span[text()='Price']"));
    wrappers.ScrollToElement(driver, check);
    Thread.sleep(1000);

driver.findElement(By.xpath("(//label[@class='tJjCVx _3DvUAf'])[1]/div[@class='XqNaEv']")).click();
Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the element to be visible
        WebElement star4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='YcSYyC']")));
        Thread.sleep(3000);
wrappers.scrollToEndOfPage(driver);
                // Get all elements with the class 'Wphh3N'
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='Wphh3N']"));

        // Create a list to store the numbers after removing the parentheses
        List<Integer> numbers = new ArrayList<>();

        // Loop through the elements, remove parentheses, and convert text to an integer
        for (WebElement element : elements) {
            String text = element.getText();  // Example: "(608)"
            text = text.replaceAll("[(),]", "");  // Remove parentheses
            int number = Integer.parseInt(text);  // Convert to integer
            numbers.add(number);  // Add to the list
        }

        // Sort the numbers in descending order
        Collections.sort(numbers, Collections.reverseOrder());

        // Print the sorted numbers
     //   System.out.println("Sorted numbers in descending order: " + numbers);

   List<Integer> numbers1 = new ArrayList<>();
        numbers1.add(numbers.get(0));
        numbers1.add(numbers.get(1));
        numbers1.add(numbers.get(2));
        numbers1.add(numbers.get(3));
        numbers1.add(numbers.get(4));

        // Create a list to store formatted numbers
        List<String> formattedNumbers = new ArrayList<>();

        // Loop through the top 5 numbers and format them
        for (int number : numbers1) {
            // Format the number with commas
            String formattedNumber = NumberFormat.getInstance().format(number);
            formattedNumbers.add(formattedNumber);
        }

for (int i=0; i<=4; i++){
   WebElement imageElement= driver.findElement(By.xpath("(//span[text()='("+formattedNumbers.get(i)+")']/parent::div/parent::div//a)[1]"));
    String imageUrl = imageElement.getAttribute("href");

    WebElement ElementTitel= driver.findElement(By.xpath("(//span[text()='("+formattedNumbers.get(i)+")']/parent::div/parent::div//a)[2]"));
    String Titel = ElementTitel.getText();

    System.out.println(imageUrl);
    System.out.println(Titel);

}
       




}//span[text()='Price']

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}