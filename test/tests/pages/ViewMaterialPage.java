package tests.pages;

import models.Material;
import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the ViewMaterial page.
 *
 * When you want to *go* to a page, do new ViewMaterialPage(browser);
 * When you are already *at* a page, do new ViewMaterialPage(browser.getDriver());
 *
 */
public class ViewMaterialPage extends NavigationWrapper {
  /**
   * Go directly to the ViewMaterial page and make sure the browser gets there.
   *
   * @param browser A remotely controlled test browser.
   * @param id      The ID number of the material to view.
   */
  public ViewMaterialPage(TestBrowser browser, long id) {
    super(browser.getDriver());
    this.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/viewMaterial?id=" + id);
    isAt();
  }


  /**
   * The browser should already be at the ViewMaterial page.  Make sure the browser is there.
   *
   * @param webDriver The state of the current test browser.
   */
  public ViewMaterialPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource()).contains("<h3>Notes</h3>");
    assertThat(pageSource()).contains("<h3>Usage</h3>");
    assertThat(pageSource()).contains("<h3>Procurement</h3>");
  }


  /**
   * Check the contents of the page for a Material.
   *
   * @param material A container holding all of the fields to check for in the page.
   */
  public void hasMaterial(Material material) {
    // Required fields
    assertThat(this.pageSource()).contains(material.getName());

    // Optional fields
    checkOptionalField(material.getDescription());
    checkOptionalField(material.getPrice());
    checkOptionalField(material.getPurchaseUrl());
    // checkOptionalField(material.getImageUrl());  // TO-DO Implement image upload tests someday
    // TO-DO: Add assertThat for "Is Inspectable? Yes"... (true/false x 3 fields)
  }


  /**
   * Click the View Routine button.
   *
   * @return The ViewRoutinePage.
   */
  public ViewRoutinePage clickViewRoutineButton() {
    this.findFirst("#viewRoutine").click();
    return new ViewRoutinePage(this.getDriver());
  }


  /**
   * Click the Edit Routine button.
   *
   * @return The EditRoutinePage.
   */
  public EditRoutinePage clickEditRoutineButton() {
    this.findFirst("#editRoutine").click();
    return new EditRoutinePage(this.getDriver());
  }


  /**
   * Click the Edit Material button.
   *
   * @return The EditMaterialPage.
   */
  public EditMaterialPage clickEditMaterialButton() {
    this.findFirst("#editMaterial").click();
    return new EditMaterialPage(this.getDriver());
  }

}
