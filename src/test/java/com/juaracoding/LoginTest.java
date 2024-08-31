package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {

    private WebDriver driver;

    private LoginPage loginPage = new LoginPage();

    public LoginTest(){
        driver = Hooks.driver;
    }

    // #TCC.HRM.0001
    @Given("I am on the OrangeHRM login page")
    public void i_am_on_th_orangehrm_login_page(){
        driver.get(Constants.URL);
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password(){
        loginPage.login("Admin","admin123");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button(){
        loginPage.setBtnLogin();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard(){
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
    }

    // #TCC.HRM.0002
    @When("I enter an invalid username and a valid password")
    public void i_enter_an_invalid_username_and_a_valid_password(){
        loginPage.logout();
        loginPage.login("invalid","admin123");
    }

    @Then("I should see an error message for invalid credentials")
    public void i_should_see_an_error_message_for_invalid_credentials(){
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(),"Invalid credentials");
    }

    // #TCC.HRM.0003

}
