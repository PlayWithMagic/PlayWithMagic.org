package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides scaffolding to remotely control common navigation elements for testing.
 *
 * This class also includes two utility methods that assist in checking/populating fields.
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


  /**
   * Optionally check for the presence of a value in the page source.
   *
   * @param field The value to check for.  If the value is null, then don't check.
   */
  protected void checkOptionalField(Object field) {
    if (field != null) {
      assertThat(this.pageSource()).contains(field.toString());
    }
  }


  /**
   * Fill a text value in field.
   *
   * @param fieldName The ID of the HTML form field.
   * @param fieldValue The value to put into the field.
   */
  protected void fillRequiredField(String fieldName, Object fieldValue) {
    assertThat(fieldName).isNotEmpty();
    assertThat(fieldValue).isNotNull();

    this.fill(fieldName).with(fieldValue.toString());
  }


  /**
   * Optionally fill a text value in a field.
   *
   * @param fieldName The ID of the HTML form field.
   * @param fieldValue The value to put into the field.
   */
  protected void fillOptionalField(String fieldName, Object fieldValue) {
    if (fieldValue != null) {
      fillRequiredField(fieldName, fieldValue);
    }
  }

}
