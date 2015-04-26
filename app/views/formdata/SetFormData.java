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
  public String name;

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
    this.name = set.getName();
    this.description = set.getDescription();
    this.routines = set.getRoutines();
  }

  /**
   * Testing initialization constructor, does not include ID.
   *
   * @param userId      The userID associated with the Set.
   * @param name        The name of the Set.
   * @param description The description of the Set.
   * @param routines    The list of Routine IDs in the Set.
   */
  public SetFormData(long userId, String name, String description, List<Long> routines) {
    this.userId = userId;
    this.name = name;
    this.description = description;
    if (routines != null) {
      System.out.println("Non-null routine data.");
      for (Long routine : routines) {
        this.routines.add(routine.longValue());
      }
    }
    else {
      System.out.println("Null Routine Data.");
      this.routines.clear();
    }

  }

  /**
   * Validate that all fields are non-empty, and that certain fields adhere to specific criteria.
   *
   * @return Either null if no errors, or a List of Div IDs and their associated error messages.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<ValidationError>();

    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Must provide a name for the Set."));
    }

    if (description == null || description.length() == 0) {
      errors.add(new ValidationError("description", "Please provide a description of this Set."));
    }

    if (routines == null) {
      errors.add(new ValidationError("routines", "Please select at least one Routine for a Set."));
    }

    //TO-DO:  Build validation inputs for a Set.

    return errors.isEmpty() ? null : errors;

  }
}
