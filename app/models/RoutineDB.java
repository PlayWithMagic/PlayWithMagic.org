package models;

import play.Logger;
import views.formdata.MaterialFormData;
import views.formdata.RoutineFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An in-memory array of Routines that have been gathered from input form data.
 */
public class RoutineDB {

  private static Map<Long, Routine> routines = new HashMap<>();
  private static long currentId = 1;

  /**
   * Get the current ID of the in-memory database.  This should be used for testing only.
   *
   * @return The current ID of the in-memory datbase.
   */
  public static long getCurrentId() {
    return currentId;
  }

  /**
   * Adds a Routine, based on formData, to the Routines database.
   *
   * @param routineForm Input data from the form.
   * @return The ID of the Routine that was just added to the database.
   */
  public static long addRoutines(RoutineFormData routineForm) {
    Routine routine;
    long idVal;

    if (routineForm.id == 0) {
      idVal = currentId++;

      routine = new Routine(
          idVal,
          routineForm.name,
          routineForm.description);
    }
    else {
      idVal = routineForm.id;

      routine = RoutineDB.getRoutine(idVal);

      routine.setName(routineForm.name);
      routine.setDescription(routineForm.description);
    }

    routine.setDuration(routineForm.duration);
    routine.setMethod(routineForm.method);
    routine.setHandling(routineForm.handling);
    routine.setResetDuration(routineForm.resetDuration);
    routine.setResetDescription(routineForm.resetDescription);
    routine.setYouTubeUrl(routineForm.youTubeUrl);
    routine.setImageUrl(routineForm.imageUrl);

    routines.put(idVal, routine);
    Logger.debug(((routineForm.id == 0) ? "Added" : "Updated") + " routine.  id = [" + idVal + "]"
        + "  name = [" + routineForm.name + "]");

    return idVal;
  }


  /**
   * Add or update a Material object to a Routine object saved in the Routines database.
   *
   * @param materialForm Input data from an HTML form.
   */
  public static void addMaterial(MaterialFormData materialForm) {
    Material material = new Material(materialForm.name);
    material.setDescription(materialForm.description);
    material.isInspectable(materialForm.isInspectable);
    material.isGivenAway(materialForm.isGivenAway);
    material.isConsumed(materialForm.isConsumed);
    material.setPrice(materialForm.price);
    material.setPurchaseUrl(materialForm.purchaseUrl);
    material.setImageUrl(materialForm.imageUrl);

    if (materialForm.materialId == -1) {
      RoutineDB.getMaterials(materialForm.routineId).add(material);
    }
    else {
      RoutineDB.getMaterials(materialForm.routineId).set(materialForm.materialId, material);
    }
  }

  /**
   * Gets a routine from the routines in-memory database with a matching ID value.
   *
   * @param id The ID value to match.
   * @return the routine associated with the ID.
   */
  public static Routine getRoutine(long id) {
    Routine routine = routines.get(id);
    if (routine == null) {
      throw new RuntimeException("Unable to find routine with given ID value.");
    }
    return routine;
  }

  /**
   * Get a list of materials for the routine.
   * <p>
   * If the routineId is 0, return an empty list.  If the routineId is non-0, return the materials from the Routine.
   *
   * @param routineId The ID of a routine or 0 to create an empty list for a new routine.
   * @return A list of materials.
   */
  public static List<Material> getMaterials(long routineId) {
    if (routineId == 0) {
      return new ArrayList<Material>();
    }
    else {
      return routines.get(routineId).getMaterials();
    }
  }

  /**
   * Deletes a routine from the in-memory database with a matching ID value.
   *
   * @param id The ID value of the routine to delete.
   */
  public static void deleteRoutine(long id) {
    Routine routine = routines.get(id);
    if (routine == null) {
      throw new RuntimeException("Unable to find routine with given ID value.");
    }
    routines.remove(id);
  }

  /**
   * Gets a list of all routines currently stored.
   *
   * @return the full list of routines.
   */
  public static List<Routine> getRoutines() {
    return new ArrayList<>(routines.values());
  }


  /**
   * Delete all of the routines in the database.  This is used by JUnit tests.
   */
  public static void resetRoutineDB() {
    routines.clear();
    currentId = 1;
    Logger.warn("Routine database reset");
  }


  /**
   * Initialize the Routine database.
   */
  public static void init() {
    resetRoutineDB();
    Routine routine = null;
    Material material = null;
    long id;

    // --------------------------------------
    routine = new Routine(0, "Ambitious Card", "Put a card in the middle of the deck.  It magically comes to "
        + "the top.");

    routine.setDuration(2);
    routine.setMethod("Get a break under the top two cards.  Perform a double turnover.  Say \"The card on the top "
        + "of the deck is the <<Card>>\".  Perform another double turnover.  Place the indifferent card anywhere in "
        + "the deck.  Turn over the top card to show that the selected card has come to the top.");
    routine.setHandling("Your lift and turnover should be flawless.  Any method will work.  I grasp the lower-right "
        + "corner of the cards under the break and turn them over, sliding the pair across the back of the deck to "
        + "maintain registration (alignment).  I leave the cards injogged and refer to them with my right index "
        + "finger.  Repeat the process for the second turnover.");
    routine.setResetDescription("No setup is required for a normal deck assuming that the selected card is also "
        + "indifferent.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/w4iu5FMaR2o");
    routine.setImageUrl("images/routines/1.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("A regular deck of cards");
    material.setDescription("I use red 808s, but any deck will do.");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("http://www.bicyclecards.com/products/playing-card/bicycle-standard-index");
    material.setImageUrl("images/material/1.jpg");

    routine.getMaterials().add(material);

    material = new Material("XXA regular deck of cards");
    material.setDescription("I use red 808s, but any deck will do.");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("http://www.bicyclecards.com/products/playing-card/bicycle-standard-index");
    material.setImageUrl("images/material/1.jpg");

    routine.getMaterials().add(material);

    material = new Material("XXXXA regular deck of cards");
    material.setDescription("I use red 808s, but any deck will do.");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("http://www.bicyclecards.com/products/playing-card/bicycle-standard-index");
    material.setImageUrl("images/material/1.jpg");

    routine.getMaterials().add(material);


    // --------------------------------------
    routine = new Routine(0, "Gypsy Thread", "Pieces of thread are restored into one continuous piece.");

    routine.setDuration(4);
    routine.setMethod("Not shared");
    routine.setHandling("I use this as an opener, with the spool in hand.  After detaching the initial piece of "
        + "thread, I hand out the spool for inspection.");
    routine.setResetDuration(2);
    routine.setResetDescription("Not shared");
    routine.setYouTubeUrl("https://www.youtube.com/embed/ANdHX8X889M");
    routine.setImageUrl("images/routines/2.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("A spool of thread");
    material.setDescription("Cotton quilting thread or silk thread work great.  Make sure it contrasts with what "
        + "you are wearing.");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(10);
    material.setPurchaseUrl("http://www.amazon.com/Natural-Cotton-Thread-Solids-Yards-Black/dp/B001K54U50/"
        + "ref=sr_1_fkmr0_2?ie=UTF8&qid=1428699866&sr=8-2-fkmr0&keywords=gutermann+cotton+quilting+thread+CNE50");
    material.setImageUrl("images/material/2.jpg");

    routine.getMaterials().add(material);


    // --------------------------------------
    routine = new Routine(0, "Magician's Practice Deck", "A 'cheap' deck of cards with nothing printed on them "
        + "magically gets printed on the front and back.");

    routine.setDuration(3);
    routine.setMethod("A standard Mental Photography deck.  \"Have you ever seen a magician's practice deck?  "
        + "A magician will go through a deck per week.  You know, the oils from your hands get on the cards and they "
        + "don't spread smothly anymore.  Anyway, a deck costs about $5 a pack -- and it gets expensive over time.  "
        + "So magicians have resorted to buying practice decks... and I'd like to show you mine.\"  << Remove the box "
        + "from your pocket and remove the 'blank' deck from the box.>>  At this point, perform Mental Photography.");
    routine.setHandling("I'll find myself using this as my first card trick of the set.  I put the deck back in the "
        + "box and the box in a pocket with a loaded deck I'll use later.  I do a coin trick between the card tricks "
        + "to demonstrate skill in a variety of magical elements.  This is a good way to introduce cards in the set.");
    routine.setResetDuration(1);
    routine.setResetDescription("Cut the deck to the blank cards.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/4a_9ZVj1lTY");
    // TO-DO:  I need to record my own performance.
    routine.setImageUrl("images/routines/3.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("A Mental Photography Deck");
    material.isInspectable(false);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(15);
    material.setPurchaseUrl("http://www.grandillusions.com/product/mental-photography/");
    material.setImageUrl("images/material/3.jpg");

    routine.getMaterials().add(material);


    // --------------------------------------
    routine = new Routine(0, "Twice Burned", "This is a good bar trick I learned from Steve Johnson.  Strike a match "
        + "and blow it out.  Strike it a second time and, astonishingly, it lights!  It's a good way to get "
        + "a free beer.");

    routine.setDuration(2);
    routine.setMethod("Prepare a duplicate match.  Use a sharpie to blacken the head.  Keep the dup in finger palm "
        + "and swap it with the burned out match.");
    routine.setHandling("");
    routine.setResetDuration(2);
    routine.setResetDescription("Blacken some match heads and put one in a place that's easy to get into finger palm.");
    routine.setYouTubeUrl("");

    routine.setImageUrl("images/routines/200.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("A matchstick");
    material.isInspectable(true);
    material.isGivenAway(true);
    material.isConsumed(true);
    material.setPrice(0);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/200.jpg");

    routine.getMaterials().add(material);

    material = new Material("Sharpie");
    material.isInspectable(false);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/201.jpg");

    routine.getMaterials().add(material);


    // --------------------------------------
    routine = new Routine(0, "Daryl's Vindu Knot", "I hope I got the title right...  This is a very fun "
        + "bit.  Take a rope and cut in half and tie the two ends together in a knot.  Have "
        + "folks from the audience test the strength of the knot -- it's solid.  Then, you have someone cover the "
        + "knot with their hand... and the knot moves.  In fact, the knot comes off in their hand and they are "
        + "left with a nice takeaway.  A beautiful torn-and-restored effect.");

    routine.setDuration(5);
    routine.setMethod("I can't share it without permission, but you can always ask Darly or watch his video.");
    routine.setHandling("");
    routine.setResetDuration(2);
    routine.setResetDescription("I have several 1-meter sections of rope ready to go.  I ensure the sissors are "
        + "in my back pocket.");
    routine.setYouTubeUrl("");

    routine.setImageUrl("images/routines/202.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Large shears or sissors");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(20);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/203.jpg");
    material.setDescription("Something that's big and impressive.");

    routine.getMaterials().add(material);

    material = new Material("Rope");
    material.isInspectable(true);
    material.isGivenAway(true);
    material.isConsumed(true);
    material.setPrice(2);
    material.setPurchaseUrl("http://www.grandillusions.com/product/rope-300-foot-ball/");
    material.setImageUrl("images/material/204.gif");
    material.setDescription("You can re-use about 90% of the rope... About 8\" will be consumed with each performance");

    routine.getMaterials().add(material);


    // --------------------------------------
    routine = new Routine(0, "Charming Chinese Challenge", "This is a three phase effect where the magician removes "
        + "Chinese coins threaded through a ribbon, one at a time.  I first learned this routine from Joshua "
        + "Jay, who credits Troy Hooser for this particular handling.");

    routine.setDuration(5);
    routine.setMethod("I can't share it without permission, but you can always ask Troy or read DesTROYers.");
    routine.setHandling("");
    routine.setResetDuration(0);
    routine.setResetDescription("Get the ribbon and all of the coins in their right places.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/PLlUMopDXhc");

    routine.setImageUrl("images/routines/203.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Ribbon");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(10);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/205.jpg");
    material.setDescription("I like bright, communist red ribbon about 8mm wide.  I cut the ends at a sharp angle "
        + "to make the coins easier to thread");

    routine.getMaterials().add(material);

    material = new Material("A few Chinese Coins");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("http://www.amazon.com/Vintage-Chinese-Wealth-Double-Fortune/dp/B00JF0UPVK/ref=sr_1_11?"
        + "ie=UTF8&qid=1428755038&sr=8-11&keywords=chinese+coins");
    material.setImageUrl("images/material/206.jpg");
    material.setDescription("About the size of a half-dollar... make sure they are thick.  I've had several coins "
        + "broken over the years.");

    routine.getMaterials().add(material);


    // --------------------------------------
    routine = new Routine(0, "Two Card Monte", "This is a 'giveaway' routine I perform whereby I teach the "
        + "audience a little magic trick and I give them two gaff (novelty) cards to remember the event.");

    routine.setDuration(10);
    routine.setMethod("It's probably best just to watch the video.");
    routine.setHandling("It usually takes 10-15 minutes and I'll do this as a sort of encore after a set.");
    routine.setResetDuration(0);
    routine.setResetDescription("");
    routine.setYouTubeUrl("https://www.youtube.com/embed/ts4sn0xNNJo");

    routine.setImageUrl("images/routines/204.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("A double backed card");
    material.isInspectable(false);
    material.isGivenAway(true);
    material.isConsumed(true);
    material.setPrice(10);
    material.setPurchaseUrl("http://www.grandillusions.com/product/double-back-cards/");
    material.setImageUrl("images/material/207.jpg");
    material.setDescription("This is the per-deck price");

    routine.getMaterials().add(material);

    material = new Material("A double faced card");
    material.isInspectable(false);
    material.isGivenAway(true);
    material.isConsumed(true);
    material.setPrice(10);
    material.setPurchaseUrl("http://www.grandillusions.com/product/double-face-cards/");
    material.setImageUrl("images/material/208.jpg");
    material.setDescription("This is the per-deck price.");

    routine.getMaterials().add(material);


    // --------------------------------------
    routine = new Routine(0, "Panic", "This is my favorite effect within a set.  It's a transposition effect that "
        + "allows me to switch from an audience-handled, sorted deck to a packet-loaded deck.  Strangly, people "
        + "forget about this nearly impossible effect because I follow it with my closer French Kiss.");

    routine.setDuration(2);
    routine.setMethod("Go buy Aaron's video.");
    routine.setHandling("I've had the best luck doing several find-the-card bits before I get into Panic.  This "
        + "firmly establishes the fact that the deck is real and full of unique cards.");
    routine.setResetDuration(2);
    routine.setResetDescription("Panic resets instantly, but I need to sort out the decks when I'm done.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/w2m30DlKR8k");

    routine.setImageUrl("images/routines/205.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("The panic gaff");
    material.isInspectable(false);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(20);
    material.setPurchaseUrl("http://www.grandillusions.com/product/panic-by-aaron-fisher/");
    material.setImageUrl("images/material/209.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);


  }
}
