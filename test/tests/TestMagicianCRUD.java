package tests;

import models.Magician;
import models.MagicianType;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.test.TestBrowser;
import tests.pages.EditMagicianPage;
import tests.pages.IndexPage;
import tests.pages.ListMagiciansPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;


/**
 * Test the live interaction of the Magician pages with Chrome.
 * <p>
 * Run a server with a fake application, in-memory database and browser (Chrome) to test the system.
 *
 * @see https://www.playframework.com/documentation/2.3.0/api/java/play/test/WithBrowser.html
 */
public class TestMagicianCRUD extends play.test.WithBrowser {

  private static Magician magician1 = null;
  private static Magician magician2 = null;

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

    magician1 = new Magician(
        "Test First Name 01"
        , "Test Last Name 01"
        , "Test_eMail_01@playwithmagic.org"
        , MagicianType.getMagicianType("Professional")
    );

    magician1.setStageName("Test stage name 01");
    magician1.setLocation("Test location 01");
    // Not doing userPhoto right now
    magician1.setBiography("Test biography 01");
    magician1.setInterests("Test interests 01");
    magician1.setInfluences("Test influences 01");
    magician1.setYearStarted(2000);
    magician1.setOrganizations("Test organizations 01");
    magician1.setWebsite("http://test.website.test/01");
    magician1.setFacebook("Test Facebook 01");
    magician1.setTwitter("Test Twitter 01");
    magician1.setLinkedIn("Test LinkedIn 01");
    magician1.setGooglePlus("Test GooglePlus 01");
    magician1.setFlickr("Test Flickr 01");
    magician1.setInstagram("Test Instagram 01");

    magician2 = new Magician(
        "02 Test First Name 02"
        , "02 Test Last Name 02"
        , "Test_eMail_02@playwithmagic.org"
        , MagicianType.getMagicianType("Historian")
    );

    magician2.setStageName("02 Test stage name 02");
    magician2.setLocation("02 Test location 02");
    // Not doing userPhoto right now
    magician2.setBiography("02 Test biography 02");
    magician2.setInterests("02 Test interests 02");
    magician2.setInfluences("02 Test influences 02");
    magician2.setYearStarted(1999);
    magician2.setOrganizations("02 Test organizations 02");
    magician2.setWebsite("http://test.website.test/02");
    magician2.setFacebook("02 Test Facebook 02");
    magician2.setTwitter("02 Test Twitter 02");
    magician2.setLinkedIn("02 Test LinkedIn 02");
    magician2.setGooglePlus("02 Test GooglePlus 02");
    magician2.setFlickr("02 Test Flickr 02");
    magician2.setInstagram("02 Test Instagram 02");
  }


  /**
   * Test Magician Navigation from home page and navigation bars.
   */
  @Test
  public void testMagicianNav() {
    // browser.maximizeWindow();

    // Start at the home page...
    IndexPage indexPage = new IndexPage(browser);

    // Click the Join the Community Today! button
    EditMagicianPage editMagicianPage = indexPage.clickJoinTheCommunityToday();

    // Click the Browse Magicians button
    ListMagiciansPage listMagiciansPage = editMagicianPage.clickBrowseMagiciansButton();
  }


  /**
   * A workflow that tests a basic add and delete Magician with only the required fields.
   */
  @Test
  public void testMagicianMinimumAddDelete() {
    initializeTest();

    // browser.maximizeWindow();

    // Start at the home page...
    IndexPage indexPage = new IndexPage(browser);

    // Click the Join the Community Today! button
    EditMagicianPage editMagician = indexPage.clickJoinTheCommunityToday();

    // Click Add without entering any information... this should generate an error.
    // TODO: Add these checks and counter-checks to the EditMagician class
    assertThat(editMagician.pageSource()).doesNotContain("Everybody (except Teller) has a first name.");
    assertThat(editMagician.pageSource()).doesNotContain("A Last Name must be provided.");
    assertThat(editMagician.pageSource()).doesNotContain("An Email address must be provided.");
    editMagician.clickSubmit();
    assertThat(editMagician.pageSource()).contains("Everybody (except Teller) has a first name.");
    assertThat(editMagician.pageSource()).contains("A Last Name must be provided.");
    assertThat(editMagician.pageSource()).contains("An Email address must be provided.");

    // Populate only the required information and click Add
    editMagician.fill("#firstName").with(magician1.getFirstName());
    editMagician.fill("#lastName").with(magician1.getLastName());
    editMagician.fill("#email").with(magician1.getEmail());
    editMagician.findFirst("#Professional").click();
    editMagician.clickSubmit();

    // This should be successful and the browser should go to ListMagicians.  Verify the magician.
    ListMagiciansPage listMagiciansPage = new ListMagiciansPage(editMagician.getDriver());
    listMagiciansPage.hasMagician(magician1.getFirstName() + " " + magician1.getLastName(),
        null, magician1.getMagicianType().getName());

    // Delete the magician
    listMagiciansPage.deleteFirstMagician();
    listMagiciansPage.doesNotHaveMagician(magician1.getFirstName() + " " + magician1.getLastName(),
        null, magician1.getMagicianType().getName());
  }


  /**
   * Test Magician CRUD.
   * <p>
   * This is a large workflow because the Play Framework the application restarts between tests -- which wipes
   * out the in-memory database.
   */
  @Test
  public void testMagicianCrudWorkflow() {
    initializeTest();

    // browser.maximizeWindow();

    // Start at the home page...
    browser.goTo("http://localhost:" + GlobalTest.TEST_PORT + "/");
    assertThat(browser.pageSource()).contains("We're looking for a few good routines");

    // Click the Join the Community Today! button
    browser.findFirst("#joinTheCommunity").click();
    assertThat(browser.pageSource()).contains("Magician Profile");

    // Populate all of the fields and click Add
// TODO: Fix this
//            EditMagicianPage.populateMagician(browser, magician1);
    browser.click(browser.find("#submit"));
    assertThat(browser.pageSource()).contains("Current Magicians");
    assertThat(browser.pageSource()).contains(magician1.getFirstName() + " " + magician1.getLastName());
    assertThat(browser.pageSource()).contains(magician1.getStageName());
    assertThat(browser.pageSource()).contains(magician1.getMagicianType().getName());

    // View the magician and check all of the fields
    browser.findFirst(".viewMagician").click();
    EditMagicianPage.checkMagician(browser, magician1);

    // Edit the magician and update all of the fields                                    // The button click
    browser.goTo(browser.findFirst(".editMagician").getElement().getAttribute("href"));  // didn't work, so I
    EditMagicianPage.checkMagician(browser, magician1);                                  // did this instead.
//            EditMagicianPage.populateMagician(browser, magician2);
    browser.click(browser.find("#submit"));
    assertThat(browser.pageSource()).contains("Current Magicians");
    assertThat(browser.pageSource()).contains(magician2.getFirstName() + " " + magician2.getLastName());
    assertThat(browser.pageSource()).contains(magician2.getStageName());
    assertThat(browser.pageSource()).contains(magician2.getMagicianType().getName());

    // View the magician and check all of the fields
    browser.findFirst(".viewMagician").click();
    EditMagicianPage.checkMagician(browser, magician2);

    // Go back to list magician and delete the magician
    browser.goTo(browser.findFirst(".listMagicians").getElement().getAttribute("href"));
    assertThat(browser.pageSource()).contains(magician2.getFirstName() + " " + magician2.getLastName());
    assertThat(browser.pageSource()).contains(magician2.getMagicianType().getName());
    browser.findFirst(".deleteMagician").click();
    assertThat(browser.pageSource()).doesNotContain(magician2.getFirstName() + " " + magician2.getLastName());
    assertThat(browser.pageSource()).doesNotContain(magician2.getMagicianType().getName());
  }

}
