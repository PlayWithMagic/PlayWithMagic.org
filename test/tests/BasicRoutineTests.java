package tests;

import models.Routine;
import models.RoutineDB;
import org.junit.Test;
import play.libs.F;
import play.test.TestBrowser;
import tests.pages.EditRoutinePage;
import tests.pages.ListRoutinesPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Test the live interaction of the Routine pages with a simulated browser.
 * <p>
 * Utilizes a test browser and the Fluentlenium framework for testing.
 */
public class BasicRoutineTests {

  /**
   * The port number on which to run the tests.
   */
  private static final int TEST_PORT = 3333;

  private static Routine routine1 = null;
  private static Routine routine2 = null;


  /**
   * Populate the static Routine objects in the constructor.
   */
  public BasicRoutineTests() {
    routine1 = new Routine(0, "Test Routine Name", "Test Routine Description");
    routine1.setDuration(11);
    routine1.setMethod("Test Routine Method");
    routine1.setHandling("Test Routine Handling");
    routine1.setResetDuration(21);
    routine1.setResetDescription("Test Routine Reset Description");
    routine1.setYouTubeUrl("Test YouTube URL");
    routine1.setImageUrl("Test Image URL");

    routine2 = new Routine(0, "Test Routine Name 02", "Test Routine Description 02");
    routine2.setDuration(12);
    routine2.setMethod("Test Routine Method 02");
    routine2.setHandling("Test Routine Handling 02");
    routine2.setResetDuration(22);
    routine2.setResetDescription("Test Routine Reset Description 02");
    routine2.setYouTubeUrl("Test YouTube URL 02");
    routine2.setImageUrl("Test Image URL 02");

    /* Logger.debug("Routines setup for testing"); */ // Logger doesn't work in JUnit tests w/ Play 2.0 (known issue).
    System.out.println("Test Routines constructed");
  }

  /**
   * Utilize a test browser and the Fluentlenium framework to exercise the List Routines page.
   */
  @Test
  public void testGetInitialListRoutinesPage() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            ListRoutinesPage listRoutinesPage = new ListRoutinesPage(browser.getDriver(), TEST_PORT);
            browser.goTo(listRoutinesPage);
            listRoutinesPage.isAt();
          }
        });
  }

  /**
   * Test Routine CRUD.
   * <p>
   * Originally, I had this workflow broken up into individual methods.  However, the Play Framework seems to
   * restart the entire application between method runs -- and this wipes out the in-memory database.
   */
  @Test
  public void testRoutineCrudWorkflow() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();

            ListRoutinesPage listRoutinesPage = null;
            EditRoutinePage editRoutinePage = null;

            // Look at the List Routines page first...
            listRoutinesPage = new ListRoutinesPage(browser.getDriver(), TEST_PORT);
            browser.goTo(listRoutinesPage);
            listRoutinesPage.isAt();

            // Add a new Routine...
            editRoutinePage = new EditRoutinePage(browser.getDriver(), TEST_PORT);
            browser.goTo(editRoutinePage);
            editRoutinePage.isAt();
            assertThat(browser.pageSource()).contains("Create Routine");

            editRoutinePage.submitForm(routine1);

            assertThat(browser.pageSource()).contains(routine1.getName());
            assertThat(browser.pageSource()).contains(routine1.getDuration().toString());

            long routineId = RoutineDB.getCurrentId() - 1;

            // Update the Routine that was just created...
            editRoutinePage = new EditRoutinePage(browser.getDriver(), TEST_PORT, routineId);
            browser.goTo(editRoutinePage);
            editRoutinePage.isAt();
            assertThat(browser.pageSource()).contains("Update Routine");
            editRoutinePage.testContents(browser, routine1);

            editRoutinePage.submitForm(routine2);

            assertThat(browser.pageSource()).contains(routine2.getName());
            assertThat(browser.pageSource()).contains(routine2.getDuration().toString());

            // Verify that all of the routine updates happened.
            editRoutinePage = new EditRoutinePage(browser.getDriver(), TEST_PORT, routineId);
            browser.goTo(editRoutinePage);
            editRoutinePage.isAt();
            assertThat(browser.pageSource()).contains("Update Routine");
            editRoutinePage.testContents(browser, routine2);

            // Delete a Routine.
            listRoutinesPage = new ListRoutinesPage(browser.getDriver(), TEST_PORT, routineId);
            browser.goTo(listRoutinesPage);
            listRoutinesPage.isAt();
            assertThat(browser.pageSource()).doesNotContain(routine2.getName());
            assertThat(browser.pageSource()).doesNotContain(routine2.getDuration().toString());
          }
        });
  }

}
