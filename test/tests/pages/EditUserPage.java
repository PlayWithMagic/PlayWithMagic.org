package tests.pages;

import models.Magician;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the EditUser page.
 *
 * When you want to *go* to a page, do new EditUserPage(browser);
 * When you are already *at* a page, do new EditUserPage(browser.getDriver());
 *
 */
public class EditUserPage extends NavigationWrapper {

  /**
   * Go directly to the EditUser page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public EditUserPage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/editUser");
    isAt();
  }


  /**
   * The browser should already be at the EditUser page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public EditUserPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * See if the browser has all of the values in the Magician object.
   *
   * @param magician A container holding all of the fields to check for in the page.
   */
  public void checkMagician(Magician magician) {
    assertThat(this.pageSource()).contains(magician.getFirstName());
    assertThat(this.pageSource()).contains(magician.getLastName());
    assertThat(this.pageSource()).contains(magician.getEmail());
    assertThat(this.pageSource()).contains(magician.getMagicianType().getName());
    assertThat(this.pageSource()).contains(magician.getPassword());
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource()).contains("<body id=\"editUser\">");
  }


  /**
   * Click the Add or Update button (submit) at the bottom of the page.
   * <p>
   * This returns void because we don't know which page it would render...
   * On success, it goes to EditMagician
   * On error, it stays on EditUser
   */
  public void clickSubmit() {
    this.findFirst("#submit").click();
  }


  /**
   * Select the Magician Type from the listbox.
   *
   * @param magicianTypeName The name of the Magician Type.
   */
  public void selectMagicianType(String magicianTypeName) {
    this.find("#" + magicianTypeName).click();
  }


  /**
   * Set passed values into the form.
   *
   * @param magician A container holding all of the fields to check for in the page.
   */
  public void populateMagician(Magician magician) {
    this.fill("#firstName").with(magician.getFirstName());
    this.fill("#lastName").with(magician.getLastName());
    this.fill("#email").with(magician.getEmail());
    selectMagicianType(magician.getMagicianType().getName());
    this.fill("#password").with(magician.getPassword());
  }


  /**
   * Test to ensure the page does not have required field validation errors.
   */
  public void doesNotHaveRequiredFieldErrors() {
    assertThat(this.pageSource()).doesNotContain("Everybody (except Teller) has a first name.");
    assertThat(this.pageSource()).doesNotContain("A Last Name must be provided.");
    assertThat(this.pageSource()).doesNotContain("An Email address must be provided.");
    assertThat(this.pageSource()).doesNotContain("How would you identify yourself as a magician?");
    assertThat(this.pageSource()).doesNotContain("You need to have a password.");
  }


  /**
   * Test to ensure the page has all of the required field validation errors.
   */
  public void hasRequiredFieldErrors() {
    assertThat(this.pageSource()).contains("Everybody (except Teller) has a first name.");
    assertThat(this.pageSource()).contains("A Last Name must be provided.");
    assertThat(this.pageSource()).contains("An Email address must be provided.");
    assertThat(this.pageSource()).contains("How would you identify yourself as a magician?");
    assertThat(this.pageSource()).contains("You need to have a password.");
  }

}

