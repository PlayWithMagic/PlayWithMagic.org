package views.formdata;

import models.GlobalDbInfo;
import models.Routine;
import play.data.validation.Constraints.Max;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Required;
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
  @Required(message = "Your routine's gotta have a name.")
  @MaxLength(value = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH,
      message = "The routine's name can't be longer than " + GlobalDbInfo.MAX_SHORT_TEXT_LENGTH + " characters.")
  public String name;

  /**
   * A multi-line description of the routine.
   */
  @Required(message = "A name's not enough.  Please write a brief description of your routine.")
  @MaxLength(value = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH,
      message = "Description can't be more than " + GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH + " characters.")
  public String description;

  /**
   * The average time to perform a basic rendition of this routine in minutes.
   */
  @Min(value = 1,
      message = "If it's under a minute, then just enter 1.")
  @Max(value = 120,
      message = "If you need a routine longer than 120 minutes, submit a bug report and we'll look into it.")
  @Required(message = "If it's under a minute, then just enter 1.")
  public Integer duration;

  /**
   * A multi-line discussion of the method for this routine.
   */
  @MaxLength(value = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH,
      message = "Method can't be more than " + GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH + " characters.")
  public String method;

  /**
   * A multi-line discussion of the handling for the routine.
   */
  @MaxLength(value = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH,
      message = "Handling can't be more than " + GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH + " characters.")
  public String handling;

  /**
   * The average time to prepare the routine for presentation.
   */
  @Min(value = 1, message = "If it resets instantly, then just leave this blank.  If it takes under a minute "
      + "to reset, then enter 1.")
  @Max(value = 120,
      message = "If it takes longer than 2 hours to reset, well... then we hope it's a great trick.  "
          + "Submit a bug report and we'll look into it.")
  public Integer resetDuration;

  /**
   * A description of the process to prepare the routine.
   */
  @MaxLength(value = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH,
      message = "Reset Description can't be more than " + GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH + " characters.")
  public String resetDescription;

  /**
   * A URL of the magician performing this Routine on YouTube.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "YouTube URL can't be more than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String youTubeUrl;

  /**
   * A URL of the image for this routine.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "The image URL can't be more than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String imageUrl;

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
    resetDuration = routine.getResetDuration();
    resetDescription = routine.getResetDescription();
    youTubeUrl = routine.getYouTubeUrl();
    imageUrl = routine.getImageUrl();
  }

  /**
   * Enforce special UI validation rules for Routines.
   *
   * @return Either null if no errors or a List of errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (id < 0) {
      errors.add(new ValidationError("id", "An invalid ID has been passed into the application."));
    }

    // TO-DO:  The Play Framework prints 'error.invalid' and not presenting this error message.
    // Can't figure out how to get a nicer looking message up front.
    if (duration != null) {
      int testDuration;
      try {
        testDuration = new Integer(duration);
      }
      catch (NumberFormatException e) {
        errors.add(new ValidationError("duration",
            "Whatever you put in there is not a nice, round number between 1 and 120 minutes."));
        // Absorb the error.
      }
    }

    return errors.isEmpty() ? null : errors;
  }
}
