package views.formdata;

import models.Magician;
import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Login form.
 */
public class DeleteUserFormData {

  /**
   * The submitted email.
   */
  public long id;

  /**
   * Input data Password field.
   */
  @Constraints.Required(message = "You must enter a password to confirm account deletion.")
  public String password = "";

  /** Required for form instantiation. */
  public DeleteUserFormData() {
  }

  /**
   * Constructor that builds the EditUserFormData object from a provided Magician.
   *
   * @param magician The Magician object passed to the constructor.
   */
  public DeleteUserFormData(Magician magician) {
    this.id = magician.getId();
  }

  /**
   * Validates Form<DeleteUserFormData>.
   * Called automatically in the controller by bindFromRequest().
   * Checks to see that email and password are valid credentials.
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    
    Magician deletingMagician = Magician.getMagician(id);
    if (!BCrypt.checkpw(password, deletingMagician.getPassword())) {
      errors.add(new ValidationError("password", "Sorry, but the provided password does not match this user."));
    }


    return (errors.size() > 0) ? errors : null;
  }

}
