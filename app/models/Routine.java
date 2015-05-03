package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * A single magic routine.
 * <p>
 * This is a central entity for the Play With Magic application.
 *
 * The synthetic unique constraint on this model is id.
 * The logical unique constraint on this model is name.
 *
 * Routines are like Wikis... many people contribute - nobody owns them.  Magicians will own a rendition of a routine.
 */
@Entity
public class Routine extends play.db.ebean.Model {
  // A unique, synthetic key to the Routine
  @Id
  private long id;

  // A short name for the routine
  @Column(unique = true, nullable = false, length = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH)
  private String name;

  // A multi-line description of the routine
  @Column(nullable = false, length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH)
  private String description;

  // The average time to perform a basic rendition of this routine in minutes
  @Column(nullable = false)
  private Integer duration;

  // A multi-line discussion of the method for this routine
  @Column(length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH)
  private String method;

  // A multi-line discussion of the handling for the routine
  @Column(length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH)
  private String handling;

  // The average time to prepare the routine for presentation
  private Integer resetDuration;

  // A description of the process to prepare the routine
  @Column(length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH)
  private String resetDescription;

  // A URL of the magician performing this routine on YouTube
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH)
  private String youTubeUrl;

  // A URL of an image of this routine
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH)
  private String imageUrl;

  // The materials used for this routine
  @OneToMany(mappedBy = "routine", cascade = CascadeType.PERSIST)
  private List<Material> materials;

  // A URL of a review of the routine
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH)
  private String reviewUrl;

  // What was the inspiration for this routine
  @Column(length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH)
  private String inspiration;

  // What routines would you put next to this
  @Column(length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH)
  private String placement;

  // Why did you make some of the choices you made in the design of this routine
  @Column(length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH)
  private String choices;

  // The sets that use this routine
  @ManyToMany(mappedBy = "routines", cascade = CascadeType.PERSIST)
  private List<Set> sets;


  /**
   * Create new, valid Routine object.
   * <p>
   * The constructor includes only the Routine's required fields.  Use setters to set the non-required
   * fields.  The idea is that an object (A routine) is always in a valid state.
   *
   * @param id          A unique, synthetic key to the Routine.
   * @param name        A short name for the routine.
   * @param description A multi-line description of the routine.
   * @param duration    The average time to perform a basic rendition of this routine in minutes.
   */
  public Routine(
      long id,
      String name,
      String description,
      Integer duration) {

    this.id = id;
    this.name = name;
    this.description = description;
    this.duration = duration;
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
   * Return a unique, synthetic key for the Routine.
   *
   * @param id A unique, synthetic key to the Routine.
   */
  public void setId(long id) {
    this.id = id;
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
   * Set the materials used for this routine.
   *
   * @param materials The materials used for this routine.
   */
  public void setMaterials(List<Material> materials) {
    this.materials = materials;
  }

  /**
   * Set a URL of the review of this routine.
   *
   * @param reviewUrl A URL of the review of this routine.
   */
  public void setReviewUrl(String reviewUrl) {
    this.reviewUrl = reviewUrl;
  }

  /**
   * Get a URL of a review for this routine.
   *
   * @return A URL of the review for this routine.
   */
  public String getReviewUrl() {
    return reviewUrl;
  }

  /**
   * Get the choices field for the routine.
   *
   * @return The choices field for the routine.
   */
  public String getChoices() {
    return choices;
  }

  /**
   * Set the choices field for the routine.
   *
   * @param choices The choices field for the routine.
   */
  public void setChoices(String choices) {
    this.choices = choices;
  }

  /**
   * Get the inspiration field for the routine.
   *
   * @return The inspiration field for the routine.
   */
  public String getInspiration() {
    return inspiration;
  }

  /**
   * Set the inspiration field for the routine.
   *
   * @param inspiration the inspiration field for the routine.
   */
  public void setInspiration(String inspiration) {
    this.inspiration = inspiration;
  }

  /**
   * Get the placement field for the routine.
   *
   * @return The placement field for the routine.
   */
  public String getPlacement() {
    return placement;
  }

  /**
   * Set the placement field for the routine.
   *
   * @param placement The placement field for the routine.
   */
  public void setPlacement(String placement) {
    this.placement = placement;
  }
}
