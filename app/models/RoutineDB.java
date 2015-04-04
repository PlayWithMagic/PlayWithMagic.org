package models;

import play.Logger;
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
   * Adds a formData input to the Routines list.
   *
   * @param formData Input data from the form.
   */
  public static void addRoutines(RoutineFormData formData) {
    long idVal = (formData.id == 0) ? currentId++ : formData.id;

    Routine routineFromForm = new Routine(
        idVal,
        formData.name,
        formData.description);

    routineFromForm.setDuration(formData.duration);
    routineFromForm.setMethod(formData.method);
    routineFromForm.setHandling(formData.handling);
    routineFromForm.setResetDuration(formData.resetDuration);
    routineFromForm.setResetDescription(formData.resetDescription);

    routines.put(idVal, routineFromForm);
    Logger.debug(((formData.id == 0) ? "Added" : "Updated") + " routine.  id = [" + idVal + "]"
        + "  name = [" + formData.name + "]");
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
      throw new RuntimeException("Unable to find routine with given ID value.");
    }
    return routine;
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


  /**
   * Initialize the Routine database.
   */
  public static void init() {
    resetRoutineDB();

    Routine routine1 = new Routine(0, "Ambitious Card", "Put a card in the middle of the deck.  It magically comes to "
        + "the top.");

    routine1.setDuration(2);
    routine1.setMethod("Get a break under the top two cards.  Perform a double turnover.  Say \"The card on the top "
        + "of the deck is the <<Card>>\".  Perform another double turnover.  Place the indifferent card anywhere in "
        + "the deck.  Turn over the top card to show that the selected card has come to the top.");
    routine1.setHandling("Your lift and turnover should be flawless.  Any method will work.  I grasp the lower-right "
        + "corner of the cards under the break and turn them over, sliding the pair across the back of the deck to "
        + "maintain registration (alignment).  I leave the cards injogged and refer to them with my right index "
        + "finger.  Repeat the process for the second turnover.");
    routine1.setResetDuration(0);
    routine1.setResetDescription("No setup is required for a normal deck assuming that the selected card is also "
        + "indifferent.");

    RoutineDB.addRoutines(new RoutineFormData(routine1));
  }
}
