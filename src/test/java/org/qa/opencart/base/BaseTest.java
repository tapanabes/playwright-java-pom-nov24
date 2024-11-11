package org.qa.opencart.base;

import com.microsoft.playwright.Page;
import org.qa.opencart.factory.PlaywrightFactory;
import org.qa.opencart.pages.HomePage;
import org.qa.opencart.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    Properties prop;
    protected HomePage homePage;
    protected LoginPage loginPage;
    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browserName) throws FileNotFoundException {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        if(browserName!=null){
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
