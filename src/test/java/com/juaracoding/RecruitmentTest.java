package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import com.juaracoding.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RecruitmentTest {

    private WebDriver driver;

    private LoginPage loginPage = new LoginPage();
    private RecruitmentPage recruitmentPage = new RecruitmentPage();

    public RecruitmentTest(){
        driver = Hooks.driver;
    }

    // TCC.HRM.0004
    @Given("I am logged into OrangeHRM as an HR manager")
    public void i_am_logged_into_orangehrm_as_an_hr_manager(){
        driver.get(Constants.URL);
        loginPage.clearPassword();
        loginPage.login("Admin","admin123");
        loginPage.setBtnLogin();
    }

    @And("I navigate to the Recruitment page")
    public void i_navigate_to_the_recruitment_page(){
        DriverSingleton.delay(2);
        recruitmentPage.setMenuRecruitment();
    }

    @When("I click on the Add button in the Candidates section")
    public void i_click_on_the_add_button_in_the_candidates_section(){
        recruitmentPage.setAdd();
    }

    @And("I fill in all required candidate information with valid data")
    public void i_fill_in_all_required_candidate_information_with_valid_data(){
        recruitmentPage.setFirstName("Juara");
        recruitmentPage.setLastName("Coding");
        recruitmentPage.setEmail("admin@juaracoding.co.id");
        recruitmentPage.setResume("C:\\Users\\Lenovo\\Documents\\SampleDataUpload.docx");
    }

    @And("I click the Save button")
    public void i_click_the_save_button(){
        recruitmentPage.setSave();
    }

    @Then("I should see the new candidate listed in the Candidates section")
    public void I_should_see_the_new_candidate_listed_in_the_candidates_section(){
        Assert.assertEquals(recruitmentPage.getTxtCandidateProfile(),"Candidate Profile");
        loginPage.logout();
    }

    // #TCC.HRM.0005
    @And("I enter invalid format email")
    public void i_enter_invalid_format_email(){
        recruitmentPage.setFirstName("Juara");
        recruitmentPage.setLastName("Coding");
        recruitmentPage.setEmail("adminjuaracoding.co.id");
    }

    @Then("I should see an error message format email")
    public void i_should_see_an_error_message_format_email(){
        Assert.assertEquals(recruitmentPage.getTxtErrorFormatEmail(),"Expected format: admin@example.com");
    }

    // #TCC.HRM.0006
    @When("I looping function view details candidate")
    public void i_looping_function_view_details_candidate(){
        DriverSingleton.scroll(driver,0,300);
        recruitmentPage.setViewCandidate(5);
    }

    // #TCC.HRM.007


}
