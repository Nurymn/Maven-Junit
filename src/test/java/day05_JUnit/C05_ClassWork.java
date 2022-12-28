package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {

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
    public void test(){
        //Verilen web sayfasina gidiniz
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Checkbox1 ve checkbox2 elementlerini locate edin
       WebElement checkBox1 =  driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
       WebElement checkBox2 =   driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        //Checkbox1 secili degilse onay kutusunu tiklayin

        if (!checkBox1.isSelected()){ //eger secili degilse
            checkBox1.click();
        }

        //Checkbox2 secili degilse onay kutusunu tiklayin

        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
    }
}
