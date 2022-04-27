package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    @Before
    public void openBowserLoginTest(){
        openBrowser("https://www.saucedemo.com/");
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");
        clickOnElement(By.id("login-button"));
        verifyText("","PRODUCTS",By.xpath("//span[contains(text(),'Products')]"));
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");
        clickOnElement(By.id("login-button"));


        int expectedResult= 6;

        List <WebElement> actualResultElement= driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualResult= actualResultElement.size();

        Assert.assertEquals(expectedResult,actualResult);
    }
    @After
    public void closeBrowserLogin(){
        closeBrowser();
    }

}
