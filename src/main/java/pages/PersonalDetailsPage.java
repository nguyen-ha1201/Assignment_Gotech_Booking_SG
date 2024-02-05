package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalDetailsPage extends BasePage {
    public PersonalDetailsPage() {
        PageFactory.initElements(getWebDriver(), this);
    }
    @FindBy(xpath = "(//img[@alt='BookingSG-app-logo'])[1]")
    private WebElement bookingAppLogo;
    @FindBy(xpath = "//button[@data-testid='submit-button']")
    private WebElement nextBtn;
    @FindBy(xpath = "//*[@for='citizen-name-base']")
    private WebElement nameTitle;

    public void clickOnNextButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(nextBtn)).click();
    }
    public void verifyPersonalDetails() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(bookingAppLogo));
        getWebDriverWait().until(ExpectedConditions.visibilityOf(nameTitle));
    }
}
