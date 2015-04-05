package controllers;

import models.MagicianDB;
import models.RoutineDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ExperienceLevels;
import views.formdata.MagicianFormData;
import views.formdata.RoutineFormData;
import views.formdata.ShowEmail;
import views.html.Index;
import views.html.NewRoutine;

import views.html.SearchRoutines;
import views.html.NewMagician;
import views.html.ShowMagicians;

import java.util.Map;

/**
 * The application's MVC Controller class.
 *
 * @see http://www.playframework.com
 */
public class Application extends Controller {

  /**
   * Render the Home page.
   *
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result index() {
    return ok(Index.render());
  }

  /**
   * Render the Search Routines page.
   *
   * @return An HTTP OK message along with the HTML content for the Search Routine page.
   */
  public static Result searchRoutines() {
    return ok(SearchRoutines.render(RoutineDB.getRoutines()));
  }

  /**
   * Renders the newMagician page with a form to add a new Magician if the ID is 0; otherwise, edit existing Magician.
   *
   * @param id The ID of the magician to edit; if new Magician, ID is 0.
   * @return An HTTP OK message along with the HTML content for the NewMagician page.
   */
  public static Result newMagician(long id) {
    MagicianFormData data = (id == 0) ? new MagicianFormData() : new MagicianFormData(MagicianDB.getMagician(id));
    Form<MagicianFormData> formData = Form.form(MagicianFormData.class).fill(data);
    Map<String, Boolean> experienceLevelMap = ExperienceLevels.getExperienceLevels(data.experienceLevel);
    Map<String, Boolean> showMyEmailMap = ShowEmail.getShowMyEmail(data.showEmail);
    return ok(NewMagician.render(formData, experienceLevelMap, showMyEmailMap));
  }

  /**
   * Handles the request to post form data from the NewMagician page.
   *
   * @return The NewMagician page, either with errors or success.
   */
  public static Result postMagician() {
    Form<MagicianFormData> formData = Form.form(MagicianFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("HTTP Form Error.");
      return badRequest(NewMagician.render(formData, ExperienceLevels.getExperienceLevels(),
          ShowEmail.getShowMyEmail()));
    }
    else {
      MagicianFormData data = formData.get();
      MagicianDB.addMagicians(data);
      System.out.printf("HTTP OK; Form Data submitted:  %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, "
              + "%s, %s, %s %n", data.id, data.firstName, data.lastName, data.stageName, data.location, data.biography,
          data.interests, data.influences, data.yearStarted, data.organizations, data.website, data.email,
          data.facebook, data.twitter, data.linkedIn, data.googlePlus, data.flickr, data.instagram);
      System.out.println(data.experienceLevel);
      System.out.println(data.showEmail);
      return ok(ShowMagicians.render(MagicianDB.getMagicians()));
    }
  }

  /**
   * Displays the full list of Magicians registered on the site.
   *
   * @return An HTTP OK message along with the HTML content for the ShowMagicians page.
   */
  public static Result showMagicians() {
    return ok(ShowMagicians.render(MagicianDB.getMagicians()));
  }

  /**
   * Delete a Magician from the database and render the Show Magicians page.
   *
   * @param id The ID of the Magician to delete.
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result deleteMagician(long id) {
    MagicianDB.deleteMagician(id);
    return ok(ShowMagicians.render(MagicianDB.getMagicians()));
  }

  /**
   * Renders the newRoutine page with a form to add new routines if the ID is 0; otherwise updates the existing routine.
   *
   * @param id The ID of the routine to edit (or 0 if it's a new routine).
   * @return An HTTP OK message along with the HTML content for the NewRoutine page.
   */
  public static Result newRoutine(long id) {
    RoutineFormData data = (id == 0) ? new RoutineFormData() : new RoutineFormData(RoutineDB.getRoutine(id));
    Form<RoutineFormData> formData = Form.form(RoutineFormData.class).fill(data);

    return ok(NewRoutine.render(formData));
  }

  /**
   * Delete a routine from the database and render the index page.
   *
   * @param id The ID of the routine to delete.
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result deleteRoutine(long id) {
    RoutineDB.deleteRoutine(id);

    return ok(SearchRoutines.render(RoutineDB.getRoutines()));
  }

  /**
   * Handles the request to post form data from the newRoutine page.
   *
   * @return The newRoutine page, either with errors or with form data.
   */
  public static Result postRoutine() {
    Form<RoutineFormData> formData = Form.form(RoutineFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println("HTTP Form Error.");

      return badRequest(NewRoutine.render(formData));
    }
    else {
      RoutineFormData data = formData.get();
      RoutineDB.addRoutines(data);

      return ok(SearchRoutines.render(RoutineDB.getRoutines()));
    }
  }
}
