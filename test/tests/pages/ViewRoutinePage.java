package tests.pages;

import models.Material;
import models.Routine;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the ViewRoutine page.
 *
 * When you want to *go* to a page, do new ViewRoutinePage(browser);
 * When you are already *at* a page, do new ViewRoutinePage(browser.getDriver());
 *
 */
public class ViewRoutinePage extends NavigationWrapper {

  /**
   * Go directly to the ViewRoutine page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   * @param id      The ID number of the routine to view.
   */
  public ViewRoutinePage(TestBrowser browser, long id) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/viewRoutine?id=" + id);
    isAt();
  }


  /**
   * The browser should already be at the ViewRoutine page.  Make sure the browser is there.
   *
   * @param webDriver The state of the current test browser.
   */
  public ViewRoutinePage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource()).contains("<body id=\"viewRoutine\">");
  }


  /**
   * Check the contents of the page for a Routine.
   *
   * @param routine A container holding all of the fields to check for in the page.
   */
  public void hasRoutine(Routine routine) {
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
//  checkOptionalField(routine.getImageUrl());
    checkOptionalField(routine.getInspiration());
    checkOptionalField(routine.getPlacement());
    checkOptionalField(routine.getChoices());
  }


  /**
   * Check the contents of the page for a Material.
   *
   * @param material A container holding all of the fields to check for in the page.
   */
  public void hasMaterial(Material material) {
    // Required fields
    assertThat(this.pageSource()).contains(material.getName());
  }



  /**
   * Check the contents of the page for the absence of a Material.
   *
   * @param material A container holding all of the fields to check for in the page.
   */
  public void doesNotHaveMaterial(Material material) {
    // Required fields
    assertThat(this.pageSource()).doesNotContain(material.getName());
  }



  /**
   * View the first material on the page.
   *
   * @return The ViewMaterialPage.
<<<<<<< HEAD
   */
  public ViewMaterialPage viewFirstMaterial() {
    this.findFirst(".viewMaterial").click();
=======
   * @param index The index of the material item to view.
   */
  public ViewMaterialPage viewMaterial(int index) {
    this.findFirst("#viewMaterial" + index).click();
>>>>>>> Milestone-3
    return new ViewMaterialPage(this.getDriver());
  }


  /**
   * Click the Edit Routine button.
   *
   * @return The EditRoutinePage.
   */
  public EditRoutinePage clickEditRoutineButton() {
    this.goTo(this.findFirst("#editRoutine").getElement().getAttribute("href"));   // The usual button click doesn't
    //this.findFirst("#editRoutine").click();                                      // work, so I'm doing this instead.
    return new EditRoutinePage(this.getDriver());
  }


  /**
   * Click the Return to Routine List button.
   *
   * @return The ListRoutinesPage.
   */
  public ListRoutinesPage clickReturnToRoutineListButton() {                               // Ths usual button click
    this.goTo(this.findFirst("#returnToRoutineList").getElement().getAttribute("href"));   // doesn't work, so I'm
    //this.findFirst("#returnToRoutineList").click();                                      // doing this instead.
    return new ListRoutinesPage(this.getDriver());
  }

}
