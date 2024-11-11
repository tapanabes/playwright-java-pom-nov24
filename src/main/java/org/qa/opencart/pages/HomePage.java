package org.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    private String search = "input[name='search']";
    private String searchIcon = "div#search button.btn";
    private String searchPageHeader = "div#content h1";
    private String loginLink = "a:text('Login')";
    private String myAccountLink = "a[title='My Account']";

    public HomePage(Page page){
       this.page = page;
    }

    public String getHomePageTitle(){
        String title = page.title();
        System.out.println("Page title: "+title);
        return title;
    }

    public String getHomePageRL(){
        String url = page.url();
        System.out.println("Url is -->" +url);
        return url;
    }

    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchIcon);
        String header = page.textContent(searchPageHeader);
        System.out.println("search header is :" +header);
        return header;
    }

    public LoginPage navigateToLoginPage(){
        page.click(myAccountLink);
        page.click(loginLink);
        return new LoginPage(page);
    }
}
