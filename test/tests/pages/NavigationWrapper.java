package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

/**
 * Provides scaffolding to remotely control common navigation elements for testing.
 */
public abstract class NavigationWrapper extends FluentPage {

  /**
   * Prepare the FluentPage for use as the test web browser.
   *
   * @param webDriver The state of the current test browser.
   */
  public NavigationWrapper(WebDriver webDriver) {
    super(webDriver);
  }


  /**
   * Click the Index button in the top navigation (the top-right 'home' icon).
   *
   * @return The IndexPage.
   */
  public IndexPage clickHomeButton() {
    this.findFirst("#linkToIndexPage").click();
    return new IndexPage(this.getDriver());
  }


  /**
   * Click the Browse Routines button in the top navigation.
   *
   * @return The ListRoutinesPage.
   */
  public ListRoutinesPage clickBrowseRoutinesButton() {
    this.findFirst("#browseRoutines").click();
    return new ListRoutinesPage(this.getDriver());
  }


  /**
   * Click the Browse Sets button in the top navigation.
   *
   * @return The ListSetsPage.
   */
  public ListSetsPage clickBrowseSetsButton() {
    this.findFirst("#browseSets").click();
    return new ListSetsPage(this.getDriver());
  }


  /**
   * Click the Browse Magicians button in the top navigation.
   *
   * @return The ListMagiciansPage.
   */
  public ListMagiciansPage clickBrowseMagiciansButton() {
    this.findFirst("#browseMagicians").click();
    return new ListMagiciansPage(this.getDriver());
  }


  /**
   * Click the Create Routine button in the top navigation.
   *
   * @return The EditRoutinePage.
   */
  public EditRoutinePage clickCreateRoutineButton() {
    this.findFirst("#createNew").click();
    this.findFirst("#createRoutine").click();
    return new EditRoutinePage(this.getDriver());
  }


  /**
   * Click the Create Set button in the top navigation.
   *
   * @return The EditSetPage.
   */
  public EditSetPage clickCreateSetButton() {
    this.findFirst("#createNew").click();
    this.findFirst("#createSet").click();
    return new EditSetPage(this.getDriver());
  }


  /**
   * Click the Help button on the Index page.
   *
   * @return The HelpPage.
   */
  public HelpPage clickHelpButton() {
    this.findFirst("#linkToHelpPage").click();
    return new HelpPage(this.getDriver());
  }

}
