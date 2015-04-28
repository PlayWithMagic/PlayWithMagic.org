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
public class EditRoutinePage extends FluentPage {
  private String url;

  /**
   * Create a EditRoutine Page (for a Create Routine action).
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public EditRoutinePage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/editRoutine";
  }

  /**
   * Create a EditRoutine Page (for an Update Routine action).
   *
   * @param webDriver The driver.
   * @param port      The port.
   * @param id        The Routine ID of the routine we shall edit.
   */
  public EditRoutinePage(WebDriver webDriver, int port, long id) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/editRoutine?id=" + id;
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

    submit("#submit");
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

}
