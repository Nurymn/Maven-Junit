package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.cert.dane.DANEEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenClassWork {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //http://zero.webappsecurity.com sayfasina gidiN

        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin

        driver.findElement(By.cssSelector("i[class='icon-signin']")).click();

        //Login alanina "username" yazdirin


        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");

        // password alanina "password yazdirin


        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");

        //sign in butonuna tiklayin

       driver.findElement(By.xpath("//*[@name='submit']")).click();
       driver.navigate().back();

       //Online Banking butonuna basiniz sonra Pay Bills sayfasina gidiniz

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        //Amount kismina yatirmak istediginiz herhangi bir miktari giriniz


        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("50000");


        //Tarih kismina "2020-09-10" yazdirin

        WebElement date = driver.findElement(By.xpath("//*[@id='sp_date']"));
        date.sendKeys("2020-09-10");
        //Pay butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //"The payment was successfully submitted." mesajinin ciktiginin kontrol ediniz

        WebElement mesaj = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));

       if ( mesaj.isDisplayed()){
           System.out.println("test passed");

       }else System.out.println("test failed");


       driver.close();


    }
}
