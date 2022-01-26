import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class testclass1 {


    WebDriver chdriver;
    WebDriverWait waitd;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        chdriver=new ChromeDriver();

        waitd=new WebDriverWait(chdriver,120);
        chdriver.manage().window().maximize();

    }

    @Test
    public void testMethod1(){

        chdriver.navigate().to("https://mohap.gov.ae/ar/home");
        WebElement eagle=chdriver.findElement(By.xpath("//div[@class='loader']"));

        waitd.until(ExpectedConditions.invisibilityOf(eagle));

        WebElement login;
        login=waitd.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//i[@class='fi-user']"))));
        login.click();

        WebElement username;
        chdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        username=chdriver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtUserName']"));
        username.sendKeys("mohammad1234");

        WebElement password;
        password=chdriver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtPassword']"));
        password.sendKeys("Asd@711711");

        WebElement logintype;
        logintype=chdriver.findElement(By.xpath("//select[@name='ctl00$MainContent$ddlLoginType']"));
        Select droplist=new Select(logintype);


        droplist.selectByIndex(1);

        WebElement loginButton;
        loginButton=chdriver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        waitd.until(ExpectedConditions.invisibilityOf(eagle));

    }

    @Test
    public void testMethod2(){

        chdriver.navigate().to("https://mohap.gov.ae/ar/home");
        WebElement eagle=chdriver.findElement(By.xpath("//div[@class='loader']"));

        waitd.until(ExpectedConditions.invisibilityOf(eagle));

        WebElement servicesPage;
        servicesPage=chdriver.findElement(By.xpath("//a[@href='ar/services']"));
        servicesPage.click();


        waitd.until(ExpectedConditions.invisibilityOf(eagle));

        WebElement GovernmentService;
        GovernmentService=chdriver.findElement(By.xpath("//i[@class='fi-government']"));
        GovernmentService.click();


        waitd.until(ExpectedConditions.invisibilityOf(eagle));

    }


    @After
    public void aftermethod(){
    chdriver.close();
    }

}
