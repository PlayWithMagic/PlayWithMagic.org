package tests.pages;

import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;


/**
 * Provides scaffolding to remotely control the DeleteUser page for testing.
 */
public class DeleteUserPage extends NavigationWrapper {

  /**
   * Go directly to the DeleteUser page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public DeleteUserPage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/deleteMagician");
    isAt();
  }


  /**
   * The browser should already be at the DeleteUser page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public DeleteUserPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource().contains("Please note that once you delete your account, it cannot be recovered!"));
  }


  /**
   * Populate the DeleteUser form with data.
   *
   * @param password The password to confirm the deletion of the account.
   */
  public void populateDeleteUser(String password) {
    this.fillRequiredField("#password", password);
  }


  /**
   * Click the DeleteUser button (submit) at the bottom of the page.
   */
  public void clickSubmit() {
    this.findFirst("#submit").click();
  }


  /**
   * Test to ensure the page does not have required field validation errors.
   */
  public void doesNotHaveRequiredFieldErrors() {
    assertThat(this.pageSource()).doesNotContain("You must enter a password to confirm account deletion.");
  }


  /**
   * Test to ensure the page has all of the required field validation errors.
   */
  public void hasRequiredFieldErrors() {
    assertThat(this.pageSource()).contains("You must enter a password to confirm account deletion.");
  }
}