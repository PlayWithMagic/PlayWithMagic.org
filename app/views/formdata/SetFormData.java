package views.formdata;

import models.Set;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * SetFormData allows for the storage of Set Form Data that is input by the user.
 * This is utilized whenever a set is built, or a set is edited.
 */
public class SetFormData {

  /**
   * Input data id hidden field.
   */
  public long id;

  /**
   * Input data user ID hidden field.
   */
  public long userId;

  /**
   * Input data Set Name field.
   */
  public String setName;

  /**
   * Input data Description field.
   */
  public String description;

  /**
   * Input data list of Routine IDs.
   */
  public List<Long> routines;

  /**
   * Default no-arg constructor required by Play.
   */
  public SetFormData() {
    // No content.
  }



  /**
   * Constructor that builds the SetFormData object from a provided Set.
   *
   * @param set The passed in Set.
   */
  public SetFormData(Set set) {
    this.id = set.getId();
    this.userId = set.getUserId();
    this.setName = set.getSetName();
    this.description = set.getDescription();
    this.routines = set.getRoutines();
  }

  /**
   * Testing initialization constructor, does not include ID.
   *
   * @param userId  The userID associated with the Set.
   * @param setName The name of the Set.
   * @param description The description of the Set.
   * @param routines The list of Routine IDs in the Set.
   */
  public SetFormData(long userId, String setName, String description, List<Long> routines) {
    this.userId = userId;
    this.setName = setName;
    this.description = description;
    this.routines = routines;
  }

  /**
   * Validate that all fields are non-empty, and that certain fields adhere to specific criteria.
   *
   * @return Either null if no errors, or a List of Div IDs and their associated error messages.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();

    //TO-DO:  Build validation inputs for a Set.

    return errors.isEmpty() ? null : errors;

  }
}
