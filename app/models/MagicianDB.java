package models;

import play.Logger;
import views.formdata.EditMagicianFormData;

/**
 * XXXX.
 *
 * @see http://www.playframework.com
 */
public class MagicianDB {
//TODO:  Kill this class

  /**
   * Delete all of the Magicians in the database.  This is used by JUnit tests.
   */
  public static void resetMagicianDB() {
    // magicians.clear();
    // currentId = 1;
    // TODO:  Sort out if this is still needed
    Logger.warn("Magician database reset");
  }

  /**
   * Initialize the Magician database.
   */
  public static void init() {
    resetMagicianDB();

    MagicianType.init();
    MagicianType magicianTypeSemiProfessional = MagicianType.getMagicianType("Semi-Professional");
    MagicianType magicianTypeProfessional = MagicianType.getMagicianType("Professional");

    // --------------------------------------

    Magician magician = null;

    magician = new Magician(
        "Mark",
        "Nelson",
        "Mark Nelson",
        "Honolulu, HI",
        null,
        "I got started in magic in 2004.  A retired magician, JC Dunn, showed me a 2-card monte and I was hooked. "
        + "Since then, I've learned the craft, performed hundreds of shows in Honolulu and most recently I nailed "
        + "a parlor act in Beijing.",
        "I'm most comfortable with close-up magic, but I'd like to develop a stage show.  I strive to be fluent in "
        + "all mediums of the art (cards, coins, rope, etc.).",
        "Tony Slydini, David Regal, Lee Asher, Aaron Fisher, my brother Steve Johnson and many, many others.",
        magicianTypeSemiProfessional,
        2004,
        null,
        "http://mark.nelson.engineer/wordpress/index.php/magic-home-page/",
        "mr_nelson@icloud.com",
        "mark.nelson.engineer",
        "@mr_marknelson",
        "http://www.linkedin.com/in/marknelsonengineer/en",
        "mr_nelson@icloud.com",
        null,
        "mr_mark_nelson"
    );

    Magician.createMagicianFromForm(new EditMagicianFormData(magician));

    magician = new Magician(
        "Lee",
        "Asher",
        "Lee Asher",
        null,
        null,
        null,
        null,
        null,
        magicianTypeProfessional,
        0,
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

    Magician.createMagicianFromForm(new EditMagicianFormData(magician));

    magician = new Magician(
        "Steve",
        "Johnson",
        "Steve Johnson",
        null,
        null,
        null,
        null,
        null,
        magicianTypeProfessional,
        0,
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

    Magician.createMagicianFromForm(new EditMagicianFormData(magician));

    magician = new Magician(
        "Wayne",
        "Houchin",
        "Wayne Houchin",
        null,
        null,
        null,
        null,
        null,
        magicianTypeProfessional,
        0,
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

    Magician.createMagicianFromForm(new EditMagicianFormData(magician));

  }

}
