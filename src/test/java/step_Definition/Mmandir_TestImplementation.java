package step_Definition;

import action.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mmPages.Home_Page_Elements;
import mmPages.InstagramPage;
import mmPages.Mmandir_Boys_Elements;
import org.openqa.selenium.WebElement;

public class Mmandir_TestImplementation extends Base {
    Home_Page_Elements hpe = new Home_Page_Elements(driver);
    Mmandir_Boys_Elements mt = new Mmandir_Boys_Elements(driver);

    InstagramPage ip = new InstagramPage(driver);

    @Before
    public void beforeAll(){
        setDriver();
        setUrl();
    }

    @Given("the user launches the home page application")
    public void the_user_launches_the_home_page_application() {
    }
    @Then("the user validates the presence of the home page logo")
    public void the_user_validates_the_presence_of_the_home_page_logo() {
        pLogo_IsVisible(hpe.pHomePage_Logo);
    }
    @Then("the user verifies the displayed mobile and email contact information")
    public void the_user_verifies_the_displayed_mobile_and_email_contact_information() {
        pData_Validation(hpe.pMobilePhone, pRead_Properties_Files("mobilephone"));
        pData_Validation(hpe.pEmail, pRead_Properties_Files("email"));
    }
    @Then("the user hovers over the PG Location button")
    public void the_user_hovers_over_the_pg_location_button() {
        pHoverOverElement(driver, hpe.pG_Location_Button);

    }
    @When("the user clicks on Manmandir Boys Hostel")
    public void the_user_clicks_on() {
       // pHoverOverElement(driver, hpe.pG_Location_Button);
        pClick(hpe.pmMandir_Boys_Button);


    }
    @Then("the user should be navigated to the details page for Manmandir Boys Hostel")
    public void the_user_should_be_navigated_to_the_details_page_for_manmandir_boys_hostel() {
        // Write code here that turns the phrase above into concrete actions
        pGet_Url(pRead_Properties_Files("Mmdir_url"));
        pElement_Highlighted(mt.pG_Location_Button);
    }

    @Then("the user should scroll to the Schedule a visit form")
    public void the_user_should_scroll_to_the_schedule_a_visit_form() {
        // Write code here that turns the phrase above into concrete actions
        scroll(mt.pFirst_Name);
    }

    @Then("the user should fill out the form {string},{string},{string},{string},{string},{string},{string},{int},{string}")
    public void the_user_should_fill_out_the_form(String firstname, String lastname, String email, String mobile, String SelectGender, String iama, String duration, int date, String message) {
        // Write code here that turns the phrase above into concrete actions
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

    }

    @Given("the user already completed the form")
    public void the_user_already_completed_the_form() {
        System.out.println("User completed the Schedule a visit form");
    }
    @When("The user gets a list of all the amenities")
    public void the_user_gets_a_list_of_all_the_amenities() {
        // Write code here that turns the phrase above into concrete actions
        for (WebElement element : mt.pAmenities2) {
            System.out.println(element.getText());
        }
        pListAmenities(mt.pAmenities2);
    }
    @Then("the user will compare the text of the elements should match the following words:")
    public void the_user_will_compare_the_text_of_the_elements_should_match_the_following_words(DataTable dataTable) {
       // pCompareWordWithText(mt.pAmenities(driver), String.valueOf(dataTable));
        System.out.println("debug");
    }

    @Then("The user will click on the logo get to the home page again")
    public void the_user_will_click_on_the_logo_get_to_the_home_page_again() {
       hpe.pHomePage_Logo.click();
    }


    @Then("The user will click on the instagram logo")
    public void the_user_will_click_on_the_instagram_logo() {
        hpe.pInstalogo.click();
    }
    @When("The user is on instragram he would validate the logo")
    public void the_user_is_on_instragram_he_would_validate_the_logo() {
        pLogo_IsVisible(ip.pInstaLogo);
    }
    @When("The user should close the instagram page and go back to the home page")
    public void the_user_should_close_the_instagram_page_and_go_back_to_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The user is back to the home page")
    public void the_user_is_back_to_the_home_page() {
        pWindowHandler();
    }
    @Then("The user will click on the Schedule a visit")
    public void the_user_will_click_on_the_schedule_a_visit() {
        hpe.pScheduleVisit.click();
    }
    @Then("The user will validated the form label")
    public void the_user_will_validated_the_form_label() {
        pLabelValidation(hpe.pScheduleVisitLabel);
    }



    @After
   public void after(){
       quit();
   }
}

