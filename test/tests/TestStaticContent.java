package tests;

import org.fluentlenium.core.FluentPage;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.AboutPage;
import tests.pages.EditMagicianPage;
import tests.pages.EditRoutinePage;
import tests.pages.EditSetPage;
import tests.pages.HelpPage;
import tests.pages.IndexPage;
import tests.pages.ListMagiciansPage;
import tests.pages.ListRoutinesPage;
import tests.pages.ListSetsPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;


/**
 * Test the static pages and basic navigation.
 */
public class TestStaticContent {

  /**
   * This test verifies the links at the bottom of the Index page.
   */
  @Test
  public void testIndexFooterLinks() {
    running(testServer(GlobalTest.TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            // browser.maximizeWindow();

            IndexPage indexPage;
            AboutPage aboutPage;
            FluentPage otherPage;

            indexPage = new IndexPage(browser);

            aboutPage = indexPage.clickAboutButton();

            indexPage = new IndexPage(browser);
            otherPage = indexPage.clickContactUsOnGithub();
            assertThat(otherPage.title()).doesNotContain("is not available");

            indexPage = new IndexPage(browser);
            otherPage = indexPage.clickResponsiveLayoutBuiltOnTwitterBootstrap();
            assertThat(otherPage.title()).doesNotContain("is not available");

            indexPage = new IndexPage(browser);
            otherPage = indexPage.clickCreatedWithPlayFramework();
            assertThat(otherPage.title()).doesNotContain("is not available");

            indexPage = new IndexPage(browser);
            otherPage = indexPage.clickVisitTheProjectOnGithub();
            assertThat(otherPage.title()).doesNotContain("is not available");
          }
        });
  }


  /**
   * This test verifies the navigation links across the top of the Index page.
   */
  @Test
  public void testIndexTopNavigation() {
    running(testServer(GlobalTest.TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            // browser.maximizeWindow();

            IndexPage indexPage = new IndexPage(browser);
            indexPage = indexPage.clickHomeButton();

            ListRoutinesPage listRoutinesPage = indexPage.clickBrowseRoutinesButton();

            ListSetsPage listSetsPage = listRoutinesPage.clickBrowseSetsButton();

            ListMagiciansPage listMagiciansPage = listSetsPage.clickBrowseMagiciansButton();

            EditMagicianPage editMagicianPage = listMagiciansPage.clickJoinTheCommunityToday();

            HelpPage helpPage = editMagicianPage.clickHelpButton();

            EditRoutinePage editRoutinePage = helpPage.clickCreateRoutineButton();

            EditSetPage editSetPage = editRoutinePage.clickCreateSetButton();
          }
        });
  }


  /**
   * This test verifies Index page functionality (just clicking the big Join the Community Today button).
   */
  @Test
  public void testIndexPage() {
    running(testServer(GlobalTest.TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            // browser.maximizeWindow();

            IndexPage indexPage = new IndexPage(browser);
            indexPage.clickJoinTheCommunityToday();
          }
        });
  }

}
