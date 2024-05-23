package org.qa.opencart.pages;


import com.microsoft.playwright.Page;

public class HomePage extends BasePage{
    private Page page;
    //Locators String
    private String searchField = "input[name=search]";
    private String searchIcon = "#search > span > button";
    private String textSearch = "#content > h1";
    private String loginLink = "a:text('Login')";
    private String registerLink = "a:text('Register')";
    private String myAccountLink = "#top-links > ul > li > a[title='My Account']";

    //Constructor
    public HomePage (Page page) {
        this.page = page;
    }

    //Page actions/ methods
    public String doSearch(String productName) {
        page.fill(searchField, productName);
        page.click(searchIcon);
        return page.textContent(textSearch);
    }

    public LoginPage navigateToLoginPage() {
        page.click(myAccountLink);
        page.click(loginLink);
        return new LoginPage(page);
    }

    public RegisterPage navigateToRegisterPage() {
        page.click(myAccountLink);
        page.click(registerLink);
        return new RegisterPage(page);
    }
}