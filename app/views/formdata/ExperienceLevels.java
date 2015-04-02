package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for handling the different experience levels of Magicians, such as Novice, Expert, Professional, etc.
 */
public class ExperienceLevels {

  private static String[] experienceLevels = {"Neophyte", "Enthusiast", "Hobbyist", "Historian", "Collector",
      "Semi-Professional", "Professional"};


  /**
   * Generates a new Map of Experience levels with all of the pairs set to false (not selected).
   * This is built using the static pre-built list.
   *
   * @return The newly generated experienceLevelMap.
   */
  public static Map<String, Boolean> getExperienceLevels() {
    Map<String, Boolean> experienceLevelMap = new HashMap<String, Boolean>();
    for (String experienceLevel : experienceLevels) {
      experienceLevelMap.put(experienceLevel, false);
    }
    return experienceLevelMap;
  }

  /**
   * Verify if a given string is in our experienceLevelMap of Experience Levels.
   *
   * @param experienceLevel The experience level to check.
   * @return Boolean value of whether the experiencelevel is a member of Experience Levels.
   */
  public static boolean isExperienceLevel(String experienceLevel) {
    return getExperienceLevels().containsKey(experienceLevel);
  }

  /**
   * Generates a new Map of Experience levels with the provided Experience Level set to true (if present).
   * This is built using the static pre-built list.
   *
   * @param experienceLevel The experience level to get from the list.
   * @return An experienceLevelMap with the associated Experience Level set to true if present.
   */
  public static Map<String, Boolean> getExperienceLevels(String experienceLevel) {
    Map<String, Boolean> experienceLevelMap = getExperienceLevels();
    if (isExperienceLevel(experienceLevel)) {
      experienceLevelMap.put(experienceLevel, true);
    }
    return experienceLevelMap;
  }

}
