package mmPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstagramPage {

    public InstagramPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@role='link'])[8]")
    public WebElement pInstaLogo;

    @FindBy(xpath = "//button[@class='_abn5 _abn6 _aa5h']")
    public WebElement pClose;


}
