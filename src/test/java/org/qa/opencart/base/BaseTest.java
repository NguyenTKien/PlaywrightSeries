package org.qa.opencart.base;

import com.microsoft.playwright.Page;
import org.qa.opencart.pages.HomePage;
import org.qa.opencart.pages.LoginPage;
import org.qa.opencart.factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected Properties prop;

    @BeforeTest
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.initProperties();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
