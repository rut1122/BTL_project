package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // השורה הזו היא הקסם שמפעיל את ה-@FindBy במחלקות היורשות
        PageFactory.initElements(driver, this);
    }
}