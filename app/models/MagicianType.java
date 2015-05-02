package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Model for handling the different types of Magicians (Novice, Expert, Professional, etc.).
 */
@Entity
public class MagicianType extends play.db.ebean.Model {
  @Id
  private long id;
  private String name;
  private String description;
  private int displayOrder;
  @OneToMany(mappedBy = "magicianType", cascade = CascadeType.PERSIST)
  private List<Magician> magicians;

  /**
   * Create a new MagicianType with all of the required fields.
   *
   * @param name         The name of this magician type.
   * @param description  A brief description of this magician type.
   * @param displayOrder When all of the magician types are selected back, where would this be?
   */
  public MagicianType(String name, String description, int displayOrder) {
    this.name = name;
    this.description = description;
    this.displayOrder = displayOrder;
    this.magicians = new ArrayList<Magician>();
  }

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, MagicianType> find() {
    return new Finder<Long, MagicianType>(Long.class, MagicianType.class);
  }

  /**
   * Get a MagicianType from the database.
   *
   * @param magicianTypeName The name of the MagicianType to get.
   * @return A MagicianType object from the database.
   */
  public static MagicianType getMagicianType(String magicianTypeName) {
    MagicianType magicianType = MagicianType.find().where().eq("name", magicianTypeName).findUnique();

    if (magicianType == null) {
      throw new RuntimeException("Can't find Magician Type = [" + magicianTypeName + "] in the database");
    }

    return magicianType;
  }


  /**
   * Add a Magician Type to the database.
   *
   * @param magicianType The magician type to add.
   * @return The MagicianType object that was just added.
   */
  protected static MagicianType init(MagicianType magicianType) {
    MagicianType foundMagicianType = MagicianType.find().where().eq("name", magicianType.getName()).findUnique();

    if (foundMagicianType == null) {
      magicianType.save();
    }

    return magicianType;
  }


  /**
   * Initialize the MagicianType dataset.
   */
  public static void init() {
    init(new MagicianType("Neophyte",
        "A newcomer to magic.", 1));
    init(new MagicianType("Enthusiast",
        "Likes magic, does a few tricks.", 2));
    init(new MagicianType("Hobbyist",
        "Studies magic.  Participates in a club.  Attends lectures.", 3));
    init(new MagicianType("Semi-Professional",
        "Gets paid gigs.  Has at least 1 full set of A-material", 4));
    init(new MagicianType("Professional",
        "Makes a living at magic.", 5));
    init(new MagicianType("Historian",
        "Someone who studies the history and lore of magic, but does not perform as much.", 6));
    init(new MagicianType("Collector",
        "Someone who collects props, gaffs or other items related to magic.", 7));
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
