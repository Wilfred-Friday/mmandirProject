package mmPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page_Elements {
    public Home_Page_Elements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='elementor-widget-container']/a/img)[1]")
    public WebElement pHomePage_Logo;

    @FindBy(xpath = "(//li[@class='elementor-icon-list-item elementor-inline-item']/a/span)[2]")
    public WebElement pMobilePhone;

    @FindBy(xpath = "(//li[@class='elementor-icon-list-item elementor-inline-item']/a/span)[4]")
    public WebElement pEmail;

    @FindBy(xpath = "//ul[@id='nav_menu30']/li/a[contains(text(),'PG Locations')]")
    public WebElement pG_Location_Button;

    @FindBy(xpath = "//ul[@id='nav_menu30']/li/ul/li/a[contains(text(),'Manmandir Boys Pg – Navrangpura')]")
    public WebElement pmMandir_Boys_Button;

    @FindBy(xpath = "(//span[@class='elementor-grid-item']/a)[2]")
    public WebElement pInstalogo;

    @FindBy(xpath = "(//div[@class='elementor-widget-container']/p/a)[1]")
    public WebElement pScheduleVisit;

    @FindBy(xpath = "//div[@class='paoc-popup-margin paoc-popup-mheading']")
    public WebElement pScheduleVisitLabel;



}
