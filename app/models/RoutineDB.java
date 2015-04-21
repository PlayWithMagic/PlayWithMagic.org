package models;

import play.Logger;
import views.formdata.MaterialFormData;
import views.formdata.RoutineFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An in-memory array of Routines that have been gathered from input form data.
 */
public class RoutineDB {

  private static Map<Long, Routine> routines = new HashMap<>();
  private static long currentId = 1;

  /**
   * Get the current ID of the in-memory database.  This should be used for testing only.
   *
   * @return The current ID of the in-memory datbase.
   */
  public static long getCurrentId() {
    return currentId;
  }

  /**
   * Adds a Routine, based on formData, to the Routines database.
   *
   * @param routineForm Input data from the form.
   * @return The ID of the Routine that was just added to the database.
   */
  public static long addRoutines(RoutineFormData routineForm) {
    Routine routine;
    long idVal;

    if (routineForm.id == 0) {
      idVal = currentId++;

      routine = new Routine(
          idVal,
          routineForm.name,
          routineForm.description);
    }
    else {
      idVal = routineForm.id;

      routine = RoutineDB.getRoutine(idVal);

      routine.setName(routineForm.name);
      routine.setDescription(routineForm.description);
    }

    routine.setDuration(routineForm.duration);
    routine.setMethod(routineForm.method);
    routine.setHandling(routineForm.handling);
    routine.setResetDuration(routineForm.resetDuration);
    routine.setResetDescription(routineForm.resetDescription);
    routine.setYouTubeUrl(routineForm.youTubeUrl);
    routine.setImageUrl(routineForm.imageUrl);
    routine.setReviewUrl(routineForm.reviewUrl);
    routine.setInspiration(routineForm.inspiration);
    routine.setPlacement(routineForm.placement);
    routine.setChoices(routineForm.choices);

    routines.put(idVal, routine);
    Logger.debug(((routineForm.id == 0) ? "Added" : "Updated") + " routine.  id = [" + idVal + "]"
        + "  name = [" + routineForm.name + "]");

    return idVal;
  }


  /**
   * Add or update a Material object to a Routine object saved in the Routines database.
   *
   * @param materialForm Input data from an HTML form.
   */
  public static void addMaterial(MaterialFormData materialForm) {
    Material material = new Material(materialForm.name);
    material.setDescription(materialForm.description);
    material.isInspectable(materialForm.isInspectable);
    material.isGivenAway(materialForm.isGivenAway);
    material.isConsumed(materialForm.isConsumed);
    material.setPrice(materialForm.price);
    material.setPurchaseUrl(materialForm.purchaseUrl);
    material.setImageUrl(materialForm.imageUrl);

    if (materialForm.materialId == -1) {
      RoutineDB.getMaterials(materialForm.routineId).add(material);
    }
    else {
      RoutineDB.getMaterials(materialForm.routineId).set(materialForm.materialId, material);
    }
  }

  /**
   * Gets a routine from the routines in-memory database with a matching ID value.
   *
   * @param id The ID value to match.
   * @return the routine associated with the ID.
   */
  public static Routine getRoutine(long id) {
    Routine routine = routines.get(id);
    if (routine == null) {
      throw new RuntimeException("Unable to find routine with given ID value of [" + id + "].");
    }
    return routine;
  }

  /**
   * Get a list of materials for the routine.
   * <p>
   * If the routineId is 0, return an empty list.  If the routineId is non-0, return the materials from the Routine.
   *
   * @param routineId The ID of a routine or 0 to create an empty list for a new routine.
   * @return A list of materials.
   */
  public static List<Material> getMaterials(long routineId) {
    if (routineId == 0) {
      return new ArrayList<Material>();
    }
    else {
      return routines.get(routineId).getMaterials();
    }
  }

  /**
   * Deletes a routine from the in-memory database with a matching ID value.
   *
   * @param id The ID value of the routine to delete.
   */
  public static void deleteRoutine(long id) {
    Routine routine = routines.get(id);
    if (routine == null) {
      throw new RuntimeException("Unable to find routine with given ID value.");
    }
    routines.remove(id);
  }

  /**
   * Gets a list of all routines currently stored.
   *
   * @return the full list of routines.
   */
  public static List<Routine> getRoutines() {
    return new ArrayList<>(routines.values());
  }


  /**
   * Delete all of the routines in the database.  This is used by JUnit tests.
   */
  public static void resetRoutineDB() {
    routines.clear();
    currentId = 1;
    Logger.warn("Routine database reset");
  }


  /******************************************************************************************************************
   * I N I T I A L I Z E   D A T A B A S E
   ******************************************************************************************************************/

  /**
   * Populate a routine.
   */
  public static void initTemplate() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "", "");

    routine.setDuration(1);
    routine.setMethod("");
    routine.setHandling("");
    routine.setResetDuration(1);
    routine.setResetDescription("");
    routine.setYouTubeUrl("https://www.youtube.com/embed/");
    routine.setReviewUrl("");
    routine.setInspiration("");
    routine.setPlacement("");
    routine.setChoices("");

    routine.setImageUrl("images/routines/xxx.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(1);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/xxx.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);
  }


  /**
   * Initialize the Routine database.
   */
  public static void init() {
    resetRoutineDB();

    RoutineDBInit1.init01();
    RoutineDBInit1.init02();
    RoutineDBInit1.init03();
    RoutineDBInit2.init205();
    RoutineDBInit1.init04();
    RoutineDBInit1.init05();
    RoutineDBInit1.init06();
    RoutineDBInit1.init07();
    RoutineDBInit1.init08();
    RoutineDBInit1.init09();
    RoutineDBInit1.init10();
    RoutineDBInit1.init11();
    RoutineDBInit1.init12();
    RoutineDBInit1.init13();
    RoutineDBInit1.init14();
    RoutineDBInit1.init15();
    RoutineDBInit1.init16();
    RoutineDBInit1.init17();
    RoutineDBInit1.init18();
    RoutineDBInit1.init19();
    RoutineDBInit2.init20();
    RoutineDBInit2.init21();
    RoutineDBInit2.init22();
    RoutineDBInit2.init23();
    RoutineDBInit2.init24();
    RoutineDBInit2.init30();
    RoutineDBInit2.init201();
    RoutineDBInit2.init31();
    RoutineDBInit2.init32();
    RoutineDBInit2.init33();
    RoutineDBInit2.init34();
    RoutineDBInit2.init35();
    RoutineDBInit2.init36();
    RoutineDBInit2.init37();
    RoutineDBInit2.init38();
    RoutineDBInit2.init39();
    RoutineDBInit2.init40();
    RoutineDBInit2.init41();
    RoutineDBInit2.init42();
    RoutineDBInit2.init43();
    RoutineDBInit2.init44();
    RoutineDBInit2.init45();
    RoutineDBInit2.init202();
    RoutineDBInit2.init203();
    RoutineDBInit2.init204();
    RoutineDBInit2.init206();
    RoutineDBInit2.init207();
    RoutineDBInit2.init208();
    RoutineDBInit2.init209();
    RoutineDBInit2.init210();
  }
}
