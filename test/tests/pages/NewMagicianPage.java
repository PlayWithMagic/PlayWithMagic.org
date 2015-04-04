package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

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
   * @param firstName       The first name of the magician.
   * @param lastName        The last name of the magician.
   * @param stageName       The stage name of the magician.
   * @param location        Global location.
   * @param biography       Biography of magician.
   * @param interests       Magician's interests in magic.
   * @param influences      Magician's invluences.
   * @param experienceLevel Magician's experience level; pre-set values.
   * @param yearsPracticing Number of years of experience.
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
    System.out.println("Experience Level: " + experienceLevel);
    find("select", withId("experienceLevel")).find("option", withText().equalTo(experienceLevel)).click();
    //find("select", withId().equalTo("gender")).find("option", withText().equalTo(gender)).click();
    fill("#yearsPracticing").with(yearsPracticing);
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

