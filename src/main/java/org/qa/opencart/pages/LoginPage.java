package org.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    //String Locators - OR
    private String emailId = "//input[@id='input-email']";
    private String password = "//input[@id='input-password']";
    private String loginBtn = "//input[@value='Login']";
    private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String logoutLink = "";

    public LoginPage(Page page){
        this.page = page;
    }

    public String getLoginPageTitle(){
        return page.title();
    }

    public boolean isForgotPwdLinkExist(){
        return page.isVisible(forgotPwdLink);
    }

    public void doLogin(String appUserName, String appPassword){
        System.out.println("App creds: "+ appUserName + " : " + appPassword);
        page.fill(emailId,appUserName);
        page.fill(password,appPassword);
        page.click(loginBtn);
    }
}
