/* Web Front-End Automation Script launched with Firefox */
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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OnlineStore {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
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
/*
* FEATURE: Navigation
* SCENARIO: we navigate to different categories
* GIVEN we navigate from the website home
* WHEN we click on each category
* THEN we can see all items of each category
*/
    Thread.sleep(2000);
    driver.findElement(By.linkText("Phones")).click();
        Thread.sleep(2000);

    driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(2000);

    driver.findElement(By.linkText("Monitors")).click();
        Thread.sleep(2000);

/*
* FEATURE: Cart
* SCENARIO: we add an item to cart
* GIVEN we add a Sony laptop from item page
* WHEN we click on Add to cart
* THEN we can see a pop up confirmation
*/
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

/*
* FEATURE: Cart
* SCENARIO: we add an item to cart
* GIVEN we add a Dell laptop from item page
* WHEN we click on Add to cart
* THEN we can see a pop up confirmation
*/
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

/*
* FEATURE: Cart
* SCENARIO: we remove an item from cart
* GIVEN we remove a laptop from cart page
* WHEN we click on Delete
* THEN the laptop dissapears in the cart
*/
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
     
/*
* FEATURE: Purchase
* SCENARIO: we confirm the purchase
* GIVEN we fill the form with valid inputs
* WHEN we click on confirmation button
* THEN the purchase is confirmed and total amount is correct
*/
     
    Thread.sleep(5000);
    String totalAmount = driver.findElement(By.id("totalp")).getText();
   
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
    
//    Thread.sleep(5000);
//    WebElement item = driver.findElement(By.className("btn-primary"));
//    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
//    item.click();
//
//    WebElement result = driver.findElement(By.className("text-muted" ));
//    
//      System.out.println(result.getText());
//       assertThat(totalAmount, is("790"));
//    driver.findElement(By.linkText("OK")).click();
    
  }
}
