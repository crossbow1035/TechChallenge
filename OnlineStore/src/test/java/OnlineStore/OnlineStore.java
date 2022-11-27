/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OnlineStore;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 *
 * @author alexbow
 */
public class OnlineStore {
  private WebDriver driver;
  private Map<String, Object> vars;
//  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
//    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    System.setProperty("webdriver.gecko.driver","/Users/alexbow/NetBeansProjects/TechChallenge/OnlineStoreTests/drivers/geckodriver");
    driver.get("https://www.demoblaze.com/index.html");
  }
    @After
  public void tearDown() {
    driver.close();
  }
  @Test
  public void Navigatethroughsections() throws InterruptedException {

//    {
//      WebElement element = driver.findElement(By.id("signin2"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();
//    }
//    {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();
//    }
    Thread.sleep(2000);
    //Customer navigation through product categories: Phones, Laptops and Monitors
    driver.findElement(By.linkText("Phones")).click();
        Thread.sleep(2000);

    driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(2000);

    driver.findElement(By.linkText("Monitors")).click();
        Thread.sleep(2000);

    
    //Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation
    driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(2000);

    driver.findElement(By.linkText("Sony vaio i5")).click();
        Thread.sleep(2000);

    driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);

    Alert popupvaio = driver.switchTo().alert();
    assertThat(popupvaio.getText(), is("Product added"));
    popupvaio.accept();
        Thread.sleep(2000);
        
        driver.get("https://www.demoblaze.com/index.html");

    //Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
    driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(2000);

    driver.findElement(By.linkText("Dell i7 8gb")).click();
        Thread.sleep(2000);

    driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);

    Alert popupi7 = driver.switchTo().alert();
    assertThat(popupi7.getText(), is("Product added"));
    popupi7.accept();
    Thread.sleep(2000);

    //Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
    driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);

     var rows =  driver.findElements(By.className("success"));
     
     for(WebElement w:rows) {
         boolean isDellItem = w.getText().contains("Dell");
         
         if (isDellItem) {
            w.findElement(By.linkText("Delete")).click();
            break;
         }
     }
    Thread.sleep(5000);

    String totalAmount = driver.findElement(By.id("totalp")).getText();
        assertThat(totalAmount, is("790"));
    //
    driver.findElement(By.className("btn-success")).click();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("Al");
    driver.findElement(By.id("country")).sendKeys("Spain");
    driver.findElement(By.id("city")).sendKeys("Zaragoza");
    driver.findElement(By.id("card")).sendKeys("7325786936542369584303476");
    driver.findElement(By.id("month")).click();
    driver.findElement(By.id("month")).sendKeys("3");
    driver.findElement(By.id("year")).click();
    driver.findElement(By.id("year")).sendKeys("23");
    
    Thread.sleep(2000);
    WebElement item = driver.findElement(By.className("btn-primary"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
    item.click();
    
    
    WebElement result = driver.findElement(By.className("text-muted" ));
    
      System.out.println(result.getText());
      
    driver.findElement(By.linkText("OK")).click();


//    driver.get("https://www.demoblaze.com/cart.html");
//    driver.findElement(By.cssSelector(".btn-success")).click();
    
  }
}
