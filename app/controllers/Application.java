package controllers;

import models.MagicianDB;
import models.RoutineDB;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ExperienceLevels;
import views.formdata.MagicianFormData;
import views.formdata.MaterialFormData;
import views.formdata.RoutineFormData;
import views.html.About;
import views.html.EditMagician;
import views.html.EditMaterial;
import views.html.EditRoutine;
import views.html.Help;
import views.html.Index;
import views.html.ListMagicians;
import views.html.ListRoutines;
import views.html.ViewMagician;
import views.html.ViewRoutine;

import java.util.Map;

/**
 * Play With Magic's MVC Controller class.
 *
 * @see http://www.playframework.com
 */
public class Application extends Controller {

  /******************************************************************************************************************
   * B A S I C   P A G E S
   ******************************************************************************************************************/

  /**
   * Render the Home/Index page.
   *
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result index() {
    return ok(Index.render());
  }


  /**
   * Render the About page.
   *
   * @return An HTTP OK message along with the HTML content for the About page.
   */
  public static Result about() {
    return ok(About.render());
  }


  /**
   * Render the Help page.
   *
   * @return An HTTP OK message along with the HTML content for the Help page.
   */
  public static Result help() {
    return ok(Help.render());
  }


  /******************************************************************************************************************
   * M A G I C I A N
   ******************************************************************************************************************/

  /**
   * Renders the editMagician page with a form to add a Magician if the ID is 0; or edit an existing
   * Magician (based on their ID).
   *
   * @param id The ID of the magician to edit; if new Magician, ID is 0.
   * @return An HTTP OK message along with the HTML content for the EditMagician page.
   */
  public static Result editMagician(long id) {
    MagicianFormData data = (id == 0) ? new MagicianFormData() : new MagicianFormData(MagicianDB.getMagician(id));
    Form<MagicianFormData> formData = Form.form(MagicianFormData.class).fill(data);
    Map<String, Boolean> experienceLevelMap = ExperienceLevels.getExperienceLevels(data.experienceLevel);
    return ok(EditMagician.render(formData, experienceLevelMap));
  }


  /**
   * Handles the request to post form data from the EditMagician page.
   *
   * @return The EditMagician page, either with errors or success.
   */
  public static Result postMagician() {
    Form<MagicianFormData> formData = Form.form(MagicianFormData.class).bindFromRequest();

    Logger.debug("Raw Magician Form Data");
    Logger.debug("  id = [" + formData.field("id").value() + "]");
    Logger.debug("  firstName = [" + formData.field("firstName").value() + "]");
    Logger.debug("  experienceLevel = [" + formData.field("experienceLevel").value() + "]");
    Logger.debug("  yearStarted = [" + formData.field("yearStarted").value() + "]");

    if (formData.hasErrors()) {
      Logger.error("HTTP Form Error.");

      Map<String, Boolean> experienceLevelMap = null;
      if (ExperienceLevels.isExperienceLevel(formData.field("experienceLevel").value())) {
        experienceLevelMap = ExperienceLevels.getExperienceLevels(formData.field("experienceLevel").value());
      }
      else {
        experienceLevelMap = ExperienceLevels.getExperienceLevels();
      }

      return badRequest(EditMagician.render(formData, experienceLevelMap));
    }

    MagicianFormData data = formData.get();

    Logger.debug("Magician Form Data");
    Logger.debug("  id = [" + data.id + "]");
    Logger.debug("  firstName = [" + data.firstName + "]");
    Logger.debug("  experienceLevel = [" + data.experienceLevel + "]");
    Logger.debug("  yearStarted = [" + data.yearStarted + "]");

    MagicianDB.addMagicians(data);

    System.out.printf("HTTP OK; Form Data submitted:  %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, "
            + "%s, %s, %s %n", data.id, data.firstName, data.lastName, data.stageName, data.location, data.biography,
        data.interests, data.influences, data.yearStarted, data.organizations, data.website, data.email,
        data.facebook, data.twitter, data.linkedIn, data.googlePlus, data.flickr, data.instagram);
    System.out.println(data.experienceLevel);

    return ok(ListMagicians.render(MagicianDB.getMagicians()));
  }


  /**
   * Displays the full list of Magicians registered on the site.
   *
   * @return An HTTP OK message along with the HTML content for the ListMagicians page.
   */
  public static Result listMagicians() {
    return ok(ListMagicians.render(MagicianDB.getMagicians()));
  }


  /**
   * Displays a single Magician based off of the provided ID.
   *
   * @param id The ID of the Magician to be displayed.
   * @return An HTTP OK message along with the HTML content for a single Magician page.
   */
  public static Result viewMagician(long id) {
    return ok(ViewMagician.render(MagicianDB.getMagician(id)));
  }


  /**
   * Delete a Magician from the database and render the List Magicians page.
   *
   * @param id The ID of the Magician to delete.
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result deleteMagician(long id) {
    MagicianDB.deleteMagician(id);
    return ok(ListMagicians.render(MagicianDB.getMagicians()));
  }


  /******************************************************************************************************************
   * R O U T I N E
   ******************************************************************************************************************/

  /**
   * Show the EditRoutine page.  If routineId is 0, then bind the page/form with a new Routine.  Otherwise,
   * bind with an existing Routine.
   *
   * @param routineId The ID of the routine to edit (or 0 if it's a new routine).
   * @return An HTTP OK message along with the HTML content for the EditRoutine page.
   */
  public static Result editRoutine(long routineId) {
    RoutineFormData routineFormData;
    if (routineId == 0) {
      routineFormData = new RoutineFormData();
    }
    else {
      routineFormData = new RoutineFormData(RoutineDB.getRoutine(routineId));
    }

    Form<RoutineFormData> formWithRoutineData = Form.form(RoutineFormData.class).fill(routineFormData);

    return ok(EditRoutine.render(formWithRoutineData, RoutineDB.getMaterials(routineId)));
  }


  /**
   * Delete a routine from the database and display the ListRoutines page.
   *
   * @param routineId The ID of the routine to delete.
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result deleteRoutine(long routineId) {
    RoutineDB.deleteRoutine(routineId);

    return ok(ListRoutines.render(RoutineDB.getRoutines()));
  }


  /**
   * Process the POST method from the EditRoutine page.  If the form has errors, then redisplay EditRoutine.  If not,
   * then display ListRoutines.
   *
   * @return The editRoutine page, either with errors or with form data.
   */
  public static Result postRoutine() {
    Form<RoutineFormData> formWithRoutineData = Form.form(RoutineFormData.class).bindFromRequest();

    long routineId = new Long(formWithRoutineData.field("id").value()).longValue();

    if (formWithRoutineData.hasErrors()) {
      Logger.error("HTTP Routine Form Error.");

      return badRequest(EditRoutine.render(formWithRoutineData, RoutineDB.getMaterials(routineId)));
    }

    RoutineFormData routineFormData = formWithRoutineData.get();
    RoutineDB.addRoutines(routineFormData);

    return ok(ListRoutines.render(RoutineDB.getRoutines()));
  }


  /**
   * Render the List Routines page.
   *
   * @return An HTTP OK message along with the HTML content for the List Routine page.
   */
  public static Result listRoutines() {
    return ok(ListRoutines.render(RoutineDB.getRoutines()));
  }


  /**
   * Display a single Routine.
   *
   * @param routineId The ID of the Routine to be displayed.
   * @return An HTTP OK message along with the HTML content for a single Routine page.
   */
  public static Result viewRoutine(long routineId) {
    return ok(ViewRoutine.render(RoutineDB.getRoutine(routineId)));
  }


  /***************************************************************************************************************
   * M A T E R I A L
   *
   * The way we integrated Materials into Routines needs a little explanation.  Routines and Materials have a chicken-
   * and-egg problem.  Materials are stored in Routine objects.  Routine objects are not created until the Routine is
   * saved at the end of EditRoutine.  You run into trouble when, while you are composing a Routine, you
   * create/edit/delete some Materials.  The Materials wants to save itself in a Routine object that doesn't yet exist.
   *
   * How do we solve this?  Essentially, all of the Material buttons (Add material, Edit and Delete) will post
   * the Routine and save it.  If the Routine is incomplete and had errors, the EditRoutine page won't let you
   * continue to the Add/Edit Materials page until the errors are fixed.  This makes sense... the UI is not letting
   * you continue until you have a good Routine object.
   *
   * You could maintain all of the Material data in RoutineFormData.  Unfortunately, Play/Scala makes it difficult
   * to iterate over and get into the variables.  The easiest way to move forward is to hold Materials in Routine Java
   * objects... and make all of the Materials buttons do a validated Save Routine first.
   *
   ***************************************************************************************************************/

  /**
   * Show the EditMaterial page to update an item.  First, process the Routine page, deal with any errors and update
   * RoutineDB.  Finally, show the EditMaterial page.
   *
   * @param materialId The ListArray index of the Material row you want to edit.
   * @return An HTTP page EditMaterial if all is well or EditRoutine if there's an error on that page.
   */
  public static Result editMaterial(Integer materialId) {
    Form<RoutineFormData> routineFormData = Form.form(RoutineFormData.class).bindFromRequest();
    long routineId = new Long(routineFormData.field("id").value()).longValue();

    if (routineFormData.hasErrors()) {
      Logger.error("HTTP Form Error in editMaterial");

      return badRequest(EditRoutine.render(routineFormData, RoutineDB.getMaterials(routineId)));
    }

    RoutineFormData data = routineFormData.get();
    routineId = RoutineDB.addRoutines(data);

    // End of processing Routine page.  Start processing material.

    MaterialFormData materialFormData =
        new MaterialFormData(RoutineDB.getMaterials(routineId).get(materialId.intValue()), routineId, materialId);

    Form<MaterialFormData> formWithMaterialData = Form.form(MaterialFormData.class).fill(materialFormData);

    return ok(EditMaterial.render(formWithMaterialData));
  }


  /**
   * Show the EditMaterial page to create a new item.  First, process the Routine page and deal with any errors.
   * Update RoutineDB and finally show the EditMaterial page.
   *
   * @return An HTTP page EditMaterial if all is well or EditRoutine if there's an error on that page.
   */
  public static Result newMaterial() {
    Form<RoutineFormData> routineFormData = Form.form(RoutineFormData.class).bindFromRequest();
    long routineId = new Long(routineFormData.field("id").value()).longValue();

    if (routineFormData.hasErrors()) {
      Logger.error("HTTP Form Error in editMaterial");

      return badRequest(EditRoutine.render(routineFormData, RoutineDB.getMaterials(routineId)));
    }

    RoutineFormData data = routineFormData.get();
    routineId = RoutineDB.addRoutines(data);

    // End of processing Routine page.  Start processing material.

    MaterialFormData materialFormData = new MaterialFormData();
    materialFormData.routineId = routineId;
    materialFormData.materialId = -1;

    Form<MaterialFormData> formWithMaterialData = Form.form(MaterialFormData.class).fill(materialFormData);
    return ok(EditMaterial.render(formWithMaterialData));
  }


  /**
   * Delete a Material item and redisplay the EditRoutine page.  First, process the Routine page and deal with any
   * errors.  Update RoutineDB, then delete the Material item and finally redisplay EditRoutine.
   *
   * @param materialId The ArrayList index in Routine.materials of the item to delete.
   * @return An HTTP EditMaterial page.
   */
  public static Result deleteMaterial(Integer materialId) {
    Form<RoutineFormData> formWithRoutineData = Form.form(RoutineFormData.class).bindFromRequest();
    long routineId = new Long(formWithRoutineData.field("id").value()).longValue();

    if (formWithRoutineData.hasErrors()) {
      System.out.println("HTTP Form Error.");

      return badRequest(EditRoutine.render(formWithRoutineData, RoutineDB.getMaterials(routineId)));
    }

    RoutineFormData routineFormData = formWithRoutineData.get();
    routineId = RoutineDB.addRoutines(routineFormData);

    // End of processing Routine page.  Start of processing material.

    RoutineDB.getMaterials(routineId).remove(materialId.intValue());

    return ok(EditRoutine.render(formWithRoutineData, RoutineDB.getMaterials(routineId)));
  }


  /**
   * Post new and updated Material information from the EditMaterial page and add it to the Routine.  Then,
   * display EditRoutine.
   *
   * @return On success, an HTTP OK message along with the HTML content for the EditRoutine page.  On a validation
   * error, an HTTP BadRequest message with the HTML content of the EditMaterial page.
   */
  public static Result postMaterial() {
    Form<MaterialFormData> formWithMaterialData = Form.form(MaterialFormData.class).bindFromRequest();

    long routineId = new Long(formWithMaterialData.field("routineId").value()).longValue();

    if (formWithMaterialData.hasErrors()) {
      Logger.error("HTTP Form Error in postMaterial.");

      return badRequest(EditMaterial.render(formWithMaterialData));
    }

    Logger.debug("Form Field Data isInspectable = " + formWithMaterialData.field("isInspectable").value());
    MaterialFormData materialFormData = formWithMaterialData.get();

    Logger.debug("isInspectable = " + materialFormData.isInspectable);

    RoutineDB.addMaterial(materialFormData);

    RoutineFormData routineFormData = new RoutineFormData(RoutineDB.getRoutine(routineId));
    Form<RoutineFormData> formWithRoutineData = Form.form(RoutineFormData.class).fill(routineFormData);

    return ok(EditRoutine.render(formWithRoutineData, RoutineDB.getMaterials(routineId)));
  }

}
