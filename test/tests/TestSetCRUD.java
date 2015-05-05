package tests;

import models.Routine;
import models.Set;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.Logger;
import play.test.TestBrowser;
import tests.pages.EditRoutinePage;
import tests.pages.EditSetPage;
import tests.pages.IndexPage;
import tests.pages.ListRoutinesPage;
import tests.pages.ListSetsPage;
import views.formdata.RoutineFormData;
import views.formdata.SetFormData;

import java.util.ArrayList;
import java.util.List;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

/**
 * Test the live interaction of the Set pages with Chrome.
 * <p>
 * Run a server with a fake application, in-memory database and browser (Chrome) to test the system.
 *
 * When you want to *go* to a page, do new IndexPage(browser);
 * When you are already *at* a page, do new IndexPage(browser.getDriver());
 *
 * @see https://www.playframework.com/documentation/2.3.0/api/java/play/test/WithBrowser.html
 */
public class TestSetCRUD extends play.test.WithBrowser {

  private static Set set1;
  private static Set set2;
  private static Routine routine1 = null;
  private static Routine routine2 = null;
  private static Routine routine3 = null;

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
   * Populate static objects needed for testing.
   */
  public void initializeTest() {
    /*
    RoutineFormData routineFormData;
    SetFormData setFormData;

    routineFormData = new RoutineFormData();
    routineFormData.id = 0;
    routineFormData.name = "Test Routine Name 01";
    routineFormData.description = "Test Routine Description 01";
    routineFormData.duration = 11;
    routine1 = Routine.saveRoutineFromForm(routineFormData);

    routineFormData = new RoutineFormData();
    routineFormData.id = 0;
    routineFormData.name = "Test Routine Name 02";
    routineFormData.description = "Test Routine Description 02";
    routineFormData.duration = 22;
    routine2 = Routine.saveRoutineFromForm(routineFormData);

    routineFormData = new RoutineFormData();
    routineFormData.id = 0;
    routineFormData.name = "Test Routine Name 03";
    routineFormData.description = "Test Routine Description 03";
    routineFormData.duration = 33;
    routine3 = Routine.saveRoutineFromForm(routineFormData);

    setFormData = new SetFormData();
    setFormData.id = 0;
    setFormData.magicianId = 0;  // TODO: Find this value
    setFormData.name = "Test Set Name 01";
    setFormData.description = "Test Set Description 01";
    setFormData.routines = new ArrayList<Routine>();
    setFormData.routines.add(routine1);
    setFormData.routines.add(routine3);
    set1 = Set.createSetFromForm(setFormData);
*/
    /*
    set1 = new Set(-1, "Test Set Name 01", "Test Set Description 01", null);
    set2 = new Set(-1, "02 Test Set Name 02", "02 Test Set Description 02", null);
    */
    Logger.debug("Test Routines constructed");
  }

    /**
     * Test Set navigation from the Index page and navigation bars.
     */
//  @Test
  public void testSetNav() {
    // browser.maximizeWindow();

    // Clear database, create a test user and login as that user.  Start at the home page...
    GlobalTest.resetDatabaseForTest("PlayWithMagic");
    GlobalTest.addUserForTest();
    IndexPage indexPage = new IndexPage(browser).loginToTestAccount();

    // Click the Browse Sets button
    ListSetsPage listSetsPage = indexPage.clickBrowseSetsButton();

    // Click the Create Sets button
    EditSetPage editSetPage = listSetsPage.clickCreateSetButton();
  }


  /**
   * A workflow that tests a basic add and delete with only the required fields.
   */
//  @Test
  public void testSetMinimumAddDelete() {
    // browser.maximizeWindow();

    // Clear database, create a test user and login as that user.  Start at the home page...
    GlobalTest.resetDatabaseForTest("PlayWithMagic");
    GlobalTest.addUserForTest();
    IndexPage indexPage = new IndexPage(browser).loginToTestAccount();
    initializeTest();

    // Add a set without entering any information... this should generate an error.
    EditSetPage editSetPage = indexPage.clickCreateSetButton();
    editSetPage.doesNotHaveRequiredFieldErrors();
    editSetPage.clickSubmit();
    editSetPage.hasRequiredFieldErrors();

    // This is all we'll test for now because all fields are required for sets
  }


  /**
   * Test Set CRUD.
   */
  @Test
  public void testSetCrudWorkflow() {
    // browser.maximizeWindow();

    // Clear database, create a test user and login as that user.  Start at the home page...
    GlobalTest.resetDatabaseForTest("PlayWithMagic");
    GlobalTest.addUserForTest();
    IndexPage indexPage = new IndexPage(browser).loginToTestAccount();
    initializeTest();

 // Add a Set.
    EditSetPage editSetPage = indexPage.clickCreateSetButton();
    editSetPage.populateSet(set1);
    editSetPage.clickSubmit();




/*
    Long routineId1;
    Long routineId2;
    Long routineId3;

    // Create three routines used for testing
  //  EditRoutinePage editRoutinePage;
    editRoutinePage = new EditRoutinePage(browser);
    editRoutinePage.populateRoutine(routine1);
// TODO:  This will no longer work with Postgres.
    routineId1 = RoutineDB.getRoutines().get(0).getId();

    editRoutinePage = new EditRoutinePage(browser);
    editRoutinePage.populateRoutine(routine2);
    routineId2 = RoutineDB.getRoutines().get(1).getId();

    editRoutinePage = new EditRoutinePage(browser);
    editRoutinePage.populateRoutine(routine3);
    routineId3 = RoutineDB.getRoutines().get(2).getId();

    // browser.maximizeWindow();

    // Start at the home page...
    browser.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/");
    assertThat(browser.pageSource()).contains("We're looking for a few good routines");

    // Click Add Set
    browser.findFirst("#createNew").click();
    browser.findFirst("#createSet").click();
    assertThat(browser.pageSource()).contains("Create Set");

    // Populate the fields, the first and third routines and click Add
    browser.fill("#name").with(set1.getName());
    browser.fill("#description").with(set1.getDescription());
    browser.findFirst("input[id=\"" + routineId1 + "\"").click();
    browser.findFirst("input[id=\"" + routineId3 + "\"").click();
    browser.click(browser.find("#submit"));

    // Verify the new set is in the list
    assertThat(browser.pageSource()).contains("Current Sets");
    assertThat(browser.pageSource()).contains(set1.getName());

    // View the new set and verify its contents
    browser.findFirst(".viewSet").click();
    assertThat(browser.pageSource()).contains(set1.getName());
    assertThat(browser.pageSource()).contains(set1.getDescription());
    assertThat(browser.pageSource()).contains(routine1.getName());
    assertThat(browser.pageSource()).doesNotContain(routine2.getName());
    assertThat(browser.pageSource()).contains(routine3.getName());

    // Go back to Edit Set and verify everyting is good
    browser.goTo(browser.findFirst(".editSet").getElement().getAttribute("href"));
    assertThat(browser.pageSource()).contains(set1.getName());
    assertThat(browser.pageSource()).contains(set1.getDescription());
    assertThat(browser.findFirst("input[id=\"" + routineId1 + "\"").isSelected());
    assertThat(!browser.findFirst("input[id=\"" + routineId2 + "\"").isSelected());
    assertThat(browser.findFirst("input[id=\"" + routineId3 + "\"").isSelected());

    // Now change all of the fields
    browser.fill("#name").with(set2.getName());
    browser.fill("#description").with(set2.getDescription());
    browser.findFirst("input[id=\"" + routineId1 + "\"").click();
    browser.findFirst("input[id=\"" + routineId2 + "\"").click();
    browser.findFirst("input[id=\"" + routineId3 + "\"").click();

    browser.click(browser.find("#submit"));

    // Verify the new set is in the list
    assertThat(browser.pageSource()).contains("Current Sets");
    assertThat(browser.pageSource()).contains(set2.getName());

    // View the new set and verify its contents
    browser.findFirst(".viewSet").click();
    assertThat(browser.pageSource()).contains(set2.getName());
    assertThat(browser.pageSource()).contains(set2.getDescription());
    assertThat(browser.pageSource()).doesNotContain(routine1.getName());
    assertThat(browser.pageSource()).contains(routine2.getName());
    assertThat(browser.pageSource()).doesNotContain(routine3.getName());

    // Go back to list sets and delete the set
    browser.goTo(browser.findFirst(".listSets").getElement().getAttribute("href"));
    assertThat(browser.pageSource()).contains("Current Sets");
    assertThat(browser.pageSource()).contains(set2.getName());
    browser.findFirst(".deleteSet").click();
    assertThat(browser.pageSource()).doesNotContain(set2.getName());
*/
  }


  /**
   * Test to verify that a EditSet form submission works and results can be viewed on the ListSets Page.
   */
  // TODO:  This needs to get re-added to the test suite when it can populate its own routines.
//  @Test
  public void testCreateNewSet() {
    // browser.maximizeWindow();

    ListSetsPage listSetsPage = new ListSetsPage(browser);
    EditSetPage editSetPage = new EditSetPage(browser);
    String name = "My First Set";
    String description = "This is the first set that I have built!";
    List<Long> routineList = new ArrayList<Long>();
    // TODO:  This needs to be refactored to populate its own routines (1 and 3 below)
    //routineList.add(1L);
    //routineList.add(3L);
    editSetPage.createSet(name, description, routineList);
    browser.goTo(listSetsPage);
    listSetsPage.isAt();
    listSetsPage.hasSet(name);
    // TODO:  Add tests to ensure the routines that should be in here are in here
  }

}
