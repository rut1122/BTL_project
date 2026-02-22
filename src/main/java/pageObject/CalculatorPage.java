package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;

public class CalculatorPage extends BtlBasePage{
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }
    //שדה סוג האיש
@FindBy(xpath = "//input[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_employeType_2\"]")
    WebElement questionGray;
    public void clickQuestionGray(){
        questionGray.click();
    }
//שדה מין
@FindBy(xpath = "//input[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_Gender_0\"]")
        WebElement gender;
    public  void clickGender(){
        gender.click();
    }
            //שדה תאריך לידה
            @FindBy(id = "ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_DynDatePicker_BirthDate_Date")    WebElement birthDate;
    public void fillBirthDate(){
        int randomYear = 1970 + (int)(Math.random() * 30); // יגריל שנה בין 1970 ל-2000
        String date = "01/01/" + randomYear;
        birthDate.sendKeys(date);
    }
    //1כפתור המשך
    @FindBy(xpath = "//input[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StartNavigationTemplateContainerID_StartNextButton\"]")
    WebElement continueButton;
    public void clickContinueButton(){
        continueButton.click();
    }

    //2כפתור המשך
    @FindBy(xpath = "//input[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StepNavigationTemplateContainerID_StepNextButton\"]")
    WebElement continueButton2;
    public void clickContinueButton2(){
        continueButton2.click();
    }
//האם מקבל קצבת נכות
@FindBy(xpath = "//input[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_GetNechut_1\"]")    WebElement getDisabilityPension;

    public void clickDisabilityPension(){
        getDisabilityPension.click();
    }

   //אלמנט צעד נוכחי
    @FindBy(xpath = "//h2[@id=\"header\"]")
    WebElement level;
;   //מחזיר את הצעד הנוכחי
    public String getLevel(){
        String s=level.getText().trim();
        return s;
    }

    //אלמנט של התוצאה הסופית
    @FindBy(xpath = "//li[contains(text(), 'סך הכל')]//strong")
    private WebElement finalAmount;

    // מתודה להוצאת הסכום כטקסט
    public String getFinalAmount() {
        System.out.println(finalAmount.getText().trim());
        return finalAmount.getText().trim();
    }
}
