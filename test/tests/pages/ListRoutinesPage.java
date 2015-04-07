package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the ListRoutines page.
 */
public class ListRoutinesPage extends FluentPage {

  private String url;

  /**
   * Create the ListRoutines page.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public ListRoutinesPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/listRoutines";
  }

  /**
   * Create the ListRoutines page (but actually delete the routine and return to the ListRoutines page).
   *
   * @param webDriver The driver.
   * @param port      The port.
   * @param id        The id of the routine to delete.
   */
  public ListRoutinesPage(WebDriver webDriver, int port, long id) {
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
    assertThat(pageSource().contains("<h1>Current Routines</h1>"));
  }

}
