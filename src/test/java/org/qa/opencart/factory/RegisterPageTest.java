package org.qa.opencart.factory;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.helpers.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    @Test (priority = 1)
    public void registerPageTitleTest() {
        registerPage = homePage.navigateToRegisterPage();
        String actualTitle = registerPage.getPageTitle(page);

        Assert.assertEquals(actualTitle, AppConstants.REGISTER_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void doRegister() {

        String email = registerPage.getRandomEmail();
        String phoneNumber = registerPage.getRandomPhoneNumber();
        System.out.println("Email: " + email + " Phone Number:" + phoneNumber);
        Assert.assertTrue(registerPage.registerAccount(AppConstants.FIRST_NAME, AppConstants.LAST_NAME,
                email, phoneNumber, prop.getProperty("password"), AppConstants.REGISTER_ACCOUNT_SUCCESSFULLY));
    }

}