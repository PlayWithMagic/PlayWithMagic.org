package tests.pages;

import models.Magician;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the ViewMagician page.
 *
 * When you want to *go* to a page, do new ViewMagicianPage(browser);
 * When you are already *at* a page, do new ViewMagicianPage(browser.getDriver());
 *
 */
public class ViewMagicianPage extends NavigationWrapper {

  /**
   * Go directly to the ViewMagician page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   * @param id      The ID number of the magician to view.
   */
  public ViewMagicianPage(TestBrowser browser, long id) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/viewMagician?id=" + id);
    isAt();
  }


  /**
   * The browser should already be at the ViewMagician page.  Make sure the browser is there.
   *
   * @param webDriver The state of the current test browser.
   */
  public ViewMagicianPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource().contains("<h3>Experience with Magic</h3>"));
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
    assertThat(this.pageSource()).contains(magician.getStageName());
    // No image for now
    assertThat(this.pageSource()).contains(magician.getLocation());
    assertThat(this.pageSource()).contains(magician.getBiography());
    assertThat(this.pageSource()).contains(magician.getInterests());
    assertThat(this.pageSource()).contains(magician.getInfluences());
    assertThat(this.pageSource()).contains(magician.getYearStarted().toString());
    assertThat(this.pageSource()).contains(magician.getOrganizations());
    assertThat(this.pageSource()).contains(magician.getWebsite());
    assertThat(this.pageSource()).contains(magician.getFacebook());
    assertThat(this.pageSource()).contains(magician.getTwitter());
    assertThat(this.pageSource()).contains(magician.getLinkedIn());
    assertThat(this.pageSource()).contains(magician.getGooglePlus());
    assertThat(this.pageSource()).contains(magician.getFlickr());
    assertThat(this.pageSource()).contains(magician.getInstagram());
  }


  /**
   * Click the Edit Profile button.
   *
   * @return The EditMagicianPage.
   */
  public EditMagicianPage clickEditProfileButton() {
    this.findFirst("#editMagician").click();
    return new EditMagicianPage(this.getDriver());
  }


  /**
   * Click the Return to Magician List button.
   *
   * @return The ListMagiciansPage.
   */
  public ListMagiciansPage clickReturnToMagicianListButton() {
    this.findFirst("#returnToMagicianList").click();
    return new ListMagiciansPage(this.getDriver());
  }


}
