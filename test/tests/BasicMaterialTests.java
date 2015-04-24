package tests;

import models.Material;
import models.Routine;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import play.Logger;
import play.libs.F;
import play.test.TestBrowser;

import java.net.MalformedURLException;
import java.net.URL;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.FIREFOX;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Test the live interaction of the Material pages with a simulated browser.
 * <p>
 * Utilizes a test browser and the Fluentlenium framework for testing.
 */
public class BasicMaterialTests {

  /**
   * The port number on which to run the tests.
   */
  private static final int TEST_PORT = 3333;

  private static Routine routine1 = null;
  private static Material material1 = null;
  private static Material material2 = null;


  /**
   * Populate the static objects needed for testing.
   */
  public BasicMaterialTests() {
    routine1 = new Routine(0, "Test Routine Name", "Test Routine Description");
    routine1.setDuration(11);
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


  /**
   * Test Material CRUD.
   * <p>
   * This is a large workflow because the Play Framework the application restarts between tests -- and this wipes
   * out the in-memory database.
   */
  @Test
  public void testMaterialCrudWorkflow() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), ChromeDriver.class,
        new F.Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();

            // Start at the home page...
            browser.goTo("http://localhost:" + TEST_PORT + "/");
            assertThat(browser.pageSource()).contains("We're looking for a few good routines");

            // Click Logged in Username -> Create Routine
            browser.goTo("http://localhost:" + TEST_PORT + "/editRoutine");
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
            assertThat(browser.pageSource()).contains("New Item");

            // Add first new Material item...
            browser.fill("#name").with(material1.getName());
            browser.fill("#description").with(material1.getDescription());
            if(material1.isInspectable()) {
              browser.find("#isInspectable").click();
            }
            if(material1.isGivenAway()) {
              browser.find("#isGivenAway").click();
            }
            if(material1.isConsumed()) {
              browser.find("#isConsumed").click();
            }
            browser.fill("#price").with(material1.getPrice().toString());
            browser.fill("#purchaseUrl").with(material1.getPurchaseUrl());
            browser.fill("#imageUrl").with(material1.getImageUrl());

            browser.click(browser.find("#submit"));
            assertThat(browser.pageSource()).contains("Update Routine");
            assertThat(browser.pageSource()).contains(material1.getName());
            assertThat(browser.pageSource()).contains(material1.getPrice().toString());
            assertThat(browser.pageSource()).contains(material1.getImageUrl());

            // Edit the material in the routine
            browser.click(browser.find("#edit-material"));
            browser.fill("#name").with(material2.getName());
            browser.fill("#description").with(material2.getDescription());
            if(material2.isInspectable()) {
              browser.find("#isInspectable").click();
            }
            if(material2.isGivenAway()) {
              browser.find("#isGivenAway").click();
            }
            if(material2.isConsumed()) {
              browser.find("#isConsumed").click();
            }
            browser.fill("#price").with(material2.getPrice().toString());
            browser.fill("#purchaseUrl").with(material2.getPurchaseUrl());
            browser.fill("#imageUrl").with(material2.getImageUrl());

            browser.executeScript("Object gettableRoutineId = document.getElementById('routineId').value");
            //Logger.debug("I am Sam = [" + browser.find("#gettableRoutineId").getValue() + "]");



            browser.click(browser.find("#submit"));
            assertThat(browser.pageSource()).contains("Update Routine");
            assertThat(browser.pageSource()).contains(material2.getName());
            assertThat(browser.pageSource()).contains(material2.getPrice().toString());
            assertThat(browser.pageSource()).contains(material2.getImageUrl());



          }
        });
  }

}