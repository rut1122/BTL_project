package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsurancePage extends BasePage {
    public InsurancePage(WebDriver driver) {
        super(driver);
    }

    //אלמנט כפתור המחשבון
    @FindBy(xpath = "//a[contains(., \"מחשבון לחישוב דמי הביטוח\")]")
    WebElement calculator;

    public void clickCalculator(WebDriver driver) {

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", calculator);
    }
}
