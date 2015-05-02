package tests.pages;

import models.Magician;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the ListMagicians page.
 *
 * When you want to *go* to a page, do new ListMagiciansPage(browser);
 * When you are already *at* a page, do new ListMagiciansPage(browser.getDriver());
 *
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
   * The browser should already be at the ListMagicians page.  Make sure the browser is there.
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
    assertThat(pageSource()).contains("<h1>Current Magicians</h1>");
  }


  /**
   * Checks the ListMagician page contains a given magician.
   *
   * @param magician A magician that should be listed on this page.
   */
  public void hasMagician(Magician magician) {
    assertThat(pageSource()).contains(magician.getFirstName() + " " + magician.getLastName());

    if (magician.getStageName() != null) {
      assertThat(pageSource()).contains(magician.getStageName());
    }

    assertThat(pageSource()).contains(magician.getMagicianType().getName());
  }


  /**
   * Checks the ListMagician page does not contain a given magician.
   *
   * @param magician A magician that should be listed on this page.
   */
  public void doesNotHaveMagician(Magician magician) {
    assertThat(pageSource()).doesNotContain(magician.getFirstName() + " " + magician.getLastName());

    if (magician.getStageName() != null) {
      assertThat(pageSource()).doesNotContain(magician.getStageName());
    }
  }


  /**
   * Delete the first magician in the page.  Return back to ListMagicians page.
   *
   * @return The ListMagiciansPage.
   */
  public ListMagiciansPage deleteFirstMagician() {
    this.findFirst(".deleteMagician").click();
    return new ListMagiciansPage(this.getDriver());
  }


  /**
   * Edit the first user in the page by going to the EditUser page.
   *
   * @return The EditUserPage.
   */
  public EditUserPage changeFirstMagicianPassword() {
    this.findFirst(".changePassword").click();
    return new EditUserPage(this.getDriver());
  }


  /**
   * Edit the first magician in the page by going to the EditMagician page.
   *
   * @return The EditMagicianPage.
   */
  public EditMagicianPage editFirstMagician() {
    this.findFirst(".editMagician").click();
    return new EditMagicianPage(this.getDriver());
  }


  /**
   * View the first magician in the page.
   *
   * @return The ViewMagicianPage.
   */
  public ViewMagicianPage viewFirstMagician() {
    this.findFirst(".viewMagician").click();
    return new ViewMagicianPage(this.getDriver());
  }

}
