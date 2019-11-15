package AutomationTasks;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CaptureScreenshot;
import utils.DriverInitiate;

import java.io.IOException;

public class medicalEligibilityCheck extends DriverInitiate {


    private static String url = "https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start";

    private static By start_Button = By.id("next-button");
    private static By next_Button = By.id("next-button");

    //Country Selection locator
    private static By wales_Button = By.id("label-wales");

    //birthdate locator
    private static By dob_Day = By.id("dob-day");
    private static By dob_Month = By.id("dob-month");
    private static By dob_Year = By.id("dob-year");

    //selction option for partner
    private static By yes_Radio_Button = By.id("label-yes");
    private static By no_Radio_Button = By.id("label-no");

    //Final page confirmation
    private static String expected_Page_Title = "You get help with health costs";

    //Common button locators
    public static void navigate_To_URL() throws IOException {
        driver.get(url);
        CaptureScreenshot.Screenshot(driver,"Screenshot:");
    }

    public static void click_Start_Button() {
        find(start_Button).click();
    }
    public static void click_Next_Button() {
        find(next_Button).click();
    }

    //Country selection page
    public static void click_Wales_Radio_Button() throws IOException {
        find(wales_Button).click();
        CaptureScreenshot.Screenshot(driver,"Screenshot:");
    }

    //Date of Birth Page
    public static void enter_Dob_Day(String day) {
        find(dob_Day).sendKeys(day);
    }
    public static void enter_Dob_Month(String month) {
        find(dob_Month).sendKeys(month);
    }
    public static void enter_Dob_Year(String year) {
        find(dob_Year).sendKeys(year);
    }

    //selection button
    public static void select_Option(String option) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 50);//Wait Function Use
        WebElement wait2 = wait.until(ExpectedConditions.elementToBeClickable(next_Button));

        if (option.equalsIgnoreCase("yes")) {
            find(yes_Radio_Button).click();
        } else {
            find(no_Radio_Button).click();
        }
        CaptureScreenshot.Screenshot(driver,"screenShot");
    }

    public static void verify_ResultPage() throws IOException {
         Assert.assertEquals(driver.getTitle(), expected_Page_Title);
         CaptureScreenshot.Screenshot(driver,"screenShot");
    }
}
