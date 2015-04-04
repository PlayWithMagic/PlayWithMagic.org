package tests.pages;

import models.Routine;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.Logger;
import play.test.TestBrowser;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the New Routine page.
 */
public class NewRoutinePage extends FluentPage {
  private String url;

  /**
   * Create a NewRoutine Page (for a Create Routine action).
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public NewRoutinePage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/newRoutine";
  }

  /**
   * Create a NewRoutine Page (for an Update Routine action).
   *
   * @param webDriver The driver.
   * @param port      The port.
   * @param id        The Routine ID of the routine we shall edit.
   */
  public NewRoutinePage(WebDriver webDriver, int port, int id) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/newRoutine?id=" + id;
  }

  @Override
  public String getUrl() {
    Logger.debug(this.url);
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Play With Magic");
    assertThat(pageSource().contains("Create Routine") || pageSource().contains("Update Routine"));
  }

  /**
   * Set passed values into the form, then submit it.
   *
   * @param routine A container holding all of the fields to populate the Routine with.
   */
  public void submitForm(Routine routine) {
    fill("#name").with(routine.getName());
    fill("#description").with(routine.getDescription());
    fill("#duration").with(routine.getDuration().toString());
    fill("#method").with(routine.getMethod());
    fill("#handling").with(routine.getHandling());
    fill("#resetDuration").with(routine.getResetDuration().toString());
    fill("#resetDescription").with(routine.getResetDescription());

    submit("#submit");
  }

  /**
   * Test the contents of the page against a Routine
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
  }

}
