package tests.pages;

import models.Magician;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

/**
 * Provides test scaffolding for the EditMagician page.
 */
public class EditMagicianPage extends FluentPage {

  private String url;

  /**
   * Create the EditMagician.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public EditMagicianPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/editMagician";
  }

  /**
   * Get the URL for this page.
   *
   * @return The page's URL.
   */
  @Override
  public String getUrl() {
    return this.url;
  }

  /**
   * A test to ensure the rendered page displays the correct content.
   */
  @Override
  public void isAt() {
    assertThat(pageSource().contains("<body id=\"editMagician\">"));
  }


  /**
   * Tests the form on the EditMagician page with provided data.
   *
   * @param firstName       The first name of the magician.
   * @param lastName        The last name of the magician.
   * @param stageName       The stage name of the magician.
   * @param location        Global location.
   * @param biography       Biography of magician.
   * @param interests       Magician's interests in magic.
   * @param influences      Magician's invluences.
   * @param experienceLevel Magician's experience level; pre-set values.
   * @param yearStarted     The year started - used to compute the number of years of experience.
   * @param organizations   Any affiliations or organizations the magician is a member of.
   * @param website         Magician's personal website.
   * @param email           Magician's email address.
   * @param facebook        The magician's facebook account.
   * @param twitter         Magician's Twitter account.
   * @param linkedIn        Magician's LinkedIn account.
   * @param googlePlus      Magician's Google Plus account.
   * @param flickr          Magician's flickr account.
   * @param instagram       Magician's instagram account.
   */
  public void createMagician(String firstName, String lastName, String stageName, String location, String biography,
                             String interests, String influences, String experienceLevel, String yearStarted,
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
    //System.out.println("Experience Level: " + experienceLevel);
    find("select", withId("experienceLevel")).find("option", withText().equalTo(experienceLevel)).click();
    //find("select", withId().equalTo("gender")).find("option", withText().equalTo(gender)).click();
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


  /**
   * Set passed values into the form, then submit it.
   *
   * @param browser The test browser containing the rendered page.
   * @param magician A container holding all of the fields to check for in the page.
   */
  public static void populateMagician(TestBrowser browser, Magician magician) {
    browser.fill("#firstName").with(magician.getFirstName());
    browser.fill("#lastName").with(magician.getLastName());
    browser.fill("#email").with(magician.getEmail());
    browser.find("#" + magician.getExperienceLevel()).click();
    browser.fill("#stageName").with(magician.getStageName());
    browser.fill("#location").with(magician.getLocation());
    browser.fill("#biography").with(magician.getBiography());
    browser.fill("#interests").with(magician.getInterests());
    browser.fill("#influences").with(magician.getInfluences());
    browser.fill("#yearStarted").with(magician.getYearStarted().toString());
    browser.fill("#organizations").with(magician.getOrganizations());
    browser.fill("#website").with(magician.getWebsite());
    browser.fill("#facebook").with(magician.getFacebook());
    browser.fill("#twitter").with(magician.getTwitter());
    browser.fill("#linkedIn").with(magician.getLinkedIn());
    browser.fill("#googlePlus").with(magician.getGooglePlus());
    browser.fill("#flickr").with(magician.getFlickr());
    browser.fill("#instagram").with(magician.getInstagram());
  }

  /**
   * Check the browser can see all of the values in the Magician object.
   *
   * @param browser The test browser containing the redered page.
   * @param magician A container holding all of the fields to check for in the page.
   */
  public static void checkMagician(TestBrowser browser, Magician magician) {
    assertThat(browser.pageSource()).contains(magician.getFirstName());
    assertThat(browser.pageSource()).contains(magician.getLastName());
    assertThat(browser.pageSource()).contains(magician.getEmail());
    assertThat(browser.pageSource()).contains(magician.getExperienceLevel());
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
}

