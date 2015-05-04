package tests;

import models.Magician;
import models.MagicianType;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import play.test.TestBrowser;
import tests.pages.DeleteUserPage;
import tests.pages.EditMagicianPage;
import tests.pages.EditUserPage;
import tests.pages.IndexPage;
import tests.pages.ListMagiciansPage;
import tests.pages.LoginPage;
import tests.pages.ViewMagicianPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;


/**
 * Test the live interaction of the Magician pages with Chrome.
 * <p>
 * Run a server with a fake application, in-memory database and browser (Chrome) to test the system.
 * <p>
 * When you want to *go* to a page, do new IndexPage(browser);
 * When you are already *at* a page, do new IndexPage(browser.getDriver());
 *
 * @see https://www.playframework.com/documentation/2.3.0/api/java/play/test/WithBrowser.html
 */
public class TestMagicianCRUD extends play.test.WithBrowser {

  private static Magician magician1New = null;
  private static Magician magician1Update = null;
  private static Magician magician2 = null;
  private static Magician magician3 = null;

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

    magician1New = new Magician(
        "Test First Name 01"
        , "Test Last Name 01"
        , "Test_eMail_01@playwithmagic.org"
        , MagicianType.getMagicianType("Professional")
        , "11P@ssw0rd111111"
    );

    magician1New.setStageName("Test stage name 01");
    magician1New.setLocation("Test location 01");
    // Not doing userPhoto right now
    magician1New.setBiography("Test biography 01");
    magician1New.setInterests("Test interests 01");
    magician1New.setInfluences("Test influences 01");
    magician1New.setYearStarted(2000);
    magician1New.setOrganizations("Test organizations 01");
    magician1New.setWebsite("http://test.website.test/01");
    magician1New.setFacebook("Test Facebook 01");
    magician1New.setTwitter("Test Twitter 01");
    magician1New.setLinkedIn("Test LinkedIn 01");
    magician1New.setGooglePlus("Test GooglePlus 01");
    magician1New.setFlickr("Test Flickr 01");
    magician1New.setInstagram("Test Instagram 01");

    // Note:  The eMail needs to stay the same.
    magician1Update = new Magician(
        "02 Test First Name 02"
        , "02 Test Last Name 02"
        , magician1New.getEmail()
        , MagicianType.getMagicianType("Historian")
        , "22P@ssw0rd222222"
    );
    magician1Update.setStageName("02 Test stage name 02");
    magician1Update.setLocation("02 Test location 02");
    // Not doing userPhoto right now
    magician1Update.setBiography("02 Test biography 02");
    magician1Update.setInterests("02 Test interests 02");
    magician1Update.setInfluences("02 Test influences 02");
    magician1Update.setYearStarted(1999);
    magician1Update.setOrganizations("02 Test organizations 02");
    magician1Update.setWebsite("http://test.website.test/02");
    magician1Update.setFacebook("02 Test Facebook 02");
    magician1Update.setTwitter("02 Test Twitter 02");
    magician1Update.setLinkedIn("02 Test LinkedIn 02");
    magician1Update.setGooglePlus("02 Test GooglePlus 02");
    magician1Update.setFlickr("02 Test Flickr 02");
    magician1Update.setInstagram("02 Test Instagram 02");

    magician2 = new Magician(
        "02 Test First Name 02"
        , "02 Test Last Name 02"
        , "Test_eMail_02@playwithmagic.org"
        , MagicianType.getMagicianType("Historian")
        , "P@ssw0rd"
    );

    magician3 = new Magician(
        "03 Test First Name 03"
        , "03 Test Last Name 03"
        , "Test_eMail_03@playwithmagic.org"
        , MagicianType.getMagicianType("Historian")
        , "P@ssw0rd"
    );

  }


  /**
   * Test Magician navigation from home page and navigation bars.
   */
  @Test
  public void testMagicianNav() {
    // browser.maximizeWindow();

    // Start at the home page...
    IndexPage indexPage = new IndexPage(browser);

    // Click the Join the Community Today! button
    EditUserPage editUserPage = indexPage.clickJoinTheCommunityToday();

    // Click the Browse Magicians button
    ListMagiciansPage listMagiciansPage = editUserPage.clickBrowseMagiciansButton();
  }


  /**
   * A workflow that tests a basic add and delete Magician with only the required fields.
   */
  @Test
  public void testMagicianMinimumAddDelete() {
    initializeTest();
    GlobalTest.resetDatabaseForTest("PlayWithMagic");

    // browser.maximizeWindow();

    // Start at the home page...
    IndexPage indexPage = new IndexPage(browser);

    // Click the Join the Community Today! button
    EditUserPage editUserPage = indexPage.clickJoinTheCommunityToday();

    // Click Add without entering any information... this should generate an error.
    editUserPage.doesNotHaveRequiredFieldErrors();
    editUserPage.clickSubmit();
    editUserPage.hasRequiredFieldErrors();

    // Populate only the required information and click Add
    editUserPage.populateMagician(magician3);
    editUserPage.clickSubmit();

    // This should be successful and the browser should go to IndexPage (unauthenticated).  Login as the new user.
    indexPage = new IndexPage(editUserPage.getDriver());
    assertThat(indexPage.pageSource()).contains("Successfully Signed Up!");
    assertThat(indexPage.isUnauthenticated()).isTrue();
    assertThat(indexPage.isAuthenticated()).isFalse();
    LoginPage loginPage = indexPage.clickLoginButton();
    loginPage.populateLogin(magician3);
    loginPage.clickSubmit();

    // This should be successful and the browser should go to IndexPage (authenticated).
    indexPage = new IndexPage(loginPage.getDriver());
    assertThat(indexPage.isUnauthenticated()).isFalse();
    assertThat(indexPage.isAuthenticated()).isTrue();

    // This should be successful and the browser should go to ViewMagician.  Verify the magician.
    ViewMagicianPage viewMagicianPage = indexPage.clickProfileButton();
    viewMagicianPage.hasMagician(magician3);

    // Check the magician in EditMagician.
    EditMagicianPage editMagicianPage = viewMagicianPage.clickEditProfileButton();
    editMagicianPage.checkMagician(magician3);
    editMagicianPage.clickSubmit();

    // This should be successful and the browser should go to ListMagicians.  Verify the magician.
    ListMagiciansPage listMagiciansPage = new ListMagiciansPage(editUserPage.getDriver());
    listMagiciansPage.hasMagician(magician3);

    // Delete the magician
    viewMagicianPage = listMagiciansPage.viewFirstMagician();
    DeleteUserPage deleteUserPage = viewMagicianPage.clickDeleteAccountButton();

    // Try clicking the Delete button without any input... it should generate an error.
    deleteUserPage.doesNotHaveRequiredFieldErrors();
    deleteUserPage.clickSubmit();
    deleteUserPage.hasRequiredFieldErrors();

    // Delete the magician (for real)
    deleteUserPage.populateDeleteUser(magician3.getPassword());
    deleteUserPage.clickSubmit();

    // Should be on the index page (unauthenticated)
    indexPage = new IndexPage(deleteUserPage.getDriver());
    assertThat(indexPage.isUnauthenticated()).isTrue();

    // Try logging in
    loginPage = indexPage.clickLoginButton();
    loginPage.populateLogin(magician3);
    loginPage.clickSubmit();
    loginPage.hasRequiredFieldErrors();
  }


  /**
   * Test Magician CRUD.
   */
  @Test
  public void testMagicianCrudWorkflow() {
    initializeTest();
    GlobalTest.resetDatabaseForTest("PlayWithMagic");

    // browser.maximizeWindow();

    // Start at the home page...
    IndexPage indexPage = new IndexPage(browser);

    // Click the Join the Community Today! button
    EditUserPage editUserPage = indexPage.clickJoinTheCommunityToday();

    // Populate all of the fields and click Add
    editUserPage.populateMagician(magician1New);
    editUserPage.clickSubmit();

    // This should be successful and the browser should go to IndexPage (unauthenticated).  Login as the new user.
    indexPage = new IndexPage(editUserPage.getDriver());
    assertThat(indexPage.pageSource()).contains("Successfully Signed Up!");
    assertThat(indexPage.isUnauthenticated()).isTrue();
    assertThat(indexPage.isAuthenticated()).isFalse();
    LoginPage loginPage = indexPage.clickLoginButton();
    loginPage.populateLogin(magician1New);
    loginPage.clickSubmit();

    // This should be successful and the browser should go to IndexPage (authenticated).
    indexPage = new IndexPage(loginPage.getDriver());
    assertThat(indexPage.isUnauthenticated()).isFalse();
    assertThat(indexPage.isAuthenticated()).isTrue();

    // Go to EditMagician page, populate all of the fields and click Add
    ViewMagicianPage viewMagicianPage = indexPage.clickProfileButton();
    EditMagicianPage editMagicianPage = viewMagicianPage.clickEditProfileButton();
    editMagicianPage.populateMagician(magician1New);
    editMagicianPage.clickSubmit();

    // This should be successful and the browser should go to ListMagicians.  Verify the magician.
    ListMagiciansPage listMagiciansPage = new ListMagiciansPage(editMagicianPage.getDriver());
    listMagiciansPage.hasMagician(magician1New);

    // Check ViewMagicians page.
    viewMagicianPage = listMagiciansPage.viewFirstMagician();
    viewMagicianPage.hasMagician(magician1New);

    // Update the user
    editUserPage = viewMagicianPage.clickChangePasswordButton();
    editUserPage.checkMagician(magician1New);
    editUserPage.populateMagician(magician1Update);
    editUserPage.clickSubmit();

    indexPage = new IndexPage(editUserPage.getDriver());
    viewMagicianPage = indexPage.clickProfileButton();
    editMagicianPage = viewMagicianPage.clickEditProfileButton();
    editMagicianPage.populateMagician(magician1Update);
    editMagicianPage.clickSubmit();  //  Back to ListMagicians...

    // Verify the new information is in the list and the old information is not.
    listMagiciansPage = new ListMagiciansPage(editMagicianPage.getDriver());
    listMagiciansPage.doesNotHaveMagician(magician1New);
    listMagiciansPage.hasMagician(magician1Update);

    // Verify the new information is in ViewMagician
    viewMagicianPage = listMagiciansPage.viewFirstMagician();
    viewMagicianPage.hasMagician(magician1Update);
    listMagiciansPage = viewMagicianPage.clickReturnToMagicianListButton();

    // Verify the new information is in the User
    editUserPage = listMagiciansPage.changeFirstMagicianPassword();
    editUserPage.checkMagician(magician1Update);
    listMagiciansPage = editUserPage.clickBrowseMagiciansButton();

    // Delete the magician
    viewMagicianPage = listMagiciansPage.viewFirstMagician();
    DeleteUserPage deleteUserPage = viewMagicianPage.clickDeleteAccountButton();
    deleteUserPage.populateDeleteUser(magician1Update.getPassword());
    deleteUserPage.clickSubmit();

    // Should be on the index page (unauthenticated)
    indexPage = new IndexPage(deleteUserPage.getDriver());
    assertThat(indexPage.isUnauthenticated()).isTrue();
  }


  /**
   * Test to ensure that the Magician and MagicianType entities are bi-directional.
   */
  @Test
  public void testMagicianType() {
    initializeTest();
    GlobalTest.resetDatabaseForTest("PlayWithMagic");

    // browser.maximizeWindow();
    EditUserPage editUserPage;
    IndexPage indexPage;
    ViewMagicianPage viewMagicianPage;
    EditMagicianPage editMagicianPage;
    ListMagiciansPage listMagiciansPage;
    LoginPage loginPage;

    // Add three magicians
    editUserPage = new EditUserPage(browser);
    editUserPage.populateMagician(magician1New);
    editUserPage.clickSubmit();
    indexPage = new IndexPage(editUserPage.getDriver());
    loginPage = indexPage.clickLoginButton();
    loginPage.populateLogin(magician1New);
    loginPage.clickSubmit();
    indexPage = new IndexPage(loginPage.getDriver());
    viewMagicianPage = indexPage.clickProfileButton();
    editMagicianPage = viewMagicianPage.clickEditProfileButton();
    editMagicianPage.populateMagician(magician1New);
    editMagicianPage.clickSubmit();
    listMagiciansPage = new ListMagiciansPage(editMagicianPage.getDriver());
    listMagiciansPage.clickLogoutButton();

    editUserPage = new EditUserPage(browser);
    editUserPage.populateMagician(magician2);
    editUserPage.clickSubmit();
    indexPage = new IndexPage(editUserPage.getDriver());
    loginPage = indexPage.clickLoginButton();
    loginPage.populateLogin(magician2);
    loginPage.clickSubmit();
    indexPage = new IndexPage(loginPage.getDriver());
    viewMagicianPage = indexPage.clickProfileButton();
    editMagicianPage = viewMagicianPage.clickEditProfileButton();
    editMagicianPage.populateMagician(magician2);
    editMagicianPage.clickSubmit();
    listMagiciansPage = new ListMagiciansPage(editMagicianPage.getDriver());
    listMagiciansPage.clickLogoutButton();

    editUserPage = new EditUserPage(browser);
    editUserPage.populateMagician(magician3);
    editUserPage.clickSubmit();
    indexPage = new IndexPage(editUserPage.getDriver());
    loginPage = indexPage.clickLoginButton();
    loginPage.populateLogin(magician3);
    loginPage.clickSubmit();
    indexPage = new IndexPage(loginPage.getDriver());
    viewMagicianPage = indexPage.clickProfileButton();
    editMagicianPage = viewMagicianPage.clickEditProfileButton();
    editMagicianPage.populateMagician(magician3);
    editMagicianPage.clickSubmit();
    listMagiciansPage = new ListMagiciansPage(editMagicianPage.getDriver());
    listMagiciansPage.clickLogoutButton();

    // We should have 1 professional and 2 historians.
    assertThat(MagicianType.getMagicianType("Neophyte").getMagicians().size()).isEqualTo(0);
    assertThat(MagicianType.getMagicianType("Enthusiast").getMagicians().size()).isEqualTo(0);
    assertThat(MagicianType.getMagicianType("Hobbyist").getMagicians().size()).isEqualTo(0);
    assertThat(MagicianType.getMagicianType("Semi-Professional").getMagicians().size()).isEqualTo(0);
    assertThat(MagicianType.getMagicianType("Professional").getMagicians().size()).isEqualTo(1);
    assertThat(MagicianType.getMagicianType("Historian").getMagicians().size()).isEqualTo(2);
    assertThat(MagicianType.getMagicianType("Collector").getMagicians().size()).isEqualTo(0);

    // ...and test the other direction.
    Magician magicianOne = Magician.find().where().eq("email", magician1New.getEmail()).findUnique();
    assertThat(magicianOne.getMagicianType()).isEqualTo(MagicianType.getMagicianType("Professional"));
  }

}
