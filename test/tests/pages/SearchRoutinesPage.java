package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the SearchRoutines page.
 */
public class SearchRoutinesPage extends FluentPage {

  private String url;

  /**
   * Create the SearchRoutines page.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public SearchRoutinesPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/searchRoutines";
  }

  /**
   * Create the SearchRoutines page (but actually delete the routine and return to the SearchRoutines page).
   *
   * @param webDriver The driver.
   * @param port      The port.
   * @param id        The id of the routine to delete.
   */
  public SearchRoutinesPage(WebDriver webDriver, int port, int id) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/deleteRoutine?id=" + id;
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Play With Magic");
    assertThat(pageSource().contains("<h1>Search Routines</h1>"));
  }

}
