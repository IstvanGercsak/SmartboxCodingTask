package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserStoryOne extends BaseUtil {

    private BaseUtil base;

    public UserStoryOne(BaseUtil base) {
        this.base = base;
    }

    @Given("^I go to the French Smartbox site$")
    public void iGoToTheFrenchSmartboxSite() {

        base.driver.navigate().to(FRENCHMAINPAGE());
        closeCookiesPopUp();

    }

    @And("^I pick the first item from the list$")
    public void iPickTheFirstItemFromTheList() {

        base.driver.findElement(By.cssSelector("#ac-cloudSearchResults > article:nth-child(1)")).click();

    }

    @Then("^Ajouter au panier button is clickable$")
    public void ajouterAuPanierButtonIsClickable() {
        base.driver.findElement(By.className("add-to-cart"));
    }


    void closeCookiesPopUp() {

        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("optanon-alert-box-corner-close")));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("optanon-alert-box-corner-close")));

        base.driver.findElement(By.className("optanon-alert-box-corner-close")).click();
    }

    @And("^I click on the Ajouter au panier button$")
    public void iClickOnTheAjouterAuPanierButton() {

        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"box-type-ebox-classic\"]/div/a/span")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"box-type-ebox-classic\"]/div/a/span")));

        base.driver.findElement(By.xpath("//*[@id=\"box-type-ebox-classic\"]/div/a/span")).click();

    }

    @Then("^Article ajouté au panier overlay appear$")
    public void articleAjoutéAuPanierOverlayAppear() {
        base.driver.findElement(By.id("addtocart-confirmation"));
    }

    @Then("^\"([^\"]*)\" and \"([^\"]*)\" is appears on the cart overlay$")
    public void andIsAppearsOnTheCartOverlay(String continueShopping, String toCart) {

        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addtocart-confirmation\"]/div/div/div[2]/a[1]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"addtocart-confirmation\"]/div/div/div[2]/a[1]")));

        base.driver.findElement(By.linkText(continueShopping));
        base.driver.findElement(By.linkText(toCart));
    }

    @And("^I click on the Voir Le Panier button$")
    public void iClickOnTheVoirLePanierButton() {

        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addtocart-confirmation\"]/div/div/div[2]/a[1]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"addtocart-confirmation\"]/div/div/div[2]/a[1]")));

        base.driver.findElement(By.linkText("VOIR LE PANIER")).click();
    }

    @Then("^The choosen product is appers on the cart page$")
    public void theChoosenProductIsAppersOnTheCartPage() {

        Assert.assertEquals(base.driver.findElement(By.className("item__box-title")).getText(), "Rendez-vous gourmand");

    }

    @Then("^I click on the trash icon$")
    public void iClickOnTheTrashIcon() {

        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("si-bin")));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("si-bin")));

        base.driver.findElement(By.className("si-bin")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart-remove-confirm-accept")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-remove-confirm-accept")));

        base.driver.findElement(By.id("cart-remove-confirm-accept")).click();

    }

    @Then("^\"([^\"]*)\" does not appears on the cart overlay$")
    public void doesNotAppearsOnTheCartOverlay(String arg0) {
        try {
            Assert.assertEquals(base.driver.findElement(By.xpath("//*[@id=\"addtocart-confirmation\"]/div/div/div[2]/a[3]")).getText(), arg0);
        } catch (Exception e) {
            System.out.println("There is no Vider le Panier option");
        }
    }

    @And("^I am able to give six box on the cart$")
    public void iAmAbleToGiveSixBoxOnTheCart() throws InterruptedException {

        iPickTheFirstItemFromTheList();

        for (int i = 0; i < 6; i++) {

            iClickOnTheAjouterAuPanierButton();
            Thread.sleep(2000);
            base.driver.findElement(By.xpath("//*[@id=\"addtocart-confirmation\"]/div/div/div[2]/a[1]")).click();

        }
    }

    @And("^I click on the cart$")
    public void iClickOnTheCart() {

        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("basket-count")));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("basket-count")));

        base.driver.findElement(By.className("basket-count")).click();
    }

    @Then("^I can checkout with six items$")
    public void iCanCheckoutWithSixItems() {
        base.driver.findElement(By.className("si-cart")).click();
    }

    @And("^I choose from the \"([^\"]*)\" Category the \"([^\"]*)\" sub-category$")
    public void iChooseFromTheCategoryTheSubCategory(String Category, String SubCategory) {

        Actions actions = new Actions(base.driver);
        actions.moveToElement(base.driver.findElement(By.linkText(Category))).perform();

        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(SubCategory)));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(SubCategory)));

        base.driver.findElement(By.linkText(SubCategory)).click();

    }

    @Then("^Search results are displays on the list$")
    public void searchResultsAreDisplaysOnTheList() {
    }
}