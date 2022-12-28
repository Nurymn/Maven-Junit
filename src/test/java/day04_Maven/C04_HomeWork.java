package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_HomeWork {
    public static void main(String[] args) {

        //https://www.saucedemo.com adresine gidin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.saucedemo.com");

        //Username kutusuna standard_user yazdirin

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //Password kutusuna secret_sauce yazdirin

        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        password.sendKeys("secret_sauce");

        //Login tusuna basin

        driver.findElement(By.id("login-button")).click();

        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        WebElement urunIsim = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        urunIsim.click();
        //String urunIsim1 = urunIsim.getText();

        //Add to cart butonuna basin

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //Alisveris sepetine tiklayin

        driver.findElement(By.className("shopping_cart_badge")).click();

        //Sectiginiz urunun basarili olarak sepete eklendigini kontrol edin

        WebElement sepetKontrol = driver.findElement(By.className("inventory_item_name"));
        if (sepetKontrol.isDisplayed()){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

        //Sayfayi kapatin

        driver.close();



    }
}
