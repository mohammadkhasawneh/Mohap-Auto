import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestClass2 {


    WebDriver ffdriver;
    WebDriverWait waitd;

    @Before
    public void beforeTest() {
        WebDriverManager.firefoxdriver().setup();
        ffdriver=new FirefoxDriver();
        waitd=new WebDriverWait(ffdriver,120);
        ffdriver.manage().window().maximize();

    }

    @Test
    public void TestCase1() {
        ffdriver.get("https://mohap.gov.ae/en/");
        WebElement eagle=ffdriver.findElement(By.xpath("//div[@class='loader']"));

        waitd.until(ExpectedConditions.invisibilityOf(eagle));

        WebElement login;
        login=waitd.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//i[@class='fi-user']"))));
        login.click();

        WebElement username;
        ffdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        username=ffdriver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtUserName']"));
        username.sendKeys("mohammad1234");

        WebElement password;
        password=ffdriver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtPassword']"));
        password.sendKeys("Asd@711711");

        WebElement logintype;
        logintype=ffdriver.findElement(By.xpath("//select[@name='ctl00$MainContent$ddlLoginType']"));
        Select droplist=new Select(logintype);


        droplist.selectByIndex(1);

        WebElement loginButton;
        loginButton=ffdriver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        waitd.until(ExpectedConditions.invisibilityOf(eagle));

    }

    @Test
    public void TestCase2() {
        ffdriver.get("https://mvnrepository.com/artifact/junit/junit/4.12");

    }

    @After
    public void AfterMethod()
    {
        //ffdriver.quit();

    }

}