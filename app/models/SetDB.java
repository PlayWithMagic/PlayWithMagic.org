package models;


import play.Logger;
import views.formdata.SetFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds an in-memory database of all Set objects in the data model.
 *
 * @see http://www.playframework.com
 */
public class SetDB {

  private static Map<Long, Set> sets = new HashMap<>();
  private static long currentId = 1;

  /**
   * Adds a formData input to the Set local storage list.
   *
   * @param formData Input data from the submitted form.
   */
  public static void addSet(SetFormData formData) {
    long idVal = (formData.id == 0) ? currentId++ : formData.id;
    Set setFromForm = new Set(idVal, formData.userId, formData.setName, formData.description, formData.routines);
    sets.put(idVal, setFromForm);
  }

  /**
   * Retrieve a Set associated with a given id from the local storage list.
   *
   * @param id The ID of the Set to retrieve.
   * @return The retrieved Set object.
   */
  public static Set getSet(long id) {
    Set set = sets.get(id);
    if (set == null) {
      throw new RuntimeException("Unable to find Set with the given ID value");
    }
    return set;
  }

  /**
   * Delete a Set associated with a given id from the local storage list.
   *
   * @param id The ID of the set to delete.
   */
  public static void deleteSet(long id) {
    Set set = sets.get(id);
    if (set == null) {
      throw new RuntimeException("Unable to find Set with given ID value.");
    }
    sets.remove(id);
  }

  /**
   * Gets the full list of all Sets in the local storage list.
   *
   * @return The full list of all Sets.
   */
  public static List<Set> getSets() {
    return new ArrayList<>(sets.values());
  }


  /**
   * Delete all of the Sets in the database.  This is used by JUnit tests.
   */
  public static void resetSetDB() {
    sets.clear();
    currentId = 1;
    Logger.warn("Set database reset");
  }

  /**
   * Initialize the Set database.
   */
  public static void init() {
    resetSetDB();
    Set set = null;
    long id;

    // --------------------------------------
    List<Long> routineIds = new ArrayList<Long>();
    routineIds.add(3L);
    set = new Set(0, 1, "Amazing Set", "This is a powerful set comprised of mostly card tricks", routineIds);
    //SetDB.addSet();


  }


}


