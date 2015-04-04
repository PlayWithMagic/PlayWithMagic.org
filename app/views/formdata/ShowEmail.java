package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for handling a single entity checkbox.
 */
public class ShowEmail {

  private static String[] showMyEmail = {"Show Email"};


  /**
   * Generates a new Map Email States with all of the pairs set to false (not selected).
   * This is built using the static pre-built list.
   *
   * @return The newly generated showEmailMap.
   */
  public static Map<String, Boolean> getShowMyEmail() {
    Map<String, Boolean> showMyEmailMap = new HashMap<String, Boolean>();
    for (String thisEmail : showMyEmail) {
      showMyEmailMap.put(thisEmail, false);
    }
    return showMyEmailMap;
  }

  /**
   * Verify if a given string is in our Show Email list.
   *
   * @param showEmail The string to check.
   * @return Boolean value of whether the showMyEmail string is a member of ShowEmails.
   */
  public static boolean isShowMyEmail(String showEmail) {
    return getShowMyEmail().containsKey(showEmail);
  }

  /**
   * Generates a new Map of ShowEmail states with the provided state in the list set to true (if present).
   * This is built using the static pre-built list.
   *
   * @param showEmail The Show Email State to get from the list.
   * @return A showMyEmailMap with the Show Email state set to true if present.
   */
  public static Map<String, Boolean> getShowMyEmail(String showEmail) {
    Map<String, Boolean> showMyEmailMap = getShowMyEmail();
    if (isShowMyEmail(showEmail)) {
      showMyEmailMap.put(showEmail, true);
    }
    return showMyEmailMap;
  }

}
