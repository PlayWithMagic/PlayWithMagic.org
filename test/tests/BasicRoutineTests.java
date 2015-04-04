package tests;

import models.Routine;
import models.RoutineDB;
import org.junit.Test;
import play.libs.F;
import play.test.TestBrowser;
import tests.pages.NewRoutinePage;
import tests.pages.SearchRoutinesPage;

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

    routine2 = new Routine(0, "Test Routine Name 02", "Test Routine Description 02");
    routine2.setDuration(12);
    routine2.setMethod("Test Routine Method 02");
    routine2.setHandling("Test Routine Handling 02");
    routine2.setResetDuration(22);
    routine2.setResetDescription("Test Routine Reset Description 02");

    /* Logger.debug("Routines setup for testing"); */ // Logger doesn't work in JUnit tests w/ Play 2.0 (known issue).
    System.out.println("Test Routines constructed");
  }

  /**
   * Utilize a test browser and the Fluentlenium framework to exercise the Search Routines page.
   */
  @Test
  public void testGetInitialSearchRoutinesPage() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            SearchRoutinesPage searchRoutinesPage = new SearchRoutinesPage(browser.getDriver(), TEST_PORT);
            browser.goTo(searchRoutinesPage);
            searchRoutinesPage.isAt();
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

            SearchRoutinesPage searchRoutinesPage = null;
            NewRoutinePage newRoutinePage = null;

            // Look at the Search Routines page first...
            searchRoutinesPage = new SearchRoutinesPage(browser.getDriver(), TEST_PORT);
            browser.goTo(searchRoutinesPage);
            searchRoutinesPage.isAt();

            // Add a new Routine...
            newRoutinePage = new NewRoutinePage(browser.getDriver(), TEST_PORT);
            browser.goTo(newRoutinePage);
            newRoutinePage.isAt();
            assertThat(browser.pageSource().contains("Create Routine"));

            newRoutinePage.submitForm(routine1);

            assertThat(browser.pageSource()).contains(routine1.getName());
            assertThat(browser.pageSource()).contains(routine1.getDuration().toString());

            long routineId = RoutineDB.getCurrentId() - 1;

            // Update the Routine that was just created...
            newRoutinePage = new NewRoutinePage(browser.getDriver(), TEST_PORT, routineId);
            browser.goTo(newRoutinePage);
            newRoutinePage.isAt();
            assertThat(browser.pageSource().contains("Update Routine"));
            newRoutinePage.testContents(browser, routine1);

            newRoutinePage.submitForm(routine2);

            assertThat(browser.pageSource()).contains(routine2.getName());
            assertThat(browser.pageSource()).contains(routine2.getDuration().toString());

            // Verify that all of the routine updates happened.
            newRoutinePage = new NewRoutinePage(browser.getDriver(), TEST_PORT, routineId);
            browser.goTo(newRoutinePage);
            newRoutinePage.isAt();
            assertThat(browser.pageSource().contains("Update Routine"));
            newRoutinePage.testContents(browser, routine2);

            // Delete a Routine.
            searchRoutinesPage = new SearchRoutinesPage(browser.getDriver(), TEST_PORT, routineId);
            browser.goTo(searchRoutinesPage);
            searchRoutinesPage.isAt();
            assertThat(browser.pageSource()).doesNotContain(routine2.getName());
            assertThat(browser.pageSource()).doesNotContain(routine2.getDuration().toString());
          }
        });
  }

}
