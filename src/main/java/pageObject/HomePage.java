package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BtlBasePage{
    @FindBy(id = "ctl00_PlaceHolderMain_ToolBarControl_Repeater1_ctl01_a")
    WebElement calculatorsLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void openCalculatorPage(){calculatorsLink.click();}
}
