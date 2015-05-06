package tests.pages;

import models.Magician;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the EditMagician page.
 *
 * When you want to *go* to a page, do new EditMagicianPage(browser);
 * When you are already *at* a page, do new EditMagicianPage(browser.getDriver());
 *
 */
public class EditMagicianPage extends NavigationWrapper {

  /**
   * Go directly to the EditMagician page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public EditMagicianPage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/editMagician");
    isAt();
  }


  /**
   * The browser should already be at the EditMagician page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public EditMagicianPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource()).contains("<h1>Magician Profile</h1>");
  }


  /**
   * See if the browser has all of the values in the Magician object.
   *
   * @param magician A container holding all of the fields to check for in the page.
   */
  public void checkMagician(Magician magician) {
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
   * Click the Add or Update button (submit) at the bottom of the page.
   * <p>
   * This returns void because we don't know which page it would render...
   * On success, it goes to ListMagicians
   * On error, it stays on EditMagician
   */
  public void clickSubmit() {
    this.findFirst("#submit").click();
  }


  /**
   * Select the Magician Type from the listbox.
   *
   * @param magicianTypeName The name of the Magician Type.
   */
  public void selectMagicianType(String magicianTypeName) {
    this.find("#" + magicianTypeName).click();
  }

  /**
   * Set passed values into the form.
   *
   * @param magician A container holding all of the fields to check for in the page.
   */
  public void populateMagician(Magician magician) {
    // Required fields
    fillRequiredField("#firstName", magician.getFirstName());
    fillRequiredField("#lastName", magician.getLastName());
    fillRequiredField("#email", magician.getEmail());
    selectMagicianType(magician.getMagicianType().getName());

    // Optional fields
    fillOptionalField("#stageName", magician.getStageName());
    fillOptionalField("#location", magician.getLocation());
    fillOptionalField("#biography", magician.getBiography());
    fillOptionalField("#interests", magician.getInterests());
    fillOptionalField("#influences", magician.getInfluences());
    fillOptionalField("#yearStarted", magician.getYearStarted());
    fillOptionalField("#organizations", magician.getOrganizations());
    fillOptionalField("#website", magician.getWebsite());
    fillOptionalField("#facebook", magician.getFacebook());
    fillOptionalField("#twitter", magician.getTwitter());
    fillOptionalField("#linkedIn", magician.getLinkedIn());
    fillOptionalField("#googlePlus", magician.getGooglePlus());
    fillOptionalField("#flickr", magician.getFlickr());
    fillOptionalField("#instagram", magician.getInstagram());
  }


  /**
   * Test to ensure the page does not have required field validation errors.
   */
  public void doesNotHaveRequiredFieldErrors() {
    assertThat(this.pageSource()).doesNotContain("Everybody (except Teller) has a first name.");
    assertThat(this.pageSource()).doesNotContain("A Last Name must be provided.");
    assertThat(this.pageSource()).doesNotContain("An Email address must be provided.");
    assertThat(this.pageSource()).doesNotContain("How would you identify yourself as a magician?");
  }


  /**
   * Test to ensure the page has all of the required field validation errors.
   */
  public void hasRequiredFieldErrors() {
    assertThat(this.pageSource()).contains("Everybody (except Teller) has a first name.");
    assertThat(this.pageSource()).contains("A Last Name must be provided.");
    assertThat(this.pageSource()).contains("An Email address must be provided.");
    assertThat(this.pageSource()).contains("How would you identify yourself as a magician?");
  }

}
