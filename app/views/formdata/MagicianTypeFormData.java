package views.formdata;

import models.MagicianType;

import java.util.HashMap;
import java.util.Map;

// TODO: Refactor this into a generic class

/**
 * Utility class for handling the different types of Magicians (Novice, Expert, Professional, etc.).
 */
public class MagicianTypeFormData {

  private static String[] experienceLevels = {"Neophyte", "Enthusiast", "Hobbyist", "Historian", "Collector",
      "Semi-Professional", "Professional"};


  /**
   * Generate a new Map of MagicianTypes with all of the pairs set to false (not selected).
   * <p>
   * These maps are used for the bootstrap3 select.scala.html dropdown list box.
   *
   * @return The newly generated magicianTypeMap.
   */
  public static Map<String, Boolean> getMagicianTypes() {
    Map<String, Boolean> magicianTypeMap = new HashMap<String, Boolean>();

    // TODO:  Magician Type is not being sorted in the Form...  This is because it's stored as a HashMap.

    for (MagicianType magicianType : MagicianType.find().orderBy("displayOrder").findList()) {
      magicianTypeMap.put(magicianType.getName(), false);
    }

    return magicianTypeMap;
  }


  /**
   * Verify if a given string is in the existing set of MagicianTypes.
   *
   * @param magicianType The experience level to check.
   * @return Boolean value of whether the magicianType is a member of MagicianType.
   */
  public static boolean isMagicianType(String magicianType) {
    int numFound = MagicianType.find().where().eq("name", magicianType).findRowCount();

    if (!(numFound == 0 || numFound == 1)) {
      throw new RuntimeException("Found an unexpected number [" + numFound + "] "
          + "of MagicianTypes called [" + magicianType + "] in the database.");
    }

    return numFound == 1;
  }


  /**
   * Generate an up-to-date Map of MagicianType with the provided magicianType set to true (if present).
   * <p>
   * These maps are used for the bootstrap3 select.scala.html dropdown list box.
   *
   * @param magicianType The experience level to get from the list.
   * @return An experienceLevelMap with the associated Experience Level set to true if present.
   */
  public static Map<String, Boolean> getMagicianTypes(String magicianType) {
    Map<String, Boolean> magicianTypeMap = getMagicianTypes();

    if (magicianType != null && isMagicianType(magicianType)) {
      magicianTypeMap.put(magicianType, true);
    }

    return magicianTypeMap;
  }

}
