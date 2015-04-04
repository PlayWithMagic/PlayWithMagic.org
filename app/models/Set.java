package models;


import java.util.List;

/**
 * A Set object that holds the information about list of Routines.
 * Is really a link of various Routine IDs.
 *
 * @see https://github.com/PlayWithMagic/PlayWithMagic/issues/101
 */
public class Set {

  private long id;
  private long userId;
  // Set Info
  private String setName;
  private String description;
  private List<Long> routines;



  /**
   * Creates a Set object.
   * @param id The ID of the Set.
   * @param userId The ID of the user who created the Set.
   * @param setName The Name of the Set.
   * @param description The description of the Set.
   * @param routines The List of Long IDs of the routines in the set.
   */
  public Set(long id, long userId, String setName, String description, List<Long> routines) {
    this.id = id;
    this.userId = userId;
    this.setName = setName;
    this.description = description;
    this.routines = routines;
  }

  /**
   * Get the ID of the set.
   * @return The Set ID value.
   */
  public long getId() {
    return id;
  }

  /**
   * Get the ID of the User who created the Set.
   * @return The ID of the user.
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Get the Name of the set.
   * @return The Name of the set.
   */
  public String getSetName() {
    return setName;
  }

  /**
   * Get the Description of the Set.
   * @return The Description of the Set.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Get the List of Routine IDs in the set.
   * @return The List of Routine IDs.
   */
  public List<Long> getRoutines() {
    return routines;
  }
}
