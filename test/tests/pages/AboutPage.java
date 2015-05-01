package tests.pages;

import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;


/**
 * Provides scaffolding to remotely control the About page for testing.
 *
 * When you want to *go* to a page, do new AboutPage(browser);
 * When you are already *at* a page, do new AboutPage(browser.getDriver());
 *
 */
public class AboutPage extends NavigationWrapper {

  /**
   * Go directly to the About page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public AboutPage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/about");
    isAt();
  }


  /**
   * The browser should already be at the About page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public AboutPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource().contains("About this Website"));
    assertThat(pageSource().contains("Play With Magic was written by:"));
  }
}
