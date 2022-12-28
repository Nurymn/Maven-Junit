package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ClassWork {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //create an account butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        //radio buttons elementlerini locate edin
        WebElement cinsiyetKadin = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        WebElement cinsiyetErkek = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        WebElement cinsiyetOzel = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));
        //secili degilse cinsiyet butonundan size uygun olani secin

        if (!cinsiyetKadin.isSelected()){
            cinsiyetKadin.click();
        }

    }
}
