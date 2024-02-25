package action;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Base {
    public  WebDriver driver = new ChromeDriver();
    String mainWindow;

    public void setDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainWindow = driver.getWindowHandle();
    }

    public  void quit(){
        driver.quit();
    }

    public void setUrl() {
        driver.get(pRead_Properties_Files("Base_url"));
    }

    public void pSendKeys(WebElement element, String key){
        element.sendKeys(key);
    }

    public void pClick(WebElement element)
    {
        try{
            element.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public String pRead_Properties_Files(String key){
        String flag = null;
        try{
            Properties prop = new Properties();
            prop.load(new FileInputStream(System.getProperty("user.dir")+"/Global.properties"));
            flag = prop.getProperty(key);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;

    }

    public boolean scroll(WebElement element)
    {
        boolean flag = false;
        try{
            waitForElementToBeVisible(element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public void getIframe(){
        driver.switchTo().frame(0);
    }

    public void quitIframe(){
        driver.switchTo().defaultContent();
    }


    protected void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
        //System.out.println(element + " Is present");
    }
    protected void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        //System.out.println(element + " Is present");
    }


    public void pSelect_Handle(WebElement element){
        Random random = new Random();
        // Generate a random number between 1 and 2 (inclusive)
        int randomNumber = random.nextInt(2) + 1;
        Select dropdown = new Select(element);
        dropdown.selectByIndex(randomNumber);
        System.out.println("Random number generated " + randomNumber);
    }

    public void pSelect_Handle(WebElement element, String value){
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }


    public void pLogo_IsVisible(WebElement element){
        try{
            waitForElementToBeVisible(element);
            if(element.isDisplayed()){
                System.out.println("Logo is Present");
            }else{
                System.out.println("Logo is not Present");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void pData_Validation(WebElement element, String file_Data){
        try{
            String element_Text = element.getText();
            if(element_Text.equals(file_Data)){
                System.out.println(file_Data + " is equal to element text: " + element_Text);
            }else{
                System.out.println(file_Data + " is not equal to element text: " + element_Text);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void pHoverOverElement(WebDriver driver, WebElement element) {
        try {
            // Create Actions instance
            Actions actions = new Actions(driver);

            // Move to the element to hover
            actions.moveToElement(element).perform();

            // Add validation or further actions if needed after hover

            System.out.println("Successfully hovered over the element.");

        } catch (Exception e) {
            // Handle any exceptions
            System.err.println("Error while hovering over the element: " + e.getMessage());
        }
    }


    public void pGet_Url(String url){
        try {
            if(url.equals(driver.getCurrentUrl())){
                System.out.println("User entered manmandir-boys-and-girls-hostel url");
            }else{
                System.out.println("User is on a different url");
            }

        } catch (Exception e){
            // Handle any exceptions
            System.err.println("Error while getting  url: " + e.getMessage());
        }
    }

    public void pElement_Highlighted(WebElement element){
        try {
            String pNot_Highlighted = "rgba(255, 255, 255, 1)";
            if(element.getCssValue("color").equals(pNot_Highlighted)){
                System.out.println("Element is not Highlighted");
            }else{
                System.out.println("Element is Highlighted");
            }
        } catch (Exception e){
            // Handle any exceptions
            System.err.println("Error while checking status of Element: " + e.getMessage());
        }
    }



    public void pCompareWordWithText(List<WebElement> elements, DataTable expectedWordsTable) {
        List<String> expectedWords = expectedWordsTable.asList(String.class);
        System.out.println(expectedWords);

        for (WebElement element : elements) {
            String actualText = element.getText().trim();
            System.out.println("Im the actual text from the element " + actualText);

            for (String data : expectedWords) {
                String actualData = data;
                System.out.println("Im the actual text from the data " + actualData);
                // Check if any word in the expectedWords list is present in the actualText
                if (actualText.equals(actualData.trim())) {
                    System.out.println("Element text '" + actualText + " equals to valid data " + actualData);
                    // If you want to break out of the loop once a match is found, you can add a break statement here.
                }
            }


        }
        System.out.println("Comparison incompleted.");
    }

    public void pListAmenities(List <WebElement> elements){
        System.out.println("Text of the elements:");
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }

    public void pWindowHandler(){
        driver.close(); // close the child tab
        driver.switchTo().window(mainWindow);
        System.out.println("User is back to the home Page");
    }

    public void pLabelValidation(WebElement element){
        if(element.isDisplayed()){
            System.out.println("Label " + element.getText() + " Is Present");
        }else {
            System.out.println("Element label is not Present");
        }
    }
}
