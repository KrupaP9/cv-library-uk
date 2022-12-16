package uk.co.library.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.BaseTest;
@Listeners(CustomListeners.class)
public class JobSearchTest extends BaseTest {
    HomePage homePage;
    ResultPage resultPage;


    @BeforeMethod(alwaysRun = true)
    public void InIt(){
        homePage = new HomePage();
        resultPage = new ResultPage();
    }
    @Test
    public void test(){}
    @Test(dataProvider = "criteria", dataProviderClass = TestData.class, groups = {"sanity","regression"})
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType,
                                                           String result) throws InterruptedException{

        // enter job title 'jobTitle'
        homePage.enterJobTitle(jobTitle);
        //    enter Location 'location'
        homePage.enterLocation(location);
        //    select distance 'distance'
        homePage.selectDistance(distance);
        //	click on moreSearchOptionsLink
        homePage.clickOnMoreSearchOptionLink();
        //    enter salaryMin 'salaryMin'
        Thread.sleep(1000);
        homePage.enterMinSalary(salaryMin);
        //    enter salaryMax 'salaryMax'
        homePage.enterMaxSalary(salaryMax);
        //	select salaryType 'salaryType'
        homePage.selectSalaryType(salaryType);
        //	select jobType 'jobType'
        Thread.sleep(1000);
        homePage.selectJobType(jobType);
        //	click on 'Find Jobs' button
        homePage.clickOnFindJobsButton();
        //	verify the result 'result'
        resultPage.verifyTheResults(result);
    }

}
