package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.IndexPage;
import tests.pages.NewMagicianPage;
import tests.pages.ShowMagiciansPage;

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
   * Test that verifies the index page can be retrieved.
   */
  @Test
  public void testRetrieveIndexPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            IndexPage indexPage = new IndexPage(browser.getDriver(), port);
            browser.goTo(indexPage);
            indexPage.isAt();
          }
        });
  }

  /**
   * Test that verifies the NewMagician page can be retrieved.
   */
  @Test
  public void testRetrieveNewMagicianPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            NewMagicianPage newMagicianPage = new NewMagicianPage(browser.getDriver(), port);
            browser.goTo(newMagicianPage);
            newMagicianPage.isAt();
          }
        });
  }

  /**
   * Tests to verify that a NewMagician form submission works and results can be viewed on the ShowMagicians page.
   */
  @Test
  public void testCreateNewMagician() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            ShowMagiciansPage showMagiciansPage = new ShowMagiciansPage(browser.getDriver(), port);
            NewMagicianPage newMagicianPage = new NewMagicianPage(browser.getDriver(), port);
            browser.goTo(newMagicianPage);
            newMagicianPage.isAt();
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
            newMagicianPage.createMagician(firstName, lastName, stageName, location, biography, interests, influences,
                experienceLevel, yearStarted, organizations, website, email, facebook, twitter, linkedIn,
                googlePlus, flickr, instagram);
            browser.goTo(showMagiciansPage);
            String fullName = firstName + " " + lastName;
            showMagiciansPage.hasMagician(fullName, stageName, experienceLevel);
          }
        });
  }
}
