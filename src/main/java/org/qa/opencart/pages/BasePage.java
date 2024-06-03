package org.qa.opencart.pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {
    //Locator
    private String featureCategory = "a.list-group-item";
    public String getPageTitle(Page page) {
        return page.title();
    }

    public String getPageURL(Page page) {
        return page.url();
    }

    public String getRandomEmail() {
        String email = "testingAutomation" + System.currentTimeMillis() + "@gmail.com";
        return email;
    }

    public String getRandomPhoneNumber() {
        double phoneNumber_D = Math.floor(100000000 + Math.random() * 900000000);
        String phoneNumber = String.format("%.0f", phoneNumber_D);
        return phoneNumber;
    }
}