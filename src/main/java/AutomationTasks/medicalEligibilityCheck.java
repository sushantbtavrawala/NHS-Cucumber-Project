package AutomationTasks;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverInitiate;

public class medicalEligibilityCheck extends DriverInitiate {


    public static String url = "https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start";


    public static By start_Button=By.id("next-button");
    public static By next_Button=By.id("next-button");

    //Country Selection locator
    public static By wales_Button=By.id("label-wales");

    //birthdate locator
    public static By dob_Day=By.id("dob-day");
    public static By dob_Month=By.id("dob-month");
    public static By dob_Year=By.id("dob-year");

    //selction option for partner

    public static By yes_Radio_Button=By.id("label-yes");
    public static By no_Radio_Button=By.id("label-no");

    //Final page confirmation
    public static String expected_Page_Title="You get help with health costs";

    //Common button locators
    public static void navigate_To_URL()
    {
        driver.get(url);
    }
    public static void click_Start_Button()
    {
        find(start_Button).click();
    }
    public static void click_Next_Button()
    {
        find(next_Button).click();
    }

    //Country selection page
    public static void click_Wales_Radio_Button()
    {
       find(wales_Button).click();
    }

    //Date of Birth Page
    public static void enter_Dob_Day(String day)
    {
        find(dob_Day).sendKeys(day);
    }
    public static void enter_Dob_Month(String month)
    {
        find(dob_Month).sendKeys(month);
    }
    public static void enter_Dob_Year(String year)
    {
        find(dob_Year).sendKeys(year);
    }

    //selection button
    public static void select_Option(String option)
    {
        WebDriverWait wait = new WebDriverWait(driver, 50);//Wait Function Use
        WebElement wait2 = wait.until(ExpectedConditions.elementToBeClickable(next_Button));

        if(option.equalsIgnoreCase("yes"))
        {find(yes_Radio_Button).click();}
        else{
            find(no_Radio_Button).click();
        }
    }

    public static void verify_ResultPage()
    {
        Assert.assertEquals(driver.getTitle(),expected_Page_Title);
    }

}
