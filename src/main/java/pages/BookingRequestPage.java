package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BookingRequestPage extends BasePage {
    public BookingRequestPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(xpath = "(//img[@alt='BookingSG-app-logo'])[1]")
    private WebElement bookingAppLogo;
    @FindBy(xpath = "//h1[@data-testid='header-text']")
    private WebElement bookingRequestInProgressTxt;
    @FindBy(xpath = "//*[@data-testid='desktop-viewBookings']")
    private WebElement viewBookingsBtn;
    @FindBy(xpath = "//div[contains(@class,'sc-buejKm')]")
    private WebElement successIcon;
    @FindBy(xpath = "//h1[@data-testid='header-text']")
    private WebElement successStatus;
    @FindBy(xpath = "//button[@data-testid='another-booking-button']")
    private WebElement makeAnotherBooking;
    @FindBy(xpath = "//button[@data-testid='button']")
    private WebElement addToCalender;
    public void verifyBookingRequestText(String message) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(bookingRequestInProgressTxt));
        String msg = bookingRequestInProgressTxt.getText();
        Assert.assertEquals(msg,message);
    }
    public void clickOnViewYourRequestButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(viewBookingsBtn)).click();
    }
    public void verifyBookingRequestInProgress(String statusBooking) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(bookingAppLogo)).isDisplayed();
        Assert.assertTrue(viewBookingsBtn.isEnabled());
        Assert.assertTrue(bookingRequestInProgressTxt.getText().toUpperCase().contains(statusBooking.toUpperCase()));
    }
    public void verifyBookingConfirmed(String statusBooking) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(bookingAppLogo)).isDisplayed();
        Assert.assertTrue(viewBookingsBtn.isEnabled());
        Assert.assertTrue(makeAnotherBooking.isEnabled());
        Assert.assertTrue(addToCalender.isEnabled());
        Assert.assertTrue(bookingRequestInProgressTxt.getText().contains(statusBooking));
    }
    public void verifyStatusOfBookingPage(String statusBooking) {
        Assert.assertTrue(bookingRequestInProgressTxt.getText().contains(statusBooking));
    }
}
