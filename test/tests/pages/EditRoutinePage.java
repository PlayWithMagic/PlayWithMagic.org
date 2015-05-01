package tests.pages;

import models.Routine;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides scaffolding to remotely control the EditRoutine page for testing.
 *
 * When you want to *go* to a page, do new EditRoutinePage(browser);
 * When you are already *at* a page, do new EditRoutinePage(browser.getDriver());
 *
 */
public class EditRoutinePage extends NavigationWrapper {

  /**
   * Go directly to the EditRoutine page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public EditRoutinePage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/editRoutine");
    isAt();
  }


  /**
   * The browser should already be at the EditRoutine page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public EditRoutinePage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource().contains("<h1>Create Routine</h1>") || pageSource().contains("<h1>Update Routine</h1>"));
  }

  /**
   * Click the Add or Update button (submit) at the bottom of the page.
   * <p>
   * This returns void because we don't know which page it would render...
   *   On success, it goes to ListRoutines
   *   On error, it stays on EditRoutine
   */
  public void clickSubmit() {
    this.findFirst("#submit").click();
  }



  /**
   * Set passed values into the form.
   *
   * @param routine A container holding all of the fields to populate the Routine with.
   */
  public void submitForm(Routine routine) {
    fill("#name").with(routine.getName());
    fill("#description").with(routine.getDescription());
    fill("#duration").with(routine.getDuration().toString());
    if (routine.getMethod() != null) {
      fill("#method").with(routine.getMethod());
    }
    if (routine.getHandling() != null) {
      fill("#handling").with(routine.getHandling());
    }
    if (routine.getResetDuration() != null) {
      fill("#resetDuration").with(routine.getResetDuration().toString());
    }
    if (routine.getResetDescription() != null) {
      fill("#resetDescription").with(routine.getResetDescription());
    }
    if (routine.getYouTubeUrl() != null) {
      fill("#youTubeUrl").with(routine.getYouTubeUrl());
    }
    if (routine.getImageUrl() != null) {
      fill("#imageUrl").with(routine.getImageUrl());
    }
    if (routine.getInspiration() != null) {
      fill("#inspiration").with(routine.getInspiration());
    }
    if (routine.getPlacement() != null) {
      fill("#placement").with(routine.getPlacement());
    }
    if (routine.getChoices() != null) {
      fill("#choices").with(routine.getChoices());
    }
  }


  /**
   * Test the contents of the page against a Routine.
   *
   * @param browser The test browser containing the rendered page.
   * @param routine A container holding all of the fields to check for in the page.
   */
  public void testContents(TestBrowser browser, Routine routine) {
    assertThat(browser.pageSource()).contains(routine.getName());
    assertThat(browser.pageSource()).contains(routine.getDescription());
    assertThat(browser.pageSource()).contains(routine.getDuration().toString());
    assertThat(browser.pageSource()).contains(routine.getMethod());
    assertThat(browser.pageSource()).contains(routine.getHandling());
    assertThat(browser.pageSource()).contains(routine.getResetDuration().toString());
    assertThat(browser.pageSource()).contains(routine.getResetDescription());
    assertThat(browser.pageSource()).contains(routine.getYouTubeUrl());
    assertThat(browser.pageSource()).contains(routine.getImageUrl());
    assertThat(browser.pageSource()).contains(routine.getInspiration());
    assertThat(browser.pageSource()).contains(routine.getPlacement());
    assertThat(browser.pageSource()).contains(routine.getChoices());
  }


  /**
   * Test to ensure the page does not have required field validation errors.
   */
  public void doesNotHaveRequiredFieldErrors() {
    assertThat(this.pageSource()).doesNotContain("Your routine's gotta have a name.");
    assertThat(this.pageSource()).doesNotContain("A name's not enough. Please write a brief description of your routine.");
    assertThat(this.pageSource()).doesNotContain("The average time to perform a basic rendition of this routine in minutes.");
  }


  /**
   * Test to ensure the page has all of the required field validation errors.
   */
  public void hasRequiredFieldErrors() {
    assertThat(this.pageSource()).contains("Your routine's gotta have a name.");
    assertThat(this.pageSource()).contains("A name's not enough. Please write a brief description of your routine.");
    assertThat(this.pageSource()).contains("The average time to perform a basic rendition of this routine in minutes.");
  }


}
