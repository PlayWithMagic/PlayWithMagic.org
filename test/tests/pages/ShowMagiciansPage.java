package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Provides test scaffolding for the showMagicians page.
 */
public class ShowMagiciansPage extends FluentPage {

  private String url;

  /**
   * Create the showMagicians Page.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public ShowMagiciansPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/showMagicians";
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
    assertThat(pageSource().contains("<body id=\"showMagician\">"));
  }

  /**
   * Checks that the NewMagician page contains a given magician, with only Name, Stage Name, Skill Level, and Interests.
   *
   * @param fullName        The combined first and last name of the magician.
   * @param stageName       The stage name of the magician.
   * @param interests       User's interests in magic.
   * @param experienceLevel User's experience level; pre-set values.
   */
  public void hasMagician(String fullName, String stageName, String interests, String experienceLevel) {
    assertThat(pageSource()).contains(fullName);
    assertThat(pageSource()).contains(stageName);
    assertThat(pageSource()).contains(experienceLevel);
    assertThat(pageSource()).contains(interests);
  }

}

