package models;

import play.Logger;
import views.formdata.MaterialFormData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * An item used in the performance of a routine.
 * <p>
 * The synthetic unique constraint on this model is id.
 * The logical unique constraint on this model is routine+name.
 * <p>
 * Material objects are 'owned' by Routines.
 */
@Entity
public class Material extends play.db.ebean.Model {
  // A unique, synthetic key for the Material
  @Id
  private long id;

  // The routine that this material belongs to
  @Column(nullable = false)
  @ManyToOne
  private Routine routine;

  // A short name for the item
  @Column(nullable = false, length = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH)
  private String name;

  // A multi-line description of the item
  @Column(length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH)
  private String description;

  // Is the item inspectable by the audience?
  @Column(nullable = false)
  private boolean isInspectable;

  // Does the audience take this with them?
  @Column(nullable = false)
  private boolean isGivenAway;

  // Is the item consumed over the course of this routine?
  @Column(nullable = false)
  private boolean isConsumed;

  // What is the cost of this item?
  private Integer price;

  // Where would you buy one of these items?
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH)
  private String purchaseUrl;

  // A URL of an image of this item.
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH)
  private String imageUrl;

  // The image id associated with this material
  private long imageId;


  /**
   * Create a new, valid FormMaterial object.
   * <p>
   * The constructor includes only the FormMaterial's required fields.  Use setters to set the non-required
   * fields.  The idea is that an object is always in a valid state.
   * </p>
   *
   * @param routine The routine associated with this item.
   * @param name    A short name for the item.
   */
  public Material(Routine routine, String name) {
    this.routine = routine;
    this.name = name;
  }


  /******************************************************************************************************************
   * G E T T E R S   &   S E T T E R S
   ******************************************************************************************************************/

  /**
   * Get the synthetic key for this Material object.
   *
   * @return The synthetic key to this Material object.
   */
  public long getId() {
    return id;
  }

  /**
   * Set the synthetic key for this Material object.
   *
   * @param id The synthetic key for this Material object.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Get the routine associated with this Material item.
   *
   * @return The routine associated with this Material item.
   */
  public Routine getRoutine() {
    return routine;
  }

  /**
   * Set the routine associated with this Material item.
   *
   * @param routine The routine associated with this Material item.
   */
  public void setRoutine(Routine routine) {
    this.routine = routine;
  }

  /**
   * Get a short name for this item.
   *
   * @return A short name for this item.
   */
  public String getName() {
    return name;
  }

  /**
   * Set a short name for this item.
   *
   * @param name A short name for this item.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get some notes about this item.
   *
   * @return Some notes about this item.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set some notes about this item.
   *
   * @param description Some notes about this item.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Is the item inspectable by the audience?
   *
   * @return True if the item is inspectable.  False if it is not inspectable.
   */
  public boolean isInspectable() {
    return isInspectable;
  }

  /**
   * Set the inspectability of the item.
   *
   * @param isInspectable True if the item is inspectable.  False if it is not inspectable.
   */
  public void setIsInspectable(boolean isInspectable) {
    this.isInspectable = isInspectable;
  }

  /**
   * Is the item given away to a spectator?
   *
   * @return True if the item is given away.  False if it is not given away.
   */
  public boolean isGivenAway() {
    return isGivenAway;
  }

  /**
   * Set weather an item is given away to a spectator.
   *
   * @param isGivenAway True if the item is given away.  False if it is not given away.
   */
  public void setIsGivenAway(boolean isGivenAway) {
    this.isGivenAway = isGivenAway;
  }

  /**
   * Is the item consumed over the course of the routine?
   *
   * @return True if the item is consumed over the course of the routine.  False if it is not consumed.
   */
  public boolean isConsumed() {
    return isConsumed;
  }

  /**
   * Set weather an item is consumed over the course of the routine.
   *
   * @param isConsumed True if the item is consumed over the course of the routine.  False if it is not consumed.
   */
  public void setIsConsumed(boolean isConsumed) {
    this.isConsumed = isConsumed;
  }

  /**
   * Get the cost of the item.
   *
   * @return The cost of the item.
   */
  public Integer getPrice() {
    return price;
  }

  /**
   * Set the cost of the item.
   *
   * @param price The cost of the item.
   */
  public void setPrice(Integer price) {
    this.price = price;
  }

  /**
   * Get the URL to where you can purchase or find this item.
   *
   * @return The URL where you can purchase or find this item.
   */
  public String getPurchaseUrl() {
    return purchaseUrl;
  }


  // No need to implement getRoutineMaterials(Routine routine)... this would be done with routine.getMaterials().

  /**
   * Set the URL where you can purchase or find this item.
   *
   * @param purchaseUrl The URL where you can purchase or find this item.
   */
  public void setPurchaseUrl(String purchaseUrl) {
    this.purchaseUrl = purchaseUrl;
  }

  /**
   * Get a URL of the image for this item.
   *
   * @return A URL of the image for this item.
   */
  public String getImageUrl() {
    return imageUrl;
  }

  /**
   * Set a URL of the image for this item.
   *
   * @param imageUrl A URL of the image for this item.
   */
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   * Gets the image id associated with this material.
   *
   * @return The image id.
   */
  public long getImageId() {
    return imageId;
  }

  /**
   * Sets the image id associated with this material.
   *
   * @param imageId The image id.
   */
  public void setImageId(long imageId) {
    this.imageId = imageId;
  }


  /******************************************************************************************************************
   * M E T H O D S
   ******************************************************************************************************************/

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, Material> find() {
    return new Finder<Long, Material>(Long.class, Material.class);
  }

  /**
   * Get all of the Materials in the database.
   *
   * @return The all Materials.
   */
  public static List<Material> getAllMaterials() {
    return Material.find().all();
  }

  // No need to implement getRoutineMaterials(Routine routine)... this would be done with routine.getMaterials().

  /**
   * Retrieve a Material item associated with a given id from the database.
   *
   * @param id The ID of the Material to retrieve.
   * @return The Material.
   * @throws RuntimeException if the ID can't be found.
   */
  public static Material getMaterial(long id) {
    Material material = Material.find().byId(id);
    if (material == null) {
      throw new RuntimeException("Unable to find Material with ID [" + id + "]");
    }

    return material;
  }

  /**
   * Add or update a Material object to a Routine object saved in the Routines database.
   *
   * @param materialFormData Input data from an HTML form.
   * @return The Material object just saved to the database.
   */
  public static Material saveMaterialFromForm(MaterialFormData materialFormData) {
    Material material;

    if (materialFormData.materialId == 0) {
      material = new Material(Routine.getRoutine(materialFormData.routineId), materialFormData.name);
    }
    else {
      material = Material.getMaterial(materialFormData.materialId);
      material.setRoutine(Routine.getRoutine(materialFormData.routineId));
      material.setName(materialFormData.name);
    }

    material.setDescription(materialFormData.description);
    material.setIsInspectable(materialFormData.isInspectable);
    material.setIsGivenAway(materialFormData.isGivenAway);
    material.setIsConsumed(materialFormData.isConsumed);
    material.setPrice(materialFormData.price);
    material.setPurchaseUrl(materialFormData.purchaseUrl);
    material.setImageUrl(materialFormData.imageUrl);

    long currentImageId = material.getImageId();
    if (materialFormData.imageId > 0) {
      if (materialFormData.imageId != currentImageId) {
        Image thisImage = Image.find().byId(currentImageId);
        thisImage.delete();
      }
      material.setImageId(materialFormData.imageId);
    }

//    if (materialFormData.materialId == 0) {
//      Routine.getMaterials(materialFormData.routineId).add(material);
//    }
//    else {
//      Routine.getMaterials(materialFormData.routineId).set(materialFormData.materialId, material);
//    }

    material.save();
    material = Material.find().byId(material.getId());

    Logger.debug(((materialFormData.materialId == 0) ? "  Add" : "  Update") + " material:"
        + "   id = [" + material.getId() + "]  name = [" + material.getName() + "]");

    return material;

  }

}