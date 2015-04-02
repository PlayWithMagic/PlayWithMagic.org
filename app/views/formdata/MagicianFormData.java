package views.formdata;

import models.Magician;

import java.io.File;
import java.util.ArrayList;

/**
 * MagicianFormData allows for the stoage of Magician Form Data that is input by the user.
 * This is utilized partially at account creation, and again whenever the Magician info is updated.
 * Eventually we'll decide on which items are strictly required at account creation.
 */
public class MagicianFormData {

  /**
   * Input data id hidden field.
   */
  public long id;

  /**
   * Input data First Name field.
   */
  public String firstName;

  /**
   * Input data Last Name field.
   */
  public String lastName;

  /**
   * Input data Stage Name field.
   */
  public String stageName;

  /**
   * Input data Date of Birth field (date picker field).
   */
  public String dateOfBirth;

  /**
   * Input boolean on whether or not to show the age.
   */
  public boolean showAge;

  /**
   * Input data Location field.
   */
  public String location;

  /**
   * Input data file of user image or photo.
   */
  public File userPhoto;

  // Magic Info
  /**
   * Input data Biography field.
   */
  public String biography;

  /**
   * Input data Interests field.
   */
  public String interests;

  /**
   * Input data Influences field.
   */
  public String influences;

  /**
   * Input data Experience Level selector; stored as string from field.
   */
  public String experienceLevel;

  /**
   * Input data Years Practicing field.
   */
  public int yearsPracticing;

  /**
   * Input data Organizations field.
   */
  public String organizations;

  /**
   * Input data Website field.
   */
  public String website;

  /**
   * Input data Email field.
   */
  public String email;

  /**
   * Input data boolean of whether to show the email to other users.
   */
  public boolean showEmail;

  /**
   * Input data Facebook field.
   */
  public String facebook;

  /**
   * Input data Twitter field.
   */
  public String twitter;

  /**
   * Input data LinkedIn field.
   */
  public String linkedIn;

  /**
   * Input data Google+ field.
   */
  public String googlePlus;

  /**
   * Input data flickr field.
   */
  public String flickr;

  /**
   * Input data Instagram field.
   */
  public String instagram;


  /**
   * Default no-arg constructor required by Play.
   */
  public MagicianFormData() {
    // No content.
  }

  /**
   * Constructor that builds the MagicianFormData object from a provided Magician.
   *
   * @param magician The Magician object passed to the constructor.
   */
  public MagicianFormData(Magician magician) {
    id = magician.getId();
    firstName = magician.getFirstName();
    lastName = magician.getLastName();
    stageName = magician.getStageName();
    dateOfBirth = magician.getDateOfBirth();
    showAge = magician.isShowAge();
    location = magician.getLocation();
    userPhoto = magician.getUserPhoto();
    biography = magician.getBiography();
    interests = magician.getInterests();
    influences = magician.getInfluences();
    experienceLevel = magician.getExperienceLevel();
    yearsPracticing = magician.getYearsPracticing();
    organizations = magician.getOrganizations();
    website = magician.getWebsite();
    email = magician.getEmail();
    showEmail = magician.isShowEmail();
    facebook = magician.getFacebook();
    twitter = magician.getTwitter();
    linkedIn = magician.getLinkedIn();
    googlePlus = magician.getGooglePlus();
    flickr = magician.getFlickr();
    instagram = magician.getInstagram();
  }

  /**
   * Validate that all fields are non-empty, and that certain fields adhere to specific criteria.
   *
   * @return Either null if no errors, or a List of Div IDs and their associated error messages.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();

    // TODO: Create each of the error issues.

    return errors.isEmpty() ? null : errors;

  }
}
