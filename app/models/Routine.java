package models;

import java.util.ArrayList;
import java.util.List;

/**
 * A single magic routine.
 * <p>
 * This is a central entity for the Play With Magic application.
 */
public class Routine {

  private long id;                   /* A unique, synthetic key to the Routine. */
  private String name;               /* A short name for the routine. */
  private String description;        /* A multi-line description of the routine. */
  private Integer duration;          /* The average time to perform a basic rendition of this routine in minutes. */
  private String method;             /* A multi-line discussion of the method for this routine. */
  private String handling;           /* A multi-line discussion of the handling for the routine. */
  private Integer resetDuration;     /* The average time to prepare the routine for presentation. */
  private String resetDescription;   /* A description of the process to prepare the routine. */
  private String youTubeUrl;         /* A URL of the magician performing this routine on YouTube. */
  private String imageUrl;           /* A URL of an image of this routine. */
  private List<Material> materials;  /* The materials used for this routine. */
  private String reviewUrl;          /* A URL of a review of the routine. */

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
    this.materials = new ArrayList<Material>();
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
   * Set a short name for the routine.
   *
   * @param name A short name for the routine.
   */
  public void setName(String name) {
    this.name = name;
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
   * Set a multi-line description of the routine.
   *
   * @param description A multi-line description of the routine.
   */
  public void setDescription(String description) {
    this.description = description;
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
   * Set the average time to perform a basic rendition of this routine in minutes.
   *
   * @param duration The average time to perform a basic rendition of this routine in minutes.
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
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
   * Set a multi-line discussion of the method for this routine.
   *
   * @param method A multi-line discussion of the method for this routine.
   */
  public void setMethod(String method) {
    this.method = method;
  }

  /**
   * Get a multi-line discussion of the handling for the routine.
   *
   * @return A multi-line discussion of the handling for the routine.
   */
  public String getHandling() {
    return handling;
  }

  /**
   * Set a multi-line discussion of the handling for this routine.
   *
   * @param handling a multi-line discussion of the handling for this routine.
   */
  public void setHandling(String handling) {
    this.handling = handling;
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
   * Set the average time to prepare the routine for presentation.
   *
   * @param resetDuration The average time to prepare the routine for presentation.
   */
  public void setResetDuration(Integer resetDuration) {
    this.resetDuration = resetDuration;
  }

  /**
   * Get a description of the process to prepare the routine.
   *
   * @return A description of the process to prepare the routine.
   */
  public String getResetDescription() {
    return resetDescription;
  }

  /**
   * Set a description of the process to prepare the routine.
   *
   * @param resetDescription A description of the process to prepare the routine.
   */
  public void setResetDescription(String resetDescription) {
    this.resetDescription = resetDescription;
  }

  /**
   * Get a URL of the magician performing this routine on YouTube.
   *
   * @return A URL of the magician performing this routine on YouTube.
   */
  public String getYouTubeUrl() {
    return youTubeUrl;
  }


  /**
   * Set a URL of the magician performing this routine on YouTube.
   *
   * @param youTubeUrl A URL of the magician performing this routine on YouTube.
   */
  public void setYouTubeUrl(String youTubeUrl) {
    this.youTubeUrl = youTubeUrl;
  }

  /**
   * Get a URL of the image for this routine.
   *
   * @return A URL of the image for this routine.
   */
  public String getImageUrl() {
    return imageUrl;
  }

  /**
   * Set a URL of the image for this routine.
   *
   * @param imageUrl A URL of the image for this routine.
   */
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   * Get the materials used for this routine.
   *
   * @return The materials used for this routine.
   */
  public List<Material> getMaterials() {
    return materials;
  }

  /**
   * Get a URL of a review for this routine.
   *
   * @return A URL of the review for this routine.
   */
  public String getReviewUrl() {
    return reviewUrl;
  }

}
