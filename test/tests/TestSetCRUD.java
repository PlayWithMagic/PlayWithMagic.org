package tests;

import models.MagicianDB;
import models.Routine;
import models.RoutineDB;
import models.Set;
import models.SetDB;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.libs.F;
import play.test.TestBrowser;
import tests.pages.EditRoutinePage;
import tests.pages.EditSetPage;
import tests.pages.ListSetsPage;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Test the live interaction of the Set pages with Chrome.
 *
 * Run a server with a fake in-memory database to test the system.
 */
public class TestSetCRUD {

  /**
   * The port number on which to run the tests.
   */
  private static final int TEST_PORT = 3333;

  private static Set set1;
  private static Set set2;

  private static Routine routine1 = null;
  private static Routine routine2 = null;
  private static Routine routine3 = null;


  /**
   * Populate static objects needed for testing.
   */
  public TestSetCRUD() {
    set1 = new Set(-1, "Test Set Name 01", "Test Set Description 01", null);
    set2 = new Set(-1, "02 Test Set Name 02", "02 Test Set Description 02", null);

    routine1 = new Routine(0, "Test Routine Name 01", "Test Routine Description 01");
    routine1.setDuration(11);

    routine2 = new Routine(0, "Test Routine Name 02", "Test Routine Description 02");
    routine2.setDuration(22);

    routine3 = new Routine(0, "Test Routine Name 03", "Test Routine Description 03");
    routine3.setDuration(33);
  }


  /**
   * Test Set Navigation from the Index page and navigation bars.
   */
  @Test
  public void testSetNav() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            // browser.maximizeWindow();

            // Start at the home page...
            browser.goTo("http://localhost:" + TEST_PORT + "/");
            assertThat(browser.pageSource()).contains("We're looking for a few good routines");
            assertThat(browser.pageSource()).contains("Join the Community Today!");

            // Click the Browse Sets button
            browser.findFirst("#browseSets").click();
            assertThat(browser.pageSource()).contains("Current Sets");

            // Click the Create Sets button
            browser.findFirst(".createNew").click();
            browser.findFirst("#createSet").click();
            assertThat(browser.pageSource()).contains("Create Set");
          }
        });
  }


  /**
   * A workflow that tests a basic add and delete with only the required fields.
   */
  @Test
  public void testSetMinimumAddDelete() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            SetDB.resetSetDB();
            RoutineDB.resetRoutineDB();
            MagicianDB.resetMagicianDB();

            // browser.maximizeWindow();

            // Start at the home page...
            browser.goTo("http://localhost:" + TEST_PORT + "/");
            assertThat(browser.pageSource()).contains("We're looking for a few good routines");

            // Click Add Set
            browser.findFirst(".createNew").click();
            browser.findFirst("#createSet").click();
            assertThat(browser.pageSource()).contains("Create Set");

            // Click Add without entering any information... this should generate an error.
            assertThat(browser.pageSource()).doesNotContain("Must provide a name for the Set.");
            assertThat(browser.pageSource()).doesNotContain("Please provide a description of this Set.");
            assertThat(browser.pageSource()).doesNotContain("Please select at least one Routine for a Set.");
            browser.click(browser.find("#submit"));
            assertThat(browser.pageSource()).contains("Must provide a name for the Set.");
            assertThat(browser.pageSource()).contains("Please provide a description of this Set.");
            assertThat(browser.pageSource()).contains("Please select at least one Routine for a Set.");

            // This is all we'll test for now because all fields are required for sets

          }
        });
  }


  /**
   * Test Set CRUD.
   * <p>
   * This is a large workflow because the Play Framework the application restarts between tests -- which wipes
   * out the in-memory database.
   */
  @Test
  public void testSetCrudWorkflow() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            SetDB.resetSetDB();
            RoutineDB.resetRoutineDB();
            MagicianDB.resetMagicianDB();
            Long routineId1;
            Long routineId2;
            Long routineId3;

            // Create three routines used for testing
            EditRoutinePage editRoutinePage;
            editRoutinePage = new EditRoutinePage(browser.getDriver(), TEST_PORT);
            browser.goTo(editRoutinePage);
            editRoutinePage.isAt();
            editRoutinePage.submitForm(routine1);
            routineId1 = RoutineDB.getRoutines().get(0).getId();

            editRoutinePage = new EditRoutinePage(browser.getDriver(), TEST_PORT);
            browser.goTo(editRoutinePage);
            editRoutinePage.isAt();
            editRoutinePage.submitForm(routine2);
            routineId2 = RoutineDB.getRoutines().get(1).getId();

            editRoutinePage = new EditRoutinePage(browser.getDriver(), TEST_PORT);
            browser.goTo(editRoutinePage);
            editRoutinePage.isAt();
            editRoutinePage.submitForm(routine3);
            routineId3 = RoutineDB.getRoutines().get(2).getId();

            // browser.maximizeWindow();

            // Start at the home page...
            browser.goTo("http://localhost:" + TEST_PORT + "/");
            assertThat(browser.pageSource()).contains("We're looking for a few good routines");

            // Click Add Set
            browser.findFirst(".createNew").click();
            browser.findFirst("#createSet").click();
            assertThat(browser.pageSource()).contains("Create Set");

            // Populate the fields, the first and third routines and click Add
            browser.fill("#name").with(set1.getName());
            browser.fill("#description").with(set1.getDescription());
            browser.findFirst("input[id=\"" + routineId1 + "\"").click();
            browser.findFirst("input[id=\"" + routineId3 + "\"").click();
            browser.click(browser.find("#submit"));

            // Verify the new set is in the list
            assertThat(browser.pageSource()).contains("Current Sets");
            assertThat(browser.pageSource()).contains(set1.getName());

            // View the new set and verify its contents
            browser.findFirst(".viewSet").click();
            assertThat(browser.pageSource()).contains(set1.getName());
            assertThat(browser.pageSource()).contains(set1.getDescription());
            assertThat(browser.pageSource()).contains(routine1.getName());
            assertThat(browser.pageSource()).doesNotContain(routine2.getName());
            assertThat(browser.pageSource()).contains(routine3.getName());

            // Go back to Edit Set and verify everyting is good
            browser.goTo(browser.findFirst(".editSet").getElement().getAttribute("href"));
            assertThat(browser.pageSource()).contains(set1.getName());
            assertThat(browser.pageSource()).contains(set1.getDescription());
            assertThat(browser.findFirst("input[id=\"" + routineId1 + "\"").isSelected());
            assertThat(!browser.findFirst("input[id=\"" + routineId2 + "\"").isSelected());
            assertThat(browser.findFirst("input[id=\"" + routineId3 + "\"").isSelected());

            // Now change all of the fields
            browser.fill("#name").with(set2.getName());
            browser.fill("#description").with(set2.getDescription());
            browser.findFirst("input[id=\"" + routineId1 + "\"").click();
            browser.findFirst("input[id=\"" + routineId2 + "\"").click();
            browser.findFirst("input[id=\"" + routineId3 + "\"").click();

            browser.click(browser.find("#submit"));

            // Verify the new set is in the list
            assertThat(browser.pageSource()).contains("Current Sets");
            assertThat(browser.pageSource()).contains(set2.getName());

            // View the new set and verify its contents
            browser.findFirst(".viewSet").click();
            assertThat(browser.pageSource()).contains(set2.getName());
            assertThat(browser.pageSource()).contains(set2.getDescription());
            assertThat(browser.pageSource()).doesNotContain(routine1.getName());
            assertThat(browser.pageSource()).contains(routine2.getName());
            assertThat(browser.pageSource()).doesNotContain(routine3.getName());

            // Go back to list sets and delete the set
            browser.goTo(browser.findFirst(".listSets").getElement().getAttribute("href"));
            assertThat(browser.pageSource()).contains("Current Sets");
            assertThat(browser.pageSource()).contains(set2.getName());
            browser.findFirst(".deleteSet").click();
            assertThat(browser.pageSource()).doesNotContain(set2.getName());

          }
        });
  }


  /**
   * Test that verifies the ListSets page can be retrieved.
   */
  @Test
  public void testRetrieveListSetsPage() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            // browser.maximizeWindow();

            ListSetsPage listSetsPage = new ListSetsPage(browser.getDriver(), TEST_PORT);
            browser.goTo(listSetsPage);
            listSetsPage.isAt();
          }
        });
  }


  /**
   * Test to verify that a EditSet form submission works and results can beviewed on the ListSets Page.
   */
  // TODO:  This needs to get re-added to the test suite.
//  @Test
  public void testCreateNewSet() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            // browser.maximizeWindow();

            ListSetsPage listSetsPage = new ListSetsPage(browser.getDriver(), TEST_PORT);
            EditSetPage editSetPage = new EditSetPage(browser.getDriver(), TEST_PORT);
            browser.goTo(editSetPage);
            editSetPage.isAt();
            String name = "My First Set";
            String description = "This is the first set that I have built!";
            List<Long> routineList = new ArrayList<Long>();
            // TODO:  This needs to be refactored to populate its own routines (1 and 3 below)
            //routineList.add(1L);
            //routineList.add(3L);
            editSetPage.createSet(name, description, routineList);
            browser.goTo(listSetsPage);
            listSetsPage.isAt();
            listSetsPage.hasSet(name);
            // TODO:  Add tests to ensure the routines that should be in here are in here
          }
        });
  }

}
