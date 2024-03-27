import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.time.Duration;
// Mở webdriver trang
public class main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://cms.anhtester.com/login");

// Điền thông tin đăng nhập
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);

// Mở tab Product
        driver.findElement(new By.ByXPath("//span[normalize-space()='Products']")).click();
        Thread.sleep(2000);
//Mở subtab Category
        driver.findElement(new By.ByXPath("//span[normalize-space()='Category']")).click();
        Thread.sleep(2000);

//Thêm mới category
        driver.findElement(new By.ByXPath("//span[normalize-space()='Add New category']")).click();
        Thread.sleep(2000);

        driver.findElement(new By.ByXPath("//input[@id='name']")).sendKeys("Adidas");
        Thread.sleep(2000);

        driver.findElement(new By.ByXPath("//div[contains(text(),'Sport Shoes')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("bs-select-1-0")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("order_level")).sendKeys("7");
        Thread.sleep(2000);
        
        driver.findElement(new By.ByXPath("//button[@title='Physical']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("bs-select-2-1")).click();
        Thread.sleep(2000);
        
        driver.findElement(new By.ByXPath("//div[5]//div[1]//div[1]//div[2]")).click();
        driver.findElement(new By.ByXPath("//div[@class='aiz-uploader-all clearfix c-scrollbar-light']//div[2]//div[1]//div[1]//div[1]//img[1]")).click();
        driver.findElement(new By.ByXPath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(2000);
        
        driver.findElement(new By.ByXPath("//div[6]//div[1]//div[1]//div[2]")).click();
        driver.findElement(new By.ByXPath("//div[10]//div[1]//div[1]//div[1]//img[1]")).click();
        driver.findElement(new By.ByXPath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.name("meta_title")).sendKeys("Shoes");
        Thread.sleep(2000);
        
        driver.findElement(By.name("meta_description")).sendKeys("easy to wear");
        Thread.sleep(2000);
        
        driver.findElement(new By.ByXPath("//button[@title='Nothing selected']")).click();
        Thread.sleep(2000);
        
        driver.findElement(new By.ByXPath("//a[@id='bs-select-3-0']")).click();
        Thread.sleep(2000);
        
        driver.findElement(new By.ByXPath("//button[normalize-space()='Save']")).click();
        Thread.sleep(2000);
        
 // Search category vừa tạo
        WebElement src_category = driver.findElement(By.id("search"));
        src_category.sendKeys("Adidas");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.RETURN);
        action.perform();
        Thread.sleep(2000);
        WebElement searchresult = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[2]"));
        Assert.assertTrue(searchresult.getText().contains("Adidas"));
    }
}
