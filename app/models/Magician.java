package models;

import views.formdata.EditMagicianFormData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
  @Column(nullable = false)
  @ManyToOne
  private MagicianType magicianType;

  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String stageName;
  @Column(length = GlobalDbInfo.MAX_LONG_TEXT_LENGTH) private String location;  // City/State? Country? Perhaps a map.
  private File userPhoto;

  // Magic Info
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


  /**
   * Create a new Magician object.
   *
   * @param id              The unique ID.
   * @param firstName       The first name of the user.
   * @param lastName        The last name of the magician.
   * @param stageName       The stage name of the magician.
   * @param location        Global location.
   * @param userPhoto       Photograph file of user.
   * @param biography       Biography of user.
   * @param interests       User's interests in magic.
   * @param influences      User's influences.
   * @param magicianType    The type of magician the user identifies with.
   * @param yearStarted     The year started - used to compute the number of years of experience.
   * @param organizations   Any affiliations or organizations the user is a member of.
   * @param website         User's personal website.
   * @param email           User's email address.
   * @param facebook        The user's facebook account.
   * @param twitter         User's Twitter account.
   * @param linkedIn        User's LinkedIn account.
   * @param googlePlus      User's Google Plus account.
   * @param flickr          User's flickr account.
   * @param instagram       User's instagram account.
   */
  public Magician(long id, String firstName, String lastName, String stageName, String location, File userPhoto,
                  String biography, String interests, String influences,
                  MagicianType magicianType, Integer yearStarted,
                  String organizations, String website, String email, String facebook, String twitter, String linkedIn,
                  String googlePlus, String flickr, String instagram) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.stageName = stageName;
    this.location = location;
    this.userPhoto = userPhoto;
    this.biography = biography;
    this.interests = interests;
    this.influences = influences;
    this.magicianType = magicianType;
    this.yearStarted = yearStarted;
    this.organizations = organizations;
    this.website = website;
    this.email = email;
    this.facebook = facebook;
    this.twitter = twitter;
    this.linkedIn = linkedIn;
    this.googlePlus = googlePlus;
    this.flickr = flickr;
    this.instagram = instagram;
  }


  /**
   * Create a magician with only the required fields.
   *
   * @param firstName       The magician's first name.
   * @param lastName        The magician's last name.
   * @param email           The magician's eMail address.
   * @param magicianType    The type of magician the user identifies with.
   */
  public Magician(String firstName, String lastName, String email, MagicianType magicianType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.magicianType = magicianType;
  }

// TODO:  Look into deleting one of these
  /**
   * Create a new Magician object for testing purposes only.
   *
   * @param firstName       The first name of the user.
   * @param lastName        The last name of the magician.
   * @param stageName       The stage name of the magician.
   * @param location        Global location.
   * @param userPhoto       Photograph file of user.
   * @param biography       Biography of user.
   * @param interests       User's interests in magic.
   * @param influences      User's invluences.
   * @param magicianType    The type of magician the user identifies with.
   * @param yearStarted     The year started - used to compute the number of years of experience.
   * @param organizations   Any affiliations or organizations the user is a member of.
   * @param website         User's personal website.
   * @param email           User's email address.
   * @param facebook        The user's facebook account.
   * @param twitter         User's Twitter account.
   * @param linkedIn        User's LinkedIn account.
   * @param googlePlus      User's Google Plus account.
   * @param flickr          User's flickr account.
   * @param instagram       User's instagram account.
   */
  public Magician(String firstName, String lastName, String stageName, String location, File userPhoto,
                  String biography, String interests, String influences,
                  MagicianType magicianType, int yearStarted,
                  String organizations, String website, String email, String facebook, String twitter, String linkedIn,
                  String googlePlus, String flickr, String instagram) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.stageName = stageName;
    this.location = location;
    this.userPhoto = userPhoto;
    this.biography = biography;
    this.interests = interests;
    this.influences = influences;
    this.magicianType = magicianType;
    this.yearStarted = yearStarted;
    this.organizations = organizations;
    this.website = website;
    this.email = email;
    this.facebook = facebook;
    this.twitter = twitter;
    this.linkedIn = linkedIn;
    this.googlePlus = googlePlus;
    this.flickr = flickr;
    this.instagram = instagram;
  }


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
   * TO-DO:  Add where status=active and create a getAllMagicians -- use only in Admin pages.
   *
   * @return The all active Magicians.
   */
  public static List<Magician> getActiveMagicians() {
    return Magician.find().all();
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
   * Get a Magician associated with a given id.
   *
   * @param id The ID of the magician to retrieve.
   * @return The retrieved magician object.
   */
  public static Magician getMagician(long id) {
    Magician magician = Magician.find().byId(id);
    if (magician == null) {
      throw new RuntimeException("Unable to find Magician with the given ID [" + id + "]");
    }
    return magician;
  }


  /**
   * Create a new Magician object from EditMagicianFormData.  Add it to the database and return the newly created
   * Magician.
   *
   * @param editMagicianFormData The source of data for the Magician.
   * @return A fully populated Magician object that's just been persisted in the database.
   */
  public static Magician createMagicianFromForm(EditMagicianFormData editMagicianFormData) {
    Magician magician = null;
    MagicianType magicianType = MagicianType.getMagicianType(editMagicianFormData.magicianType);

    if (editMagicianFormData.id == 0) {
      magician = new Magician(
          editMagicianFormData.firstName
          , editMagicianFormData.lastName
          , editMagicianFormData.email
          , magicianType);
    }
    else {
      magician = Magician.find().byId(editMagicianFormData.id);
      magician.setFirstName(editMagicianFormData.firstName);
      magician.setLastName(editMagicianFormData.lastName);
      magician.setEmail(editMagicianFormData.email);
      magician.setMagicianType(magicianType);
    }

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



  public Magician init(Magician magician) {
return null;
  }

// TODO:  Add eMails and use init(magician) function.
  /**
   * Initialize the Magician database.
   */
  public static void init() {
    // resetMagicianDB();

    MagicianType magicianTypeSemiProfessional = MagicianType.getMagicianType("Semi-Professional");
    MagicianType magicianTypeProfessional = MagicianType.getMagicianType("Professional");

    // --------------------------------------

    Magician magician = null;

    magician = new Magician(
        "Mark",
        "Nelson",
        "Mark Nelson",
        "Honolulu, HI",
        null,
        "I got started in magic in 2004.  A retired magician, JC Dunn, showed me a 2-card monte and I was hooked. "
            + "Since then, I've learned the craft, performed hundreds of shows in Honolulu and most recently I nailed "
            + "a parlor act in Beijing.",
        "I'm most comfortable with close-up magic, but I'd like to develop a stage show.  I strive to be fluent in "
            + "all mediums of the art (cards, coins, rope, etc.).",
        "Tony Slydini, David Regal, Lee Asher, Aaron Fisher, my brother Steve Johnson and many, many others.",
        magicianTypeSemiProfessional,
        2004,
        null,
        "http://mark.nelson.engineer/wordpress/index.php/magic-home-page/",
        "mr_nelson@icloud.com",
        "mark.nelson.engineer",
        "@mr_marknelson",
        "http://www.linkedin.com/in/marknelsonengineer/en",
        "mr_nelson@icloud.com",
        null,
        "mr_mark_nelson"
    );

    Magician.createMagicianFromForm(new EditMagicianFormData(magician));

    magician = new Magician(
        "Lee",
        "Asher",
        "Lee Asher",
        null,
        null,
        null,
        null,
        null,
        magicianTypeProfessional,
        0,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    );

    Magician.createMagicianFromForm(new EditMagicianFormData(magician));

    magician = new Magician(
        "Steve",
        "Johnson",
        "Steve Johnson",
        null,
        null,
        null,
        null,
        null,
        magicianTypeProfessional,
        0,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    );

    Magician.createMagicianFromForm(new EditMagicianFormData(magician));

    magician = new Magician(
        "Wayne",
        "Houchin",
        "Wayne Houchin",
        null,
        null,
        null,
        null,
        null,
        magicianTypeProfessional,
        0,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    );

    Magician.createMagicianFromForm(new EditMagicianFormData(magician));
  }

}
