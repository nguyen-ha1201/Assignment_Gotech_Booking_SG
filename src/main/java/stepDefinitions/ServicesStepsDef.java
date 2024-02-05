package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

import java.util.logging.Logger;

public class ServicesStepsDef {
    LoginPage loginPage = new LoginPage();
    BookingSGPage bookingSGPage = new BookingSGPage();
    PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
    ReviewPage reviewPage = new ReviewPage();
    BookingRequestPage bookingRequestPage = new BookingRequestPage();
    YourBookingsPage yourBookingsPage = new YourBookingsPage();

    @Given("User opens browser and navigate {string} with {string} and login")
    public void userOpensBrowserAndNavigateToAndLogin(String serviceName, String url) {
        System.out.println(serviceName);
        loginPage.navigateToService(url);
        loginPage.clickOnLoginBtn();
    }

    @When("User should see Booking page of {string} and chooses the first time slot")
    public void userShouldSeeBookingPageOfAndChoosesTheFirstTimeSlot(String serviceName) {
        bookingSGPage.isBookingScreenDisplay(serviceName);
        bookingSGPage.chooseTheFirstSlot();
        bookingSGPage.getEndTimeOfSlot();
        Assert.assertTrue(bookingSGPage.isComfirmButtonEnabled());
    }

    @When("User clicks confirm button in Booking page")
    public void userClicksConfirmButtonInBookingPage() {
        Assert.assertTrue(bookingSGPage.isComfirmButtonEnabled());
        bookingSGPage.clickOnConfirmBtn();
    }

    @And("User should see Personal details page and click on Next button")
    public void userShouldSeePersonalDetailsPageAndClickOnNextButton() {
        personalDetailsPage.clickOnNextButton();
    }

    @And("User should see Review page and click on Submit button")
    public void userShouldSeeReviewPageAndClickOnSubmitButton() {
        reviewPage.clickOnSubmitButton();
    }

    @And("User should see Booking request page and click on View booking button")
    public void userShouldSeeBookingRequestPageAndClickOnViewBookingButton() {
        bookingRequestPage.clickOnViewYourRequestButton();
    }

    @Then("User should see Your bookings page")
    public void userShouldSeeYourBookingsPage() {

    }
    @And("User should see Booking request page in {string} with {string}")
    public void userShouldSeeBookingRequestPageWith(String serviceName, String bookingStatus) {
        switch (serviceName.toUpperCase()) {
            case "SERVICE_1", "SERVICE_2", "SERVICE_4", "SERVICE_6":
                bookingRequestPage.verifyBookingRequestInProgress(bookingStatus);
                bookingRequestPage.clickOnViewYourRequestButton();
                break;
            case "SERVICE_3", "SERVICE_5":
                bookingRequestPage.verifyBookingConfirmed(bookingStatus);
                bookingRequestPage.clickOnViewYourRequestButton();
        }
    }

    @And("User should see information of booking request in {string} with status as {string}")
    public void userShouldSeeInformationOfBookingRequestInWithStatusAs(String serviceName, String status) {
        yourBookingsPage.verifyStatus(status);
        switch (serviceName.toUpperCase()) {
            case "SERVICE_1":
                Assert.assertTrue(yourBookingsPage.isEndTimeDisplayed(),"End time is displayed");
                Assert.assertTrue(yourBookingsPage.isProviderNameVisible(serviceName),"Booking request is assigned for admin");
                Assert.assertFalse(yourBookingsPage.isCancelBtnEnable(),"Cancel button is disabled");
                Assert.assertFalse(yourBookingsPage.isRescheduleBtnEnable(),"Reschedule button is disabled");
                break;
            case "SERVICE_2":
                Assert.assertTrue(yourBookingsPage.isEndTimeDisplayed(),"End time is displayed");
                Assert.assertFalse(yourBookingsPage.isProviderNameVisible(serviceName), "Booking request has been assigned for admin");
                Assert.assertFalse(yourBookingsPage.isCancelBtnEnable(),"Cancel button is disabled");
                Assert.assertFalse(yourBookingsPage.isRescheduleBtnEnable(),"Reschedule button is disabled");
                break;
            case "SERVICE_3":
                Assert.assertTrue(yourBookingsPage.isEndTimeDisplayed(),"End time is displayed");
                Assert.assertTrue(yourBookingsPage.isProviderNameVisible(serviceName),"Booking request is assigned for admin");
                Assert.assertFalse(yourBookingsPage.isCancelBtnEnable(),"Cancel button is disabled");
                Assert.assertTrue(yourBookingsPage.isRescheduleBtnEnable(),"Reschedule button is enabled");
                break;
            case "SERVICE_4, SERVICE_6":
                Assert.assertFalse(yourBookingsPage.isEndTimeDisplayed(),"End time is not displayed");
                Assert.assertFalse(yourBookingsPage.isProviderNameVisible(serviceName), "Booking request has been assigned for admin");
                Assert.assertFalse(yourBookingsPage.isCancelBtnEnable(),"Cancel button is disabled");
                Assert.assertFalse(yourBookingsPage.isRescheduleBtnEnable(),"Reschedule button is disabled");
                break;
            case "SERVICE_5":
                Assert.assertFalse(yourBookingsPage.isEndTimeDisplayed(),"End time is not displayed");
                Assert.assertTrue(yourBookingsPage.isProviderNameVisible(serviceName),"Booking request is assigned for admin");
                Assert.assertTrue(yourBookingsPage.isCancelBtnEnable(),"Cancel button is enabled");
                Assert.assertFalse(yourBookingsPage.isRescheduleBtnEnable(),"Reschedule button is disabled");
                break;
            default:
                System.out.println("Browser is invalid, Launching Chrome as browser of choice...");
        }
    }
}
