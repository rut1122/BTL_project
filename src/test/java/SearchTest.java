import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.BtlBasePage;
import pageObject.HomePage;

public class SearchTest extends BaseTest{



@Test
    public void checkSearch() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.search("חישוב סכום דמי לידה ליום");
        Thread.sleep(5000);
        WebElement title= driver.findElement(By.xpath("//div[@id=\"mainContent\"]/div/h1"));
        String s= title.getText();
    Assertions.assertTrue(s.contains("חישוב סכום דמי לידה ליום"),
            "הכותרת בדף תוצאות החיפוש אינה תואמת לחיפוש");    }

}
