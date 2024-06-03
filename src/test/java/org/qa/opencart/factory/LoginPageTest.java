package org.qa.opencart.factory;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.helpers.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageTitleTest() {
        loginPage = homePage.navigateToLoginPage();
        String actualText = loginPage.getPageTitle(page);
        Assert.assertEquals(actualText, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test (priority = 2)
    public void forgotPasswordExistTest() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkAvailable());
    }

    @Test (priority = 3)
    public void loginSuccessfullyTest() {
        Assert.assertTrue(loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password")));
    }
}
