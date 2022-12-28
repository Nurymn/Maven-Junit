package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownReusable {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    //REUSABLE METHOD : Dropdown icin tekrar tekrar kullanabilecegimiz bir metot olusturalim

    public void selectFromDropDown(WebElement dropdown,String secenek){
        //  selectFromDropDown(driver.findElement(By.xpath("//select[@id='year']")),"2005); gibi
        //Gonderilen dropdown elementlerinin tum optionslari alinir
        List<WebElement> options = dropdown.findElements(By.tagName("option")); //tum options tag`li elementleri aliriz
        for (WebElement w: options) {
            if (w.getText().equals(secenek)){
                w.click();
                break;
            }

        }

    }

    @Test
    public void selectFromDropDown(){
        selectFromDropDown(driver.findElement(By.xpath("//select[@id='year']")),"2005");
    }



}
