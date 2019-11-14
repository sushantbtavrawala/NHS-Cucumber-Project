package Steps;

import AutomationTasks.medicalEligibilityCheck;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;


public class walesMedicalCheckEligibility {

    @Given("^I am a person from Wales$")
    public void i_am_a_person_from_wales() throws Throwable {
        medicalEligibilityCheck.navigate_To_URL();
        medicalEligibilityCheck.click_Start_Button();
        medicalEligibilityCheck.click_Wales_Radio_Button();
        medicalEligibilityCheck.click_Next_Button();
    }

    @When("^I put my circumstances into the Checker tool$")
    public void i_put_my_circumstances_into_the_checker_tool(DataTable testdata) throws Throwable {
        for(Map<String, String> data : testdata.asMaps(String.class, String.class))
        {
            medicalEligibilityCheck.enter_Dob_Day(data.get("Bday"));
            medicalEligibilityCheck.enter_Dob_Month(data.get("Bmonth"));
            medicalEligibilityCheck.enter_Dob_Year(data.get("Byear"));
            medicalEligibilityCheck.click_Next_Button();
            medicalEligibilityCheck.select_Option(data.get("Partner"));
            medicalEligibilityCheck.click_Next_Button();
            medicalEligibilityCheck.select_Option("benefits");
            medicalEligibilityCheck.click_Next_Button();
            medicalEligibilityCheck.select_Option("pregnant");
            medicalEligibilityCheck.click_Next_Button();
            medicalEligibilityCheck.select_Option("injury");
            medicalEligibilityCheck.click_Next_Button();
            medicalEligibilityCheck.select_Option("diabetes");
            medicalEligibilityCheck.click_Next_Button();
            medicalEligibilityCheck.select_Option("glaucoma");
            medicalEligibilityCheck.click_Next_Button();
            medicalEligibilityCheck.select_Option("carehome");
            medicalEligibilityCheck.click_Next_Button();
            medicalEligibilityCheck.select_Option("savings");
            medicalEligibilityCheck.click_Next_Button();
        }
    }

    @Then("^I should get a result of whether I will get help or not$")
    public void i_should_get_a_result_of_whether_i_will_get_help_or_not() throws Throwable {
            medicalEligibilityCheck.verify_ResultPage();
    }

}
