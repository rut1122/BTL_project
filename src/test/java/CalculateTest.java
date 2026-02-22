import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObject.CalculatorPage;
import pageObject.HomePage;
import pageObject.InsurancePage;

public class CalculateTest extends BaseTest {


    @Test
    public void calculateYeshivaStudent() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.navigate("דמי ביטוח","דמי ביטוח לאומי");
        //וידוא שעלה הדף הנכון- לעשות!!!!!
       InsurancePage insurancePage=new InsurancePage(driver);
        insurancePage.clickCalculator(driver);
        Thread.sleep(5000);

        CalculatorPage calculatorPage=new CalculatorPage(driver);
        Thread.sleep(2000);
        //וידוא שהגעתי לצעד ראשון
        Assertions.assertTrue(calculatorPage.getLevel().contains("צעד ראשון"),
                "הטקסט הצפוי 'צעד ראשון' לא נמצא. נמצא: " + calculatorPage.getLevel());        //מילוי השדות
        calculatorPage.clickQuestionGray();
        calculatorPage.clickGender();
        calculatorPage.fillBirthDate();
        //לחיצה על המשך
        calculatorPage.clickContinueButton();
        Thread.sleep(2000);
        //בדיקה שהגעתי לצעד שני
        Assertions.assertTrue(calculatorPage.getLevel().contains("צעד שני"),calculatorPage.getLevel());
        calculatorPage.clickDisabilityPension();
        //לחיצה על המשך
        calculatorPage.clickContinueButton2();
        Thread.sleep(2000);
        //בדיקה שהגעתי לסיום
        Assertions.assertTrue(calculatorPage.getLevel().contains("סיום"),
                "הכותרת לא מכילה את המילה 'סיום'. הטקסט שנמצא: " + calculatorPage.getLevel());       Assertions.assertEquals("171",calculatorPage.getFinalAmount());







    }
}
