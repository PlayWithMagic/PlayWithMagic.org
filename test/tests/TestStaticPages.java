package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.AboutPage;
import tests.pages.HelpPage;
import tests.pages.IndexPage;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;


/**
 * Test the static pages and basic navigation.
 */
public class TestStaticPages {

  /**
   * The port to be used for testing.
   */
  private final int port = 3333;

  /**
   * This test verifies that the Index, About and Help pages can be retrieved.
   */
//  @Test
  public void testStaticPages() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            // browser.maximizeWindow();

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

}
