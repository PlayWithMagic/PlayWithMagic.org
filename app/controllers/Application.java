package controllers;

import models.MagicianDB;
import models.RoutineDB;
import models.SetDB;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ExperienceLevels;
import views.formdata.MagicianFormData;
import views.formdata.RoutineFormData;
import views.formdata.SetFormData;
import views.html.About;
import views.html.EditMagician;
import views.html.EditRoutine;
import views.html.EditSet;
import views.html.Help;
import views.html.Index;
import views.html.ListMagicians;
import views.html.ListRoutines;
import views.html.ViewMagician;
import views.html.ViewRoutine;

import java.util.Map;

/**
 * The application's MVC Controller class.
 *
 * @see http://www.playframework.com
 */
public class Application extends Controller {

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


  /**
   * Renders the editRoutine page with a form to add a new Routine if the ID is 0.  Otherwise, update an existing
   * Routine based on the passed in ID number.
   *
   * @param id The ID of the routine to edit (or 0 if it's a new routine).
   * @return An HTTP OK message along with the HTML content for the EditRoutine page.
   */
  public static Result editRoutine(long id) {
    RoutineFormData data = (id == 0) ? new RoutineFormData() : new RoutineFormData(RoutineDB.getRoutine(id));
    Form<RoutineFormData> formData = Form.form(RoutineFormData.class).fill(data);

    return ok(EditRoutine.render(formData));
  }


  /**
   * Delete a routine from the database and display the ListRoutines page.
   *
   * @param id The ID of the routine to delete.
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result deleteRoutine(long id) {
    RoutineDB.deleteRoutine(id);

    return ok(ListRoutines.render(RoutineDB.getRoutines()));
  }


  /**
   * Handles the request to post form data from the editRoutine page.
   *
   * @return The editRoutine page, either with errors or with form data.
   */
  public static Result postRoutine() {
    Form<RoutineFormData> formData = Form.form(RoutineFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println("HTTP Form Error.");

      return badRequest(EditRoutine.render(formData));
    }
    else {
      RoutineFormData data = formData.get();
      RoutineDB.addRoutines(data);

      return ok(ListRoutines.render(RoutineDB.getRoutines()));
    }
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
   * Displays a single Routine based off of the provided ID.
   *
   * @param id The ID of the Routine to be displayed.
   * @return An HTTP OK message along with the HTML content for a single Routine page.
   */
  public static Result viewRoutine(long id) {
    return ok(ViewRoutine.render(RoutineDB.getRoutine(id)));
  }


  /**
   * Renders the editSet page with a form to add a new Set if the ID is 0.  Otherwise, update an existing
   * Set based on the passed in ID number.
   *
   * @param id The ID of the Set to edit (or 0 if it's a new routine).
   * @return An HTTP OK message along with the HTML content for the EditSet page.
   */
  public static Result editSet(long id) {
    SetFormData data = (id == 0) ? new SetFormData() : new SetFormData(SetDB.getSet(id));
    Form<SetFormData> formData = Form.form(SetFormData.class).fill(data);

    return ok(EditSet.render(formData, RoutineDB.getRoutines()));
  }
}
