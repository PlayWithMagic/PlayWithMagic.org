package models;

import java.util.List;

/**
 * Created by mark on 4/27/15.
 */
public class MagicianType {
  private long id;
  private String name;
  private String description;
  private int displayOrder;
  private List<Magician> magicians;


  /**
   * Create a new MagicianType with all of the required fields.
   *
   * @param name The name of this magician type.
   * @param description A brief description of this magician type.
   * @param displayOrder When all of the magician types are selected back, where would this be?
   */
  public MagicianType(String name, String description, int displayOrder) {
    this.name = name;
    this.description = description;
    this.displayOrder = displayOrder;
  }

  /**
   * Get the description of the magician type.
   *
   * @return The description of the magician type.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set the description of the magician type.
   *
   * @param description The description of the magician type.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Get the display order of this magician type.
   *
   * @return The display order of this magican type.
   */
  public int getDisplayOrder() {
    return displayOrder;
  }

  /**
   * Set the display order of this magician type.
   *
   * @param displayOrder The display order of this magician type.
   */
  public void setDisplayOrder(int displayOrder) {
    this.displayOrder = displayOrder;
  }

  /**
   * Get the ID of this magician type.
   *
   * @return The ID of this magician type.
   */
  public long getId() {
    return id;
  }

  /**
   * Set the ID of this magician type.
   *
   * @param id The ID of this magician type.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Get the name of this magician type.
   *
   * @return The name of this magician type.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name for this magician type.
   *
   * @param name The name for this magician type.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the set of magicians for this magician type.
   *
   * @return The list of magicians for this magician type.
   */
  public List<Magician> getMagicians() {
    return magicians;
  }

  /**
   * Set the list of magicians for this magician type.
   *
   * @param magicians A list of magicians for this magician type.
   */
  public void setMagicians(List<Magician> magicians) {
    this.magicians = magicians;
  }

  /**
   * Add a magician to this magician type.
   *
   * @param magician The magician to add to this type.
   */
  public void addMagician(Magician magician) {
    magicians.add(magician);
  }
}
