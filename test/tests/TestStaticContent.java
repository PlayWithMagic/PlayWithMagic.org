package tests;

import org.fluentlenium.core.FluentPage;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.test.TestBrowser;
import tests.pages.AboutPage;
import tests.pages.EditRoutinePage;
import tests.pages.EditSetPage;
import tests.pages.EditUserPage;
import tests.pages.HelpPage;
import tests.pages.IndexPage;
import tests.pages.ListMagiciansPage;
import tests.pages.ListRoutinesPage;
import tests.pages.ListSetsPage;
import tests.pages.LoginPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;


/**
 * Test the live interaction of the Index page and navigation with Chrome.
 * <p>
 * Run a server with a fake application, in-memory database and browser (Chrome) to test the system.
 *
 * @see https://www.playframework.com/documentation/2.3.0/api/java/play/test/WithBrowser.html
 */
public class TestStaticContent extends play.test.WithBrowser {

  @Override
  protected play.test.FakeApplication provideFakeApplication() {
    return fakeApplication(inMemoryDatabase());
  }

  @Override
  protected int providePort() {
    return GlobalTest.TEST_PORT;
  }

  @Override
  protected TestBrowser provideBrowser(int port) {
    return new TestBrowser(new ChromeDriver(), "/");
  }

  /**
   * This test verifies the links at the bottom of the Index page.
   */
//  @Test
  public void testIndexFooterLinks() {
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


  /**
   * This test verifies the navigation links across the top of the Index page.
   */
  @Test
  public void testIndexTopNavigationNotLoggedIn() {
    // browser.maximizeWindow();

    IndexPage indexPage = new IndexPage(browser);
    indexPage = indexPage.clickHomeButton();

    ListRoutinesPage listRoutinesPage = indexPage.clickBrowseRoutinesButton();

    ListSetsPage listSetsPage = listRoutinesPage.clickBrowseSetsButton();

    ListMagiciansPage listMagiciansPage = listSetsPage.clickBrowseMagiciansButton();

    HelpPage helpPage = listMagiciansPage.clickHelpButton();

    EditUserPage editUserPage = helpPage.clickSignupButton();

    LoginPage loginPage = editUserPage.clickLoginButton();

    indexPage = loginPage.clickHomeButton();

//    EditRoutinePage editRoutinePage = helpPage.clickCreateRoutineButton();

//    EditSetPage editSetPage = editRoutinePage.clickCreateSetButton();
  }


  /**
   * This test verifies Index page functionality (just click the big Join the Community Today button).
   */
//  @Test
  public void testIndexPage() {
    // browser.maximizeWindow();

    IndexPage indexPage = new IndexPage(browser);
    indexPage.clickJoinTheCommunityToday();
  }

}
