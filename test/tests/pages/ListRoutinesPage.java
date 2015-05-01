package tests.pages;

import models.Routine;
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


  /**
   * See if the browser has all of the values in the Routine object.
   *
   * @param routine A container holding all of the fields to check for in the page.
   */
  public void hasRoutine(Routine routine) {
    assertThat(this.pageSource()).contains(routine.getName());
    assertThat(this.pageSource()).contains(routine.getDuration().toString());
  }


  /**
   * Ensure the browser does not have this Routine object.
   *
   * @param routine A container holding all of the fields to check for in the page.
   */
  public void doesNotHaveRoutine(Routine routine) {
    assertThat(this.pageSource()).doesNotContain(routine.getName());
  }


  /**
   * Delete the first routine on the page.  Return back to ListRoutines page.
   *
   * @return The ListMagiciansPage.
   */
  public ListRoutinesPage deleteFirstRoutine() {
    this.findFirst(".deleteRoutine").click();
    return new ListRoutinesPage(this.getDriver());
  }




}
