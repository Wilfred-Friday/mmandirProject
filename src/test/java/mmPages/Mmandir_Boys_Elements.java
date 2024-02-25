package mmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Mmandir_Boys_Elements {
    public Mmandir_Boys_Elements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@id='nav_menu20']/li/a[contains(text(),'PG Locations')]")
    public WebElement pG_Location_Button;  //check if it's higlitedt

    //Form Elements
    @FindBy(xpath = "(//input[@id='ff_4_names_first_name_'])[1]")
    public WebElement pFirst_Name;

    @FindBy(xpath = "(//input[@id='ff_4_names_last_name_'])[1]")
    public WebElement pLast_Name;

    @FindBy(xpath = "(//input[@id='ff_4_email'])[1]")
    public WebElement pEmail;

    @FindBy(xpath = "(//input[@id='ff_4_numeric-field'])[1]")
    public WebElement pMobile;

    @FindBy(xpath = "(//select[@id='ff_4_dropdown'])[1]")
    public WebElement pGender_Dropdown;

    @FindBy(xpath = "(//select[@id='ff_4_dropdown_2'])[1]")
    public WebElement pI_Am_Dropdown;

    @FindBy(xpath = "(//select[@id='ff_4_dropdown_1'])[1]")
    public WebElement pDurationStay_Dropdown;

    @FindBy(xpath = "(//input[@id='ff_4_datetime'])[1]")
    public WebElement pDate_piker;

    @FindBy(xpath = "(//textarea[@id='ff_4_message'])[1]")
    public WebElement pTextArea;

    public WebElement pDaySelection(WebDriver driver, int day){
        return driver.findElement(By.xpath("//div[@class='dayContainer']/span[contains(text(),"+day+")]"));
    }




    //Amenities locator

    public List <WebElement> pAmenities(WebDriver driver){
        return driver.findElements(By.xpath("//div[@class='elementor-widget-wrap elementor-element-populated']/section/div/div/div/div/div/div/div[contains(@class,'elementor-image-box-content')]/h3"));
    }

    @FindBys({
            @FindBy(xpath = "//body/div[@id='perspective']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[1]/section/div/div/div"),
            @FindBy(tagName = "h3")
    }) public List <WebElement> pAmenities2;


}
