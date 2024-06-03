package org.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class RegisterPage extends BasePage {
    private Page page;
    //Locator
    private String firstNameField = "#input-firstname";
    private String lastNameField = "#input-lastname";
    private String emailField = "#input-email";
    private String telephoneNumber = "#input-telephone";
    private String passwordField = "#input-password";
    private String confirmPasswordField = "#input-confirm";
    private String policyCheckbox = "input[name=agree]";
    private String submitButton = "input[type=submit]";
    private String createSuccessTitle = "#content > h1";

    //Constructor
    public RegisterPage(Page page) {
        this.page = page;
    }

    //Page action - methods
    public boolean registerAccount(String firstName, String lastName, String email,
                                String telephone, String password, String successText) {
        page.fill(firstNameField, firstName);
        page.fill(lastNameField, lastName);
        page.fill(emailField, email);
        page.fill(telephoneNumber, telephone);
        page.fill(passwordField, password);
        page.fill(confirmPasswordField, password);
        page.check(policyCheckbox);
        page.click(submitButton);

        if(page.textContent(createSuccessTitle).equals(successText)) {
            System.out.println(successText);
            return true;
        }
        return false;

    }

}