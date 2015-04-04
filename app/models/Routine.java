package models;

/**
 * A single magic routine.
 * <p>
 * This is a central entity for the Play With Magic application.
 */
public class Routine {

  private long id;                 /* A unique, synthetic key to the Routine. */
  private String name;             /* A short name for the routine. */
  private String description;      /* A multi-line description of the routine. */
  private Integer duration;        /* The average time to perform a basic rendition of this routine in minutes. */
  private String method;           /* A multi-line discussion of the method for this routine. */
  private String handling;         /* A multi-line discussion of the handling for the routine. */
  private Boolean resetInstantly;  /* Set to true if the routine resets instantly. */
  private Integer resetDuration;   /* The average time to prepare the routine for presentation. */
  private String resetDescription; /* A description of the process to prepare the routine. */

  /**
   * Create new, valid Routine object.
   * <p>
   * The constructor includes only the Routine's required fields.  Use setters to set the non-required
   * fields.  The idea is that an object (A routine) is always in a valid state.
   *
   * @param id          A unique, synthetic key to the Routine.
   * @param name        A short name for the routine.
   * @param description A multi-line description of the routine.
   */
  public Routine(
      long id,
      String name,
      String description) {

    this.id = id;
    this.name = name;
    this.description = description;
  }

  /**
   * Returns a unique, synthetic key to the Routine.
   *
   * @return id A unique, synthetic key to the Routine.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns a short name for the routine.
   *
   * @return A short name for the routine.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns a multi-line description of the routine.
   *
   * @return A multi-line description of the routine.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Get the average time to perform a basic rendition of this routine in minutes.
   *
   * @return The average time to perform a basic rendition of this routine in minutes.
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * Get a multi-line discussion of the method for this routine.
   *
   * @return A multi-line discussion of the method for this routine.
   */
  public String getMethod() {
    return method;
  }

  /**
   * Get a multi-line discussion of the handling for the routine.
   * @return A multi-line discussion of the handling for the routine.
   */
  public String getHandling() {
    return handling;
  }

  /**
   * Does the routine reset instantly?
   *
   * @return True if the routine resets instantly.  False if not.
   */
  public Boolean isResetInstantly() {
    return resetInstantly;
  }

  /**
   * Get the average time to prepare the routine for presentation.
   *
   * @return The average time to prepare the routine for presentation.
   */
  public Integer getResetDuration() {
    return resetDuration;
  }

  /**
   * Get a description of the process to prepare the routine.
   *
   * @return A description of the process to prepare the routine.
   */
  public String getResetDescription() {
    return resetDescription;
  }
}
