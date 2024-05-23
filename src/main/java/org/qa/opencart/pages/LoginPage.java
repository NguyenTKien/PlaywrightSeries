package org.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private Page page;
    //Locators
    private String emailId = "//input[@id='input-email']";
    private String password = "//input[@id='input-password']";
    private String forgotPasswordLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String loginButton = "//input[@value='Login']";
    private String logoutLink = "#column-right > div > a:text('Logout')";

    //Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    //Page actions/ methods
    public boolean isForgotPasswordLinkAvailable() {
        return page.isVisible(forgotPasswordLink);
    }

    public boolean doLogin(String appUsername, String appPassword) {
        System.out.println("App creds: " + appUsername+ " " + appPassword);
        page.fill(emailId, appUsername);
        page.fill(password, appPassword);
        page.click(loginButton);
        if (page.isVisible(logoutLink)) {
            System.out.println("user is login successfully");
            return true;
        }
        return false;
    }
}
