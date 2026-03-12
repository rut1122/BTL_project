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
    public void checkSearch(){

       String searchTerm="חישוב סכום דמי לידה ליום";
       HomePage homePage=new HomePage(driver);
        homePage.search(searchTerm);
        String title= homePage.getResultTitle();
        Assertions.assertTrue(title.contains(searchTerm),
            "הכותרת בדף תוצאות החיפוש אינה תואמת לחיפוש"+title);    }

}
