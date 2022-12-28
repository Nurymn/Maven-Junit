package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static metotlar icin calsir
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test metotlarinin hepsini ayni anda calistirip
    en son @AfterClass`i calistiririz
        Ama sadece @Before ve @After kullanirsak her test icin @before ve @after`i kullanir
     */

    @BeforeClass
    public static void setUp(){

        System.out.println("Butun testlerden once calisti");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Butun testlerden sonra calisti");
    }

    @Before
    public void setUp01(){
        System.out.println("Her testten once calisti");
    }

    @After
    public void tearDown01(){
        System.out.println("Her testten sonra calisti ");
    }

    @Test
    public void test01(){
        System.out.println("1.Test");
    }

    @Test
    public void test02(){
        System.out.println("2.Test");
    }

    @Test
    @Ignore
    public void test03(){
        System.out.println("3.Test");
    }

}
