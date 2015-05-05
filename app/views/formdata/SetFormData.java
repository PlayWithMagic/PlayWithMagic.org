package views.formdata;

import models.GlobalDbInfo;
import models.Routine;
import models.Set;
import play.data.validation.Constraints.Required;
import play.data.validation.Constraints.MaxLength;
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
   * Input data Magician id hidden field.
   */
  public long magicianId;

  /**
   * A short name for the set.
   */
  @Required(message = "You must provide a name for your Set.")
  @MaxLength(value = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH,
      message = "The set's name can't be longer than " + GlobalDbInfo.MAX_SHORT_TEXT_LENGTH + " characters.")
  public String name;

  /**
   * A multi-line description of the set.
   */
  @Required(message = "Please provide a description of this Set.")
  @MaxLength(value = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH,
      message = "Description can't be more than " + GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH + " characters.")
  public String description;

  /**
   * Input data list of Routine IDs.
   */
  public List<Long> routines;


  /******************************************************************************************************************
   * C O N S T R U C T O R S
   ******************************************************************************************************************/

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
    this.name = set.getName();
    this.description = set.getDescription();
    this.routines = Routine.getListOfIds(set.getRoutines());
  }


  /******************************************************************************************************************
   * M E T H O D S
   ******************************************************************************************************************/

  /**
   * Testing initialization constructor, does not include ID.
   *
   * @param name        The name of the Set.
   * @param description The description of the Set.
   * @param routines    The list of Routine IDs in the Set.
   */
  public SetFormData(String name, String description, List<Long> routines) {
/*
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
*/
  }


  /**
   * Validate that at least one routine is in the set.
   *
   * @return Either null if no errors, or a List of Div IDs and their associated error messages.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<ValidationError>();

    if (routines == null || routines.size() == 0) {
      errors.add(new ValidationError("routines", "Please select at least one Routine for a Set."));
    }

    return errors.isEmpty() ? null : errors;

  }
}
