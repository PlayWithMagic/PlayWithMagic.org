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
    Set setFromForm = new Set(idVal, formData.userId, formData.name, formData.description, formData.routines);
    sets.put(idVal, setFromForm);
  }


  /**
   * Adds a Set to the DB directly for pre-filling the Database.
   *
   * @param newSet The pre-formatted set to place in the database.
   */
  public static void addSet(Set newSet) {
    long idVal = (newSet.getId() == 0) ? currentId++ : newSet.getId();
    sets.put(idVal, newSet);
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
    //long id;

    // --------------------------------------
    List<Long> routineIds = new ArrayList<Long>();
    routineIds.add(2L);
    routineIds.add(1L);
    set = new Set(currentId, 1, "Amazing Set", "This is the best set ever. It opens with the Ambitious Card trick"
        + " to warm up the audience. From there, it shifts to something different with Gypsy Thread. "
        + "And in the closer, it breaks back down to a card trick to cool down the audience afterwords.", routineIds);
    SetDB.addSet(set);
    currentId++;

    List<Long> routineIds2 = new ArrayList<Long>();
    routineIds2.add(5L);
    routineIds2.add(10L);
    routineIds2.add(33L);
    set = new Set(currentId, 2, "With Flare", "This starts off with a match routine for something that has a bit "
        + "of an explosive opener, followed by a simple card trick.  Finally, you light up the night with a flaming "
        + "wallet routine, which binds the card trick and the fire trick together.", routineIds2);
    SetDB.addSet(set);
    currentId++;

    List<Long> routineIds3 = new ArrayList<Long>();
    routineIds3.add(4L);
    routineIds3.add(14L);
    routineIds3.add(15L);
    routineIds3.add(34L);
    System.out.println(currentId);
    System.out.println(routineIds);
    set = new Set(currentId, 3, "Mechanisms", "With each of the routines in this set, it involves some physical device"
        + " that the audience can either interact with, or view interaction with.  The key is to really liven up "
        + "Zig-Zag-Pencil with your own bit of flare, otherwise it will pale against the other routines in this Set. "
        + "Next, a simple card trick that allows the audience member to interact with their cell phone!  Always good "
        + "to have more audience interaction.  Finally, the close is something that goes back to the engineer theme "
        + "of the opener with a twist! "
        + "Once you've closed, the audience member will walk away with a photo memory on their phone.", routineIds3);
    SetDB.addSet(set);
    currentId++;


  }


}


