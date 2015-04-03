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
   * Input data id hidden field.
   */
  public long id;
  /**
   * Input data name field.
   */
  public String name;
  /**
   * Input data image field.
   */
  public String image;
  /**
   * Input data magic type field.
   */
  public String magicType;
  /**
   * Input data skill level field.
   */
  public String skillLevel;
  /**
   * Input data info field.
   */
  public String info;
  /**
   * Input data description field.
   */
  public String description;
  /**
   * Input data materials field.
   */
  public String materials;

  /**
   * Default no-arg constructor required by Play.
   */
  public RoutineFormData() {
    // No content.
  }

  /**
   * Constructor that builds the RoutineFormData object from a Routine.
   *
   * @param routine The routine object passed to the constructor.
   */
  public RoutineFormData(Routine routine) {
    id = routine.getId();
    name = routine.getName();
    image = routine.getImage();
    magicType = routine.getMagicType();
    skillLevel = routine.getSkillLevel();
    info = routine.getInfo();
    description = routine.getDescription();
    materials = routine.getMaterials();
  }


  /**
   * Validate that all fields are non-empty and that telephone field is 12 characters.
   *
   * @return Either null if no errors, or a List of errors.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "A Routine Name must be provided."));
    }
    if (image == null || image.length() == 0) {
      errors.add(new ValidationError("image", "A Routine Image must be provided."));
    }
    if (magicType == null || magicType.length() == 0) {
      errors.add(new ValidationError("magicType", "A Routine Magic Type must be provided."));
    }
    if (skillLevel == null || skillLevel.length() == 0) {
      errors.add(new ValidationError("skillLevel", "A Routine Image must be provided."));
    }
    if (info == null || info.length() == 0) {
      errors.add(new ValidationError("info", "A Routine's Information must be provided."));
    }
    if (description == null || description.length() == 0) {
      errors.add(new ValidationError("description", "A Routine's Description must be provided."));
    }
    if (materials == null || materials.length() == 0) {
      errors.add(new ValidationError("materials", "A Routine list of materials must be provided."));
    }

    return errors.isEmpty() ? null : errors;
  }
}
