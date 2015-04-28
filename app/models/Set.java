package models;

import java.util.List;

/**
 * A Set object that holds the information about lists of Routines.
 * Is really a link to various Routine IDs.
 *
 * @see https://github.com/PlayWithMagic/PlayWithMagic/issues/101
 */
public class Set extends play.db.ebean.Model {

  private long id;
  // Set Info
  private String name;
  private String description;
  private List<Long> routines;


  /**
   * Creates a Set object.
   *
   * @param id          The ID of the Set.
   * @param name        The name of the Set.
   * @param description The description of the Set.
   * @param routines    The List of Long IDs of the routines in the set.
   */
  public Set(long id, String name, String description, List<Long> routines) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.routines = routines;
  }


  /**
   * Get the ID of the Set.
   *
   * @return The Set ID value.
   */
  public long getId() {
    return id;
  }

  /**
   * Set the ID of the... Set.
   *
   * @param id The ID of the Set.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Get the name of the Set.
   *
   * @return The name of the Set.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the Set.
   *
   * @param name The name of the Set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the Description of the Set.
   *
   * @return The Description of the Set.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set the description of the Set.
   *
   * @param description The Description of the Set.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Get the List of Routine IDs in the set.
   *
   * @return The List of Routine IDs.
   */
  public List<Long> getRoutines() {
    return routines;
  }

  /**
   * Set the List of Routine IDs in the set.
   *
   * @param routines The list of Routine IDs.
   */
  public void setRoutines(List<Long> routines) {
    this.routines = routines;
  }
}
