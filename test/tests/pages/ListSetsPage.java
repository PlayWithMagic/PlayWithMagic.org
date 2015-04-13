package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the ListRoutines page.
 */
public class ListSetsPage extends FluentPage {

  private String url;

  /**
   * Create the ListSets page.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public ListSetsPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/listSets";
  }

  /**
   * Create the ListSets page (but actually delete the Set and return to the ListSets page).
   *
   * @param webDriver The driver.
   * @param port      The port.
   * @param id        The id of the routine to delete.
   */
  public ListSetsPage(WebDriver webDriver, int port, long id) {
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
    assertThat(pageSource().contains("<h1>Current Sets</h1>"));
  }

  /**
   * Checks that the ListSets page contains a given Set, with only name.
   *
   * @param name        The name of the set.
   */
  public void hasSet(String name) {
    assertThat(pageSource()).contains(name);
  }

}
