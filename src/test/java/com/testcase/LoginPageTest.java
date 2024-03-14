package com.testcase;

import bs_baseclass.Baseclass;
import bs_pages.Login_page;
import bs_utility.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listenser.ListenserAction.class)

public class LoginPageTest extends Baseclass {
    Login_page loginPage;
    Utility utility;
    public String sheetName = "Sheet1";

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialisation();
        loginPage = new Login_page();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("User login Test")
    @Feature("Login: 1")

    public void loginPage() {
        String title = loginPage.validateinPageOfTitle();
        Assert.assertEquals(title, "Online Bookstore | Buy Books Online | Read Books Online");
    }

    @Test(priority = 2)
    public void LoginTest() throws InterruptedException {
        loginPage.login(properties.getProperty("mobileNumber"), properties.getProperty("password"));

    }

    //    @AfterMethod
//    public void tearDown()
//{
//    driver.quit();
//}
    @DataProvider
    public Object[][] getLoginTestData() {
        Object data[][] = utility.getTestData(sheetName);
        return data;
    }

    @Test(dataProvider = "getLoginTestData", priority = 3)
    public void multipleLoginTest(String mobileOrEmail, String password) throws InterruptedException {
        Login_page.multipleLogin(mobileOrEmail, password);

    }

}
