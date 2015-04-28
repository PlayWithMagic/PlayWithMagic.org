package tests;

import models.MagicianDB;
import models.RoutineDB;
import models.Set;
import models.SetDB;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.libs.F;
import play.test.TestBrowser;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Test the live interaction of the Set pages with Chrome.
 */
public class TestSetCRUD {

  /**
   * The port number on which to run the tests.
   */
  private static final int TEST_PORT = 3333;

  private static Set set1;
  private static Set set2;


  public TestSetCRUD() {
  }

  /**
   * Test Set Navigation from home page and navigation bars.
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

            // browser.maximizeWindow();

            // Start at the home page...
            browser.goTo("http://localhost:" + TEST_PORT + "/");
            assertThat(browser.pageSource()).contains("We're looking for a few good routines");

            // Click Add Set
            browser.findFirst(".createNew").click();
            browser.findFirst("#createSet").click();
            assertThat(browser.pageSource()).contains("Create Set");


/*
            // Click the Join the Community Today! button
            browser.findFirst("#joinTheCommunity").click();
            assertThat(browser.pageSource()).contains("Magician Profile");

            // Populate all of the fields and click Add
            EditMagicianPage.populateMagician(browser, magician1);
            browser.click(browser.find("#submit"));
            assertThat(browser.pageSource()).contains("Current Magicians");
            assertThat(browser.pageSource()).contains(magician1.getFirstName() + " " + magician1.getLastName());
            assertThat(browser.pageSource()).contains(magician1.getStageName());
            assertThat(browser.pageSource()).contains(magician1.getExperienceLevel());

            // View the magician and check all of the fields
            browser.findFirst(".viewMagician").click();
            EditMagicianPage.checkMagician(browser, magician1);

            // Edit the magician and update all of the fields                                    // The button click
            browser.goTo(browser.findFirst(".editMagician").getElement().getAttribute("href"));  // didn't work, so I
            EditMagicianPage.checkMagician(browser, magician1);                                  // did this instead.
            EditMagicianPage.populateMagician(browser, magician2);
            browser.click(browser.find("#submit"));
            assertThat(browser.pageSource()).contains("Current Magicians");
            assertThat(browser.pageSource()).contains(magician2.getFirstName() + " " + magician2.getLastName());
            assertThat(browser.pageSource()).contains(magician2.getStageName());
            assertThat(browser.pageSource()).contains(magician2.getExperienceLevel());

            // View the magician and check all of the fields
            browser.findFirst(".viewMagician").click();
            EditMagicianPage.checkMagician(browser, magician2);

            // Go back to list magician and delete the magician
            browser.goTo(browser.findFirst(".listMagicians").getElement().getAttribute("href"));
            assertThat(browser.pageSource()).contains(magician2.getFirstName() + " " + magician2.getLastName());
            assertThat(browser.pageSource()).contains(magician2.getExperienceLevel());
            browser.findFirst(".deleteMagician").click();
            assertThat(browser.pageSource()).doesNotContain(magician2.getFirstName() + " " + magician2.getLastName());
            assertThat(browser.pageSource()).doesNotContain(magician2.getExperienceLevel());
*/
          }
        });
  }



}
