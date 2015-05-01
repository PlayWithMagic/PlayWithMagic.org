package tests;

import models.Routine;
import models.RoutineDB;
import models.SetDB;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.test.TestBrowser;
import tests.pages.EditRoutinePage;
import tests.pages.IndexPage;
import tests.pages.ListRoutinesPage;
import tests.pages.ViewRoutinePage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

/**
 * Test the live interaction of the Routine pages with Chrome.
 * <p>
 * Run a server with a fake application, in-memory database and browser (Chrome) to test the system.
 *
 * @see https://www.playframework.com/documentation/2.3.0/api/java/play/test/WithBrowser.html
 */
public class TestRoutineCRUD extends play.test.WithBrowser {

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

  @Override
  protected play.test.FakeApplication provideFakeApplication() {
    return fakeApplication(inMemoryDatabase());
  }

  @Override
  protected int providePort() {
    return GlobalTest.TEST_PORT;
  }

  @Override
  protected TestBrowser provideBrowser(int port) {
    return new TestBrowser(new ChromeDriver(), "/");
  }

  /**
   * Test Routine navigation from index page and navigation bars.
   */
  @Test
  public void testRoutineNav() {
    // browser.maximizeWindow();

    // Start at the home page...
    IndexPage indexPage = new IndexPage(browser);
    browser.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/");
    assertThat(browser.pageSource()).contains("We're looking for a few good routines");
    assertThat(browser.pageSource()).contains("Join the Community Today!");

    // Click the Browse Routines button
    browser.findFirst("#browseRoutines").click();
    assertThat(browser.pageSource()).contains("Current Routines");

    // Click the Create Routines button
    browser.findFirst("#createNew").click();
    browser.findFirst("#createRoutine").click();
    assertThat(browser.pageSource()).contains("Create Routine");
  }


  /**
   * Utilize a test browser and the Fluentlenium framework to exercise the List Routines page.
   */
  @Test
  public void testGetInitialListRoutinesPage() {
    // browser.maximizeWindow();

    ListRoutinesPage listRoutinesPage = new ListRoutinesPage(browser);
  }


  /**
   * Test Routine CRUD.
   * <p>
   * Originally, I had this workflow broken up into individual methods.  However, the Play Framework seems to
   * restart the entire application between method runs -- and this wipes out the in-memory database.
   */
  @Test
  public void testRoutineCrudWorkflow() {
    SetDB.resetSetDB();
    RoutineDB.resetRoutineDB();
    // MagicianDB.resetMagicianDB();

    // browser.maximizeWindow();

    ListRoutinesPage listRoutinesPage = null;
    EditRoutinePage editRoutinePage = null;

    // Look at the List Routines page first...
    listRoutinesPage = new ListRoutinesPage(browser);

    // Add a new Routine...
    editRoutinePage = new EditRoutinePage(browser);
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

}
