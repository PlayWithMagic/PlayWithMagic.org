package tests.pages;

import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Provides scaffolding to remotely control the EditSet page for testing.
 *
 * When you want to *go* to a page, do new EditSetPage(browser);
 * When you are already *at* a page, do new EditSetPage(browser.getDriver());
 *
 */
public class EditSetPage extends NavigationWrapper {

  /**
   * Go directly to the EditSet page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public EditSetPage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/editSet");
    isAt();
  }


  /**
   * The browser should already be at the EditSet page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public EditSetPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource().contains("<h1>Create Set</h1>") || pageSource().contains("<h1>Update Set</h1>"));
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

