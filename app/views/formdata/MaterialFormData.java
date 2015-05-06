package views.formdata;

import models.GlobalDbInfo;
import models.Material;
import play.data.validation.Constraints.Max;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Play Framework backing class that allows for the storage of Form Data input by the user.
 */
public class MaterialFormData {

  /**
   * A unique, synthetic key to the Routine - hidden field.
   * <p>
   * This is held as a key to a HashMap, so a long datatype is warranted.
   */
  public long routineId;

  /**
   * A unique, index of the material item or 0 if it's a new item.
   * <p>
   * This is held as an index into an ArrayList, so an int (the index into the ArrayList) is warranted.
   */
  public long materialId;

  /**
   * It's name -- whatever you'd call this item.
   */
  @Required(message = "A name for the material is required.")
  @MaxLength(value = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH,
      message = "The name can't be longer than " + GlobalDbInfo.MAX_SHORT_TEXT_LENGTH + " characters.")
  public String name;

  /**
   * Is the item inspectable?
   */
  public Boolean isInspectable = false;

  /**
   * Is the item given away?
   */
  public Boolean isGivenAway = false;

  /**
   * Is the item consumed during the course of the routine?
   */
  public Boolean isConsumed = false;

  /**
   * The cost of this item.  Currently in US Dollars.
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
   * The image id associated with this material.
   */
  public long imageId;


  /**
   * Default no-arg constructor required by Play.
   */
  public MaterialFormData() {
    // No content.
  }


  /**
   * Build a MaterialFormData object from a material object.
   *
   * @param material   The container holding the non-key portion of the material data.
   */
  public MaterialFormData(Material material) {
    this.routineId = material.getRoutine().getId();
    this.materialId = material.getId();
    this.name = material.getName();
    this.isInspectable = material.isInspectable();
    this.isGivenAway = material.isGivenAway();
    this.isConsumed = material.isConsumed();
    this.price = material.getPrice();
    this.description = material.getDescription();
    this.purchaseUrl = material.getPurchaseUrl();
    this.imageUrl = material.getImageUrl();
    this.imageId = material.getImageId();
  }


  /**
   * Enforce special UI validation rules for Material.
   *
   * @return Either null if no errors or a List of errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<ValidationError>();

    if (routineId < 0) {
      errors.add(new ValidationError("routineId", "An invalid routine ID has been passed into the application."));
    }

    if (materialId < -1) {
      errors.add(new ValidationError("materialId", "An invalid material ID has been passed into the application."));
    }

    return errors.isEmpty() ? null : errors;
  }
}
