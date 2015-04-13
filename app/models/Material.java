package models;

/**
 * An item used in the performance of a routine.
 */
public class Material {
  private String name;             /* A short name for the item. */
  private String description;      /* A multi-line description of the item. */
  private boolean isInspectable;   /* Is the item inspectable by the audience? */
  private boolean isGivenAway;     /* Does the audience take this with them? */
  private boolean isConsumed;      /* Is the item consumed over the course of this routine? */
  private Integer price;           /* What is the cost of this item? */
  private String purchaseUrl;      /* Where would you buy one of these items? */
  private String imageUrl;         /* A URL of an image of this item. */

  /**
   * Create a new, valid FormMaterial object.
   * <p>
   * The constructor includes only the FormMaterial's required fields.  Use setters to set the non-required
   * fields.  The idea is that an object is always in a valid state.
   * </p>
   *
   * @param name A short name for the item.
   */
  public Material(String name) {
    this.name = name;
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
  public void isInspectable(boolean isInspectable) {
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
  public void isGivenAway(boolean isGivenAway) {
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
  public void isConsumed(boolean isConsumed) {
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
}
