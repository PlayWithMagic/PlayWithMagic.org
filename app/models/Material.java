package models;

/**
 * An item used in the performance of a routine.
 */
public class Material {
  private long id;                 /* A unique, synthetic key to the Material. */
  private Routine routine;         /* The routine that holds this item. */
  private String name;             /* A short name for the item. */
  private String description;      /* A multi-line description of the item. */
  private Boolean isInspectable;   /* Is the item inspectable by the audience? */
  private Boolean isGivenAway;     /* Does the audience take this with them? */
  private Boolean isConsumed;      /* Is the item consumed over the course of this routine? */
  private Integer price;           /* What is the cost of this item? */
  //TODO:  Let's do currency later -- create an item for multi-currency support
  private String purchaseURL;      /* Where would you buy one of these items? */
  private String imageUrl;         /* A URL of an image of this item. */

  /**
   * Create a new, valid Material object.
   * <p>
   * The constructor includes only the Material's required fields.  Use setters to set the non-required
   * fields.  The idea is that an object is always in a valid state.
   * </p>
   *
   * @param id      A unique, synthetic key to the Material.
   * @param routine The Routine that holds this item.
   * @param name    A short name for the item.
   */
  public Material(long id, Routine routine, String name) {
    this.id = id;
    this.routine = routine;
    this.name = name;
  }

  /**
   * Returns a unique, synthetic key to the Material.
   *
   * @return A unique, synthetic key to the Material.
   */
  public long getId() {
    return id;
  }

  /**
   * Set a unique, synthetick key to the Material.
   *
   * @param id A unique, synthetic key to the Material.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * A reference to the Routine that uses this item.
   *
   * @return routine The Routine that uses this item.
   */
  public Routine getRoutine() {
    return routine;
  }

  /**
   * Set the Routine that uses this item.
   *
   * @param routine The Routine that uses this item.
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
  public Boolean isInspectable() {
    return isInspectable;
  }

  /**
   * Set the inspectability of the item.
   *
   * @param isInspectable True if the item is inspectable.  False if it is not inspectable.
   */
  public void setIsInspectable(Boolean isInspectable) {
    this.isInspectable = isInspectable;
  }

  /**
   * Is the item given away to a spectator?
   *
   * @return True if the item is given away.  False if it is not given away.
   */
  public Boolean isGivenAway() {
    return isGivenAway;
  }

  /**
   * Set weather an item is given away to a spectator.
   *
   * @param isGivenAway True if the item is given away.  False if it is not given away.
   */
  public void setIsGivenAway(Boolean isGivenAway) {
    this.isGivenAway = isGivenAway;
  }

  /**
   * Is the item consumed over the course of the routine?
   *
   * @return True if the item is consumed over the course of the routine.  False if it is not consumed.
   */
  public Boolean isConsumed() {
    return isConsumed;
  }

  /**
   * Set weather an item is consumed over the course of the routine.
   *
   * @param isConsumed True if the item is consumed over the course of the routine.  False if it is not consumed.
   */
  public void setIsConsumed(Boolean isConsumed) {
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
  public String getPurchaseURL() {
    return purchaseURL;
  }

  /**
   * Set the URL where you can purchase or find this item.
   *
   * @param purchaseURL The URL where you can purchase or find this item.
   */
  public void setPurchaseURL(String purchaseURL) {
    this.purchaseURL = purchaseURL;
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
