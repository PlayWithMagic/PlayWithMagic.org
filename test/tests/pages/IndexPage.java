package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides testing support for the Index page.
 */
public class IndexPage extends FluentPage {

  private String url;

  /**
   * Create the IndexPage.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Home - digits");
  }

  /**
   * Checks that the index page table has a given contact.
   *
   * @param firstName The first name.
   * @param lastName  The last name.
   * @param telephone The telephone number.
   */
  public void hasContact(String firstName, String lastName, String telephone) {
    assertThat(pageSource()).contains(firstName);
    assertThat(pageSource()).contains(lastName);
    assertThat(pageSource()).contains(telephone);
  }

}

