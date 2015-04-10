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
   * Adds a Routine, based on formData, to the Routines database.
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
    routineFromForm.setYouTubeUrl(formData.youTubeUrl);
    routineFromForm.setImageUrl(formData.imageUrl);

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
    Routine routine = null;

    // --------------------------------------
    routine = new Routine(0, "Ambitious Card", "Put a card in the middle of the deck.  It magically comes to "
        + "the top.");

    routine.setDuration(2);
    routine.setMethod("Get a break under the top two cards.  Perform a double turnover.  Say \"The card on the top "
        + "of the deck is the <<Card>>\".  Perform another double turnover.  Place the indifferent card anywhere in "
        + "the deck.  Turn over the top card to show that the selected card has come to the top.");
    routine.setHandling("Your lift and turnover should be flawless.  Any method will work.  I grasp the lower-right "
        + "corner of the cards under the break and turn them over, sliding the pair across the back of the deck to "
        + "maintain registration (alignment).  I leave the cards injogged and refer to them with my right index "
        + "finger.  Repeat the process for the second turnover.");
    routine.setResetDescription("No setup is required for a normal deck assuming that the selected card is also "
        + "indifferent.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/w4iu5FMaR2o");
    routine.setImageUrl("images/routines/1.jpg");


    RoutineDB.addRoutines(new RoutineFormData(routine));

    // --------------------------------------
    routine = new Routine(0, "Gypsy Thread", "Pieces of thread are restored into one continuous piece.");

    routine.setDuration(4);
    routine.setMethod("Not shared");
    routine.setHandling("I use this as an opener, with the spool in hand.  After detaching the initial piece of "
        + "thread, I hand out the spool for inspection.");
    routine.setResetDuration(2);
    routine.setResetDescription("Not shared");
    routine.setYouTubeUrl("https://www.youtube.com/embed/ANdHX8X889M");
    routine.setImageUrl("images/routines/2.jpg");

    RoutineDB.addRoutines(new RoutineFormData(routine));

    // --------------------------------------
    routine = new Routine(0, "Magician's Practice Deck", "A 'cheap' deck of cards with nothing printed on them "
        + "magically gets printed on the front and back.");

    routine.setDuration(3);
    routine.setMethod("A standard Mental Photography deck.  \"Have you ever seen a magician's practice deck?  "
        + "A magician will go through a deck per week.  You know, the oils from your hands get on the cards and they "
        + "don't spread smothly anymore.  Anyway, a deck costs about $5 a pack -- and it gets expensive over time.  "
        + "So magicians have resorted to buying practice decks... and I'd like to show you mine.\"  << Remove the box "
        + "from your pocket and remove the 'blank' deck from the box.>>  At this point, perform Mental Photography.");
    routine.setHandling("I'll find myself using this as my first card trick of the set.  I put the deck back in the "
        + "box and the box in a pocket with a loaded deck I'll use later.  I do a coin trick between the card tricks "
        + "to demonstrate skill in a variety of magical elements.  This is a good way to introduce cards in the set.");
    routine.setResetDuration(1);
    routine.setResetDescription("Cut the deck to the blank cards.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/4a_9ZVj1lTY");
    // TO-DO:  I need to record my own performance.
    routine.setImageUrl("images/routines/3.jpg");

    RoutineDB.addRoutines(new RoutineFormData(routine));
  }
}
