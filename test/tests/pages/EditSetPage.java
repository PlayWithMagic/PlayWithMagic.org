package tests.pages;

import models.Routine;
import models.Set;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

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
    assertThat(pageSource()).contains("<body id=\"editSet\">");
  }


  /**
   * Click the Add or Update button (submit) at the bottom of the page.
   * <p>
   * This returns void because we don't know which page it would render...
   *   On success, it goes to ListSets
   *   On error, it stays on EditSet
   */
  public void clickSubmit() {
    this.findFirst("#submit").click();
  }


  /**
   * Set passed values into the form.
   *
   * @param set A container holding all of the fields to populate the Set with.
   */
  public void populateSet(Set set) {
    // Required fields
    fillRequiredField("#name", set.getName());
    fillRequiredField("#description", set.getDescription());

    for (Routine routine : set.getRoutines()) {
      String value = String.valueOf(routine.getId());
      find("input", withId(value)).click();
    }
  }


  /**
   * Test to ensure the page does not have required field validation errors.
   */
  public void doesNotHaveRequiredFieldErrors() {
    assertThat(this.pageSource()).doesNotContain("You must provide a name for your Set.");
    assertThat(this.pageSource()).doesNotContain("Please provide a description of this Set.");
    // assertThat(this.pageSource()).doesNotContain("Please select at least one Routine for a Set.");
  }


  /**
   * Test to ensure the page has all of the required field validation errors.
   */
  public void hasRequiredFieldErrors() {
    assertThat(this.pageSource()).contains("You must provide a name for your Set.");
    assertThat(this.pageSource()).contains("Please provide a description of this Set.");
    // assertThat(this.pageSource()).contains("Please select at least one Routine for a Set.");
  }

}

