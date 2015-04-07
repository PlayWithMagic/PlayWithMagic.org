package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the listMagicians page.
 */
public class ListMagiciansPage extends FluentPage {

  private String url;

  /**
   * Create the listMagicians Page.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public ListMagiciansPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/listMagicians";
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
    assertThat(pageSource().contains("<body id=\"viewMagician\">"));
  }

  /**
   * Checks that the EditMagician page contains a given magician, with only Name, Stage Name, Skill Level, and
   * Interests.
   *
   * @param fullName        The combined first and last name of the magician.
   * @param stageName       The stage name of the magician.
   * @param experienceLevel User's experience level; pre-set values.
   */
  public void hasMagician(String fullName, String stageName, String experienceLevel) {
    assertThat(pageSource()).contains(fullName);
    assertThat(pageSource()).contains(stageName);
    assertThat(pageSource()).contains(experienceLevel);
  }

}

