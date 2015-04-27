package tests.pages;

import models.Routine;
import play.test.TestBrowser;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the ViewRoutine page.
 */
public class ViewRoutinePage {
  /**
   * Test the contents of the page against a Routine.
   *
   * @param browser The test browser containing the rendered page.
   * @param routine A container holding all of the fields to check for in the page.
   */
  public static void testContents(TestBrowser browser, Routine routine) {
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
