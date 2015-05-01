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
 * When you want to *go* to a page, do new IndexPage(browser);
 * When you are already *at* a page, do new IndexPage(browser.getDriver());
 *
 * @see https://www.playframework.com/documentation/2.3.0/api/java/play/test/WithBrowser.html
 */
public class TestRoutineCRUD extends play.test.WithBrowser {

  private static Routine routine1 = null;
  private static Routine routine2 = null;
  private static Routine routine3 = null;

  /**
   * Populate static objects needed for testing.
   */
  public TestRoutineCRUD() {
    routine1 = new Routine(0, "Test Routine Name 01", "Test Routine Description 01", 101);
    routine1.setMethod("Test Routine Method 01");
    routine1.setHandling("Test Routine Handling 01");
    routine1.setResetDuration(21);
    routine1.setResetDescription("Test Routine Reset Description 01");
    routine1.setYouTubeUrl("Test YouTube URL 01");
    routine1.setImageUrl("Test Image URL 01");
    routine1.setInspiration("Test Inspiration 01");
    routine1.setPlacement("Test Placement 01");
    routine1.setChoices("Test Choices 01");

    routine2 = new Routine(0, "02 Test Routine Name 02", "02 Test Routine Description 02", 22);
    routine2.setMethod("02 Test Routine Method 02");
    routine2.setHandling("02 Test Routine Handling 02");
    routine2.setResetDuration(119);
    routine2.setResetDescription("02 Test Routine Reset Description 02");
    routine2.setYouTubeUrl("02 Test YouTube URL 02");
    routine2.setImageUrl("02 Test Image URL 02");
    routine2.setInspiration("02 Test Inspiration 02");
    routine2.setPlacement("02 Test Placement 02");
    routine2.setChoices("02 Test Choices 02");

    routine3 = new Routine(0, "Test Routine Name 03", "Test Routine Description 03", 33);

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

    // Click the Browse Routines button
    ListRoutinesPage listRoutinesPage = indexPage.clickBrowseRoutinesButton();

    // Click the Create Routines button
    EditRoutinePage editRoutinePage = listRoutinesPage.clickCreateRoutineButton();
  }


  /**
   * A workflow that tests a basic add and delete Routine with only the required fields.
   */
  @Test
  public void testMagicianMinimumAddDelete() {
    // browser.maximizeWindow();

    // Start at the home page...
    IndexPage indexPage = new IndexPage(browser);

    // Click the Create Routines button
    EditRoutinePage editRoutinePage = indexPage.clickCreateRoutineButton();

    // Click Add without entering any information... this should generate an error.
    editRoutinePage.doesNotHaveRequiredFieldErrors();
    editRoutinePage.clickSubmit();
    editRoutinePage.hasRequiredFieldErrors();

    // Populate only the required information and click Add
    editRoutinePage.populateRoutine(routine3);
    editRoutinePage.clickSubmit();

    // This should be successful and the browser should go to ListRoutines.  Verify the routine.
    ListRoutinesPage listRoutinesPage = new ListRoutinesPage(editRoutinePage.getDriver());
    listRoutinesPage.hasRoutine(routine3);

    // Delete the routine
    listRoutinesPage.deleteFirstRoutine();
    listRoutinesPage.doesNotHaveRoutine(routine3);
  }


    /**
     * Test Routine CRUD.
     */
//  @Test
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

    editRoutinePage.populateRoutine(routine1);

    // Verify the routine data is in the database...
    browser.findFirst(".editRoutine").click();
    editRoutinePage.checkRoutine(routine1);
    browser.findFirst("#submit").click();
    browser.findFirst(".viewRoutine").click();
    ViewRoutinePage.testContents(browser, routine1);


    // Edit/modify all of the data...                                                   // The button click
    browser.goTo(browser.findFirst(".editRoutine").getElement().getAttribute("href"));  // didn't work, so I
    editRoutinePage.isAt();                                                             // did this instead.
    assertThat(browser.pageSource()).contains("Update Routine");
    editRoutinePage.populateRoutine(routine2);
    browser.findFirst(".editRoutine").click();
    editRoutinePage.checkRoutine(routine2);

    // Delete a Routine.
    browser.findFirst("#submit").click();
    assertThat(browser.pageSource()).contains(routine2.getName());
    assertThat(browser.pageSource()).contains(routine2.getDuration().toString());
    browser.findFirst(".deleteRoutine").click();
    assertThat(browser.pageSource()).doesNotContain(routine2.getName());
    assertThat(browser.pageSource()).doesNotContain(routine2.getDuration().toString());

  }

}
