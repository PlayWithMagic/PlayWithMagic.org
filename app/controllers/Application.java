package controllers;

import models.ContactDB;
import models.RoutineDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.RoutineFormData;
import views.html.Index;
import views.html.NewContact;
import views.html.NewRoutine;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   *
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Renders the newContact page with a form to add new contacts if the ID is 0; otherwise updates the existing contact.
   *
   * @param id The ID value passed in.
   * @return The newContact page.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    return ok(NewContact.render(formData));
  }

  /**
   * Renders the index page with the given record deleted from the in-memory database.
   *
   * @param id The ID value passed in.
   * @return The Index page.
   */
  public static Result deleteContact(long id) {
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Handles the request to post form data from the newContact page.
   *
   * @return The newContact page, either with errors or with form data.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("HTTP Form Error.");
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContacts(data);
      System.out.printf("HTTP OK; Form Data:  %s, %s, %s, %n", data.firstName, data.lastName, data.telephone);
      return ok(NewContact.render(formData));
    }
  }

  /**
   * Renders the newRoutine page with a form to add new routines if the ID is 0; otherwise updates the existing routine.
   *
   * @param id The ID value passed in.
   * @return The newRoutine page.
   */
  public static Result newRoutine(long id) {
    RoutineFormData data = (id == 0) ? new RoutineFormData() : new RoutineFormData(RoutineDB.getRoutine(id));
    Form<RoutineFormData> formData = Form.form(RoutineFormData.class).fill(data);
    return ok(NewRoutine.render(formData));
  }

  /**
   * Renders the index page with the given record deleted from the in-memory database.
   *
   * @param id The ID value passed in.
   * @return The Index page.
   */
  public static Result deleteRoutine(long id) {
    RoutineDB.deleteRoutine(id);
    return ok(Index.render(RoutineDB.getRoutines()));
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
      System.out.printf("HTTP OK; Form Data:  %s, %s, %s, %n", data.name, data.image, data.magicType,
          data.skillLevel, data.info, data.description, data.materials);
      return ok(NewRoutine.render(formData));
    }
  }
}
