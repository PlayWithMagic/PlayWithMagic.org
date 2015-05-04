package views.formdata;

import models.GlobalDbInfo;
import models.Magician;
import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * EditMagicianFormData allows for the storage of Magician data from an HTML form.
 *
 * This is a Play Framework backing class that allows for the storage of HTML Form Data input by the user (usually as
 * String data being moved in/out of Model data).
 *
 * These backing classes also contain basic input form validation for required fields, field length, etc.
 *
 * This is utilized partially at account creation, and again whenever the Magician info is updated.
 */
public class EditMagicianFormData {

  /**
   * Magician ID hidden field.
   */
  public long id;

  /**
   * Input data First Name field.
   */
  @Required(message = "Everybody (except Teller) has a first name.")
  @MaxLength(value = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH,
      message = "Your name can't be longer than " + GlobalDbInfo.MAX_SHORT_TEXT_LENGTH + " characters.")
  public String firstName;

  /**
   * Input data Last Name field.
   */
  @Required(message = "A Last Name must be provided.")
  @MaxLength(value = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH,
      message = "Your name can't be longer than " + GlobalDbInfo.MAX_SHORT_TEXT_LENGTH + " characters.")
  public String lastName;

  /**
   * Input data Email field.
   */
  @Required(message = "An Email address must be provided.")
  @Email(message = "An Email address must be provided.")
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "The Email address can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String email;

  /**
   * Input data MagicianType selector; stored as a string from the selectbox.
   */
  @Required(message = "How would you identify yourself as a magician?  Please select from the list.")
  public String magicianType;

  /**
   * Input data Stage Name field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your stage name can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String stageName;

  /**
   * Input data Location field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your location can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String location;

  /**
   * Input data file of user image or photo.
   */
  public File userPhoto;

  /**
   * Input data Biography field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH,
      message = "Your biography can't be longer than " + GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH + " characters.")
  public String biography;

  /**
   * Input data Interests field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH,
      message = "Your interests can't be longer than " + GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH + " characters.")
  public String interests;

  /**
   * Input data Influences field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your influences can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String influences;

  /**
   * Input data Year Started field.
   */
  @Min(value = 1900, message = "How about a real year?")
  public Integer yearStarted;

  /**
   * Input data Organizations field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your list of organizations can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String organizations;

  /**
   * Input data Website field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your website URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String website;

  /**
   * Input data Facebook field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your Facebook URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String facebook;

  /**
   * Input data Twitter field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your Twitter URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String twitter;

  /**
   * Input data LinkedIn field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your LinkedIn URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String linkedIn;

  /**
   * Input data Google+ field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your Google+ URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String googlePlus;

  /**
   * Input data flickr field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your Flickr URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String flickr;

  /**
   * Input data Instagram field.
   */
  @MaxLength(value = GlobalDbInfo.MAX_LONG_TEXT_LENGTH,
      message = "Your Instagram URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters.")
  public String instagram;


  /**
   * Default no-arg constructor required by Play.
   */
  public EditMagicianFormData() {
    // No content.
  }


  /**
   * Constructor that builds the EditMagicianFormData object from a provided Magician.
   *
   * @param magician The Magician object passed to the constructor.
   */
  public EditMagicianFormData(Magician magician) {
    this.id = magician.getId();
    this.firstName = magician.getFirstName();
    this.lastName = magician.getLastName();
    this.email = magician.getEmail();
    this.magicianType = magician.getMagicianType().getName();
    this.stageName = magician.getStageName();
    this.location = magician.getLocation();
    this.userPhoto = magician.getUserPhoto();
    this.biography = magician.getBiography();
    this.interests = magician.getInterests();
    this.influences = magician.getInfluences();
    this.yearStarted = magician.getYearStarted();
    this.organizations = magician.getOrganizations();
    this.website = magician.getWebsite();
    this.facebook = magician.getFacebook();
    this.twitter = magician.getTwitter();
    this.linkedIn = magician.getLinkedIn();
    this.googlePlus = magician.getGooglePlus();
    this.flickr = magician.getFlickr();
    this.instagram = magician.getInstagram();
  }


  /**
   * Enforce special user interface validation rules for Magician HTML form data.
   *
   * @return Either null if no errors, or a List of Div IDs and their associated error messages.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<ValidationError>();

    if (Magician.find().where().ne("id", id).ieq("email", email).findList().size() > 0) {
      errors.add(new ValidationError("email",
          "This eMail address is already in Play With Magic.  Please enter another address."));
    }

    if (Magician.find().where().ne("id", id).ieq("stageName", stageName).findList().size() > 0) {
      errors.add(new ValidationError("stageName",
          "This Stage Name is already in Play With Magic.  Bummer.  Please enter another name."));
    }

    if (!MagicianTypeFormData.isMagicianType(magicianType)) {
      errors.add(new ValidationError("magicianType",
          "How would you identify yourself as a magician?  Please select from the list."));
    }

    if (yearStarted != null && yearStarted.intValue() > Calendar.getInstance().get(Calendar.YEAR)) {
      errors.add(new ValidationError("yearStarted", "How about a real year?"));
    }

    return errors.isEmpty() ? null : errors;
  }
}
