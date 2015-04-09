package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the About page.
 */
public class AboutPage extends FluentPage {

  private String url;

  /**
   * Create the About Page.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public AboutPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/about";
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
    assertThat(title()).isEqualTo("Play With Magic");
    assertThat(pageSource().contains("About this Website"));
    assertThat(pageSource().contains("Play With Magic was written by:"));
  }
}

