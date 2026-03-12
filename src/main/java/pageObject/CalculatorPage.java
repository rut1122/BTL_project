package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalculatorPage extends BtlBasePage {

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    // עזר פנימי לביצוע לחיצה בטוחה דרך JS
    private void jsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    //שדה סוג האיש
    @FindBy(xpath = "//input[contains(@id, 'rdb_employeType_2')]")
    WebElement questionGray;
    public void clickQuestionGray() {
        jsClick(questionGray);
    }

    //שדה מין
    @FindBy(xpath = "//input[contains(@id, 'rdb_Gender_0')]")
    WebElement gender;
    public void clickGender() {
        jsClick(gender);
    }

    //שדה תאריך לידה
    @FindBy(id = "ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_DynDatePicker_BirthDate_Date")
    WebElement birthDate;
    public void fillBirthDate() {
        wait.until(ExpectedConditions.visibilityOf(birthDate));
        int randomYear = 1970 + (int) (Math.random() * 30); // יגריל שנה בין 1970 ל-2000
        String date = "01/01/" + randomYear;
        birthDate.sendKeys(date);
    }

    //1כפתור המשך
    @FindBy(xpath = "//input[contains(@id, 'StartNextButton')]")
    WebElement continueButton;
    public void clickContinueButton() {
        jsClick(continueButton);
    }

    //2כפתור המשך
    @FindBy(xpath = "//input[contains(@id, 'StepNextButton')]")
    WebElement continueButton2;
    public void clickContinueButton2() {
        jsClick(continueButton2);
    }

    //האם מקבל קצבת נכות
    @FindBy(xpath = "//input[contains(@id, 'rdb_GetNechut_1')]")
    WebElement getDisabilityPension;
    public void clickDisabilityPension() throws InterruptedException {
        Thread.sleep(1500);
        By disabilityBy = By.xpath("//input[contains(@id, 'rdb_GetNechut_1')]");
        wait.until(ExpectedConditions.elementToBeClickable(disabilityBy));

        WebElement disabilityBtn = driver.findElement(disabilityBy);
        // גלילה למרכז המסך כדי למנוע חסימה של אלמנטים אחרים
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", disabilityBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", disabilityBtn);

        Thread.sleep(1000);
    }

    //אלמנט צעד נוכחי
    @FindBy(xpath = "//h2[@id=\"header\"]")
    WebElement level;

    //מחזיר את הצעד הנוכחי
    public String getLevel() {
        wait.until(ExpectedConditions.visibilityOf(level));
        return level.getText().trim();
    }

    //אלמנט של התוצאה הסופית
    @FindBy(xpath = "//li[contains(text(), 'סך הכל')]//strong")
    private WebElement finalAmount;

    // מתודה להוצאת הסכום כטקסט
    public String getFinalAmount() {
        wait.until(ExpectedConditions.visibilityOf(finalAmount));
        System.out.println(finalAmount.getText().trim());
        return finalAmount.getText().trim();
    }
}