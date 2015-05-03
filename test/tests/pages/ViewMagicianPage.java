package tests.pages;

import models.Magician;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the ViewMagician page.
 *
 * When you want to *go* to a page, do new ViewMagicianPage(browser);
 * When you are already *at* a page, do new ViewMagicianPage(browser.getDriver());
 *
 */
public class ViewMagicianPage extends NavigationWrapper {

  /**
   * Go directly to the ViewMagician page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   * @param id      The ID number of the magician to view.
   */
  public ViewMagicianPage(TestBrowser browser, long id) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/viewMagician?id=" + id);
    isAt();
  }


  /**
   * The browser should already be at the ViewMagician page.  Make sure the browser is there.
   *
   * @param webDriver The state of the current test browser.
   */
  public ViewMagicianPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource()).contains("<h3>Experience with Magic</h3>");
  }


  /**
   * See if the browser has all of the values in the Magician object.
   *
   * @param magician A container holding all of the fields to check for in the page.
   */
  public void hasMagician(Magician magician) {
    // Required fields
    assertThat(this.pageSource()).contains(magician.getFirstName());
    assertThat(this.pageSource()).contains(magician.getLastName());
    assertThat(this.pageSource()).contains(magician.getEmail());
    assertThat(this.pageSource()).contains(magician.getMagicianType().getName());

    // Optional fields
    checkOptionalField(magician.getStageName());
    // No image for now
    checkOptionalField(magician.getLocation());
    checkOptionalField(magician.getBiography());
    checkOptionalField(magician.getInterests());
    checkOptionalField(magician.getInfluences());
    checkOptionalField(magician.getYearStarted());
    checkOptionalField(magician.getOrganizations());
    checkOptionalField(magician.getWebsite());
    checkOptionalField(magician.getFacebook());
    checkOptionalField(magician.getTwitter());
    checkOptionalField(magician.getLinkedIn());
    checkOptionalField(magician.getGooglePlus());
    checkOptionalField(magician.getFlickr());
    checkOptionalField(magician.getInstagram());
  }


  /**
   * Click the Edit Profile button.
   *
   * @return The EditMagicianPage.
   */
  public EditMagicianPage clickEditProfileButton() {
    this.findFirst("#editMagician").click();
    return new EditMagicianPage(this.getDriver());
  }


  /**
   * Click the Change Password button.
   *
   * @return The EditUserPage.
   */
  public EditUserPage clickChangePasswordButton() {
    this.findFirst("#changePassword").click();
    return new EditUserPage(this.getDriver());
  }


  /**
   * Click the Return to Magician List button.
   *
   * @return The ListMagiciansPage.
   */
  public ListMagiciansPage clickReturnToMagicianListButton() {
    this.findFirst("#returnToMagicianList").click();
    return new ListMagiciansPage(this.getDriver());
  }


}
