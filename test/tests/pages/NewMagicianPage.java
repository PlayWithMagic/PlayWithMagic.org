package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Provides test scaffolding for the NewMagician page.
 */
public class NewMagicianPage extends FluentPage {

  private String url;

  /**
   * Create the NewMagician.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public NewMagicianPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/newMagician";
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
    assertThat(pageSource().contains("<body id=\"newMagician\">"));
  }


  /**
   * Tests the form on the NewMagician page with provided data.
   *
   * @param firstName       The first name of the user.
   * @param lastName        The last name of the magician.
   * @param stageName       The stage name of the magician.
   * @param location        Global location.
   * @param biography       Biography of user.
   * @param interests       User's interests in magic.
   * @param influences      User's invluences.
   * @param experienceLevel User's experience level; pre-set values.
   * @param yearsPracticing Number of years of experience.
   * @param organizations   Any affiliations or organizations the user is a member of.
   * @param website         User's personal website.
   * @param email           User's email address.
   * @param facebook        The user's facebook account.
   * @param twitter         User's Twitter account.
   * @param linkedIn        User's LinkedIn account.
   * @param googlePlus      User's Google Plus account.
   * @param flickr          User's flickr account.
   * @param instagram       User's instagram account.
   */
  public void createMagician(String firstName, String lastName, String stageName, String location, String biography,
                             String interests, String influences, String experienceLevel, String yearsPracticing,
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
    find("select", withId("experienceLevel")).find("option", withId(experienceLevel)).click();
    fill("#yearsPracticing").with(yearsPracticing);
    fill("#organizations").with(organizations);
    fill("#website").with(website);
    fill("#facebook").with(facebook);
    fill("#twitter").with(twitter);
    fill("#linkedIn").with(linkedIn);
    fill("#linkedIn").with(linkedIn);
    fill("#googlePlus").with(googlePlus);
    fill("#flickr").with(flickr);
    fill("#instagram").with(instagram);
    submit("#submit");
  }
}

