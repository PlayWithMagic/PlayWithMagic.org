package models;

/**
 * A note is constructive criticism.
 *
 * Notes are not persisted in the database.
 */
public class Note {
  private String text;


  /**
   * Create a new note.
   *
   * @param text The text of the note.
   */
  public Note(String text) {
    this.text = text;
  }


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

}
