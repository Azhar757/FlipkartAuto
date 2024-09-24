package demo.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

 public void    SearchMain(WebDriver driver ,String toSearch) throws InterruptedException{


WebElement searchfield =driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
searchfield.sendKeys(toSearch);
WebElement searchButton =driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']"));
Thread.sleep(800);
searchButton.click();
Thread.sleep(3800);


}

public void ScrollToElement (WebDriver driver , WebElement element){

    JavascriptExecutor js = (JavascriptExecutor) driver; 
    js.executeScript("arguments[0].scrollIntoView(true);", element);


}
public void scrollToEndOfPage(WebDriver driver) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
}

}
