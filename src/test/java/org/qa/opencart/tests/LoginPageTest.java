package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageNavigationTest(){
        loginPage = homePage.navigateToLoginPage();
        String title = loginPage.getLoginPageTitle();
        System.out.println("Title is -->"+title);
        Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
    }
}
