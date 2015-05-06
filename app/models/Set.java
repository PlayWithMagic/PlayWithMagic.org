package models;

import controllers.Secured;
import play.Logger;
import views.formdata.SetFormData;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;
import play.mvc.Http.Context;

/**
 * A Set consists of an ordered lists of Routines.
 *
 * The synthetic unique constraint on this model is id.
 * The logical unique constraint on this model is magician + name.
 *
 * Sets are 'owned' by Magicians.
 *
 * @see https://github.com/PlayWithMagic/PlayWithMagic/issues/101
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"magician_id", "name"}))
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

  @ManyToMany(cascade = CascadeType.REMOVE)
  private List<Routine> routines;


  /**
   * Create a valid Set object.
   *
   * The constructor includes only the Set's required fields.  Use setters to set the non-required
   * fields (if any).  The idea is that an object (A Set) is always in a valid state.
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
   * Get all of the Sets in the database.
   *
   * @return All of the Sets in the database.
   */
  public static List<Set> getAllSets() {
    return Set.find().all();
  }


  /**
   * Get the current Magician's Sets.
   *
   * @return The current Magician's Sets.
   */
  public static List<Set> getMySets() {
    Context context = Context.current();
    Magician magician = Secured.getUserInfo(context);

    return Set.find().where().eq("magician_id", magician.getId()).findList();
  }


  /**
   * Retrieve a Set associated with a given id from the database.
   *
   * @param id The ID of the Set to retrieve.
   * @return The retrieved Set object.
   * @throws RuntimeException if the ID can't be found.
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
   * @param magician The magician who owns this set.
   * @param setFormData Input data from the submitted form.
   * @return The set that was just saved.
   */
  public static Set createSetFromForm(Magician magician, SetFormData setFormData) {
    Set set;

    if (setFormData.id == 0) {
      set = new Set(magician, setFormData.name, setFormData.description, Routine.getRoutines(setFormData.routines));
    }
    else {
      // TO-DO: Right now anybody can modify someone else's set
      set = Set.find().byId(setFormData.id);
      set.setName(setFormData.name);
      set.setDescription(setFormData.description);
      set.setRoutines(Routine.getRoutines(setFormData.routines));
    }

    set.save();
    set = Set.getSet(set.id);

    Logger.debug(((setFormData.id == 0) ? "Add" : "Update") + " set.  id = [" + set.getId() + "]"
        + "  name = [" + set.getName() + "]");

    return set;
  }


  /**
   * Delete a Set.
   *
   * @param id The ID of the set to delete.
   */
  public static void deleteSet(long id) {
    Set set = Set.getSet(id);
    set.delete();
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


  /**
   * Initialize the Set database.
   *
   * @param magician The Magician who will own these sets.
   */
  public static void init(Magician magician) {

    Set set = null;
    SetFormData setFormData = null;

    setFormData = new SetFormData();
    setFormData.id = 0;
    setFormData.magicianId = magician.getId();
    setFormData.name = "My Amazing Set";
    setFormData.description = "This is the best set ever. It opens with the Ambitious Card trick"
        + " to warm up the audience. From there, it shifts to something different with Gypsy Thread. "
        + "And in the closer, it breaks back down to a card trick to cool down the audience afterwords.";
    setFormData.routines = new ArrayList<Long>();
    setFormData.routines.add(Routine.getRoutine("Ambitious Card").getId());
    setFormData.routines.add(Routine.getRoutine("Gypsy Thread").getId());
    setFormData.routines.add(Routine.getRoutine("Two Card Monte").getId());
    if (Set.find().where().eq("magician_id", magician.getId()).eq("name", setFormData.name).findList().size() == 0) {
      Set.createSetFromForm(magician, setFormData);
    }

    setFormData = new SetFormData();
    setFormData.id = 0;
    setFormData.magicianId = magician.getId();
    setFormData.name = "With Flare";
    setFormData.description = "This starts off with a match routine for something that has a bit "
        + "of an explosive opener, followed by a simple card trick.  Finally, you light up the night with a flaming "
        + "wallet routine, which binds the card trick and the fire trick together.";
    setFormData.routines = new ArrayList<Long>();
    setFormData.routines.add(Routine.getRoutine("Twice Burned").getId());
    setFormData.routines.add(Routine.getRoutine("Phantom").getId());
    setFormData.routines.add(Routine.getRoutine("Lucifer's Wallet").getId());
    if (Set.find().where().eq("magician_id", magician.getId()).eq("name", setFormData.name).findList().size() == 0) {
      Set.createSetFromForm(magician, setFormData);
    }

    setFormData = new SetFormData();
    setFormData.id = 0;
    setFormData.magicianId = magician.getId();
    setFormData.name = "Mechanisms";
    setFormData.description = "With each of the routines in this set, it involves some physical device"
        + " that the audience can either interact with, or view interaction with.  The key is to really liven up "
        + "Zig-Zag-Pencil with your own bit of flare, otherwise it will pale against the other routines in this Set. "
        + "Next, a simple card trick that allows the audience member to interact with their cell phone!  Always good "
        + "to have more audience interaction.  Finally, the close is something that goes back to the engineer theme "
        + "of the opener with a twist! "
        + "Once you've closed, the audience member will walk away with a photo memory on their phone.";
    setFormData.routines = new ArrayList<Long>();
    setFormData.routines.add(Routine.getRoutine("Zig-Zag-Pencil").getId());
    setFormData.routines.add(Routine.getRoutine("Triumph and Triumph Again").getId());
    setFormData.routines.add(Routine.getRoutine("Ambitious Card").getId());
    if (Set.find().where().eq("magician_id", magician.getId()).eq("name", setFormData.name).findList().size() == 0) {
      Set.createSetFromForm(magician, setFormData);
    }

  }

}