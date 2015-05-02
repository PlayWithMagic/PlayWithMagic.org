package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides scaffolding to remotely control the Index page for testing.
 */
public class IndexPage extends NavigationWrapper {

  /**
   * Go directly to the IndexPage and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public IndexPage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/");
    isAt();
  }


  /**
   * The browser should already be at IndexPage.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public IndexPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(this.title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(this.pageSource().contains("We're looking for a few good routines"));
    assertThat(this.pageSource().contains("Post Routines, Create Sets and Share Magic!"));
  }

  /**
   * Click the Navbar Help button in the upper right.
   *
   * @return The HelpPage.
   */
  public HelpPage clickNavbarHelpButton() {
    this.findFirst("#navbarLinkToHelpPage");
    return new HelpPage(this.getDriver());
  }

  /**
   * Click the Navbar Login button in the upper right.
   *
   * @return The LoginPage.
   */
  public LoginPage clickNavbarLoginButton() {
    this.findFirst("#navbarLinkToLoginPage").click();
    return new LoginPage(this.getDriver());
  }

  /**
   * Click the Navbar Signup button in the upper right.
   *
   * @return The EditUserPage with Signup rendering.
   */
  public EditUserPage clickNavbarSignupButton() {
    this.findFirst("#navbarLinkToSignupPage").click();
    return new EditUserPage(this.getDriver());
  }

  /**
   * Click the Join the Community Today button.
   *
   * @return The EditUserPage.
   */
  public EditUserPage clickJoinTheCommunityToday() {
    this.findFirst("#joinTheCommunity").click();
    return new EditUserPage(this.getDriver());
  }


  // Footers are only on the Index, Help, and Login pages

  /**
   * Click the About button on the Index page.
   *
   * @return The AboutPage.
   */
  public AboutPage clickAboutButton() {
    this.findFirst("#linkToAboutPage").click();
    return new AboutPage(this.getDriver());
  }


  /**
   * Click the 'Contact us on Github' link.
   *
   * @return A generic (outside the application) FluentPage.
   */
  public FluentPage clickContactUsOnGithub() {
    this.findFirst("#linkToGitHubNewIssue").click();
    return this;
  }


  /**
   * Click the 'Responsive Layout built on Twitter' link.
   *
   * @return A generic (outside the application) FluentPage.
   */
  public FluentPage clickResponsiveLayoutBuiltOnTwitterBootstrap() {
    this.findFirst("#linkToTwitterBootstrap").click();
    return this;
  }


  /**
   * Click the 'Created with Play Framework' link.
   *
   * @return A generic (outside the application) FluentPage.
   */
  public FluentPage clickCreatedWithPlayFramework() {
    this.findFirst("#linkToPlayFramework").click();
    return this;
  }


  /**
   * Click the 'Visit the Project on Github' link.
   *
   * @return A generic (outside the application) FluentPage.
   */
  public FluentPage clickVisitTheProjectOnGithub() {
    this.findFirst("#linkToProjectHomepage").click();
    return this;
  }



}
