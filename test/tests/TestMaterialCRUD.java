package tests;

import models.Material;
import models.Routine;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.test.TestBrowser;
import tests.pages.EditMaterialPage;
import tests.pages.EditRoutinePage;
import tests.pages.IndexPage;
import tests.pages.ListRoutinesPage;
import tests.pages.ViewMaterialPage;
import tests.pages.ViewRoutinePage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

/**
 * Test the live interaction of the Material pages with Chrome.
 * <p>
 * Run a server with a fake application, in-memory database and browser (Chrome) to test the system.
 *
 * When you want to *go* to a page, do new IndexPage(browser);
 * When you are already *at* a page, do new IndexPage(browser.getDriver());
 *
 * @see https://www.playframework.com/documentation/2.3.0/api/java/play/test/WithBrowser.html
 */
public class TestMaterialCRUD extends play.test.WithBrowser {

  private static Routine routine1 = null;
  private static Routine routine2 = null;
  private static Material material1 = null;
  private static Material material2 = null;
  private static Material material3 = null;

  /**
   * Populate static objects needed for testing.
   */
  public TestMaterialCRUD() {

    // TO-DO:  This type of initialization is no longer viable.  Need to find another way to do it.

    routine1 = new Routine("Test Routine Name 01", "Test Routine Description 01", 11);
    routine1.setMethod("Test Routine Method 01");
    routine1.setHandling("Test Routine Handling 01");
    routine1.setResetDuration(10);
    routine1.setResetDescription("Test Routine Reset Description 01");
    routine1.setYouTubeUrl("Test YouTube URL 01");
    routine1.setImageUrl("Test Image URL 01");

    routine2 = new Routine("02 Test Routine Name 02", "02 Test Routine Description 02", 22);
    routine2.setMethod("02 Test Routine Method 02");
    routine2.setHandling("02 Test Routine Handling 02");
    routine2.setResetDuration(20);
    routine2.setResetDescription("02 Test Routine Reset Description 02");
    routine2.setYouTubeUrl("02 Test YouTube URL 02");
    routine2.setImageUrl("02 Test Image URL 02");

    material1 = new Material(routine1, "Test Material 01");
    material1.setDescription("Test Material Description 01");
    material1.setIsConsumed(true);
    material1.setIsGivenAway(false);
    material1.setIsInspectable(true);
    material1.setPrice(11011);
    material1.setPurchaseUrl("Test Material Purchase URL 01");
    material1.setImageUrl("Test Material Image URL 01");

    material2 = new Material(routine1, "02 Test Material 02");
    material2.setDescription("02 Test Material Description 02");
    material2.setIsConsumed(false);
    material2.setIsGivenAway(true);
    material2.setIsInspectable(false);
    material2.setPrice(22022);
    material2.setPurchaseUrl("Test Material Purchase URL 02");
    material2.setImageUrl("Test Material Image URL 02");

    material3 = new Material(routine1, "Test Material 03");
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
   * A workflow that tests a basic add of Material with only the required fields.
   */
  @Test
  public void testMaterialMinimumAddDelete() {
    // browser.maximizeWindow();

    // Clear database, create a test user and login as that user.  Start at the home page...
    GlobalTest.resetDatabaseForTest("PlayWithMagic");
    GlobalTest.addUserForTest();
    IndexPage indexPage = new IndexPage(browser).loginToTestAccount();

    // Add a routine...
    EditRoutinePage editRoutinePage = indexPage.clickCreateRoutineButton();

    // Click AddMaterial... and look for error messages.
    editRoutinePage.doesNotHaveRequiredFieldErrors();
    editRoutinePage.clickAddMaterial();
    editRoutinePage.hasRequiredFieldErrors();

    // Populate the routine and click the Add Material button.
    editRoutinePage.populateRoutine(routine1);
    editRoutinePage.clickAddMaterial();

    // Click Add (in the material page) without entering any information... and look for error messages.
    EditMaterialPage editMaterialPage = new EditMaterialPage(editRoutinePage.getDriver());
    editMaterialPage.doesNotHaveRequiredFieldErrors();
    editMaterialPage.clickSubmit();
    editMaterialPage.hasRequiredFieldErrors();

    // Populate the material and click Add.
    editMaterialPage.populateMaterial(material3);
    editMaterialPage.clickSubmit();

    editRoutinePage = new EditRoutinePage(editMaterialPage.getDriver());
    editRoutinePage.hasMaterial(material3);
    editRoutinePage.deleteFirstMaterial();
    editRoutinePage.doesNotHaveMaterial(material3);
  }


  /**
   * Test Material CRUD.
   */
  @Test
  public void testMaterialCrudWorkflow() {
    // browser.maximizeWindow();

    // Clear database, create a test user and login as that user.  Start at the home page...
    GlobalTest.resetDatabaseForTest("PlayWithMagic");
    GlobalTest.addUserForTest();
    IndexPage indexPage = new IndexPage(browser).loginToTestAccount();

    // Add a routine
    EditRoutinePage editRoutinePage = indexPage.clickCreateRoutineButton();
    editRoutinePage.populateRoutine(routine1);

    // Populate material information #1
    editRoutinePage.clickAddMaterial();
    EditMaterialPage editMaterialPage = new EditMaterialPage(editRoutinePage.getDriver());
    editMaterialPage.populateMaterial(material1);
    editMaterialPage.clickSubmit();

    // Check material information in routine
    editRoutinePage = new EditRoutinePage(editMaterialPage.getDriver());
    editRoutinePage.hasMaterial(material1);

    // Save the routine
    editRoutinePage.clickSubmit();

    // Check all of the entered data
    // View the routine & check the material view
    ListRoutinesPage listRoutinesPage = new ListRoutinesPage(editMaterialPage.getDriver());
    ViewRoutinePage viewRoutinePage = listRoutinesPage.viewRoutine(0);
    viewRoutinePage.hasMaterial(material1);
    ViewMaterialPage viewMaterialPage = viewRoutinePage.viewMaterial(0);
    viewMaterialPage.hasMaterial(material1);

    // Edit the material
    listRoutinesPage = new ListRoutinesPage(browser);
    editRoutinePage = listRoutinesPage.editFirstRoutine();
    editRoutinePage.checkRoutine(routine1);
    editRoutinePage.hasMaterial(material1);
    editMaterialPage = editRoutinePage.editFirstMaterial();
    editMaterialPage.hasMaterial(material1);
    editMaterialPage.populateMaterial(material2);
    editMaterialPage.clickSubmit();

    // Check the edited routine and material
    editRoutinePage = new EditRoutinePage(editMaterialPage.getDriver());
    editRoutinePage.checkRoutine(routine1);
    editRoutinePage.doesNotHaveMaterial(material1);
    editRoutinePage.hasMaterial(material2);
    editRoutinePage.clickSubmit();

    // Verify the new material information is available on the view page
    listRoutinesPage = new ListRoutinesPage(editRoutinePage.getDriver());
    listRoutinesPage.hasRoutine(routine1);
    viewRoutinePage = listRoutinesPage.viewRoutine(0);
    viewRoutinePage.hasRoutine(routine1);
    viewRoutinePage.doesNotHaveMaterial(material1);
    viewRoutinePage.hasMaterial(material2);

    // Verify the new material page is in ViewMaterial.
    viewMaterialPage = viewRoutinePage.viewMaterial(0);
    viewMaterialPage.hasMaterial(material2);

    // Delete the first material
    editRoutinePage = viewMaterialPage.clickEditRoutineButton();
    editRoutinePage.doesNotHaveMaterial(material1);
    editRoutinePage.hasMaterial(material2);
    editRoutinePage.deleteFirstMaterial();
    editRoutinePage.doesNotHaveMaterial(material1);
    editRoutinePage.doesNotHaveMaterial(material2);

    // Delete the routine
    editRoutinePage.clickSubmit();
    listRoutinesPage = new ListRoutinesPage(editMaterialPage.getDriver());
    listRoutinesPage.hasRoutine(routine1);

// Commented out as we do not want users to delete routines.
//    listRoutinesPage.deleteFirstRoutine();
//    listRoutinesPage.doesNotHaveRoutine(routine1);

  }


  /**
   * Test to ensure that the Routine and Material entities are bi-directional.
   */
  @Test
  public void testBidirectionalEntities() {
    // browser.maximizeWindow();

    // Clear database, create a test user and login as that user.  Start at the home page...
    GlobalTest.resetDatabaseForTest("PlayWithMagic");
    GlobalTest.addUserForTest();
    IndexPage indexPage = new IndexPage(browser).loginToTestAccount();

    // Add a routine
    EditRoutinePage editRoutinePage = indexPage.clickCreateRoutineButton();
    editRoutinePage.populateRoutine(routine1);

    // Populate material information #1
    editRoutinePage.clickAddMaterial();
    EditMaterialPage editMaterialPage = new EditMaterialPage(editRoutinePage.getDriver());
    editMaterialPage.populateMaterial(material1);
    editMaterialPage.clickSubmit();

    Routine routineSrc = Routine.getAllRoutines().get(0);
    Material material = routineSrc.getMaterials().get(0);
    Routine routineDest = material.getRoutine();

    assertThat(routineSrc.getId()).isEqualTo(routineDest.getId());
  }
}