package views.formdata;

import models.GlobalDbInfo;
import models.Magician;
import play.data.validation.ValidationError;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * MagicianFormData allows for the storage of Magician Form Data that is input by the user.
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
   * Input data Year Started field.
   */
  public Integer yearStarted;

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
  public String showEmail;

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
    this.id = magician.getId();
    this.firstName = magician.getFirstName();
    this.lastName = magician.getLastName();
    this.stageName = magician.getStageName();
    this.location = magician.getLocation();
    this.userPhoto = magician.getUserPhoto();
    this.biography = magician.getBiography();
    this.interests = magician.getInterests();
    this.influences = magician.getInfluences();
    this.experienceLevel = magician.getExperienceLevel();
    this.yearStarted = magician.getYearStarted();
    this.organizations = magician.getOrganizations();
    this.website = magician.getWebsite();
    this.email = magician.getEmail();
    this.showEmail = magician.isShowEmail();
    this.facebook = magician.getFacebook();
    this.twitter = magician.getTwitter();
    this.linkedIn = magician.getLinkedIn();
    this.googlePlus = magician.getGooglePlus();
    this.flickr = magician.getFlickr();
    this.instagram = magician.getInstagram();
  }

  /**
   * Validate that all fields are non-empty, and that certain fields adhere to specific criteria.
   *
   * @return Either null if no errors, or a List of Div IDs and their associated error messages.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "Everybody (except Teller) has a first name."));
    }

    if (firstName != null && firstName.length() > GlobalDbInfo.MAX_SHORT_TEXT_LENGTH) {
      errors.add(new ValidationError("firstName",
          "The name can't be longer than " + GlobalDbInfo.MAX_SHORT_TEXT_LENGTH + " characters."));
    }

    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "A Last Name must be provided."));
    }

    if (lastName != null && lastName.length() > GlobalDbInfo.MAX_SHORT_TEXT_LENGTH) {
      errors.add(new ValidationError("lastName",
          "The name can't be longer than " + GlobalDbInfo.MAX_SHORT_TEXT_LENGTH + " characters."));
    }

    if (email == null || email.length() == 0) {
      errors.add(new ValidationError("email", "An email address must be provided."));
    }

    if (email != null && email.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("email",
          "The Email address can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (!ExperienceLevels.isExperienceLevel(experienceLevel)) {
      errors.add(new ValidationError("experienceLevel", "Please select a level of experience from the list."));
    }

    if (stageName != null && stageName.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("stageName",
          "The name can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (location != null && location.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("location",
          "The location can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (biography != null && biography.length() > GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH) {
      errors.add(new ValidationError("biography",
          "Your biography can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (interests != null && interests.length() > GlobalDbInfo.MAX_MULTILINE_TEXT_LENGTH) {
      errors.add(new ValidationError("interests",
          "Your interests can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (influences != null && influences.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("influences",
          "Your influences can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (yearStarted != null && yearStarted.intValue() < 1900) {
      errors.add(new ValidationError("yearStarted", "How about a real year?"));
    }

    if (yearStarted != null && yearStarted.intValue() > Calendar.getInstance().get(Calendar.YEAR)) {
      errors.add(new ValidationError("yearStarted", "How about a real year?"));
    }

    if (organizations != null && organizations.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("organizations",
          "Your organizations can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (website != null && website.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("website",
          "Your website URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (facebook != null && facebook.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("facebook",
          "Your facebook URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (twitter != null && twitter.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("twitter",
          "Your twitter URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (linkedIn != null && linkedIn.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("linkedIn",
          "Your linkedIn URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (googlePlus != null && googlePlus.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("googlePlus",
          "Your googlePlus URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (flickr != null && flickr.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("flickr",
          "Your flickr URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    if (instagram != null && instagram.length() > GlobalDbInfo.MAX_LONG_TEXT_LENGTH) {
      errors.add(new ValidationError("instagram",
          "Your instagram URL can't be longer than " + GlobalDbInfo.MAX_LONG_TEXT_LENGTH + " characters."));
    }

    return errors.isEmpty() ? null : errors;

  }
}
