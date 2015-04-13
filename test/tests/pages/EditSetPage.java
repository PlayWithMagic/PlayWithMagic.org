package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Provides test scaffolding for the EditMagician page.
 */
public class EditSetPage extends FluentPage {

  private String url;

  /**
   * Create the EditSet page object.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public EditSetPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/editSet";
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
    assertThat(pageSource().contains("<body id=\"editSet\">"));
  }


  /**
   * Tests the form on the EditSet page with provided data.
   *
   * @param name           The name of the Set.
   * @param description    The description of the Set.
   * @param routines       The list of routine IDs in the Set.
   */
  public void createSet(String name, String description, List<Long> routines) {
    fill("#name").with(name);
    fill("#description").with(description);
    for (long routine : routines) {
      String value = String.valueOf(routine);
      find("input", withId(value)).click();
    }
    submit("#submit");
  }
}

