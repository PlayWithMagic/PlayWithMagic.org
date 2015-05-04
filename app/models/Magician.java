package models;

import org.mindrot.jbcrypt.BCrypt;
import views.formdata.EditMagicianFormData;
import views.formdata.EditUserFormData;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.File;
import java.util.List;

/**
 * A Magician object that holds the information about a user of the Play With Magic site.
 * Essentially the user data.
 *
 * The synthetic unique constraint on this model is id.
 * The logical unique constraint on this model is email.
 *
 * TODO: Be sure to drop the first_name, last_name unique constraint
 *
 * @see https://github.com/PlayWithMagic/PlayWithMagic/issues/32
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"first_name", "last_name"}))
public class Magician extends play.db.ebean.Model {
  @Id
  private long id;
  // Magician Information
  @Column(nullable = false, length = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH) private String firstName;
  @Column(nullable = false, length = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH) private String lastName;
  @Column(unique = true, nullable = false, length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String email;
  @Column(nullable = false, length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String password;
  @Column(nullable = false)
  @ManyToOne
  private MagicianType magicianType;

  @OneToMany(mappedBy = "magician", cascade = CascadeType.PERSIST)
  private List<Set> sets;

  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String stageName;
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String location;  // City/State? Country? Perhaps a map.
  private File userPhoto;

  // Magician Info
  @Column(length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH) private String biography;
  @Column(length = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH) private String interests;
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String influences;

  private Integer yearStarted;  // The year started - used to compute the number of years of experience.
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String organizations;
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String website;

  // Social Media
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String facebook;
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String twitter;
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String linkedIn;
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String googlePlus;
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String flickr;
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String instagram;

  // Magician Image
  private long imageId;

  /**
   * Create a magician with only the required fields.
   *
   * @param firstName       The magician's first name.
   * @param lastName        The magician's last name.
   * @param email           The magician's eMail address.
   * @param magicianType    The type of magician the user identifies with.
   * @param password        The magician's password.
   */
  public Magician(String firstName, String lastName, String email, MagicianType magicianType, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.magicianType = magicianType;
    this.password = password;
  }


  /******************************************************************************************************************
   * G E T T E R S   &   S E T T E R S
   ******************************************************************************************************************/

  /**
   * Get the ID of the magician.
   *
   * @return The ID.
   */
  public long getId() {
    return id;
  }

  /**
   * Set the ID of the magician.
   *
   * @param id The ID of the magician.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Get the first name of the magician.
   *
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the first name of the magician.
   *
   * @param firstName The magician's first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Get the last name of the magician.
   *
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the magician's last name.
   *
   * @param lastName The magician's last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Get the magician's encrypted password.
   *
   * @return The magician's password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the magician's encrypted password.
   *
   * @param password The magician's password.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get the stage name of the magician.
   *
   * @return The stage name.
   */
  public String getStageName() {
    return stageName;
  }

  /**
   * Set the magician's stage name.
   *
   * @param stageName The magician's stage name.
   */
  public void setStageName(String stageName) {
    this.stageName = stageName;
  }

  /**
   * Get the location of the magician.
   *
   * @return The location.
   */
  public String getLocation() {
    return location;
  }

  /**
   * Set the magician's location.
   *
   * @param location The magician's location.
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * Get the magician photo file object.
   *
   * @return The magician photo file object.
   */
  public File getUserPhoto() {
    return userPhoto;
  }

  /**
   * Set the magician's photo.
   *
   * @param userPhoto A file containing the image of the magician.
   */
  public void setUserPhoto(File userPhoto) {
    this.userPhoto = userPhoto;
  }

  /**
   * Get the biography of the magician.
   *
   * @return The biography.
   */
  public String getBiography() {
    return biography;
  }

  /**
   * St the magician's biography.
   *
   * @param biography The magician's biography.
   */
  public void setBiography(String biography) {
    this.biography = biography;
  }

  /**
   * Get the interests of the magician.
   *
   * @return The interests.
   */
  public String getInterests() {
    return interests;
  }

  /**
   * Set the magician's interests.
   *
   * @param interests The magician's interests.
   */
  public void setInterests(String interests) {
    this.interests = interests;
  }

  /**
   * Get the influences of the magician.
   *
   * @return The influences.
   */
  public String getInfluences() {
    return influences;
  }

  /**
   * Set the magician's influences.
   *
   * @param influences The magician's influences.
   */
  public void setInfluences(String influences) {
    this.influences = influences;
  }

  /**
   * Get the number of years the magician has been practicing.
   *
   * @return The number of years of practice.
   */
  public Integer getYearStarted() {
    return yearStarted;
  }

  /**
   * Set the year the magician started practicing magic.
   *
   * @param yearStarted The year the magician started practcing magic.
   */
  public void setYearStarted(Integer yearStarted) {
    this.yearStarted = yearStarted;
  }

  /**
   * Get the magician's affiliated organizations.
   *
   * @return The organizations.
   */
  public String getOrganizations() {
    return organizations;
  }

  /**
   * Set the organizations the magician is affiliated with.
   *
   * @param organizations The magician's organizations.
   */
  public void setOrganizations(String organizations) {
    this.organizations = organizations;
  }

  /**
   * Get the magician's website.
   *
   * @return The website.
   */
  public String getWebsite() {
    return website;
  }

  /**
   * Set the magician's website.
   *
   * @param website The magician's website.
   */
  public void setWebsite(String website) {
    this.website = website;
  }

  /**
   * Get the magician's email address.
   *
   * @return The email address.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the magician's eMail address.
   *
   * @param email The magician's eMail address.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get the magician's Facebook page link.
   *
   * @return The Facebook page link.
   */
  public String getFacebook() {
    return facebook;
  }

  /**
   * Set the magician's Facebook page link.
   *
   * @param facebook The magician's Facebook page link.
   */
  public void setFacebook(String facebook) {
    this.facebook = facebook;
  }

  /**
   * Get the magician's Twitter page link.
   *
   * @return The Twitter page link.
   */
  public String getTwitter() {
    return twitter;
  }

  /**
   * Set the magician's Twitter page link.
   *
   * @param twitter The magician's Twitter page link.
   */
  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }

  /**
   * Get the magician's LinkedIn link.
   *
   * @return The LinkedIn link.
   */
  public String getLinkedIn() {
    return linkedIn;
  }

  /**
   * Set the magician's LinkedIn profile link.
   *
   * @param linkedIn The magician's LinkedIn profile link.
   */
  public void setLinkedIn(String linkedIn) {
    this.linkedIn = linkedIn;
  }

  /**
   * Get the magician's Google Plus link.
   *
   * @return The Google Plus link.
   */
  public String getGooglePlus() {
    return googlePlus;
  }

  /**
   * Set the magician's Google Plus link.
   *
   * @param googlePlus The magician's Google Plus link.
   */
  public void setGooglePlus(String googlePlus) {
    this.googlePlus = googlePlus;
  }

  /**
   * Get the magician's flickr account link.
   *
   * @return The flickr account link.
   */
  public String getFlickr() {
    return flickr;
  }

  /**
   * Set the magician's Flickr account link.
   *
   * @param flickr The Flickr account link.
   */
  public void setFlickr(String flickr) {
    this.flickr = flickr;
  }

  /**
   * Get the magician's Instagram account link.
   *
   * @return The Instagram account.
   */
  public String getInstagram() {
    return instagram;
  }

  /**
   * Set the magician's Instagram account link.
   *
   * @param instagram The Instagram account.
   */
  public void setInstagram(String instagram) {
    this.instagram = instagram;
  }

  /**
   * Get the MagicianType object.
   *
   * @return The MagicianType object.
   */
  public MagicianType getMagicianType() {
    return magicianType;
  }

  /**
   * Set the MagicianType object.
   *
   * @param magicianType The MagicianType object.
   */
  public void setMagicianType(MagicianType magicianType) {
    this.magicianType = magicianType;
  }

  /**
   * Gets the image id.
   * @return The image id.
   */
  public long getImageId() {
    return imageId;
  }

  /**
   * Sets the image id.
   * @param imageId The image id.
   */
  public void setImageId(long imageId) {
    this.imageId = imageId;
  }


  /******************************************************************************************************************
   * M E T H O D S
   ******************************************************************************************************************/

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, Magician> find() {
    return new Finder<Long, Magician>(Long.class, Magician.class);
  }


  /**
   * Get all of the active Magicians.
   * <p>
   * TODO:  Add where status=active and create a getAllMagicians -- use only in Admin pages.
   *
   * @return The all active Magicians.
   */
  public static List<Magician> getActiveMagicians() {
    return Magician.find().all();
  }


  /**
   * Get all of the Magicians.
   * <p>
   * TODO:  Add where status=active and create a getAllMagicians -- use only in Admin pages.
   *
   * @return The all active Magicians.
   */
  public static List<Magician> getAllMagicians() {
    return Magician.find().all();
  }


  /**
   * Get a Magician associated with a given id.
   *
   * @param id The ID of the magician to retrieve.
   * @return The retrieved magician object.
   * @throws RuntimeException if the ID can't be found.
   */
  public static Magician getMagician(long id) {
    Magician magician = Magician.find().byId(id);
    if (magician == null) {
      throw new RuntimeException("Unable to find Magician with the given ID [" + id + "]");
    }
    return magician;
  }


  /**
   * Get a Magician associated with a given email.
   *
   * @param email The ID of the magician to retrieve.
   * @return The retrieved magician object.
   */
  public static Magician getMagician(String email) {
    Magician magician = Magician.find().where().eq("email", email).findUnique();
    if (magician == null) {
      throw new RuntimeException("Unable to find Magician with the given email [" + email + "]");
    }
    return magician;
  }


  /**
   * Delete a Magician associated with a given id.
   * <p>
   * TO-DO:  Set the status=inactive instead of deleting the magician.  Rename method to deactivate Magician.
   * Create an activate Magician method.
   *
   * @param id The ID of the magician to delete.
   */
  public static void deleteMagician(long id) {
    Magician magician = getMagician(id);

    magician.delete();
  }


  /**
   * Check if an email address is associated with an existing Magician.
   *
   * @param email The email address to check against in the DB
   * @return True if found, otherwise false.
   */
  public static boolean isExistingMagician(String email) {
    int count = Magician.find().where().eq("email", email).findRowCount();
    return count >= 1;
  }


  /**
   * Check if a Magician's credentials are valid.
   *
   * @param email The email address of the Magician.
   * @param password The password of the Magician to check.
   * @return True if Magician exists and Password matches hashed password, otherwise false.
   */
  public static boolean isValidMagician(String email, String password) {
    return ((email != null)
        && (password != null)
        && isExistingMagician(email)
        && BCrypt.checkpw(password, getMagician(email).getPassword()));
  }


  /**
   * Update an existing Magician object from EditMagicianFormData.  Update the database and return the current
   * Magician.
   *
   * @param editMagicianFormData The source of data for the Magician.
   * @return A fully populated Magician object that's just been persisted in the database.
   */
  public static Magician createMagicianFromForm(EditMagicianFormData editMagicianFormData) {
    MagicianType magicianType = MagicianType.getMagicianType(editMagicianFormData.magicianType);

    Magician magician = Magician.find().byId(editMagicianFormData.id);
    if (magician == null) {
      magician = Magician.find().where().eq("email", editMagicianFormData.email).findUnique();
    }

    magician.setFirstName(editMagicianFormData.firstName);
    magician.setLastName(editMagicianFormData.lastName);
    magician.setEmail(editMagicianFormData.email);
    magician.setMagicianType(magicianType);

    magician.setStageName(editMagicianFormData.stageName);
    magician.setLocation(editMagicianFormData.location);
    // User photo
    magician.setBiography(editMagicianFormData.biography);
    magician.setInterests(editMagicianFormData.interests);
    magician.setInfluences(editMagicianFormData.influences);
    magician.setYearStarted(editMagicianFormData.yearStarted);
    magician.setOrganizations(editMagicianFormData.organizations);
    magician.setWebsite(editMagicianFormData.website);
    magician.setFacebook(editMagicianFormData.facebook);
    magician.setTwitter(editMagicianFormData.twitter);
    magician.setLinkedIn(editMagicianFormData.linkedIn);
    magician.setGooglePlus(editMagicianFormData.googlePlus);
    magician.setInstagram(editMagicianFormData.instagram);
    magician.setFlickr(editMagicianFormData.flickr);

    magician.save();
    return magician;
  }

// TODO:  Need a mechanism to prevent a user from deleting their own account (or if they do, then log them out first).

  /**
   * Create a new Magician object from EditUserFormData.  Add it to the database and return the newly created
   * Magician.
   *
   * @param editUserFormData The source of data for the Magician.
   * @return A fully populated Magician object that's just been persisted in the database.
   */
  public static Magician createMagicianFromForm(EditUserFormData editUserFormData) {
    Magician magician = null;
    MagicianType magicianType = MagicianType.getMagicianType(editUserFormData.magicianType);

    if (editUserFormData.id == 0) {
      magician = new Magician(
          editUserFormData.firstName
          , editUserFormData.lastName
          , editUserFormData.email
          , magicianType
          , BCrypt.hashpw(editUserFormData.password, BCrypt.gensalt(12)));
    }
    else {
      magician = Magician.find().byId(editUserFormData.id);
      magician.setFirstName(editUserFormData.firstName);
      magician.setLastName(editUserFormData.lastName);
      magician.setEmail(editUserFormData.email);
      magician.setMagicianType(magicianType);
      magician.setPassword(BCrypt.hashpw(editUserFormData.password, BCrypt.gensalt(12)));
    }

    magician.save();
    return magician;
  }


  /**
   * Initialize the Magician dataset.
   */
  public static void init() {
    Magician magician = null;
    EditUserFormData editUserFormData = null;

    // Add Mark
    magician = Magician.find().where().eq("email", "mr_nelson@icloud.com").findUnique();
    if (magician == null) {
      editUserFormData = new EditUserFormData();
      editUserFormData.id = 0;
      editUserFormData.firstName = "Mark";
      editUserFormData.lastName = "Nelson";
      editUserFormData.magicianType = "Semi-Professional";
      editUserFormData.email = "mr_nelson@icloud.com";
      editUserFormData.password = "P@ssw0rd";
      Magician.createMagicianFromForm(editUserFormData);

      EditMagicianFormData editMagicianFormData = new EditMagicianFormData();
      editMagicianFormData.firstName = "Mark";
      editMagicianFormData.lastName = "Nelson";
      editMagicianFormData.magicianType = "Semi-Professional";
      editMagicianFormData.email = "mr_nelson@icloud.com";
      editMagicianFormData.location = "Honolulu, HI";
      // No photo
      editMagicianFormData.biography = "I got started in magic in 2004.  A retired magician, JC Dunn, showed me a "
          + "2-card monte and I was hooked.  Since then, I've learned the craft, performed hundreds of shows in "
          + "Honolulu and most recently I nailed a parlor act in Beijing.";
      editMagicianFormData.interests = "I'm most comfortable with close-up magic, but I'd like to develop a stage "
          + "show.  I strive to be fluent in all mediums of the art (cards, coins, rope, etc.).";
      editMagicianFormData.influences = "Tony Slydini, David Regal, Lee Asher, Aaron Fisher, my brother Steve Johnson "
          + "and many, many others.";
      editMagicianFormData.yearStarted = 2004;
      editMagicianFormData.organizations = "";
      editMagicianFormData.website = "http://mark.nelson.engineer/wordpress/index.php/magic-home-page/";
      editMagicianFormData.facebook = "mark.nelson.engineer";
      editMagicianFormData.twitter = "@mr_marknelson";
      editMagicianFormData.linkedIn = "http://www.linkedin.com/in/marknelsonengineer/en";
      editMagicianFormData.googlePlus = "mr_nelson@icloud.com";
      editMagicianFormData.instagram = "mr_mark_nelson";
      Magician.createMagicianFromForm(editMagicianFormData);
    }

    // Add Patrick
    magician = Magician.find().where().eq("email", "pkarjala@gmail.com").findUnique();
    if (magician == null) {
      editUserFormData = new EditUserFormData();
      editUserFormData.id = 0;
      editUserFormData.firstName = "Patrick";
      editUserFormData.lastName = "Karjala";
      editUserFormData.magicianType = "Enthusiast";
      editUserFormData.email = "pkarjala@gmail.com";
      editUserFormData.password = "P@ssw0rd";
      Magician.createMagicianFromForm(editUserFormData);
    }

    // Add David
    magician = Magician.find().where().eq("email", "dneely@hawaii.edu").findUnique();
    if (magician == null) {
      editUserFormData = new EditUserFormData();
      editUserFormData.id = 0;
      editUserFormData.firstName = "David";
      editUserFormData.lastName = "Neely";
      editUserFormData.magicianType = "Enthusiast";
      editUserFormData.email = "dneely@hawaii.edu";
      editUserFormData.password = "P@ssw0rd";
      Magician.createMagicianFromForm(editUserFormData);
    }

    // Add Lee
    magician = Magician.find().where().eq("email", "lee@leeasher.com").findUnique();
    if (magician == null) {
      editUserFormData = new EditUserFormData();
      editUserFormData.id = 0;
      editUserFormData.firstName = "Lee";
      editUserFormData.lastName = "Asher";
      editUserFormData.magicianType = "Professional";
      editUserFormData.email = "lee@leeasher.com";
      editUserFormData.password = "P@ssw0rd";
      Magician.createMagicianFromForm(editUserFormData);
    }

    // Add Steve
    magician = Magician.find().where().eq("email", "steve@grandillusions.com").findUnique();
    if (magician == null) {
      editUserFormData = new EditUserFormData();
      editUserFormData.id = 0;
      editUserFormData.firstName = "Steve";
      editUserFormData.lastName = "Johnson";
      editUserFormData.magicianType = "Professional";
      editUserFormData.email = "steve@grandillusions.com";
      editUserFormData.password = "P@ssw0rd";
      Magician.createMagicianFromForm(editUserFormData);
    }

    // Add Wayne
    magician = Magician.find().where().eq("email", "wayne@waynehouchin.com").findUnique();
    if (magician == null) {
      editUserFormData = new EditUserFormData();
      editUserFormData.id = 0;
      editUserFormData.firstName = "Wayne";
      editUserFormData.lastName = "Houchin";
      editUserFormData.magicianType = "Professional";
      editUserFormData.email = "wayne@waynehouchin.com";
      editUserFormData.password = "P@ssw0rd";
      Magician.createMagicianFromForm(editUserFormData);
    }
  }

}
