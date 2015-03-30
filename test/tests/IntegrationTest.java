package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.IndexPage;
import tests.pages.NewContact;

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
   * Sample test that verifies the index page can be retrieved.
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
   * Tests to verify that a NewContact form submission works and can be viewed on the index page.
   */
  @Test
  public void testCreateNewContact() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            IndexPage indexPage = new IndexPage(browser.getDriver(), port);
            NewContact contactPage = new NewContact(browser.getDriver(), port);
            browser.goTo(contactPage);
            contactPage.isAt();
            String firstName = "Patrick";
            String lastName = "Karjala";
            String telephone = "808-822-2601";
            contactPage.createContact(firstName, lastName, telephone);
            browser.goTo(indexPage);
            indexPage.hasContact(firstName, lastName, telephone);
          }
        });
  }

}
