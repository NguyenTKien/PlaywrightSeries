package org.qa.opencart.base;

import com.microsoft.playwright.Page;
import org.qa.opencart.pages.HomePage;
import org.qa.opencart.pages.LoginPage;
import org.qa.opencart.factory.PlaywrightFactory;
import org.qa.opencart.pages.RegisterPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    protected Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected Properties prop;

    @Parameters({ "browser"})
    @BeforeTest
    public void setup(String browserName) {
        pf = new PlaywrightFactory();

        prop = pf.initProperties();
        if (browserName != null) {
            prop.setProperty("browser", browserName);
        }

        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}