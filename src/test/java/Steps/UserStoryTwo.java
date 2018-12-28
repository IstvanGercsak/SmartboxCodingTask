package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserStoryTwo extends BaseUtil {

    private BaseUtil base;

    public UserStoryTwo(BaseUtil base) {
        this.base = base;
    }

    @And("^I click on the search field$")
    public void iClickOnTheSearchField() {
        base.driver.findElement(By.className("search-input")).click();
    }

    @And("^I am looking for the product called \"([^\"]*)\"$")
    public void iAmLookingForTheProductCalled(String keyWord) {
        base.driver.findElement(By.className("search-input")).sendKeys(keyWord);
    }

    @And("^I click on the \"([^\"]*)\" Category$")
    public void iClickOnTheCategory(String Gastronomie) {

        base.driver.findElement(By.linkText(Gastronomie)).click();

    }

    @Then("^Filter options are displayed$")
    public void filterOptionsAreDisplayed() {

        base.driver.findElement(By.id("location")).click();

    }

    @And("^I type \"([^\"]*)\" on the filter field$")
    public void iTypeOnTheFilterField(String keyWord) {

        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("location")));

        base.driver.findElement(By.id("location")).sendKeys(keyWord);

    }

    @And("^I click on the rating title$")
    public void iClickOnTheRatingTitle() {

        base.driver.findElement(By.className("product-info__review-link"));

    }

    @Then("^The reviews section become visible$")
    public void theReviewsSectionBecomeVisible() {

        ExpectedConditions.visibilityOfElementLocated(By.id("reviews"));

    }

    @Then("^Search results are displays on the list with the name of \"([^\"]*)\"$")
    public void searchResultsAreDisplaysOnTheListWith(String result) {

        String firstWord = base.driver.findElement(By.xpath("//*[@id=\"search\"]/div/ul/li[2]/a/span[1]")).getText();
        String SecondWord = base.driver.findElement(By.xpath("//*[@id=\"search\"]/div/ul/li[2]/a/span[2]/span[2]")).getText();

        Assert.assertEquals(firstWord + " - " + SecondWord, result);

    }
}
