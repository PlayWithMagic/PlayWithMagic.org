package tests.pages;

import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides scaffolding to remotely control the ListSets page for testing.
 *
 * When you want to *go* to a page, do new ListSetsPage(browser);
 * When you are already *at* a page, do new ListSetsPage(browser.getDriver());
 *
 */
public class ListSetsPage extends NavigationWrapper {

  /**
   * Go directly to the ListSets page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public ListSetsPage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/listSets");
    isAt();
  }


  /**
   * The browser should already be at the ListSets page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public ListSetsPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource().contains("<h1>Current Sets</h1>"));
  }


  /**
   * Checks that the ListSets page contains a given Set.
   *
   * @param name The name of the set.
   */
  public void hasSet(String name) {
    assertThat(pageSource()).contains(name);
  }

}
