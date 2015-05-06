package tests.pages;

import models.Magician;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;


/**
 * Provides scaffolding to remotely control the Login page for testing.
 */
public class LoginPage extends NavigationWrapper {

  /**
   * Go directly to the Login page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public LoginPage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/login");
    isAt();
  }


  /**
   * The browser should already be at the Login page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public LoginPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource().contains("Please log in"));
  }


  /**
   * Populate the login form with data.
   *
   * @param magician A container holding all of the fields to populate.
   */
  public void populateLogin(Magician magician) {
    this.fillRequiredField("#email", magician.getEmail());
    this.fillRequiredField("#password", magician.getPassword());
  }


  /**
   * Click the Login button (submit) at the bottom of the page.
   */
  public void clickSubmit() {
    this.findFirst("#submit").click();
  }


  /**
   * Test to ensure the page has all of the required field validation errors.
   */
  public void hasRequiredFieldErrors() {
    assertThat(this.pageSource()).contains("error with login credentials");
  }
}