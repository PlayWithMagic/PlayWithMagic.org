package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An in-memory array of Contacts that have been gathered from input form data.
 */
public class ContactDB {

  private static Map<Long, Contact> contacts = new HashMap<>();
  private static long currentId = 1;

  /**
   * Adds a formData input to the Contacts list.
   *
   * @param formData Input data from the form.
   */
  public static void addContacts(ContactFormData formData) {
    long idVal = (formData.id == 0) ? currentId++ : formData.id;
    Contact contactFromForm = new Contact(idVal, formData.firstName, formData.lastName, formData.telephone);
    contacts.put(idVal, contactFromForm);
  }

  /**
   * Gets a contact from the contacts in-memory database with a matching ID value.
   *
   * @param id The ID value to match.
   * @return the contact associated with the ID.
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Unable to find contact with given ID value.");
    }
    return contact;
  }

  /**
   * Deletes a contact from the in-memory database with a matching ID value.
   *
   * @param id The ID value of the contact to delete.
   */
  public static void deleteContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Unable to find contact with given ID value.");
    }
    contacts.remove(id);
  }

  /**
   * Gets a list of all contacts currently stored.
   *
   * @return the full list of contacts.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }
}
