import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) {


        WebDriverManager.firefoxdriver().setup();
        WebDriver ffdriver=new FirefoxDriver();
        WebDriverWait waitd=new WebDriverWait(ffdriver,120);
        ffdriver.manage().window().maximize();

        //ffdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        ffdriver.get("https://www.wikipedia.org/");
        WebElement aboutus;
        aboutus=waitd.until(ExpectedConditions.elementToBeClickable(ffdriver.findElement(By.xpath("/html/body/div[2]/div[1]/a/strong"))));



       // aboutus=ffdriver.findElement(By.id("dropdown8150"));


        aboutus.click();

        //waitd.until(ExpectedConditions.visibilityOfAllElements());
        WebElement loginButton;

        loginButton=waitd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fi-user']")));
        loginButton.click();
       waitd.until(ExpectedConditions.visibilityOfAllElements(ffdriver.findElement(By.xpath("//i[@class='fi-user']"))));

       // waitd.until(ExpectedConditions.elementToBeClickable(ffdriver.findElement(By.xpath("//i[@class='fi-user']"))));



        //waitd.until(ffdriver.findElement(By.xpath("//i[@class='fi-user']")));

//        WebElement username;
//        ffdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        username=ffdriver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtUserName']"));
//        username.sendKeys("mohammad1234");
//
//        WebElement password;
//        password=ffdriver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtPassword']"));
//        password.sendKeys("Asd@711711");
//
//        WebElement list;
//        list=ffdriver.findElement(By.xpath("//option[@value='2']"));
//        list.click();
//
//
//        WebElement signin;
//        signin=ffdriver.findElement(By.xpath("//input[@type='submit']"));
//        waitd.until(ExpectedConditions.visibilityOf(signin));
//
//        signin.click();










    }
}
