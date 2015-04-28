package tests;

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



}
