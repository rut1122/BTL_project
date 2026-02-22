import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public  abstract  class BaseTest {

protected WebDriver driver;


    @BeforeEach
    public void beforeEachTest() {
        // 1. הגדרת הדרייבר
        WebDriverManager.chromedriver().setup();

        // 2. הגדרת אפשרויות להאצת הטעינה (EAGER - לא מחכה לכל התמונות והסקריפטים)
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        // 3. יצירת הדרייבר פעם אחת בלבד עם האופציות
        driver = new ChromeDriver(options);

        // 4. הגדרות חלון וגלישה לאתר
        driver.manage().window().maximize();
        driver.get("https://www.btl.gov.il/Pages/default.aspx");
    }

    @AfterEach
    public void afterEachTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}