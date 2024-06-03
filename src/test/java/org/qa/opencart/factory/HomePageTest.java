package org.qa.opencart.factory;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.helpers.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTitleTest() {
        String actualTitle = homePage.getPageTitle(page);
        Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void homePageURLTest() {
        String actualURL = homePage.getPageURL(page);
        Assert.assertEquals(actualURL, prop.getProperty("url"));
    }

    @DataProvider
    public Object[][] getProductData() {
        return new Object[][] {
            {"Macbook"},
            {"iPad"},
            {"iPhone"}
        };
    }

    @Test (dataProvider = "getProductData")
    public void searchTest(String productName) {
        String actualSearchText = homePage.doSearch(productName);
        Assert.assertEquals(actualSearchText, "Search - "+ productName);
    }

}