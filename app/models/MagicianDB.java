package models;

import play.Logger;
import views.formdata.MagicianFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds an in-memory database of all Magician objects in the data model.
 *
 * @see http://www.playframework.com
 */
public class MagicianDB {

  private static Map<Long, Magician> magicians = new HashMap<>();
  private static long currentId = 1;

  /**
   * Adds a formData input to the magicians local storage list.
   *
   * @param formData Input data from the submitted form.
   */
  public static void addMagicians(MagicianFormData formData) {
    long idVal = (formData.id == 0) ? currentId++ : formData.id;
    Magician magicianFromForm = new Magician(idVal, formData.firstName, formData.lastName, formData.stageName,
        formData.location, formData.userPhoto, formData.biography, formData.interests, formData.influences,
        formData.experienceLevel, formData.yearsPracticing, formData.organizations, formData.website, formData.email,
        formData.showEmail, formData.facebook, formData.twitter, formData.linkedIn, formData.googlePlus,
        formData.flickr, formData.instagram);
    magicians.put(idVal, magicianFromForm);
  }

  /**
   * Retrieve a Magician associated with a given id from the local storage list.
   *
   * @param id The ID of the magician to retrieve.
   * @return The retrieved magician object.
   */
  public static Magician getMagician(long id) {
    Magician magician = magicians.get(id);
    if (magician == null) {
      throw new RuntimeException("Unable to find Magician with the given ID value");
    }
    return magician;
  }

  /**
   * Delete a Magician associated with a given id from the local storage list.
   *
   * @param id The ID of the magician to delete.
   */
  public static void deleteMagician(long id) {
    Magician magician = magicians.get(id);
    if (magician == null) {
      throw new RuntimeException("Unable to find Magician with given ID value.");
    }
    magicians.remove(id);
  }

  /**
   * Gets the full list of all Magicians in the local storage list.
   *
   * @return The full list of all Magicians.
   */
  public static List<Magician> getMagicians() {
    return new ArrayList<>(magicians.values());
  }

  /**
   * Delete all of the Magicians in the database.  This is used by JUnit tests.
   */
  public static void resetRoutineDB() {
    magicians.clear();
    currentId = 1;
    Logger.warn("Magician database reset");
  }

  /**
   * Initialize the Routine database.
   */
  public static void init() {
    resetRoutineDB();
    Routine routine = null;

    // --------------------------------------

    Magician magician = null;

    magician = new Magician(
        "Mark",
        "Nelson",
        "Mark Nelson",
        "Honolulu, HI",
        null,
        "I got started in magic in 2004.  A retired magician showed me a 2-card monte and I was hooked.  Since "
        + "then, I've learned the craft, performed hundreds of shows in Honolulu and most recently I nailed"
        + "a parlor act in Beijing.",
        "I'm most comfortable with close-up magic, but I'd like to develop a stage show.  I'd like to be fluent in "
        + "all mediums of the art (Cards, coins, rope, etc.).",
        "Tony Slydini, David Regal, Lee Asher, Aaron Fisher, my brother Steve Johnson and many, many others.",
        "Semi-Professional",
        11,
        null,
        "http://mark.nelson.engineer/wordpress/index.php/magic-home-page/",
        "mr_nelson@icloud.com",
        "Y",
        "mark.nelson.engineer",
        "@mr_marknelson",
        "http://www.linkedin.com/in/marknelsonengineer/en",
        "mr_nelson@icloud.com",
        null,
        "mr_mark_nelson"
    );

    MagicianDB.addMagicians(new MagicianFormData(magician));

    magician = new Magician(
        "Lee",
        "Asher",
        "Lee Asher",
        null,
        null,
        null,
        null,
        null,
        "Professional",
        0,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    );

    MagicianDB.addMagicians(new MagicianFormData(magician));

    magician = new Magician(
        "Steve",
        "Johnson",
        "Steve Johnson",
        null,
        null,
        null,
        null,
        null,
        "Professional",
        0,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    );

    MagicianDB.addMagicians(new MagicianFormData(magician));

    magician = new Magician(
        "Wayne",
        "Houchin",
        "Wayne Houchin",
        null,
        null,
        null,
        null,
        null,
        "Professional",
        0,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    );

    MagicianDB.addMagicians(new MagicianFormData(magician));

  }

}
