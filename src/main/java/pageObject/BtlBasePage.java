package pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BtlBasePage extends BasePage{

    public BtlBasePage(WebDriver driver) {
        super(driver);
    }

    //אלמנט כפתור החיפוש
    @FindBy(xpath = "//*[@id='ctl00_SiteHeader_reserve_btnSearch']")
   private WebElement serchButton;
    //אלמנט אימנפוט החיפוש
    @FindBy(id="TopQuestions")
    WebElement searchInput;
    //אלמנט התפריט
    @FindBy(xpath = "//div[@class=\"megamenu_wrapper megamenu_light_theme\"]")
    private WebElement menu;
//אלמנט כותרת הדף
    @FindBy(xpath = "//*[@id='results']//h2")
    WebElement resultTitle;

public void navigate(String mainMenuText,String subMenuText){
    driver.findElement(By.xpath("//a[contains(text(),'"+mainMenuText+"')]")).click();
    driver.findElement(By.xpath("//a[contains(text(),'"+subMenuText+"')]")).click();

}
    public  void search(String textToSearch){
        searchInput.sendKeys(textToSearch);
        serchButton.click();
        Assertions.assertEquals(textToSearch,resultTitle.getText());
            }


}

