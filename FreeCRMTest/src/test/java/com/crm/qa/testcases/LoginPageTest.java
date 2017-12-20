package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;
    Logger log = Logger.getLogger(LoginPageTest.class);

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority=1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
        log.info("Login page title: " + title);
        log.warn("This is a test warning");
        log.debug("This is a test debug log");
        log.fatal("This is a test fatal log");
    }

    @Test(priority=2)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority=3)
    public void loginTest(){
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
