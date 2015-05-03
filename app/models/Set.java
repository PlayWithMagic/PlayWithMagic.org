package models;

import controllers.Secured;
import views.formdata.SetFormData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;
import play.mvc.Http.Context;

/**
 * A Set consists of an ordered lists of Routines.
 *
 * @see https://github.com/PlayWithMagic/PlayWithMagic/issues/101
 */
@Entity
public class Set extends play.db.ebean.Model {

  @Id
  private long id;

  @Column(nullable = false)
  @ManyToOne
  private Magician magician;

  @Column(nullable = false, length = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH)
  private String name;

  @Column(nullable = false, length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH)
  private String description;

  @ManyToMany()
  private List<Routine> routines;


  /**
   * Create a Set object.
   *
   * @param magician    The Magician who created this Set.
   * @param name        The name of the Set.
   * @param description The description of the Set.
   * @param routines    The List of Long IDs of the routines in the set.
   */
  public Set(Magician magician, String name, String description, List<Routine> routines) {
    this.magician = magician;
    this.name = name;
    this.description = description;
    this.routines = routines;
  }


  /******************************************************************************************************************
   * G E T T E R S   &   S E T T E R S
   ******************************************************************************************************************/

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
   * Get the Magician who created this set.
   *
   * @return The Magician who created this set.
   */
  public Magician getMagician() {
    return magician;
  }

  /**
   * Set the Magician who created this set.
   *
   * @param magician The Magician who created this set.
   */
  public void setMagician(Magician magician) {
    this.magician = magician;
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
   * Get the List of Routines in the set.
   *
   * @return The List of Routines.
   */
  public List<Routine> getRoutines() {
    return routines;
  }

  /**
   * Set the List of Routines in the set.
   *
   * @param routines The list of Routines.
   */
  public void setRoutines(List<Routine> routines) {
    this.routines = routines;
  }


  /******************************************************************************************************************
   * M E T H O D S
   ******************************************************************************************************************/

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, Set> find() {
    return new Finder<Long, Set>(Long.class, Set.class);
  }


  /**
   * Get all of the sets in the database.
   *
   * @return All of the sets in the database.
   */
  public static List<Set> getAllSets() {
    return Set.find().all();
  }


  /**
   * Get the current Magician's Sets.
   *
   * @return The current Magician's Sets.
   */
  public static List<Set> getMySets(Context context) {
    Magician magician = Secured.getUserInfo(context);
    //TODO: Once we get things working, we need to get a function like below working...
    //return Set.find().where().eq("magician", magician);
    return Set.find().all();
  }


  /**
   * Retrieve a Set associated with a given id from the database.
   *
   * @param id The ID of the Set to retrieve.
   * @return The retrieved Set object.
   */
  public static Set getSet(long id) {
    Set set = Set.find().byId(id);
    if (set == null) {
      throw new RuntimeException("Unable to find Set with ID [" + id + "]");
    }

    return set;
  }


  /**
   * Create/save a new Set from SetFormData.
   *
   * TODO: Rename SetFormData to EditSetFormData.
   * @param setFormData Input data from the submitted form.
   */
  public static void createSetFromForm(Context context, SetFormData setFormData) {
    Magician magician = Secured.getUserInfo(context);
    Set set;

    if (setFormData.id == 0) {
      set = new Set(magician, setFormData.name, setFormData.description, setFormData.routines);
    }
    else {
      // TODO: Right now anybody can modify someone else's set
      set = Set.find().byId(setFormData.id);
      set.setName(setFormData.name);
      set.setDescription(setFormData.description);
      set.setRoutines(setFormData.routines);
    }
    set.save();
  }


  /**
   * Remove a Routine from this Set.
   *
   * @param routine The Routine to remove.
   * @throws RuntimeException If the routine is not currently in the Set.
   */
  public void removeRoutine(Routine routine) {
    if (!routines.contains(routine)) {
      throw new RuntimeException("Attempt to remove routine [" + routine.getName() + "] from a set... but the "
          + "routine was not in the set");
      // If this exception becomes a pain, then remove it and ignore the condition.
    }

    routines.remove(routine);
    this.save();
  }


  /**
   * Add a Routine to this Set.
   *
   * @param routine The Routine to add.
   * @throws RuntimeException If the routine is already in the Set.
   */
  public void addRoutine(Routine routine) {
    if (routines.contains(routine)) {
      throw new RuntimeException("Attempt to add a routine [" + routine.getName() + "] to a set... but the "
          + "routine is already in the set");
      // If this exception becomes a pain, then remove it and ignore the condition.
    }

    routines.add(routine);
    this.save();
  }
}
