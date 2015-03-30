package models;

import views.formdata.MagicianFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Patrick A. Karjala on 3/29/15.
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
        formData.dateOfBirth, formData.showAge, formData.location, formData.userPhoto, formData.biography,
        formData.interests, formData.influences, formData.experienceLevel, formData.yearsPracticing,
        formData.organizations, formData.website, formData.email, formData.showEmail, formData.facebook,
        formData.twitter, formData.linkedIn, formData.googlePlus, formData.flickr, formData.instagram);
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
}
