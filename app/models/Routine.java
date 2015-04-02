package models;

/**
 * A routine object that holds a name, image, magic type, skill level,
 * information, description, and materials associated with the routine.
 */
public class Routine {

  private long id;
  private String name;
  private String image;
  private String magicType;
  private String skillLevel;
  private String info;
  private String description;
  private String materials;

  /**
   * Create new Routine object.
   *
   * @param id          The id.
   * @param name        The name of the routine.
   * @param image       The image associated with the routine.
   * @param magicType   The type of magic associated with the routine.
   * @param skillLevel  The skill level required to do this routine.
   * @param info        The information about this routine.
   * @param description The description of this routine.
   * @param materials   The materials needed to perform this routine.
   */
  public Routine(long id, String name, String image, String magicType, String skillLevel,
                 String info, String description, String materials) {

    this.id = id;
    this.name = name;
    this.image = image;
    this.magicType = magicType;
    this.skillLevel = skillLevel;
    this.info = info;
    this.description = description;
    this.materials = materials;
  }

  /**
   * Returns the id value to the caller.
   *
   * @return id long value.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns the name value to the caller.
   *
   * @return The name string.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the image value to the caller.
   *
   * @return The image string.
   */
  public String getImage() {
    return image;
  }

  /**
   * Returns the magic type value to the caller.
   *
   * @return The magic type string.
   */
  public String getMagicType() {
    return magicType;
  }

  /**
   * Returns the skill level value to the caller.
   *
   * @return The skill level string.
   */
  public String getSkillLevel() {
    return skillLevel;
  }

  /**
   * Returns the info value to the caller.
   *
   * @return The info string.
   */
  public String getInfo() {
    return info;
  }

  /**
   * Returns the description value to the caller.
   *
   * @return The description string.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the materials value to the caller.
   *
   * @return The materials string.
   */
  public String getMaterials() {
    return materials;
  }

}
