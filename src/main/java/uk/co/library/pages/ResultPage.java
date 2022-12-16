package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[@class='search-header__title']")
    WebElement resultText;
    public void verifyTheResults(String expected){
        Assert.assertEquals(resultText.getText(),expected);
        System.out.println(resultText.getText());
        System.out.println(expected);
    }
    public void acceptCookies(){
        acceptAlert();
    }
}
