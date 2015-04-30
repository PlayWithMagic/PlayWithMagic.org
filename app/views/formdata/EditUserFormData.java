package views.formdata;

import models.GlobalDbInfo;
import models.Magician;
import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * EditUserFormData allows for the storage of a subset of Magician data from an HTML form.
 * <p>
 * This is a Play Framework backing class that allows for the storage of HTML Form Data input by the user (usually as
 * String data being moved in/out of Model data).
 * <p>
 * These backing classes also contain basic input form validation for required fields, field length, etc.
 * <p>
 * This is utilized partially at account creation, and again whenever the Magician info is updated.
 */
public class EditUserFormData {

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
   * Input data Password field.
   */
  @Required(message = "You need to have a password.")
  @MaxLength(value = GlobalDbInfo.MAX_SHORT_TEXT_LENGTH,
      message = "Your password can't be longer than " + GlobalDbInfo.MAX_SHORT_TEXT_LENGTH + " characters.")
  @MinLength(value = GlobalDbInfo.MIN_PASSWORD_LENGTH,
      message = "The password must be at least " + GlobalDbInfo.MIN_PASSWORD_LENGTH + " characters.")
  public String password;


  /**
   * Default no-arg constructor required by Play.
   */
  public EditUserFormData() {
    // No content.
  }


  /**
   * Constructor that builds the EditUserFormData object from a provided Magician.
   *
   * @param magician The Magician object passed to the constructor.
   */
  public EditUserFormData(Magician magician) {
    this.id = magician.getId();
    this.firstName = magician.getFirstName();
    this.lastName = magician.getLastName();
    this.email = magician.getEmail();
    this.magicianType = magician.getMagicianType().getName();
    this.password = magician.getPassword();
  }


  /**
   * Enforce special user interface validation rules for Magician HTML form data.
   *
   * @return Either null if no errors, or a List of Div IDs and their associated error messages.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<ValidationError>();

    int upperCase = 0;
    int lowerCase = 0;
    int number = 0;

    for (int k = 0; k < this.password.length(); k++) {
      if (Character.isUpperCase(this.password.charAt(k))) {
        upperCase++;
      }

      if (Character.isLowerCase(this.password.charAt(k))) {
        lowerCase++;
      }

      if (Character.isDigit(this.password.charAt(k))) {
        number++;
      }
    }

    int symbolicChars = this.password.length() - upperCase - lowerCase - number;

    if (upperCase < GlobalDbInfo.MIN_PASSWORD_UPPERCASE_CHARS) {
      errors.add(new ValidationError("password",
          "You should have at least " + GlobalDbInfo.MIN_PASSWORD_UPPERCASE_CHARS + " uppercase character."));
    }

    if (lowerCase < GlobalDbInfo.MIN_PASSWORD_LOWERCASE_CHARS) {
      errors.add(new ValidationError("password",
          "You should have at least " + GlobalDbInfo.MIN_PASSWORD_LOWERCASE_CHARS + " lowercase character."));
    }

    if (number < GlobalDbInfo.MIN_PASSWORD_NUMERIC_CHARS) {
      errors.add(new ValidationError("password",
          "You should have at least " + GlobalDbInfo.MIN_PASSWORD_NUMERIC_CHARS + " number."));
    }

    if (symbolicChars < GlobalDbInfo.MIN_PASSWORD_SYMBOL_CHARS) {
      errors.add(new ValidationError("password",
          "You should have at least " + GlobalDbInfo.MIN_PASSWORD_SYMBOL_CHARS + " symbol."));
    }

    if (!MagicianTypeFormData.isMagicianType(magicianType)) {
      errors.add(new ValidationError("magicianType",
          "How would you identify yourself as a magician?  Please select from the list."));
    }

    return errors.isEmpty() ? null : errors;
  }
}
