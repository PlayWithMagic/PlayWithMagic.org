package tests.pages;

import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the ListMagicians page.
 */
public class ListMagiciansPage extends NavigationWrapper {

  /**
   * Go directly to the ListMagicians page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public ListMagiciansPage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/listMagicians");
    isAt();
  }


  /**
   * The browser should already be at the ListMagicians page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public ListMagiciansPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource().contains("<h1>Current Magicians</h1>"));
  }


  /**
   * Checks the ListMagician page contains a given magician.
   *
   * @param fullName        The combined first and last name of the magician.
   * @param stageName       The stage name of the magician.
   * @param experienceLevel User's experience level; pre-set values.
   */
  public void hasMagician(String fullName, String stageName, String experienceLevel) {
    assertThat(pageSource()).contains(fullName);
    if (stageName != null) {
      assertThat(pageSource()).contains(stageName);
    }
    assertThat(pageSource()).contains(experienceLevel);
  }


  /**
   * Checks the ListMagician page does not contain a given magician.
   *
   * @param fullName        The combined first and last name of the magician.
   * @param stageName       The stage name of the magician.
   * @param experienceLevel User's experience level; pre-set values.
   */
  public void doesNotHaveMagician(String fullName, String stageName, String experienceLevel) {
    assertThat(pageSource()).doesNotContain(fullName);
    if (stageName != null) {
      assertThat(pageSource()).doesNotContain(stageName);
    }
    assertThat(pageSource()).doesNotContain(experienceLevel);
  }


  /**
   * Delete the first magician in the page.
   *
   * @return The ListMagiciansPage.
   */
  public ListMagiciansPage deleteFirstMagician() {
    this.findFirst(".deleteMagician").click();
    return new ListMagiciansPage(this.getDriver());
  }

}
