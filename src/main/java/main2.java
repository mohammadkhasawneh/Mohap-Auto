import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class main2 {

    public static void main(String[] args)  {
        WebDriverManager.firefoxdriver().setup();
        WebDriver ffdriver=new FirefoxDriver();
        WebDriverWait waitd=new WebDriverWait(ffdriver,120);
        ffdriver.manage().window().maximize();

        //ffdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       // ffdriver.get("https://mohap.gov.ae/ar/home");
        ffdriver.navigate().to("https://mohap.gov.ae/ar/home");

        WebElement eagle=ffdriver.findElement(By.xpath("//div[@class='loader']"));

        waitd.until(ExpectedConditions.invisibilityOf(eagle));

        WebElement login;
            login=waitd.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//i[@class='fi-user']"))));
            login.click();








        }






    }

