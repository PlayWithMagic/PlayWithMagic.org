package tests.pages;

import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides scaffolding to remotely control the ListRoutines page for testing.
 *
 * When you want to *go* to a page, do new ListRoutinesPage(browser);
 * When you are already *at* a page, do new ListRoutinesPage(browser.getDriver());
 *
 */
public class ListRoutinesPage extends NavigationWrapper {

  /**
   * Go directly to the ListRoutines page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public ListRoutinesPage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/listRoutines");
    isAt();
  }


  /**
   * The browser should already be at the ListRoutinesPage page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public ListRoutinesPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource().contains("<h1>Current Routines</h1>"));
  }

}
