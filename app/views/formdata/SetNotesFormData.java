package views.formdata;

import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Max;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * SetNotesFormData allows for the input of Set Notes HTML Form Data that is input by the user.
 */
public class SetNotesFormData {

  /**
   * Set ID hidden field.
   */
  public long id;

  /** The desired duration of the Set. */
  @Min(value = 1,
      message = "If it's under a minute, then just enter 1.")
  @Max(value = 120,
      message = "If you need a set longer than 120 minutes, submit a bug report and we'll look into it.")
  public Integer duration;

  /** The desired cost of the Set. */
  @Min(value = 0,
      message = "What are your expenses for one performance of this set?")
  @Max(value = 1000,
      message = "If you need to make this larger, submit a bug report and we'll look into it.")
  public Integer cost;


  /******************************************************************************************************************
   * C O N S T R U C T O R S
   ******************************************************************************************************************/

  /**
   * Default no-arg constructor required by Play.
   */
  public SetNotesFormData() {
    // No content.
  }

  /**
   * Constructor that builds the SetFormData object from a provided Set.
   *
   * @param setId The ID of the Set to generate notes on.
   * @param duration The desired duration of the Set.
   * @param cost The desired cost of the Set.
   */
  public SetNotesFormData(long setId, Integer duration, Integer cost) {
    this.id = setId;
    this.duration = duration;
    this.cost = cost;
  }


  /******************************************************************************************************************
   * M E T H O D S
   ******************************************************************************************************************/

  /**
   * Validate that at least one routine is in the set.
   *
   * @return Either null if no errors, or a List of Div IDs and their associated error messages.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<ValidationError>();

    return errors.isEmpty() ? null : errors;

  }
}