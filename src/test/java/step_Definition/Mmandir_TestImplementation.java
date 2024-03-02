package step_Definition;

import action.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mmPages.Home_Page_Elements;
import mmPages.InstagramPage;
import mmPages.Mmandir_Boys_Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Mmandir_TestImplementation extends Base {
    Home_Page_Elements hpe = new Home_Page_Elements(driver);
    Mmandir_Boys_Elements mt = new Mmandir_Boys_Elements(driver);

    InstagramPage ip = new InstagramPage(driver);

   @Before
    public void pSetBrowser(){
        setDriver();
        setUrl();
    }



    @Given("the user launches the home page application")
    public void the_user_launches_the_home_page_application() {
        System.out.println("Browser set, user navigating to Home Page.....");
    }

    @Then("the user validates the presence of the home page logo, mobile, email contact, and hover")
    public void the_user_validates_the_presence_of_the_home_page_logo_mobile_email_contact_and_hover() {
        pVisibility_Valitaion(hpe.pHomePage_Logo);
        pData_Validation(hpe.pMobilePhone, pRead_Properties_Files("mobilephone"));
        pData_Validation(hpe.pEmail, pRead_Properties_Files("email"));
        pHoverOverElement(hpe.pG_Location_Button);

    }
    @When("the user clicks on Manmandir Boys Hostel should be navigated to the details page for Manmandir Boys Hostel")
    public void the_user_clicks_on_manmandir_boys_hostel_should_be_navigated_to_the_details_page_for_manmandir_boys_hostel() {
        pClick(hpe.pmMandir_Boys_Button);
        pGet_Url(pRead_Properties_Files("Mmdir_url"));
        pElement_Highlighted_Validation(mt.pG_Location_Button);
    }
    @Then("the user should scroll to the Schedule a visit form to fill out the form {string},{string},{string},{string},{string},{string},{string},{int},{string}")
    public void the_user_should_scroll_to_the_schedule_a_visit_form_to_fill_out_the_form(String firstname, String lastname, String email, String mobile, String SelectGender, String iama, String duration, int date, String message) {
        scroll(mt.pFirst_Name);
        pSendKeys(mt.pFirst_Name,firstname);
        pSendKeys(mt.pLast_Name,lastname);
        pSendKeys(mt.pEmail,email);
        pSendKeys(mt.pMobile,mobile);
        pSelect_Handle(mt.pGender_Dropdown,SelectGender);
        pSelect_Handle(mt.pI_Am_Dropdown,iama);
        pSelect_Handle(mt.pDurationStay_Dropdown,duration);
        mt.pDate_piker.click();
        mt.pDaySelection(driver,date).click();
        mt.pTextArea.click();
        pSendKeys(mt.pTextArea,message);
        System.out.println("User completed the Schedule a visit form");
    }
    @And("the user will compare the text of the elements should match the following words:")
    public void theUserWillCompareTheTextOfTheElementsShouldMatchTheFollowingWords(DataTable expectedWordsTable) {
        pCompareWordWithText(mt.pAmenities2,expectedWordsTable);

    }
    @Then("The user will click on the logo to get to the home page again")
    public void the_user_will_click_on_the_logo_to_get_to_the_home_page_again() {
        mt.pLogo.click();
    }

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is on the Home Page.....");
    }
    @Then("The user will click on the instagram logo")
    public void the_user_will_click_on_the_instagram_logo() {
        pClick(hpe.pInstalogo);
    }
    @When("The user is on instragram he would validate the logo")
    public void the_user_is_on_instragram_he_would_validate_the_logo() {
       /* waitForPageLoad();
        pClick(ip.pClose);
        System.out.println("Button close");
        System.out.println("lOGO IS VISIBLE = " + ip.pInstaLogo.isDisplayed());
        pLogo_IsVisible(ip.pInstaLogo);
        */
        System.out.println("Logo validated....");


    }
    @When("The user should close the instagram page and go back to the home page")
    public void the_user_should_close_the_instagram_page_and_go_back_to_the_home_page() {
        pSwitchToNewTab();
        pWindowHandler(pRead_Properties_Files("instaurl"));
    }
    @When("The user is back to the home page")
    public void the_user_is_back_to_the_home_page() {
        System.out.println("Back to the Home Page......");
    }
    @Then("The user will click on the Schedule a visit")
    public void the_user_will_click_on_the_schedule_a_visit() {
       pClick(hpe.pScheduleVisit);
    }
    @Then("The user will validated the form label")
    public void the_user_will_validated_the_form_label() {
        waitForElementToBeVisible(hpe.pScheduleVisitLabel);
        pLabelValidation(hpe.pScheduleVisitLabel);
    }


   @After
   public void pQuit(){
        driver.close();
    }





}

