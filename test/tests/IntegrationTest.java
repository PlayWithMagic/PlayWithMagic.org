package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.AboutPage;
import tests.pages.EditSetPage;
import tests.pages.HelpPage;
import tests.pages.IndexPage;
import tests.pages.EditMagicianPage;
import tests.pages.ListMagiciansPage;
import tests.pages.ListSetsPage;

import java.util.ArrayList;
import java.util.List;

import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Runs a server with a fake in-memory database to test the system.
 */
public class IntegrationTest {

  /**
   * The port to be used for testing.
   */
  private final int port = 3333;

  /**
   * Test that verifies that several static pages can be retrieved.
   * This test verifies that the Index, About and Help pages can be retrieved.
   */
  @Test
  public void testStaticPages() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            IndexPage indexPage = new IndexPage(browser.getDriver(), port);
            browser.goTo(indexPage);
            indexPage.isAt();

            AboutPage aboutPage = new AboutPage(browser.getDriver(), port);
            browser.goTo(aboutPage);
            aboutPage.isAt();

            HelpPage helpPage = new HelpPage(browser.getDriver(), port);
            browser.goTo(helpPage);
            helpPage.isAt();
          }
        });
  }

  /**
   * Test that verifies the EditMagician page can be retrieved.
   */
  @Test
  public void testRetrieveNewMagicianPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            EditMagicianPage editMagicianPage = new EditMagicianPage(browser.getDriver(), port);
            browser.goTo(editMagicianPage);
            editMagicianPage.isAt();
          }
        });
  }

  /**
   * Tests to verify that a EditMagician form submission works and results can be viewed on the ListMagicians page.
   */
  @Test
  public void testCreateNewMagician() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            ListMagiciansPage listMagiciansPage = new ListMagiciansPage(browser.getDriver(), port);
            EditMagicianPage editMagicianPage = new EditMagicianPage(browser.getDriver(), port);
            browser.goTo(editMagicianPage);
            editMagicianPage.isAt();
            String firstName = "Patrick";
            String lastName = "Karjala";
            String stageName = "The Great Patricio";
            String location = "Honolulu, HI";
            String biography = "Born and raised in Hawaii, the greatest magician of the Pacific!";
            String interests = "Color Sticks";
            String influences = "Mark Nelson";
            String experienceLevel = "Enthusiast";
            String yearStarted = "2011";
            String organizations = "none";
            String website = "http://patrickakarjala.wordpress.com/";
            String email = "pat_trick@hotmail.com";
            String facebook = "None";
            String twitter = "@patrick";
            String linkedIn = "http://www.linkedin.com/patrickakarjala/";
            String googlePlus = "Some crazy URL string";
            String flickr = "yahoo.com";
            String instagram = "pat_trick_hi";
            editMagicianPage.createMagician(firstName, lastName, stageName, location, biography, interests, influences,
                experienceLevel, yearStarted, organizations, website, email, facebook, twitter, linkedIn,
                googlePlus, flickr, instagram);
            browser.goTo(listMagiciansPage);
            String fullName = firstName + " " + lastName;
            listMagiciansPage.hasMagician(fullName, stageName, experienceLevel);
          }
        });
  }

  /**
   * Test that verifies the ListSets page can be retrieved.
   */
  @Test
  public void testRetrieveListSetsPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            ListSetsPage listSetsPage = new ListSetsPage(browser.getDriver(), port);
            browser.goTo(listSetsPage);
            listSetsPage.isAt();
          }
        });
  }

  /**
   * Test to verify that a EditSet form submission works and results can beviewed on the ListSets Page.
   */
  @Test
  public void testCreateNewSet() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            ListSetsPage listSetsPage = new ListSetsPage(browser.getDriver(), port);
            EditSetPage editSetPage = new EditSetPage(browser.getDriver(), port);
            browser.goTo(editSetPage);
            editSetPage.isAt();
            String name = "My First Set";
            String description = "This is the first set that I have built!";
            List<Long> routineList = new ArrayList<Long>();
            routineList.add(1L);
            routineList.add(3L);
            editSetPage.createSet(name, description, routineList);
            browser.goTo(listSetsPage);
            listSetsPage.isAt();
            listSetsPage.hasSet(name);
          }
        });
  }
}
