import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;


public class BrowserAutomation {
    WebDriver driver;

    static Logger logger = Logger.getLogger(BrowserAutomation.class);

    @Before
    public void setup() {
        PropertyConfigurator.configure("log4j.properties");
       WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @Test
    public void testSuccessFulLogin() throws InterruptedException {

        // Open a website
        driver.get("https://www.mailtravel.co.uk");

        Thread.sleep(2000);
        driver.manage().window().maximize();


        // Find the element that represents to accept cookies button
        WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));

        // Click the accept cookies button
        if (acceptCookiesButton != null && acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }

        // Locate the search bar element
        WebElement searchBox = driver.findElement(By.id("searchtext_freetext_search_form"));

        // Input  search query

        searchBox.sendKeys("India");


        // Implicitly wait for elements to load
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);

        searchBox.sendKeys(Keys.ARROW_DOWN);

        // Implicitly wait for elements to load
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);

        searchBox.sendKeys(Keys.ENTER);
        // Implicitly wait for elements to load
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.name("enterbookingflow"));
        button.click();

        // Implicitly wait for elements to load
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("dates_and_prices_title_tab"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        // Implicitly wait for elements to load
        //  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);


        WebElement element1 = driver.findElement(By.xpath("//span[normalize-space()='£2,149']"));
        element1.click();

        // Implicitly wait for elements to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement element2 = driver.findElement(By.xpath("//div[@id='book-button']//button[@type='submit']"));
        element2.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='room-1837299-numselect']"));
        Select dropdown = new Select(dropDownElement);
        dropdown.selectByValue("1");


        WebElement selectYourRoomAndContinue = driver.findElement(By.xpath("//div[@class='nbf_fancy_nbf_tpl_pms_book_room nbf_fg_pms_button_text ']"));
        selectYourRoomAndContinue.click();

        WebElement continueWithoutExtras = driver.findElement(By.xpath("//div[@id='extrasButton']"));
        continueWithoutExtras.click();

        // First Person details
        Thread.sleep(2000);

        WebElement title = driver.findElement(By.xpath("//select[@id='pax-a-title-1']"));
        Select titleDropdown1 = new Select(title);
        titleDropdown1.selectByValue("Mr");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement firstName = driver.findElement(By.xpath("//input[@id='pax-a-first-1']"));
        firstName.sendKeys("Manish");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='pax-a-last-1']"));
        lastName.sendKeys("Anant");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement dateOfBirth = driver.findElement(By.xpath("//select[@id='pax-a-dobd-1']"));
        Select dateOfBirthDropdown = new Select(dateOfBirth);
        dateOfBirthDropdown.selectByValue("23");

        WebElement monthOfBirth = driver.findElement(By.xpath("//select[@id='pax-a-dobm-1']"));
        Select monthOfBirthDropdown = new Select(monthOfBirth);
        monthOfBirthDropdown.selectByValue("7");

        WebElement yearOfBirth = driver.findElement(By.xpath("//select[@id='pax-a-doby-1']"));
        Select yearOfBirthDropDown = new Select(yearOfBirth);
        yearOfBirthDropDown.selectByValue("2003");

        //Second person details

        Thread.sleep(2000);


        WebElement title2 = driver.findElement(By.xpath("//select[@id='pax-a-title-2']"));
        Select titleDropdown2 = new Select(title2);
        titleDropdown2.selectByValue("Mrs");

        WebElement firstName2 = driver.findElement(By.xpath("//input[@id='pax-a-first-2']"));
        firstName2.sendKeys("FirstName");


        WebElement lastName2 = driver.findElement(By.xpath("//input[@id='pax-a-last-2']"));
        lastName2.sendKeys("LastName");

        WebElement dateOfBirth2 = driver.findElement(By.xpath("//select[@id='pax-a-dobd-2']"));
        Select dateOfBirthDropdown2 = new Select(dateOfBirth2);
        dateOfBirthDropdown2.selectByValue("13");


        WebElement mob = driver.findElement(By.xpath("//select[@id='pax-a-dobm-2']"));
        Select mob2 = new Select(mob);
        mob2.selectByValue("3");

        WebElement yearOfBirth2 = driver.findElement(By.xpath("//select[@id='pax-a-doby-2']"));
        Select yearOfBirthDropDown2 = new Select(yearOfBirth2);
        yearOfBirthDropDown2.selectByValue("2001");

        // Create a JavascriptExecutor instance
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;

        // Scroll down by 1100 pixels
        jsExecutor2.executeScript("window.scrollBy(0, 1100);");

        //Lead Contact Details

        WebElement yourName = driver.findElement(By.xpath("//input[@id='contact-name']"));
        yourName.sendKeys("firstNameLastName");

        WebElement mobileNo = driver.findElement(By.xpath("//input[@id='contact-mobile']"));
        mobileNo.sendKeys("7466558902");

        WebElement emailAddress = driver.findElement(By.xpath("//input[@id='contact-email']"));
        emailAddress.sendKeys("testing@gmail.com");

        WebElement addressLine1 = driver.findElement(By.xpath("//input[@id='contact-address1']"));
        addressLine1.sendKeys("addr1");

        WebElement addressLine2 = driver.findElement(By.xpath("//input[@id='contact-address2']"));
        addressLine2.sendKeys("addr2");

        WebElement city = driver.findElement(By.xpath("//input[@id='contact-city']"));
        city.sendKeys("Belfast");

        WebElement postcode = driver.findElement(By.xpath("//input[@id='contact-postcode']"));
        postcode.sendKeys("BT4 8EP");

        WebElement country = driver.findElement(By.xpath("//select[@id='contact-country']"));
        Select countryDropDown = new Select(country);
        countryDropDown.selectByValue("GB");

        WebElement pleaseSelect = driver.findElement(By.xpath("//select[@id='contact-hearabout']"));
        Select pleaseSelectDropDown = new Select(pleaseSelect);
        pleaseSelectDropDown.selectByValue("2");

        WebElement continueButton = driver.findElement(By.xpath("//div[@class='nbf_fancy_paxButton nbf_fg_pms_button_text ']"));
        continueButton.click();

        // Find the element containing the text you want to assert
        WebElement confirmDetails = driver.findElement(By.xpath("//h1[@class='nbf_fancyimg_payment_pageheader']"));

        // Get the text from the element
        String actualText = confirmDetails.getText();


        // Define the expected text
        String expectedText = "Confirm Details + Book";

        // Use Assert.assertEquals to compare the actual and expected text
        // This will throw an AssertionError if the text does not match

        Assert.assertEquals(actualText, expectedText);


        // Find the button element by its XPath and check it's enabled
        WebElement bookNowButton = driver.findElement(By.xpath("//div[@class='nbf_fancyimg_payment_book_button']"));
        Assert.assertTrue(bookNowButton.isEnabled());

        // Close the WebDriver
        driver.quit();
    }
}







