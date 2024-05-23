package org.qa.opencart.pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {
    public String getPageTitle(Page page) {
        return page.title();
    }

    public String getPageURL(Page page) {
        return page.url();
    }
}
