package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookingSGPage extends BasePage {
    public BookingSGPage() {
        PageFactory.initElements(getWebDriver(), this);
    }
    @FindBy(xpath = "(//img[@alt='BookingSG-app-logo'])[1]")
    private WebElement bookingAppLogo;
    @FindBy(xpath = "//h1[@data-testid='service-title']")
    private WebElement bookingTitle;
    @FindBy(xpath = "//button[@data-testid='submit-button']")
    private WebElement confirmBtn;
    @FindBy(xpath = "//*[@data-testid='calendar-date-text']")
    private WebElement calenderTitle;
    @FindBy(xpath = "//p[contains(text(),'Morning slots')]")
    private WebElement morningSlots;
    @FindBy(xpath = "//p[contains(text(),'Afternoon slots')]")
    private WebElement afterSlots;
    @FindBy(xpath = "(//*[@data-testid='card-content'])[1]//span[1]")
    private WebElement firstTimeSlot;
    @FindBy(xpath = "//*[@data-testid='card-content']")
    private List<WebElement> listOfSlots;
    @FindBy(xpath = "//div[@data-testid='selected-date-time']//h4")
    private WebElement confirmTimeSlotInfor;
    @FindBy(xpath = "//h5[contains(@class,'sc-dcrmVg')]")
    private List<WebElement> listOfDays;

    public void isBookingScreenDisplay(String title) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(bookingAppLogo)).isDisplayed();
        String pageTitle = bookingTitle.getText().toLowerCase();
        if (title.contains("_")) {
            title = title.replace("_"," ").toLowerCase();
            System.out.println(title);
        }
        Assert.assertEquals(title, pageTitle, "Title of Page is visible");
        getWebDriverWait().until(ExpectedConditions.visibilityOf(calenderTitle)).isDisplayed();
        morningSlots.isDisplayed();
        afterSlots.isDisplayed();
        firstTimeSlot.isEnabled();
    }
    public void chooseTheFirstSlot() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(morningSlots)).isDisplayed();
        firstTimeSlot.click();
    }
    public boolean isComfirmButtonEnabled() {
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(confirmBtn)).isEnabled();
    }
    public boolean isConfirmTimeSlotDisplay() {
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(confirmTimeSlotInfor)).isDisplayed();
    }
    public void isComfirmSlotInfor() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(confirmTimeSlotInfor)).isDisplayed();
    }
    public String getEndTimeOfSlot() {
        String timeSlotText = getWebDriverWait().until(ExpectedConditions.visibilityOf(firstTimeSlot)).getText();
        timeSlotText = timeSlotText.substring(0,timeSlotText.length()-2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime startTime = LocalTime.parse(timeSlotText, formatter);
        System.out.println("Original Time: " + startTime);
        LocalTime plusHoursTime = startTime.plusHours(1);
        END_TIME = plusHoursTime.format(formatter);
        System.out.println("Updated Time: " + END_TIME);
        return END_TIME;
    }


    public void clickOnConfirmBtn() {
        confirmBtn.click();
    }
}
