package views.formdata;

import models.Routine;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * RoutineFormData allows for the storage of Form Data that is input by the user.
 */
public class RoutineFormData {

  /**
   * A unique, synthetic key to the Routine - hidden field.
   */
  public long id;

  /**
   * A short name for the routine..
   */
  public String name;

  /**
   * A multi-line description of the routine.
   */
  public String description;

  /**
   * The average time to perform a basic rendition of this routine in minutes.
   */
  public Integer duration;

  /**
   * A multi-line discussion of the method for this routine.
   */
  public String method;

  /**
   * A multi-line discussion of the handling for the routine.
   */
  public String handling;

  /**
   * Set to true if the routine resets instantly.
   */
  public Boolean resetInstantly;

  /**
   * The average time to prepare the routine for presentation.
   */
  public Integer resetDuration;

  /**
   * A description of the process to prepare the routine.
   */
  public String resetDescription;


  /**
   * Default no-arg constructor required by Play.
   */
  public RoutineFormData() {
    // No content.
  }


  /**
   * Build a RoutineFormData object from a Routine.
   *
   * @param routine The routine object passed to the constructor.
   */
  public RoutineFormData(Routine routine) {
    id = routine.getId();
    name = routine.getName();
    description = routine.getDescription();
    duration = routine.getDuration();
    method = routine.getMethod();
    handling = routine.getHandling();
    resetInstantly = routine.isResetInstantly();
    resetDuration = routine.getResetDuration();
    resetDescription = routine.getResetDescription();
  }


  /**
   * Enforce the UI validation rules for Routines.
   *
   * 1. The required fields are:  Name, Description
   *
   * @return Either null if no errors or a List of errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (id < 0) {
      errors.add(new ValidationError("id", "An invalid ID has been passed into the application."));
    }

    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Your routine's gotta have a name."));
    }

    if (description == null || description.length() == 0) {
      errors.add(new ValidationError("description",
          "A name's not enough.  Please write a brief description of your routine."));
    }

    return errors.isEmpty() ? null : errors;
  }
}
