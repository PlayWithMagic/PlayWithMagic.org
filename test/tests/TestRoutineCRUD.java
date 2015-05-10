package tests;

import models.Routine;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.Logger;
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
    routine1 = new Routine("Test Routine Name 01", "Test Routine Description 01", 101);
    routine1.setMethod("Test Routine Method 01");
    routine1.setHandling("Test Routine Handling 01");
    routine1.setResetDuration(21);
    routine1.setResetDescription("Test Routine Reset Description 01");
    routine1.setYouTubeUrl("Test YouTube URL 01");
    routine1.setImageUrl("Test Image URL 01");
    routine1.setInspiration("Test Inspiration 01");
    routine1.setPlacement("Test Placement 01");
    routine1.setChoices("Test Choices 01");

    routine2 = new Routine("02 Test Routine Name 02", "02 Test Routine Description 02", 22);
    routine2.setMethod("02 Test Routine Method 02");
    routine2.setHandling("02 Test Routine Handling 02");
    routine2.setResetDuration(119);
    routine2.setResetDescription("02 Test Routine Reset Description 02");
    routine2.setYouTubeUrl("02 Test YouTube URL 02");
    routine2.setImageUrl("02 Test Image URL 02");
    routine2.setInspiration("02 Test Inspiration 02");
    routine2.setPlacement("02 Test Placement 02");
    routine2.setChoices("02 Test Choices 02");

    routine3 = new Routine("Test Routine Name 03", "Test Routine Description 03", 33);

    /* Logger.debug("Routines setup for testing"); */ // Logger doesn't work in JUnit tests w/ Play 2.0 (known issue).
    Logger.debug("Test Routines constructed");
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

    // Clear database, create a test user and login as that user.  Start at the home page...
    GlobalTest.resetDatabaseForTest("PlayWithMagic");
    GlobalTest.addUserForTest();
    IndexPage indexPage = new IndexPage(browser).loginToTestAccount();

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

    // Clear database, create a test user and login as that user.  Start at the home page...
    GlobalTest.resetDatabaseForTest("PlayWithMagic");
    GlobalTest.addUserForTest();
    IndexPage indexPage = new IndexPage(browser).loginToTestAccount();

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

// Commented out delete as we do not currently allow users to delete routines
//    // Delete the routine
//    listRoutinesPage.deleteFirstRoutine();
//    listRoutinesPage.doesNotHaveRoutine(routine3);
  }


  /**
   * Test Routine CRUD.
   */
  @Test
  public void testRoutineCrudWorkflow() {
    // browser.maximizeWindow();

    // Clear database, create a test user and login as that user.  Start at the home page...
    GlobalTest.resetDatabaseForTest("PlayWithMagic");
    GlobalTest.addUserForTest();
    IndexPage indexPage = new IndexPage(browser).loginToTestAccount();

    // Look at the List Routines page first...
    ListRoutinesPage listRoutinesPage = indexPage.clickBrowseRoutinesButton();
    listRoutinesPage.doesNotHaveRoutine(routine1);

    // Add a new Routine...
    EditRoutinePage editRoutinePage = listRoutinesPage.clickCreateRoutineButton();
    assertThat(editRoutinePage.pageSource()).contains("Create Routine");
    editRoutinePage.populateRoutine(routine1);
    editRoutinePage.clickSubmit();

    // This should be successful and the browser should go to ListRoutines.  Verify the routine.
    listRoutinesPage = new ListRoutinesPage(editRoutinePage.getDriver());
    listRoutinesPage.hasRoutine(routine1);

    // View the routine and check all of the fields
    ViewRoutinePage viewRoutinePage = listRoutinesPage.viewRoutine(0);
    viewRoutinePage.hasRoutine(routine1);

    // Update the routine
    editRoutinePage = viewRoutinePage.clickEditRoutineButton();
    assertThat(editRoutinePage.pageSource()).contains("Update Routine");
    editRoutinePage.checkRoutine(routine1);
    editRoutinePage.populateRoutine(routine2);
    editRoutinePage.clickSubmit();

    // Verify the new information is in the list and the old information is not.
    listRoutinesPage = new ListRoutinesPage(editRoutinePage.getDriver());
    listRoutinesPage.doesNotHaveRoutine(routine1);
    listRoutinesPage.hasRoutine(routine2);

    // Verify the new information is in ViewRoutine
    viewRoutinePage = listRoutinesPage.viewRoutine(0);
    viewRoutinePage.hasRoutine(routine2);
    listRoutinesPage = viewRoutinePage.clickReturnToRoutineListButton();

    // Verify the new information is in EditRoutine
    editRoutinePage = listRoutinesPage.editFirstRoutine();
    editRoutinePage.checkRoutine(routine2);
    listRoutinesPage = editRoutinePage.clickBrowseRoutinesButton();

    // Delete the routine
    listRoutinesPage.hasRoutine(routine2);

// Commented out delete as we do not currently allow users to delete routines
//    listRoutinesPage.deleteFirstRoutine();
//    listRoutinesPage.doesNotHaveRoutine(routine2);
//    listRoutinesPage.doesNotHaveRoutine(routine1);

  }

}