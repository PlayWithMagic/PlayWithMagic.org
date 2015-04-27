package tests;

import models.MagicianDB;
import models.Routine;
import models.RoutineDB;
import models.SetDB;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.libs.F;
import play.test.TestBrowser;
import tests.pages.EditRoutinePage;
import tests.pages.ListRoutinesPage;
import tests.pages.ViewRoutinePage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Test the live interaction of the Routine pages with Chrome.
 */
public class TestRoutineCRUD {

  /**
   * The port number on which to run the tests.
   */
  private static final int TEST_PORT = 3333;

  private static Routine routine1 = null;
  private static Routine routine2 = null;


  /**
   * Populate static objects needed for testing.
   */
  public TestRoutineCRUD() {
    routine1 = new Routine(0, "Test Routine Name 01", "Test Routine Description 01");
    routine1.setDuration(101);
    routine1.setMethod("Test Routine Method 01");
    routine1.setHandling("Test Routine Handling 01");
    routine1.setResetDuration(21);
    routine1.setResetDescription("Test Routine Reset Description 01");
    routine1.setYouTubeUrl("Test YouTube URL 01");
    routine1.setImageUrl("Test Image URL 01");
    routine1.setInspiration("Test Inspiration 01");
    routine1.setPlacement("Test Placement 01");
    routine1.setChoices("Test Choices 01");

    routine2 = new Routine(0, "Test Routine Name 02", "Test Routine Description 02");
    routine2.setDuration(12);
    routine2.setMethod("Test Routine Method 02");
    routine2.setHandling("Test Routine Handling 02");
    routine2.setResetDuration(119);
    routine2.setResetDescription("Test Routine Reset Description 02");
    routine2.setYouTubeUrl("Test YouTube URL 02");
    routine2.setImageUrl("Test Image URL 02");
    routine2.setInspiration("Test Inspiration 02");
    routine2.setPlacement("Test Placement 02");
    routine2.setChoices("Test Choices 02");

    /* Logger.debug("Routines setup for testing"); */ // Logger doesn't work in JUnit tests w/ Play 2.0 (known issue).
    System.out.println("Test Routines constructed");
  }


  /**
   * Utilize a test browser and the Fluentlenium framework to exercise the List Routines page.
   */
  @Test
  public void testGetInitialListRoutinesPage() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
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
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            SetDB.resetSetDB();
            RoutineDB.resetRoutineDB();
            MagicianDB.resetMagicianDB();

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

            // Verify the routine data is in the database...
            browser.findFirst(".editRoutine").click();
            editRoutinePage.testContents(browser, routine1);
            browser.findFirst("#submit").click();
            browser.findFirst(".viewRoutine").click();
            ViewRoutinePage.testContents(browser, routine1);


            // Edit/modify all of the data...                                                   // The button click
            browser.goTo(browser.findFirst(".editRoutine").getElement().getAttribute("href"));  // didn't work, so I
            editRoutinePage.isAt();                                                             // did this instead.
            assertThat(browser.pageSource()).contains("Update Routine");
            editRoutinePage.submitForm(routine2);
            browser.findFirst(".editRoutine").click();
            editRoutinePage.testContents(browser, routine2);

            // Delete a Routine.
            browser.findFirst("#submit").click();
            assertThat(browser.pageSource()).contains(routine2.getName());
            assertThat(browser.pageSource()).contains(routine2.getDuration().toString());
            browser.findFirst(".deleteRoutine").click();
            assertThat(browser.pageSource()).doesNotContain(routine2.getName());
            assertThat(browser.pageSource()).doesNotContain(routine2.getDuration().toString());

          }
        });
  }

}
