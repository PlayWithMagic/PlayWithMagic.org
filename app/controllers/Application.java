package controllers;

import models.RoutineDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.RoutineFormData;
import views.html.Index;
import views.html.NewRoutine;
import views.html.SearchRoutines;

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

      return ok(NewRoutine.render(formData));
    }
  }
}
