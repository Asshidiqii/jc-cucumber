package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RecruitmentPage {

    private WebDriver driver;

    public RecruitmentPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement menuRecruitment;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")
    private WebElement email;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resume;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSave;

    @FindBy(xpath = "//h6[normalize-space()='Candidate Profile']")
    private WebElement txtCandidateProfile;

    @FindBy(xpath = "")
    private WebElement txtFirstNameFromListCandidate;

    @FindBy(xpath = "//span[contains(@class,'input-field-error-message')]")
    private WebElement txtErrorFormatEmail;

    @FindBy(xpath = "//i[@class='oxd-icon bi-eye-fill']")
    private List<WebElement> viewCandidate;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div")
    private WebElement listStatus;

    public void setMenuRecruitment(){
        menuRecruitment.click();
    }

    public void setAdd(){
        btnAdd.click();
    }

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email){
        this.email.sendKeys(email);
    }

    public void setResume(String resume){
        this.resume.sendKeys(resume);
    }

    public void setSave(){
        btnSave.click();
    }

    public void setViewCandidate(int num){
        for (int i = 1; i <= num; i++) {
            driver.findElement(By.xpath("(//i[@class='oxd-icon bi-eye-fill'])["+i+"]")).click();
            DriverSingleton.delay(2);
            driver.navigate().back();
            DriverSingleton.delay(2);
        }
        System.out.println(viewCandidate.size());
        for (int i = 3; i <= 5; i++) {
            System.out.println(driver.findElement(By.xpath("//div[@role='rowgroup']//div[1]//div[1]//div["+i+"]//div[1]")).getText());
        }
    }

    public void setListStatus(){
        listStatus.click();
    }

    public String getTxtCandidateProfile(){
        return txtCandidateProfile.getText();
    }

    public String getTxtFirstNameFromListCandidate(){
        return txtFirstNameFromListCandidate.getText();
    }

    public String getTxtErrorFormatEmail(){
        return txtErrorFormatEmail.getText();
    }

}
