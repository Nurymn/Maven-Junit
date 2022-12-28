package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C03_HomeWork {

    public static void main(String[] args) {

        //https://www.google.com/ adresine gidiniz

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com/ ");

        //cookies uyarisini kabul ederek kapatin
        //==>boyle bir uyari almadim


        //Sayfa basliginin google ifadesi icerdigini test edin

        String title = driver.getTitle();
        if (title.equals("Google")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

        //Arama cubuguna Nutella yazip aratin

        WebElement aramaCubugu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaCubugu.sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin

        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']"));

        System.out.println(sonucSayisi.getText());


        //Sonuc sayisininn 10 milyondan fazla oldugunu test edin

        String[] arr  = sonucSayisi.getText().split(" ");

        String r1 = arr[1].replace(".","");

        int result = Integer.parseInt(r1);


        if (result>10000000){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");


        driver.close();




    }

}
