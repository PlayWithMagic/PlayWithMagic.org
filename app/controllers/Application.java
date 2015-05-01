package controllers;

import models.Magician;
import models.Material;
import models.Routine;
import models.RoutineDB;
import models.Set;
import models.SetDB;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.EditMagicianFormData;
import views.formdata.EditUserFormData;
import views.formdata.MagicianTypeFormData;
import views.formdata.MaterialFormData;
import views.formdata.RoutineFormData;
import views.formdata.SetFormData;
import views.html.About;
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
import views.html.ViewMagician;
import views.html.ViewMaterial;
import views.html.ViewRoutine;
import views.html.ViewSet;

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
   * U S E R
   ******************************************************************************************************************/

  /**
   * Show the EditUser page.  Add a Magician if the ID is 0; or edit an existing Magician (based on their ID).
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
    return ok(EditUser.render(formData, magicianTypeMap));
  }


  /**
   * Handles the request to post form data from the EditUser page.
   *
   * @return On success, the EditMagician page.  On failure, redisplay the EditUser page.
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

      Map<String, Boolean> magicianTypeMap = null;
      if (MagicianTypeFormData.isMagicianType(formData.field("magicianType").value())) {
        magicianTypeMap = MagicianTypeFormData.getMagicianTypes(formData.field("magicianType").value());
      }
      else {
        magicianTypeMap = MagicianTypeFormData.getMagicianTypes();
      }

      return badRequest(EditUser.render(formData, magicianTypeMap));
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

    Form<EditMagicianFormData> editMagicianFormFields;
    editMagicianFormFields = Form.form(EditMagicianFormData.class).fill(editMagicianFormData);
    Map<String, Boolean> magicianTypeMap = MagicianTypeFormData.getMagicianTypes(editMagicianFormData.magicianType);
    return ok(EditMagician.render(editMagicianFormFields, magicianTypeMap));
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
  public static Result editMagician(long id) {
    EditMagicianFormData editMagicianFormData = new EditMagicianFormData(Magician.getMagician(id));

    Form<EditMagicianFormData> formData = Form.form(EditMagicianFormData.class).fill(editMagicianFormData);
    Map<String, Boolean> magicianTypeMap = MagicianTypeFormData.getMagicianTypes(editMagicianFormData.magicianType);
    return ok(EditMagician.render(formData, magicianTypeMap));
  }


  /**
   * Handles the request to post form data from the EditMagician page.
   *
   * @return If successful, the ListMagicians page.  On error, the EditMagician page.
   */
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

      return badRequest(EditMagician.render(formData, magicianTypeMap));
    }

    EditMagicianFormData editMagicianFormData = formData.get();

    Logger.debug("postMagician Magician Form Data");
    Logger.debug("  id = [" + editMagicianFormData.id + "]");
    Logger.debug("  firstName = [" + editMagicianFormData.firstName + "]");
    Logger.debug("  magicianType = [" + editMagicianFormData.magicianType + "]");

    Magician magician = Magician.createMagicianFromForm(editMagicianFormData);

    Logger.debug("postMagician Magician Persisted Data");
    Logger.debug("  id = [" + magician.getId() + "]");
    Logger.debug("  firstName = [" + magician.getFirstName() + "]");
    Logger.debug("  magicianType = [" + magician.getMagicianType().getName() + "]");

    return ok(ListMagicians.render(Magician.getActiveMagicians()));
  }


  /**
   * Displays the full list of Magicians registered on the site.
   *
   * @return An HTTP OK message along with the HTML content for the ListMagicians page.
   */
  public static Result listMagicians() {
    return ok(ListMagicians.render(Magician.getActiveMagicians()));
  }


  /**
   * Displays a single Magician based off of the provided ID.
   *
   * @param id The ID of the Magician to be displayed.
   * @return An HTTP OK message along with the HTML content for a single Magician page.
   */
  public static Result viewMagician(long id) {
    return ok(ViewMagician.render(Magician.getMagician(id)));
  }


  /**
   * Delete a Magician from the database and render the List Magicians page.
   *
   * @param id The ID of the Magician to delete.
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result deleteMagician(long id) {
    Magician.deleteMagician(id);
    return ok(ListMagicians.render(Magician.getActiveMagicians()));
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
   * Process the POST method from the EditRoutine page.  If the form has errors, then redisplay EditRoutine.  If not,
   * then display ListRoutines.
   *
   * @return On success, the ListRoutines page.  On failure, redisplay the EditRoutine page.
   */
  public static Result postRoutine() {
    Form<RoutineFormData> formWithRoutineData = Form.form(RoutineFormData.class).bindFromRequest();

    Logger.debug("postRoutine Raw Routine Form Data");
    Logger.debug("  id = [" + formWithRoutineData.field("id").value() + "]");
    Logger.debug("  name = [" + formWithRoutineData.field("name").value() + "]");
    Logger.debug("  duration = [" + formWithRoutineData.field("duration").value() + "]");

    long routineId = new Long(formWithRoutineData.field("id").value()).longValue();

    if (formWithRoutineData.hasErrors()) {
      Logger.error("postRoutine HTTP Form Error.");

      return badRequest(EditRoutine.render(formWithRoutineData, RoutineDB.getMaterials(routineId)));
    }

    RoutineFormData routineFormData = formWithRoutineData.get();

    Logger.debug("postRoutine Form Backing Class Data");
    Logger.debug("  id = [" + routineFormData.id + "]");
    Logger.debug("  name = [" + routineFormData.name + "]");
    Logger.debug("  duration = [" + routineFormData.duration + "]");

    Routine routine = RoutineDB.saveRoutineFromForm(routineFormData);

    Logger.debug("postRoutine Persisted Data");
    Logger.debug("  id = [" + routine.getId() + "]");
    Logger.debug("  name = [" + routine.getName() + "]");
    Logger.debug("  duration = [" + routine.getDuration() + "]");

    return ok(ListRoutines.render(RoutineDB.getRoutines()));
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
   * S E T
   ***************************************************************************************************************/

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
    if (id != 0) {
      Set thisSet = SetDB.getSet(id);
      return ok(EditSet.render(formData, RoutineDB.getRoutines(), thisSet.getRoutines()));
    }
    else {
      List<Long> temp = new ArrayList<Long>();
      return ok(EditSet.render(formData, RoutineDB.getRoutines(), temp));
    }
  }

  /**
   * Delete a set from the database and display the ListSets page.
   *
   * @param id The ID of the set to delete.
   * @return An HTTP OK message along with the HTML content for the Set List page.
   */
  public static Result deleteSet(long id) {
    SetDB.deleteSet(id);
    return ok(ListSets.render(SetDB.getSets()));
  }

  /**
   * Handles the request to post form data from the editSet page.
   *
   * @return An HTTP OK message if no errors, otherwise the form page with errors.
   */
  public static Result postSet() {
    Form<SetFormData> formWithSetData = Form.form(SetFormData.class).bindFromRequest();

    long setId = new Long(formWithSetData.field("id").value()).longValue();

    if (formWithSetData.hasErrors()) {
      Logger.warn("HTTP Form Error in postSet");
      List<Long> listOfRoutines;
      if (setId != 0) {
        listOfRoutines = SetDB.getSet(setId).getRoutines();
      }
      else {
        listOfRoutines = new ArrayList<Long>();
      }
      return badRequest(EditSet.render(formWithSetData, RoutineDB.getRoutines(), listOfRoutines));
    }
    else {
      SetFormData data = formWithSetData.get();
      SetDB.addSet(data);
      return ok(ListSets.render(SetDB.getSets()));
    }
  }

  /**
   * Render the List Sets page.
   *
   * @return An HTTP OK message along with the HTML content for the List Set page.
   */
  public static Result listSets() {
    return ok(ListSets.render(SetDB.getSets()));
  }

  /**
   * Render the View Set page.
   *
   * @param id The ID of the Set to view.
   * @return An HTTP OK message along with the HTML content for a single Set page.
   */
  public static Result viewSet(long id) {
    Set thisViewSet = SetDB.getSet(id);
    return ok(ViewSet.render(SetDB.getSet(id), RoutineDB.getRoutines(), thisViewSet.getRoutines()));
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
    Routine routine = RoutineDB.saveRoutineFromForm(data);
    routineId = routine.getId();

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
    Routine routine = RoutineDB.saveRoutineFromForm(data);
    routineId = routine.getId();

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
    Routine routine = RoutineDB.saveRoutineFromForm(routineFormData);
    routineId = routine.getId();

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


  /**
   * Display a single Material page.
   *
   * @param routineId  The ID of the Routine to be displayed.
   * @param materialId The ArrayList index of the material to display.
   * @return An HTTP OK message along with the HTML content for a single Routine page.
   */
  public static Result viewMaterial(long routineId, int materialId) {
    Routine routine = RoutineDB.getRoutine(routineId);
    Material material = routine.getMaterials().get(materialId);

    return ok(ViewMaterial.render(material));
  }

}
