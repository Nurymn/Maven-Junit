package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertion {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @After
    public void tearDown(){
        driver.close();
    }

    //https://amazon.com adresine gidin
    //Asagidaki adlari kullanarak uc test metodu olusturun ve gerekli testleri yapin.
    //-Sayfa basliginin Amazon old test edin
    //-amazon resminin goruntulendigini (isDisplayed()) test edin
    //-Search Box`in erisilebiilir old (isEnable()) test edin
    //sayfa basliginin amazon olmadigini dogrula

    @Test
    public void test01(){
       String actualTitle =  driver.getTitle();
       String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void test02(){
       WebElement amazonResim =  driver.findElement(By.id("nav-logo-sprites"));
       Assert.assertTrue(amazonResim.isDisplayed());
    }

    @Test
    public void test03(){
      WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
      Assert.assertTrue(searchBox.isDisplayed());
    }

    @Test
    public void test04(){
        String gercekBaslik = driver.getTitle();
        String beklenenBaslik = "amazon";
        Assert.assertFalse(gercekBaslik.contains(beklenenBaslik));

    }


}
