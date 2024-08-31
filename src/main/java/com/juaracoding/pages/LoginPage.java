package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    //p[contains(@class,'userdropdown')]
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement btnLogout;

    //h6[contains(@class,'topbar-header-breadcrumb')]
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement txtDashboard;

    //p[contains(@class,'alert-content-text')]
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement txtInvalidCredentials;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void setBtnLogin(){
        btnLogin.click();
    }

    public void clearPassword(){
        password.sendKeys(Keys.CONTROL+"A");
        password.sendKeys(Keys.DELETE);
    }

    public void logout(){
        userDropdown.click();
        btnLogout.click();
    }

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public String getTxtInvalidCredentials(){
        return txtInvalidCredentials.getText();
    }

}
