package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.AboutPage;
import tests.pages.EditSetPage;
import tests.pages.HelpPage;
import tests.pages.IndexPage;
import tests.pages.ListSetsPage;

import java.util.ArrayList;
import java.util.List;

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
    running(testServer(port, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
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
   * Test that verifies the ListSets page can be retrieved.
   */
  @Test
  public void testRetrieveListSetsPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
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
    running(testServer(port, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
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
