package tests;

import models.Routine;
import models.RoutineDB;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import play.Logger;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasicRoutineTests {

  /**
   * The port number on which to run the tests.
   */
  private static final int TEST_PORT = 3333;

  private static Routine routine1 = null;
  private static Routine routine2 = null;


  /**
   * Condition the database for testing routines.
   */
  @BeforeClass
  public static void oneTimeSetUp() {
    RoutineDB.resetRoutineDB();

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

    Logger.debug("Routines setup for testing!!");
    System.out.println("Routines setup for testing");  // Logger doesn't seem to printout yet.
  }

  /**
   * Utilize a test browser and the Fluentlenium framework to exercise the Search Routines page.
   */
  @Test
  public void test01GetInitialSearchRoutinesPage() {
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
   * Test adding one routine.
   */
  @Test
  public void test02AddRoutine() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            NewRoutinePage newRoutinePage = new NewRoutinePage(browser.getDriver(), TEST_PORT);
            browser.goTo(newRoutinePage);
            newRoutinePage.isAt();
            assertThat(browser.pageSource().contains("Create Routine"));

            newRoutinePage.submitForm(routine1);

            assertThat(browser.pageSource()).contains(routine1.getName());
            assertThat(browser.pageSource()).contains(routine1.getDuration().toString());
          }
        });
  }


  /**
   * Test updating the first routine.
   */
  @Test
  public void test03UpdateRoutine() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();

            /* The 1 at the end of the constructor below assumes that the ID for the routine that was
             * just created is = 1.  We need to write software to get the current ID from the add
             * routine and make this test more robust.
             */
            NewRoutinePage newRoutinePage = new NewRoutinePage(browser.getDriver(), TEST_PORT, 1);
            browser.goTo(newRoutinePage);
            newRoutinePage.isAt();
            assertThat(browser.pageSource().contains("Update Routine"));
            assertThat(browser.pageSource()).contains(routine1.getName());
            assertThat(browser.pageSource()).contains(routine1.getDescription());
            assertThat(browser.pageSource()).contains(routine1.getDuration().toString());
            assertThat(browser.pageSource()).contains(routine1.getMethod());
            assertThat(browser.pageSource()).contains(routine1.getHandling());
            assertThat(browser.pageSource()).contains(routine1.getResetDuration().toString());
            assertThat(browser.pageSource()).contains(routine1.getResetDescription());

            newRoutinePage.submitForm(routine2);

            assertThat(browser.pageSource()).contains(routine2.getName());
            assertThat(browser.pageSource()).contains(routine2.getDuration().toString());
          }
        });
  }


  /**
   * Verify that all of the routine updates happened.
   */
  @Test
  public void test04VerifyUpdateRoutine() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();

            /* The 1 at the end of the constructor below assumes that the ID for the routine that was
             * just created is = 1.  We need to write software to get the current ID from the add
             * routine and make this test more robust.
             */
            NewRoutinePage newRoutinePage = new NewRoutinePage(browser.getDriver(), TEST_PORT, 1);
            browser.goTo(newRoutinePage);
            newRoutinePage.isAt();
            assertThat(browser.pageSource().contains("Update Routine"));
            assertThat(browser.pageSource()).contains(routine2.getName());
            assertThat(browser.pageSource()).contains(routine2.getDescription());
            assertThat(browser.pageSource()).contains(routine2.getDuration().toString());
            assertThat(browser.pageSource()).contains(routine2.getMethod());
            assertThat(browser.pageSource()).contains(routine2.getHandling());
            assertThat(browser.pageSource()).contains(routine2.getResetDuration().toString());
            assertThat(browser.pageSource()).contains(routine2.getResetDescription());
          }
        });
  }

  /**
   * Test deleting a routine.
   */
  @Test
  public void test05DeleteRoutine() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            /* The 1 at the end of the constructor below assumes that the ID for the routine that was
             * just created is = 1.  We need to write software to get the current ID from the add
             * routine and make this test more robust.
             */
            SearchRoutinesPage searchRoutinesPage = new SearchRoutinesPage(browser.getDriver(), TEST_PORT, 1);
            browser.goTo(searchRoutinesPage);
            searchRoutinesPage.isAt();
            assertThat(browser.pageSource()).doesNotContain(routine2.getName());
            assertThat(browser.pageSource()).doesNotContain(routine2.getDuration().toString());
          }
        });
  }

}
