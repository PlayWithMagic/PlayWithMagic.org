package services.setNotes;

import models.Note;
import models.Set;
import play.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Analyze a Set and generate Notes for the Magician.
 */
public class ActAnalysis {

  private Set set;
  private Integer expectedDuration = null;
  private Integer expectedCost = null;
  private List<Note> notes;


  /**
   * Create an empty ActAnalysis.
   *
   * @param set The set to analyze.
   */
  public ActAnalysis(Set set) {
    this.set = set;

    notes = new ArrayList<Note>();
  }

  /**
   * Get the desired cost of the set.
   *
   * @return The desired cost of the set.
   */
  public Integer getExpectedCost() {
    return expectedCost;
  }

  /**
   * Set the desired cost of the set.
   *
   * @param expectedCost The desired cost of the set.
   */
  public void setExpectedCost(Integer expectedCost) {
    this.expectedCost = expectedCost;
  }

  /**
   * Get the desired duration of the set.
   *
   * @return The desired duration of the set.
   */
  public Integer getExpectedDuration() {
    return expectedDuration;
  }

  /**
   * Set the desired duration of the set.
   *
   * @param expectedDuration The desired duration of the set.
   */
  public void setExpectedDuration(Integer expectedDuration) {
    this.expectedDuration = expectedDuration;
  }

  /**
   * Get the notes for this analysis.
   *
   * There is no setter for this.  To update/set the notes use analyzeSet().
   *
   * @return The notes for this analysis.
   */
  public List<Note> getNotes() {
    return notes;
  }

  /**
   * Get the set that this service is analyzing.
   *
   * Set is immutable in this class.  There is no setter.
   *
   * @return The set that this service is analyzing.
   */
  public Set getSet() {
    return set;
  }

  /**
   * Analzye the set and generate notes.
   *
   * @return The list of notes.
   */
  public List<Note> analyzeSet() {
    Logger.debug("Number of routines = [" + set.getRoutines().size() + "]");

    if (set.getRoutines().size() <= 2) {
      Note note = new Note("Consider adding more routines to your set.  You only have "
          + set.getRoutines().size() + ((set.getRoutines().size() == 1) ? " routine" : " routines") + " right now.");

      notes.add(note);
    }

    if (expectedDuration != null) {
      Note note = new Note("That's something duration");

      notes.add(note);
    }

    if (expectedCost != null) {
      Note note = new Note("That's something cost");

      notes.add(note);
    }

    return notes;
  }



  /******************************************************************************************************************
   * S T A T I C   M E T H O D S
   ******************************************************************************************************************/

  /**
   * Get an empty list of SetNotes.
   *
   * @return An empty list of SetNotes.
   */
  public static List<Note> getEmptyList() {
    return new ArrayList<Note>();
  }

}
