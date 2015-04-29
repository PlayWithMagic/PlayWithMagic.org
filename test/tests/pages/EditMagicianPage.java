package tests.pages;

import models.Magician;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

/**
 * Provides test scaffolding for the EditMagician page.
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
    assertThat(pageSource().contains("<h1>Magician Profile</h1>"));
  }


  /**
   * Click the Add or Update button (submit) at the bottom of the page.
   *
   * This returns void because we don't know which page it would render...
   *   On success, it goes to ListMagicians
   *   On error, it stays on EditMagician
   */
  public void clickSubmit() {
    this.findFirst("#submit").click();
  }


  //TODO:  Check this method
  /**
   * Set passed values into the form, then submit it.
   *
   * @param magician A container holding all of the fields to check for in the page.
   */
  public void populateMagician(Magician magician) {
    this.fill("#firstName").with(magician.getFirstName());
    this.fill("#lastName").with(magician.getLastName());
    this.fill("#email").with(magician.getEmail());
    this.find("#" + magician.getMagicianType().getName()).click();
    this.fill("#stageName").with(magician.getStageName());
    this.fill("#location").with(magician.getLocation());
    this.fill("#biography").with(magician.getBiography());
    this.fill("#interests").with(magician.getInterests());
    this.fill("#influences").with(magician.getInfluences());
    this.fill("#yearStarted").with(magician.getYearStarted().toString());
    this.fill("#organizations").with(magician.getOrganizations());
    this.fill("#website").with(magician.getWebsite());
    this.fill("#facebook").with(magician.getFacebook());
    this.fill("#twitter").with(magician.getTwitter());
    this.fill("#linkedIn").with(magician.getLinkedIn());
    this.fill("#googlePlus").with(magician.getGooglePlus());
    this.fill("#flickr").with(magician.getFlickr());
    this.fill("#instagram").with(magician.getInstagram());
  }

  //TODO: Check this method
  /**
   * Check the browser can see all of the values in the Magician object.
   *
   * @param browser  The test browser containing the redered page.
   * @param magician A container holding all of the fields to check for in the page.
   */
  public static void checkMagician(TestBrowser browser, Magician magician) {
    assertThat(browser.pageSource()).contains(magician.getFirstName());
    assertThat(browser.pageSource()).contains(magician.getLastName());
    assertThat(browser.pageSource()).contains(magician.getEmail());
    assertThat(browser.pageSource()).contains(magician.getMagicianType().getName());
    assertThat(browser.pageSource()).contains(magician.getStageName());
    // No image for now
    assertThat(browser.pageSource()).contains(magician.getLocation());
    assertThat(browser.pageSource()).contains(magician.getBiography());
    assertThat(browser.pageSource()).contains(magician.getInterests());
    assertThat(browser.pageSource()).contains(magician.getInfluences());
    assertThat(browser.pageSource()).contains(magician.getYearStarted().toString());
    assertThat(browser.pageSource()).contains(magician.getOrganizations());
    assertThat(browser.pageSource()).contains(magician.getWebsite());
    assertThat(browser.pageSource()).contains(magician.getFacebook());
    assertThat(browser.pageSource()).contains(magician.getTwitter());
    assertThat(browser.pageSource()).contains(magician.getLinkedIn());
    assertThat(browser.pageSource()).contains(magician.getGooglePlus());
    assertThat(browser.pageSource()).contains(magician.getFlickr());
    assertThat(browser.pageSource()).contains(magician.getInstagram());
  }


  // TODO: Check this method
  /**
   * Tests the form on the EditMagician page with provided data.
   *
   * @param firstName     The first name of the magician.
   * @param lastName      The last name of the magician.
   * @param stageName     The stage name of the magician.
   * @param location      Global location.
   * @param biography     Biography of magician.
   * @param interests     Magician's interests in magic.
   * @param influences    Magician's invluences.
   * @param magicianType  Magician's experience level; pre-set values.
   * @param yearStarted   The year started - used to compute the number of years of experience.
   * @param organizations Any affiliations or organizations the magician is a member of.
   * @param website       Magician's personal website.
   * @param email         Magician's email address.
   * @param facebook      The magician's facebook account.
   * @param twitter       Magician's Twitter account.
   * @param linkedIn      Magician's LinkedIn account.
   * @param googlePlus    Magician's Google Plus account.
   * @param flickr        Magician's flickr account.
   * @param instagram     Magician's instagram account.
   */
  public void createMagician(String firstName, String lastName, String stageName, String location, String biography,
                             String interests, String influences, String magicianType, String yearStarted,
                             String organizations, String website, String email, String facebook,
                             String twitter, String linkedIn, String googlePlus, String flickr, String instagram) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#email").with(email);
    fill("#stageName").with(stageName);
    fill("#location").with(location);
    fill("#biography").with(biography);
    fill("#interests").with(interests);
    fill("#influences").with(influences);
    // System.out.println("MagicianType = [" + magicianType + "]");
    find("select", withId("magicianType")).find("option", withText().equalTo(magicianType)).click();
    fill("#yearStarted").with(yearStarted);
    fill("#organizations").with(organizations);
    fill("#website").with(website);
    fill("#facebook").with(facebook);
    fill("#twitter").with(twitter);
    fill("#linkedIn").with(linkedIn);
    fill("#googlePlus").with(googlePlus);
    fill("#flickr").with(flickr);
    fill("#instagram").with(instagram);

    submit("#submit");
  }
}

