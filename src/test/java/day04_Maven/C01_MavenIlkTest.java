package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //arama kutusunu locate edelim

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));


        //“Samsung headphones” ile arama yapalim

        aramaKutusu.sendKeys("Samsung headphones");
        aramaKutusu.submit();//enter`a bastik

        //Bulunan sonuc sayisini yazdiralim

        WebElement aramaSonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Arama Sonucu : "+aramaSonucu.getText());

        //Ilk urunu tiklayalaim

        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //Sayfadaki tum basliklari yazdiralim

        List<WebElement> sayfaBasliklariListesi = driver.findElements(By.xpath("//h1"));

        for (WebElement w:sayfaBasliklariListesi) {
            System.out.println(w.getText());

        }

        //lambda ile listi yazdiralim

        sayfaBasliklariListesi.forEach(t-> System.out.println(t.getText()));

        //sayfayi kapatalim

        driver.close();







    }
}
