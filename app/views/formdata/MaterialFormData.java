package views.formdata;

import models.GlobalDbInfo;
import models.Material;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Max;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Play Framework backing class that allows for the storage of Form Data input by the user.
 */
public class MaterialFormData {
  /**
   * A unique, synthetic key to the Routine - hidden field.
   *
   * This is held as a key to a HashMap, so a long datatype is warranted.
   */
  public long routineId;

  /**
   * A unique, index of the material item or 0 if it's a new item.
   *
   * This is held as an index into an ArrayList, so an int (the index into the ArrayList) is warranted.
   */
  public int materialId;

  /**
   * It's name -- whatever you'd call this item.
   */
  @Required(message = "A name for the material is required.")
  public String name;

  // TODO:  Implement checkboxes

  /**
   * The cost of this item.
   */
  @Min(value = 0,
      message = "Gotta be a positive number")
  @Max(value = 1000000,
      message = "The maximum value for Play With Magic is $1,000,000.")
  public Integer price;

  /**
   * Notes about this item.
   */
  @MaxLength(value = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH,
      message = "Description can't be more than " + GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH + " characters.")
  public String description;

  /**
   * A link to where you might purchase this item.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "The purchase URL can't be more than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")

  public String purchaseUrl;

  /**
   * A URI to an image of this item.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "The image URL can't be more than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String imageUrl;

  /**
   * Default no-arg constructor required by Play.
   */
  public MaterialFormData() {
    // No content.
  }

  /**
   * Build a MaterialFormData object from a material object.
   *
   * @param material The container holding the non-key portion of the material data.
   * @param routineId  The ID of the routine associated with this material.
   * @param materialId  The ID of the material (if it's being edited) or 0 if it's new.
   */
  public MaterialFormData(Material material, long routineId, int materialId) {
    this.routineId = routineId;
    this.materialId = materialId;
    this.name = material.getName();
    // TODO:  Add boolean fields
    this.price = material.getPrice();
    this.description = material.getDescription();
    this.purchaseUrl = material.getPurchaseUrl();
    this.imageUrl = material.getImageUrl();
  }


  /**
   * Enforce special UI validation rules for Material.
   *
   * @return Either null if no errors or a List of errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (routineId < 0) {
      errors.add(new ValidationError("routineId", "An invalid routine ID has been passed into the application."));
    }

    if (materialId < -1) {
      errors.add(new ValidationError("materialId", "An invalid material ID has been passed into the application."));
    }

    return errors.isEmpty() ? null : errors;
  }
}
