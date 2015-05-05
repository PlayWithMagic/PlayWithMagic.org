package controllers;

import models.Image;
import models.Magician;
import models.Material;
import models.Routine;
import models.Set;
import play.Logger;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.DeleteUserFormData;
import views.formdata.EditMagicianFormData;
import views.formdata.EditUserFormData;
import views.formdata.LoginFormData;
import views.formdata.MagicianTypeFormData;
import views.formdata.MaterialFormData;
import views.formdata.RoutineFormData;
import views.formdata.SetFormData;
import views.html.About;
import views.html.DeleteUser;
import views.html.EditMagician;
import views.html.EditMaterial;
import views.html.EditRoutine;
import views.html.EditSet;
import views.html.EditUser;
import views.html.Help;
import views.html.Index;
import views.html.ListMagicians;
import views.html.ListRoutines;
import views.html.ListSets;
import views.html.Login;
import views.html.ViewMagician;
import views.html.ViewMaterial;
import views.html.ViewRoutine;
import views.html.ViewSet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
   * @param message A String message that is passed to the home page.
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result index(String message) {
// TODO: Remove below
    /*
    Http.Context context = Http.Context.current();
    Magician magician = Secured.getUserInfo(context);

    Logger.debug("Get My Sets");
    List<Magician> myMagicians = Magician.find().where().eq("magician", magician.getId()).findList();
    for (Set theSet : mySets) {
      Logger.debug("    " + theSet.getName())
    }

    */
    return ok(Index.render("home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), message));
  }


  /**
   * Render the About page.
   *
   * @return An HTTP OK message along with the HTML content for the About page.
   */
  public static Result about() {
    return ok(About.render("about", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }


  /**
   * Render the Help page.
   *
   * @return An HTTP OK message along with the HTML content for the Help page.
   */
  public static Result help() {
    return ok(Help.render("help", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }


  /******************************************************************************************************************
   * U S E R
   ******************************************************************************************************************/

  /**
   * Show the EditUser page.  Add a Magician if the ID is 0; or edit an existing Magician (based on their ID).
   *
   * This is the Signup page (for unauthenticated users).
   * <p>
   * Note:  EditMagician and EditUser are two different views on the same entity.
   *
   * @param id The ID of the Magician to edit; if new Magician, ID is 0.
   * @return An HTTP OK message along with the HTML content for the EditUser page.
   */
  public static Result editUser(long id) {
    EditUserFormData editUserFormData;

    if (id == 0) {
      editUserFormData = new EditUserFormData();
    }
    else {
      editUserFormData = new EditUserFormData(Magician.getMagician(id));
    }

    Form<EditUserFormData> formData = Form.form(EditUserFormData.class).fill(editUserFormData);
    Map<String, Boolean> magicianTypeMap = MagicianTypeFormData.getMagicianTypes(editUserFormData.magicianType);

    return ok(EditUser.render("editUser", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        formData, magicianTypeMap));
  }


  /**
   * Handles the request to post form data from the EditUser page.
   *
   * First we bind the HTTP POST data to an instance of EditUserFormData.
   * The binding process will invoke the EditUserFormData.validate() method.
   *
   * If errors are found, re-render the page, displaying the error data.
   * If errors not found, take the user to the login screen and display message.
   *
   * The flash() method is an easy way to push error messages and then retireve them in the page view.
   *
   * @return On success, the Index page.  On failure, redisplay the EditUser page.
   * @see https://www.playframework.com/documentation/2.3.7/JavaSessionFlash
   */
  public static Result postUser() {
    Form<EditUserFormData> formData = Form.form(EditUserFormData.class).bindFromRequest();

    Logger.debug("postUser Raw Magician Form Data");
    Logger.debug("  id = [" + formData.field("id").value() + "]");
    Logger.debug("  firstName = [" + formData.field("firstName").value() + "]");
    Logger.debug("  eMail = [" + formData.field("email").value() + "]");
    Logger.debug("  magicianType = [" + formData.field("magicianType").value() + "]");

      if (formData.hasErrors()) {
        Logger.error("postUser HTTP Form Error.");

        for (String key : formData.errors().keySet()) {
          List<ValidationError> currentError = formData.errors().get(key);
          for (play.data.validation.ValidationError error : currentError) {
            if (!error.message().equals("")) {
              Logger.error("   " + key + ":  " + error.message());
              flash(key, error.message());
            }
          }
        }

       Map<String, Boolean> magicianTypeMap = null;
        if (MagicianTypeFormData.isMagicianType(formData.field("magicianType").value())) {
          magicianTypeMap = MagicianTypeFormData.getMagicianTypes(formData.field("magicianType").value());
        }
        else {
          magicianTypeMap = MagicianTypeFormData.getMagicianTypes();
        }

      return badRequest(EditUser.render("editUser", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formData, magicianTypeMap));
    }

    EditUserFormData editUserFormData = formData.get();

    Logger.debug("postUser Form Backing Class Data");
    Logger.debug("  id = [" + editUserFormData.id + "]");
    Logger.debug("  firstName = [" + editUserFormData.firstName + "]");
    Logger.debug("  eMail = [" + editUserFormData.email + "]");
    Logger.debug("  magicianType = [" + editUserFormData.magicianType + "]");

    Magician magician = Magician.createMagicianFromForm(editUserFormData);

    Logger.debug("postUser Persisted Data");
    Logger.debug("  id = [" + magician.getId() + "]");
    Logger.debug("  firstName = [" + magician.getFirstName() + "]");
    Logger.debug("  eMail = [" + magician.getEmail() + "]");
    Logger.debug("  magicianType = [" + magician.getMagicianType().getName() + "]");

    EditMagicianFormData editMagicianFormData = new EditMagicianFormData(magician);

    return redirect(routes.Application.index("Successfully Signed Up!"));
  }


  /**
   * Posts an authenticated delete user request.
   *
   * @return The Index page, logged out.
   */
  @Security.Authenticated(Secured.class)
  public static Result postDeleteUser() {
    Form<DeleteUserFormData> deleteUserFormData = Form.form(DeleteUserFormData.class).bindFromRequest();
    //DeleteUserFormData formData = deleteUserFormData.get();
    if (deleteUserFormData.hasErrors()) {
      for (String key : deleteUserFormData.errors().keySet()) {
        List<ValidationError> currentError = deleteUserFormData.errors().get(key);
        for (play.data.validation.ValidationError error : currentError) {
          if (!error.message().equals("")) {
            flash(key, error.message());
          }
        }
      }

      //Magician magician = Magician.getMagician(formData.id);
      return badRequest(DeleteUser.render("deleteMagician", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          deleteUserFormData, Secured.getUserInfo(ctx())));
    }
    DeleteUserFormData formData = deleteUserFormData.get();
    Magician.deleteMagician(formData.id);
    session().clear();
    return redirect(routes.Application.index(""));
  }


  /******************************************************************************************************************
   * A U T H E N T I C A T I O N
   ******************************************************************************************************************/

  /**
   * Render the Login page (only to unauthenticated users).
   *
   * @param message The message being passed from any errors on the Login form.
   * @return The Login page.
   */
  public static Result login(String message) {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, message));
  }


  /**
   * Processes a login form submission from an unauthenticated user.
   *
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   *
   * If errors are found, re-render the page, displaying the error data.
   * If errors not found, render the page with the good data.
   *
   * @return The index page with the results of validation.
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      for (String key : formData.errors().keySet()) {
        List<ValidationError> currentError = formData.errors().get(key);
        for (play.data.validation.ValidationError error : currentError) {
          if (!error.message().equals("")) {
            flash(key, error.message());
          }
        }
      }
      return badRequest(Login.render("login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, ""));
    }

    // email/password OK, so now we set the session variable and only go to authenticated pages.
    session().clear();
    session("email", formData.get().email);
    return redirect(routes.Application.index(""));
  }

  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page.
   *
   * @return A redirect to the Index page.
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index(""));
  }


  /******************************************************************************************************************
   * M A G I C I A N
   ******************************************************************************************************************/

  /**
   * Show the EditMagician page.  Can only edit existing Magicians (based on the ID).
   * <p>
   * Note:  EditMagician and EditUser are two different views on the same entity.
   *
   * @param id The ID of the magician to edit.
   * @return An HTTP OK message along with the HTML content for the EditMagician page.
   */
  @Security.Authenticated(Secured.class)
  public static Result editMagician(long id) {
    EditMagicianFormData editMagicianFormData = new EditMagicianFormData(Magician.getMagician(id));

    Form<EditMagicianFormData> formData = Form.form(EditMagicianFormData.class).fill(editMagicianFormData);
    Map<String, Boolean> magicianTypeMap = MagicianTypeFormData.getMagicianTypes(editMagicianFormData.magicianType);
    return ok(EditMagician.render("editMagician", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        formData, magicianTypeMap));
  }


  /**
   * Handle the request to post form data from the EditMagician page.
   *
   * @return If successful, the ListMagicians page.  On error, the EditMagician page.
   */
  @Security.Authenticated(Secured.class)
  public static Result postMagician() {
    Form<EditMagicianFormData> formData = Form.form(EditMagicianFormData.class).bindFromRequest();

    Logger.debug("postMagician Raw Magician Form Data");
    Logger.debug("  id = [" + formData.field("id").value() + "]");
    Logger.debug("  firstName = [" + formData.field("firstName").value() + "]");
    Logger.debug("  magicianType = [" + formData.field("magicianType").value() + "]");

    if (formData.hasErrors()) {
      Logger.error("postMagician HTTP Form Error.");

      Map<String, Boolean> magicianTypeMap = null;
      if (MagicianTypeFormData.isMagicianType(formData.field("magicianType").value())) {
        magicianTypeMap = MagicianTypeFormData.getMagicianTypes(formData.field("magicianType").value());
      }
      else {
        magicianTypeMap = MagicianTypeFormData.getMagicianTypes();
      }

      return badRequest(EditMagician.render("editMagician", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formData, magicianTypeMap));
    }

    EditMagicianFormData editMagicianFormData = formData.get();

    long imageId = uploadImage(request());
    if (imageId > 0) {
      editMagicianFormData.imageId = imageId;
    }

    Logger.debug("postMagician Magician Form Data");
    Logger.debug("  id = [" + editMagicianFormData.id + "]");
    Logger.debug("  firstName = [" + editMagicianFormData.firstName + "]");
    Logger.debug("  magicianType = [" + editMagicianFormData.magicianType + "]");
    Logger.debug("  imageId = [" + editMagicianFormData.imageId + "]");

    Magician magician = Magician.createMagicianFromForm(editMagicianFormData);

    Logger.debug("postMagician Magician Persisted Data");
    Logger.debug("  id = [" + magician.getId() + "]");
    Logger.debug("  firstName = [" + magician.getFirstName() + "]");
    Logger.debug("  magicianType = [" + magician.getMagicianType().getName() + "]");

    return ok(ListMagicians.render("listMagicians", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        Magician.getActiveMagicians()));
  }


  /**
   * Display the full list of Magicians registered on the site.
   *
   * @return An HTTP OK message along with the HTML content for the ListMagicians page.
   */
  public static Result listMagicians() {
    return ok(ListMagicians.render("listMagicians", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        Magician.getActiveMagicians()));
  }


  /**
   * Display a single Magician based off of the provided ID.
   *
   * @param id The ID of the Magician to be displayed.
   * @return An HTTP OK message along with the HTML content for a single Magician page.
   */
  public static Result viewMagician(long id) {
    return ok(ViewMagician.render("viewMagician", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        Magician.getMagician(id)));
  }


  /**
   * Direct a user to the Delete User page with the ID of the magician to be deleted.
   *
   * @param id The ID of the Magician to delete.
   * @return An HTTP OK message along with the HTML content for the DeleteUser confirmation page.
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteMagician(long id) {
    //Magician.deleteMagician(id);
    if (id == 0) {
      return redirect(routes.Application.index(""));
    }
    else {
      DeleteUserFormData deleteUserFormData = new DeleteUserFormData(Magician.getMagician(id));

      Form<DeleteUserFormData> formWithDeleteData = Form.form(DeleteUserFormData.class).fill(deleteUserFormData);
      return ok(DeleteUser.render("deleteMagician", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formWithDeleteData, Magician.getMagician(id)));
    }
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
  @Security.Authenticated(Secured.class)
  public static Result editRoutine(long routineId) {
    RoutineFormData routineFormData;

    if (routineId == 0) {
      routineFormData = new RoutineFormData();
    }
    else {
      routineFormData = new RoutineFormData(Routine.getRoutine(routineId));
    }

    Form<RoutineFormData> formWithRoutineData = Form.form(RoutineFormData.class).fill(routineFormData);

    return ok(EditRoutine.render("editRoutine", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        formWithRoutineData, Routine.getMaterials(routineId)));
  }


  /**
   * Process the POST method from the EditRoutine page.  If the form has errors, then redisplay EditRoutine.  If not,
   * then display ListRoutines.
   *
   * @return On success, the ListRoutines page.  On failure, redisplay the EditRoutine page.
   */
  @Security.Authenticated(Secured.class)
  public static Result postRoutine() {
    Form<RoutineFormData> formWithRoutineData = Form.form(RoutineFormData.class).bindFromRequest();

    Logger.debug("postRoutine Raw Routine Form Data");
    Logger.debug("  id = [" + formWithRoutineData.field("id").value() + "]");
    Logger.debug("  name = [" + formWithRoutineData.field("name").value() + "]");
    Logger.debug("  duration = [" + formWithRoutineData.field("duration").value() + "]");

    long routineId = new Long(formWithRoutineData.field("id").value()).longValue();

    if (formWithRoutineData.hasErrors()) {
      Logger.error("postRoutine HTTP Form Error.");

      return badRequest(EditRoutine.render("editRoutine", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formWithRoutineData, Routine.getMaterials(routineId)));
    }

    RoutineFormData routineFormData = formWithRoutineData.get();

    long imageId = uploadImage(request());
    if (imageId > 0) {
      routineFormData.imageId = imageId;
    }

    Logger.debug("postRoutine Form Backing Class Data");
    Logger.debug("  id = [" + routineFormData.id + "]");
    Logger.debug("  name = [" + routineFormData.name + "]");
    Logger.debug("  duration = [" + routineFormData.duration + "]");
    Logger.debug("  imageId = [" + routineFormData.imageId + "]");

    Routine routine = Routine.saveRoutineFromForm(routineFormData);

    Logger.debug("postRoutine Persisted Data");
    Logger.debug("  id = [" + routine.getId() + "]");
    Logger.debug("  name = [" + routine.getName() + "]");
    Logger.debug("  duration = [" + routine.getDuration() + "]");

    return ok(ListRoutines.render("listRoutines", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        Routine.getActiveRoutines()));
  }


  /**
   * Delete a routine from the database and display the ListRoutines page.
   *
   * @param routineId The ID of the routine to delete.
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result deleteRoutine(long routineId) {
    Routine.deleteRoutine(routineId);

    return ok(ListRoutines.render("listRoutines", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        Routine.getActiveRoutines()));
  }


  /**
   * Render the List Routines page.
   *
   * @return An HTTP OK message along with the HTML content for the List Routine page.
   */
  public static Result listRoutines() {
    return ok(ListRoutines.render("listRoutines", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        Routine.getActiveRoutines()));
  }


  /**
   * Display a single Routine.
   *
   * @param routineId The ID of the Routine to be displayed.
   * @return An HTTP OK message along with the HTML content for a single Routine page.
   */
  public static Result viewRoutine(long routineId) {
    return ok(ViewRoutine.render("viewRoutine", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        Routine.getRoutine(routineId)));
  }


  /***************************************************************************************************************
   * S E T
   ***************************************************************************************************************/

  /**
   * Renders the editSet page with a form to add a new Set if the ID is 0.  Otherwise, update an existing
   * Set based on the passed in ID number.
   *
   * @param id The ID of the Set to edit (or 0 if it's a new routine).
   * @return An HTTP OK message along with the HTML content for the EditSet page.
   */
  @Security.Authenticated(Secured.class)
  public static Result editSet(long id) {
    SetFormData setFormData = (id == 0) ? new SetFormData() : new SetFormData(Set.getSet(id));

    Form<SetFormData> formData = Form.form(SetFormData.class).fill(setFormData);

    if (id != 0) {
      Set thisSet = Set.getSet(id);
      return ok(EditSet.render("editSet", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData,
          Routine.getActiveRoutines(), thisSet.getRoutines()));
    }
    else {
      List<Routine> emptyListOfRoutinesInSet = new ArrayList<Routine>();

      return ok(EditSet.render("editSet", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData,
          Routine.getActiveRoutines(), emptyListOfRoutinesInSet));
    }
  }


  /**
   * Handles the request to post form data from EditSet.
   *
   * @return An HTTP OK message if no errors, otherwise the form page with errors.
   */
  @Security.Authenticated(Secured.class)
  public static Result postSet() {
    Form<SetFormData> formWithSetData = Form.form(SetFormData.class).bindFromRequest();

    long setId = new Long(formWithSetData.field("id").value()).longValue();

    if (formWithSetData.hasErrors()) {
      Logger.warn("HTTP Form Error in postSet");
      List<Routine> listOfRoutines;
      if (setId != 0) {
        listOfRoutines = Set.getSet(setId).getRoutines();
      }
      else {
        listOfRoutines = new ArrayList<Routine>();
      }
      return badRequest(EditSet.render("editSet", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formWithSetData, Routine.getActiveRoutines(), listOfRoutines));
    }
    else {
      SetFormData data = formWithSetData.get();
      Set.createSetFromForm(data);
      return ok(ListSets.render("listSets", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), Set.getMySets()));
    }
  }


  /**
   * Render the List Sets page with all sets.
   *
   * @return An HTTP OK message along with the HTML content for the List Set page.
   */
  public static Result listAllSets() {

    return ok(ListSets.render("listSets", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), Set.getAllSets()));
  }


  /**
   * Render the List Sets page with just the Magician's sets.
   *
   * @return An HTTP OK message along with the HTML content for the List Set page.
   */
  public static Result listMySets() {

    return ok(ListSets.render("listSets", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), Set.getMySets()));
  }


  /**
   * Render the View Set page.
   *
   * @param id The ID of the Set to view.
   * @return An HTTP OK message along with the HTML content for a single Set page.
   */
  public static Result viewSet(long id) {
    Set thisViewSet = Set.getSet(id);

    return ok(ViewSet.render("viewSet", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), Set.getSet(id),
        Routine.getActiveRoutines(), thisViewSet.getRoutines()));
  }


  /**
   * Delete a set from the database and display the ListSets page.
   *
   * @param id The ID of the set to delete.
   * @return An HTTP OK message along with the HTML content for the Set List page.
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteSet(long id) {
    Set.deleteSet(id);
    return ok(ListSets.render("listSets", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), Set.getMySets()));
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
   * the database.  Finally, show the EditMaterial page.
   *
   * @param materialId The ID of the Material you want to edit.
   * @return An HTTP page EditMaterial if all is well or EditRoutine if there's an error on that page.
   */
  @Security.Authenticated(Secured.class)
  public static Result editMaterial(Long materialId) {
    Form<RoutineFormData> formWithRoutineData = Form.form(RoutineFormData.class).bindFromRequest();

    Logger.debug("editMaterial Raw Routine Form Data");
    Logger.debug("  routineId = [" + formWithRoutineData.field("id").value() + "]");
    Logger.debug("  name = [" + formWithRoutineData.field("name").value() + "]");
    Logger.debug("  materialID = [" + materialId + "]");

    long routineId = new Long(formWithRoutineData.field("id").value()).longValue();

    if (formWithRoutineData.hasErrors()) {
      Logger.error("HTTP Form Error in editMaterial");

      return badRequest(EditRoutine.render("editRoutine", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formWithRoutineData, Routine.getMaterials(routineId)));
    }

    RoutineFormData data = formWithRoutineData.get();
    Routine routine = Routine.saveRoutineFromForm(data);
    routineId = routine.getId();

    // End of processing Routine page.  Start processing material.

    MaterialFormData materialFormData =
        new MaterialFormData(Material.getMaterial(materialId));

    Form<MaterialFormData> formWithMaterialData = Form.form(MaterialFormData.class).fill(materialFormData);

    return ok(EditMaterial.render("editMaterial", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        formWithMaterialData));
  }


  /**
   * Show the EditMaterial page to create a new item.  First, process the Routine page and deal with any errors.
   * Update the database and finally show the EditMaterial page.
   *
   * @return An HTTP page EditMaterial if all is well or EditRoutine if there's an error on that page.
   */
  @Security.Authenticated(Secured.class)
  public static Result newMaterial() {
    Form<RoutineFormData> routineFormData = Form.form(RoutineFormData.class).bindFromRequest();
    long routineId = new Long(routineFormData.field("id").value()).longValue();

    if (routineFormData.hasErrors()) {
      Logger.error("HTTP Form Error in newMaterial");

      return badRequest(EditRoutine.render("editRoutine", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          routineFormData, Routine.getMaterials(routineId)));
    }

    RoutineFormData data = routineFormData.get();
    Routine routine = Routine.saveRoutineFromForm(data);
    routineId = routine.getId();

    // End of processing Routine page.  Start processing material.

    MaterialFormData materialFormData = new MaterialFormData();
    materialFormData.routineId = routineId;
    materialFormData.materialId = 0;

    Form<MaterialFormData> formWithMaterialData = Form.form(MaterialFormData.class).fill(materialFormData);
    return ok(EditMaterial.render("editMaterial", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        formWithMaterialData));
  }


  /**
   * Delete a Material item and redisplay the EditRoutine page.  First, process the Routine page and deal with any
   * errors.  Update the database, then delete the Material item and finally redisplay EditRoutine.
   *
   * @param materialId The ID of the Material to delete.
   * @return An HTTP EditMaterial page.
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteMaterial(Long materialId) {
    Form<RoutineFormData> formWithRoutineData = Form.form(RoutineFormData.class).bindFromRequest();
    long routineId = new Long(formWithRoutineData.field("id").value()).longValue();

    if (formWithRoutineData.hasErrors()) {
      Logger.error("HTTP Form Error in deleteMaterial");

      return badRequest(EditRoutine.render("editRoutine", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formWithRoutineData, Routine.getMaterials(routineId)));
    }

    RoutineFormData routineFormData = formWithRoutineData.get();
    Routine routine = Routine.saveRoutineFromForm(routineFormData);
    routineId = routine.getId();

    // End of processing Routine page.  Start of processing material.

    Material.getMaterial(materialId).delete();

    return ok(EditRoutine.render("editRoutine", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        formWithRoutineData, Routine.getMaterials(routineId)));
  }


  /**
   * Post new and updated Material information from the EditMaterial page and add it to the Routine.  Then,
   * display EditRoutine.
   *
   * @return On success, an HTTP OK message along with the HTML content for the EditRoutine page.  On a validation
   * error, an HTTP BadRequest message with the HTML content of the EditMaterial page.
   */
  @Security.Authenticated(Secured.class)
  public static Result postMaterial() {
    Form<MaterialFormData> formWithMaterialData = Form.form(MaterialFormData.class).bindFromRequest();

    long routineId = new Long(formWithMaterialData.field("routineId").value()).longValue();

    if (formWithMaterialData.hasErrors()) {
      Logger.error("HTTP Form Error in postMaterial.");

      return badRequest(EditMaterial.render("editMaterial", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          formWithMaterialData));
    }

    Logger.debug("Form Field Data isInspectable = " + formWithMaterialData.field("isInspectable").value());
    MaterialFormData materialFormData = formWithMaterialData.get();

    Logger.debug("isInspectable = " + materialFormData.isInspectable);

    long imageId = uploadImage(request());
    if (imageId > 0) {
      materialFormData.imageId = imageId;
    }

    Material.saveMaterialFromForm(materialFormData);

    RoutineFormData routineFormData = new RoutineFormData(Routine.getRoutine(routineId));
    Form<RoutineFormData> formWithRoutineData = Form.form(RoutineFormData.class).fill(routineFormData);

    return ok(EditRoutine.render("editRoutine", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        formWithRoutineData, Routine.getMaterials(routineId)));
  }

  /**
   * Display a single Material page.
   *
   * @param routineId  The ID of the Routine to be displayed.
   * @param materialId The ArrayList index of the material to display.
   * @return An HTTP OK message along with the HTML content for a single Routine page.
   */
  public static Result viewMaterial(long routineId, int materialId) {
    Routine routine = Routine.getRoutine(routineId);
    Material material = routine.getMaterials().get(materialId);

    return ok(ViewMaterial.render("viewRoutine", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), material));
  }


  /***************************************************************************************************************
   * I M A G E S
   *
   * Gets the image from the Images database.
   *
   ***************************************************************************************************************/

  /**
   * Gets the image that has been uploaded to the database.
   * @param id The image id.
   * @return The image.
   */
  public static Result getImage(long id) {
    Image image = Image.find.byId(id);
    if (image == null) {
      throw new RuntimeException("Could not find the image with associated id.");
    }

    return ok(image.data).as("image");
  }

  /**
   * Uploads image in Request to the Images database.
   * @param request The request.
   * @return The image id. Returns -1 if file size limit exceeded or no image found in form.
   */
  public static long uploadImage(Http.Request request) {

    // takes request
    Http.MultipartFormData body = request.body().asMultipartFormData();
    Http.MultipartFormData.FilePart picture = body.getFile("image");

    // creates variables
    String fileName = "";
    String contentType = "";
    File file = null;
    long imageId;
    Image image = null;

    // checks image upload size against max
    if (request().body().isMaxSizeExceeded()) {
      System.out.printf("Image exceeds maximum allowed file size. (512K)");
      imageId = -1;
    }
    else if (picture != null) {
      fileName = picture.getFilename();
      contentType = picture.getContentType();
      file = picture.getFile();
      image = new Image(fileName, file);
      imageId = image.id;
    }
    else {
      System.out.printf("No new image found in form.");
      imageId = -1;
    }

    return imageId;
  }

}
