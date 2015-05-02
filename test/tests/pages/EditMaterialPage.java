package tests.pages;

import models.Material;
import org.openqa.selenium.WebDriver;
import tests.GlobalTest;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides scaffolding to remotely control the EditMaterial page for testing.
 *
 * When you want to *go* to a page, do new EditMaterial(browser);
 * When you are already *at* a page, do new EditMaterial(browser.getDriver());
 *
 */
public class EditMaterialPage extends NavigationWrapper {

  /**
   * The browser should already be at the EditMaterial page.  Make sure the browser is already there.
   *
   * Note:  You can't navigate directly to an EditMaterial page (for example, by typing a URL in a browser)... you
   * must go through EditRoutine first.
   *
   * @param webDriver The state of the current test browser.
   */
  public EditMaterialPage(WebDriver webDriver) {
    super(webDriver);
    isAt();
  }


  /**
   * Validate that the browser is on the right page.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(GlobalTest.APPLICATION_NAME);
    assertThat(pageSource()).contains("<body id=\"editMaterial\">");
  }


  /**
   * Click the Add or Update button (submit) at the bottom of the page.
   * <p>
   * This returns void because we don't know which page it would render...
   *   On success, it goes to EditRoutine
   *   On error, it stays on EditMaterial
   */
  public void clickSubmit() {
    this.findFirst("#submit").click();
  }


  /**
   * Set passed values into the form.
   *
   * @param material A container holding all of the fields to populate the Material with.
   */
  public void populateMaterial(Material material) {
    // Required fields
    fillRequiredField("#name", material.getName());

    // Optional fields
    // Checkbox #isInspectable is not implemented
    // Checkbox #isGivenAway is not implemented
    // Checkbox #isConsumed is not implemented
    fillOptionalField("#price", material.getPrice());
    fillOptionalField("#purchaseUrl", material.getPurchaseUrl());
    fillOptionalField("#description", material.getDescription());
    fillOptionalField("#imageUrl", material.getImageUrl());
  }


  /**
   * Test to ensure the page does not have required field validation errors.
   */
  public void doesNotHaveRequiredFieldErrors() {
    assertThat(this.pageSource()).doesNotContain("A name for the material is required.");
  }


  /**
   * Test to ensure the page has all of the required field validation errors.
   */
  public void hasRequiredFieldErrors() {
    assertThat(this.pageSource()).contains("A name for the material is required.");
  }

}
