package tests;

import models.Material;
import models.Routine;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.test.TestBrowser;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

/**
 * Test the live interaction of the Material pages with Chrome.
 * <p>
 * Run a server with a fake application, in-memory database and browser (Chrome) to test the system.
 *
 * @see https://www.playframework.com/documentation/2.3.0/api/java/play/test/WithBrowser.html
 */
public class TestMaterialCRUD extends play.test.WithBrowser {

  private static Routine routine1 = null;
  private static Material material1 = null;
  private static Material material2 = null;

  /**
   * Populate static objects needed for testing.
   */
  public TestMaterialCRUD() {
    routine1 = new Routine(0, "Test Routine Name", "Test Routine Description", 11);
    routine1.setMethod("Test Routine Method");
    routine1.setHandling("Test Routine Handling");
    routine1.setResetDuration(21);
    routine1.setResetDescription("Test Routine Reset Description");
    routine1.setYouTubeUrl("Test YouTube URL");
    routine1.setImageUrl("Test Image URL");

    material1 = new Material("Test Material 01");
    material1.setDescription("Test Material Description 01");
    material1.isConsumed(true);
    material1.isGivenAway(false);
    material1.isInspectable(true);
    material1.setPrice(11011);
    material1.setPurchaseUrl("Test Material Purchase URL 01");
    material1.setImageUrl("Test Material Image URL 01");

    material2 = new Material("Test Material 02");
    material2.setDescription("Test Material Description 02");
    material2.isConsumed(false);
    material2.isGivenAway(true);
    material2.isInspectable(false);
    material2.setPrice(22022);
    material2.setPurchaseUrl("Test Material Purchase URL 02");
    material2.setImageUrl("Test Material Image URL 02");
  }

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
   * Test Material CRUD.
   * <p>
   * This is a large workflow because the Play Framework the application restarts between tests -- which wipes
   * out the in-memory database.
   */
  @Test
  public void testMaterialCrudWorkflow() {
    // browser.maximizeWindow();

    // Start at the home page...
    browser.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/");
    assertThat(browser.pageSource()).contains("We're looking for a few good routines");

    // Click Logged in Username -> Create Routine
    browser.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/editRoutine");
    assertThat(browser.pageSource()).contains("Create Routine");

    // Click Add Material without entering any information... this should generate an error.
    assertThat(browser.pageSource()).doesNotContain("Your routine's gotta have a name.");
    browser.click(browser.find("#add-material"));
    assertThat(browser.pageSource()).contains("Your routine's gotta have a name.");

    // Populate required Routine information and click Add Material...
    browser.fill("#name").with(routine1.getName());
    browser.fill("#description").with(routine1.getDescription());
    browser.fill("#duration").with(routine1.getDuration().toString());
    browser.click(browser.find("#add-material"));
    browser.await().untilPage().isLoaded();

    // Add first new Material item...
    assertThat(browser.pageSource()).contains("New Item");
    browser.fill("#name").with(material1.getName());
    browser.fill("#description").with(material1.getDescription());
    if (material1.isInspectable()) {
      browser.find("#isInspectable").click();
    }
    if (material1.isGivenAway()) {
      browser.find("#isGivenAway").click();
    }
    if (material1.isConsumed()) {
      browser.find("#isConsumed").click();
    }
    browser.fill("#price").with(material1.getPrice().toString());
    browser.fill("#purchaseUrl").with(material1.getPurchaseUrl());
    browser.fill("#imageUrl").with(material1.getImageUrl());

    browser.click(browser.find("#submit"));

    // Verify the basic material information is in the Routine page
    assertThat(browser.pageSource()).contains("Update Routine");
    assertThat(browser.pageSource()).contains(material1.getName());
    assertThat(browser.pageSource()).contains(material1.getPrice().toString());
    assertThat(browser.pageSource()).contains(material1.getImageUrl());

    // Edit the material in the routine
    browser.click(browser.find("#edit-material"));
    browser.fill("#name").with(material2.getName());
    browser.fill("#description").with(material2.getDescription());
    browser.fill("#price").with(material2.getPrice().toString());
    browser.fill("#purchaseUrl").with(material2.getPurchaseUrl());
    browser.fill("#imageUrl").with(material2.getImageUrl());

    String routineId = browser.findFirst("#routineId").getValue();
    String materialId = browser.findFirst("#materialId").getValue();

    browser.click(browser.find("#submit"));

    // Verify the basic material is updated on the Routine page
    assertThat(browser.pageSource()).contains("Update Routine");
    assertThat(browser.pageSource()).contains(material2.getName());
    assertThat(browser.pageSource()).contains(material2.getPrice().toString());
    assertThat(browser.pageSource()).contains(material2.getImageUrl());

    // Verify all material information is on the View page
    browser.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/viewMaterial"
            + "?routineId=" + routineId
            + "&materialId=" + materialId
    );  //http://localhost:9000/viewMaterial?routineId=3&materialId=0
    assertThat(browser.pageSource()).contains(material2.getName());
    assertThat(browser.pageSource()).contains(material2.getDescription());
    // The checkboxes are not fully implemented because it's difficult to get their state out of the page
    assertThat(browser.pageSource()).contains(material2.getPrice().toString());
    assertThat(browser.pageSource()).contains(material2.getPurchaseUrl());
    assertThat(browser.pageSource()).contains(material2.getImageUrl());

    // Go to the Routine page
    browser.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/editRoutine"
            + "?id=" + routineId
    );  //http://localhost:9000/editRoutine?id=1

    // Delete the material
    assertThat(browser.pageSource()).contains(material2.getName());
    browser.findFirst("#delete-material").click();
    assertThat(browser.pageSource()).doesNotContain(material2.getName());

    browser.click(browser.find("#submit"));

    // Delete the routine
    assertThat(browser.pageSource()).contains(routine1.getName());
    browser.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/deleteRoutine"
            + "?id=" + routineId
    );  //http://localhost:9000/deleteRoutine?id=3
    assertThat(browser.pageSource()).doesNotContain(routine1.getName());
  }

}