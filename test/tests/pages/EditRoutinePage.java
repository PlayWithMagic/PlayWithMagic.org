package tests.pages;

import models.Material;
import models.Routine;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides scaffolding to remotely control the EditRoutine page for testing.
 *
 * When you want to *go* to a page, do new EditRoutinePage(browser);
 * When you are already *at* a page, do new EditRoutinePage(browser.getDriver());
 *
 */
public class EditRoutinePage extends NavigationWrapper {

  /**
   * Go directly to the EditRoutine page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   */
  public EditRoutinePage(TestBrowser browser) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/editRoutine");
    isAt();
  }


  /**
   * The browser should already be at the EditRoutine page.  Make sure the browser is already there.
   *
   * @param webDriver The state of the current test browser.
   */
  public EditRoutinePage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource()).contains("<body id=\"editRoutine\">");
  }

  /**
   * Click the Add or Update button (submit) at the bottom of the page.
   * <p>
   * This returns void because we don't know which page it would render...
   *   On success, it goes to ListRoutines
   *   On error, it stays on EditRoutine
   */
  public void clickSubmit() {
    this.findFirst("#submit").click();
  }


  /**
   * Click the Add Material button.
   * <p>
   * This returns void because we don't know which page it would render...
   *   On success, it goes to EditMaterial
   *   On error, it stays on EditRoutine
   */
  public void clickAddMaterial() {
    this.findFirst("#saveMaterialFromForm").click();
  }


  /**
   * Set passed values into the form.
   *
   * @param routine A container holding all of the fields to populate the Routine with.
   */
  public void populateRoutine(Routine routine) {
    // Required fields
    fillRequiredField("#name", routine.getName());
    fillRequiredField("#description", routine.getDescription());
    fillRequiredField("#duration", routine.getDuration());

    // Optional fields
    fillOptionalField("#method", routine.getMethod());
    fillOptionalField("#handling", routine.getHandling());
    fillOptionalField("#resetDuration", routine.getResetDuration());
    fillOptionalField("#resetDescription", routine.getResetDescription());
    fillOptionalField("#youTubeUrl", routine.getYouTubeUrl());
    fillOptionalField("#imageUrl", routine.getImageUrl());
    fillOptionalField("#inspiration", routine.getInspiration());
    fillOptionalField("#placement", routine.getPlacement());
    fillOptionalField("#choices", routine.getChoices());
  }


  /**
   * See if the browser has all of the values in the Routine object.
   *
   * @param routine A container holding all of the fields to check for in the page.
   */
  public void checkRoutine(Routine routine) {
    // Required fields
    assertThat(this.pageSource()).contains(routine.getName());
    assertThat(this.pageSource()).contains(routine.getDescription());
    assertThat(this.pageSource()).contains(routine.getDuration().toString());

    // Optional fields
    checkOptionalField(routine.getMethod());
    checkOptionalField(routine.getHandling());
    checkOptionalField(routine.getResetDuration());
    checkOptionalField(routine.getResetDescription());
    checkOptionalField(routine.getYouTubeUrl());
    checkOptionalField(routine.getImageUrl());
    checkOptionalField(routine.getInspiration());
    checkOptionalField(routine.getPlacement());
    checkOptionalField(routine.getChoices());
  }


  /**
   * Delete the first material on the page.  Return back to EditRoutine page.
   *
   * @return The EditRoutinePage.
   */
  public EditRoutinePage deleteFirstMaterial() {
    this.findFirst(".deleteMaterial").click();
    return new EditRoutinePage(this.getDriver());
  }


  /**
   * Edit the first material on the page.  Return back to EditMaterialPage page.
   *
   * @return The EditMaterialPage.
   */
  public EditMaterialPage editFirstMaterial() {
    this.findFirst(".editMaterial").click();
    return new EditMaterialPage(this.getDriver());
  }


  /**
   * See if the browser has all of the values in the Material object.
   *
   * @param material A container holding all of the fields to check for in the page.
   */
  public void hasMaterial(Material material) {
    assertThat(this.pageSource()).contains(material.getName());
    checkOptionalField(material.getPrice());
    checkOptionalField(material.getImageUrl());
  }


  /**
   * Ensure the browser does not have this Material object.
   *
   * @param material A container holding all of the fields to check for in the page.
   */
  public void doesNotHaveMaterial(Material material) {
    assertThat(this.pageSource()).doesNotContain(material.getName());
  }


  /**
   * Test to ensure the page does not have required field validation errors.
   */
  public void doesNotHaveRequiredFieldErrors() {
    assertThat(this.pageSource()).doesNotContain("Your routine's gotta have a name.");
    assertThat(this.pageSource()).doesNotContain("Please write a brief description of your routine.");
    assertThat(this.pageSource()).doesNotContain("If it's under a minute, then just enter 1.");
  }


  /**
   * Test to ensure the page has all of the required field validation errors.
   */
  public void hasRequiredFieldErrors() {
    assertThat(this.pageSource()).contains("Your routine's gotta have a name.");
    assertThat(this.pageSource()).contains("Please write a brief description of your routine.");
    assertThat(this.pageSource()).contains("If it's under a minute, then just enter 1.");
  }


}
