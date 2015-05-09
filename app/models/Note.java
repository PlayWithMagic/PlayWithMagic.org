package models;

import java.util.ArrayList;
import java.util.List;

/**
 * A note is constructive criticism.
 *
 * Notes are not persisted in the database.
 */
public class Note {
  private String text;

  /**
   * Get the text of a note.
   *
   * @return The text of a note.
   */
  public String getText() {
    return text;
  }

  /**
   * Set the text of a note.
   *
   * @param text The text of a note.
   */
  public void setText(String text) {
    this.text = text;
  }


  public static List<Note> generateSetNotes(Set set) {
    List<Note> notes = new ArrayList<Note>();

    

    return notes;
  }


}
