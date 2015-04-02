package views.formdata;

import models.Contact;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * ContactFormData allows for the storage of Form Data that is input by the user.
 */
public class ContactFormData {

  private static final int MAX_TELEPHONE_DIGITS = 12;

  /**
   * Input data id hidden field.
   */
  public long id;

  /**
   * Input data first name field.
   */
  public String firstName = "";

  /**
   * Input data last name field.
   */
  public String lastName = "";

  /**
   * Input data telephone field.
   */
  public String telephone = "";

  /**
   * Default no-arg constructor required by Play.
   */
  public ContactFormData() {
    // No content.
  }

  /**
   * Constructor that builds the ContactFormData object from a Contact.
   *
   * @param contact The contact object passed to the constructor.
   */
  public ContactFormData(Contact contact) {
    id = contact.getId();
    firstName = contact.getFirstName();
    lastName = contact.getLastName();
    telephone = contact.getTelephone();
  }


  /**
   * Validate that all fields are non-empty and that telephone field is 12 characters.
   *
   * @return Either null if no errors, or a List of errors.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "A First Name must be provided."));
    }
    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "A Last Name must be provided."));
    }
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "A telephone number must be provided."));
    }
    if ((telephone != null) && (telephone.length() != MAX_TELEPHONE_DIGITS)) {
      errors.add(new ValidationError("telephone", "Telephone number must be of the format xxx-xxx-xxxx."));
    }
    return errors.isEmpty() ? null : errors;
  }
}
