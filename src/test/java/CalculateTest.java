import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.CalculatorPage;
import pageObject.HomePage;
import pageObject.InsurancePage;

public class CalculateTest extends BaseTest {


    @Test
    public void calculateYeshivaStudent() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.navigate("דמי ביטוח","דמי ביטוח לאומי");

        // וידוא שהגעתי לדף הנכון
        String header = driver.findElement(By.tagName("h1")).getText();
        Assertions.assertTrue(header.contains("דמי ביטוח לאומי"), "לא הגענו לדף הנכון!");

        InsurancePage insurancePage=new InsurancePage(driver);
        insurancePage.clickCalculator(driver);
        Thread.sleep(3000); // המתנה שהמחשבון ייטען

        CalculatorPage calculatorPage=new CalculatorPage(driver);
        Thread.sleep(2000);

        //וידוא שהגעתי לצעד ראשון
        Assertions.assertTrue(calculatorPage.getLevel().contains("צעד ראשון"),
                "הטקסט הצפוי 'צעד ראשון' לא נמצא. נמצא: " + calculatorPage.getLevel());

        //מילוי השדות
        calculatorPage.clickQuestionGray();
        calculatorPage.clickGender();
        calculatorPage.fillBirthDate();

        //לחיצה על המשך
        calculatorPage.clickContinueButton();
        Thread.sleep(2000); // המתנה למעבר לצעד 2

        //בדיקה שהגעתי לצעד שני
        Assertions.assertTrue(calculatorPage.getLevel().contains("צעד שני"),calculatorPage.getLevel());
        calculatorPage.clickDisabilityPension();
        Thread.sleep(1000); // המתנה קצרה אחרי לחיצה על רדיו באטן

        //לחיצה על המשך
        calculatorPage.clickContinueButton2();
        Thread.sleep(2000); // המתנה לטעינת דף סיום

        //בדיקה שהגעתי לסיום
        Assertions.assertTrue(calculatorPage.getLevel().contains("סיום"),
                "הכותרת לא מכילה את המילה 'סיום'. הטקסט שנמצא: " + calculatorPage.getLevel());

        String amount = calculatorPage.getFinalAmount();
        Assertions.assertTrue(amount.contains("171"), "הסכום הצפוי 171 לא נמצא, נמצא: " + amount);

    }
}