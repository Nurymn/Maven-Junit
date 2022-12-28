package day06;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    WebDriver driver;
    //    Eger test sinifinda birden fazla method olusturulmussa, @Before kullanir
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void selectByIndexTest(){
//
//        1. LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
//        2. Select objesi olustur
        Select yearDropdown = new Select(year);
//        3. Select object i kullaarak 3 farkli sekilde secim yapabilirim
        yearDropdown.selectByIndex(22);//SECENEK SIRASI 0 DAN BASLAR. 2000 yili 23. sirada
//        Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
//      Ay Secimi
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropdown = new Select(ay);
        ayDropdown.selectByValue("0");//option in value degeri ile secim yapilabilir. January seceneinin value si 0
//        Gun secimi selectByVisibleTest
        WebElement gun = driver.findElement(By.id("day"));
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10");//CASE SENSITIVE -
    }
    @Test
    public void printAllTest(){

        //tum eyalet isimlerini konsola yazdir
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select stateDropDown = new Select(state);
        List<WebElement> stateList = stateDropDown.getOptions();
        for (WebElement w: stateList) {
            System.out.println(w.getText());

        }
    }

    @Test
    public void getSelectedOptionsTest(){

        //State dropdown`daki varsayilan secili secenegin select a state oldugunu
        //verify edelim
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select stateDropDown = new Select(state);
        String seciliSecenek = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",seciliSecenek);
    }

    @After
    public void tearDown(){
        driver.close();
    }







}

/*
1. What is dropdown?
liste olusturmak icin kullanilir
2/How to handle dropdown? nasil automate edilir?
-dropdown`i locate ederiz
-select objesini olustururuz
-select objesi ile istedigim secenegi secerim
NOT: Select objesi olusturma nedenim, dropdownlarin select class`i iile olusturulmasi
3. Tum dropdown secenekleri nasil print ederiz
-tum dropdown elementlerini getOptions() metodu ile listeye koyariz sonra secenekleri
loop ile yazdirabiliriz
4.Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
Ornek: Gun larak 10u sectik ama ya secilmediyse??
getFirstSelectedOption() secili olan secenegi return eder.
 */