package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@id='keywords']")
    WebElement jobTitle;
    @CacheLookup
    @FindBy(xpath = "//input[@id='keywords']")
    List<WebElement> jobTitleList;
    @CacheLookup
    @FindBy(xpath = "//input[@id='location']")
    WebElement location;
    @CacheLookup
    @FindBy(xpath = "//select[@class='hp-distance form__select']")
    WebElement distanceDropDown;
    @CacheLookup
    @FindBy(xpath = "//button[@type='button']/span[text()='More Search Options']")
    WebElement moreSearchOptionsLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;
    @CacheLookup
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;
    @CacheLookup
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;
    @CacheLookup
    @FindBy(xpath = "//input[@id='hp-search-btn']")
    WebElement findJobsBtn;

    public void enterJobTitle(String jobTitles) throws InterruptedException{
        Reporter.log("Enter Job Title" + jobTitles + "to field" + jobTitle);
        sendTextToElement(jobTitle, jobTitles);
        Thread.sleep(500);
        jobTitleList.get(1).click();
        CustomListeners.test.log(Status.PASS, "Enter Password " + jobTitles);
    }

    public void enterLocation(String locations) {
        Reporter.log("Enter location" + locations + "to field" + location);
        sendTextToElement(location, locations);
        CustomListeners.test.log(Status.PASS, "Enter location " + locations);
    }

    public void selectDistance(String distances) throws InterruptedException {
    Reporter.log("select "+distances+"from"+distanceDropDown);
    mouseHoverToElementAndClick(distanceDropDown);
    selectByVisibleTextFromDropDown(distanceDropDown,distances);
    Thread.sleep(1000);
    CustomListeners.test.log(Status.PASS,"Select "+distances+"from dropdown");
    }

    public void clickOnMoreSearchOptionLink() {
        Reporter.log("Clicking on more search options " + moreSearchOptionsLink.toString());
        mouseHoverToElementAndClick(moreSearchOptionsLink);
        CustomListeners.test.log(Status.PASS, "Click on more search options");
    }

    public void enterMinSalary(String minSalarys) {
        Reporter.log("Enter minimum salary" + minSalarys + "to field" + location);
        sendTextToElement(salaryMin, minSalarys);
        CustomListeners.test.log(Status.PASS, "Enter minimum salary " + minSalarys);
    }

    public void enterMaxSalary(String maxSalarys) {
        Reporter.log("Enter maximum salary" + maxSalarys + "to field" + location);
        sendTextToElement(salaryMax, maxSalarys);
        CustomListeners.test.log(Status.PASS, "Enter maximum salary " + maxSalarys);
    }

    public void selectSalaryType(String sTypes) {
        Reporter.log("select "+sTypes+"from"+salaryTypeDropDown);
        selectByVisibleTextFromDropDown(salaryTypeDropDown,sTypes);
        CustomListeners.test.log(Status.PASS,"Select "+sTypes+"from dropdown");
    }

    public void selectJobType(String jobTypes) {
        Reporter.log("select "+jobTypes+"from"+jobTypeDropDown);
        selectByVisibleTextFromDropDown(jobTypeDropDown,jobTypes);
        CustomListeners.test.log(Status.PASS,"Select "+jobTypes+"from dropdown");
    }

    public void clickOnFindJobsButton() {
        Reporter.log("Clicking on find jobs button " + findJobsBtn.toString());
        clickOnElement(findJobsBtn);
        CustomListeners.test.log(Status.PASS, "Click on find jobs button");
    }
    public void acceptCookies(){
        driver.switchTo().frame("gdpr-consent-notice");
        acceptAlert();
    }
}
