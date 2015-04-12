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
      throw new RuntimeException("Unable to find routine with given ID value of [" + id + "].");
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


  /******************************************************************************************************************
   * I N I T I A L I Z E   D A T A B A S E
   ******************************************************************************************************************/

  /**
   * Populate a routine.
   */
  public static void init01() {
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

  }

  /**
   * Populate a routine.
   */
  public static void init02() {
    Routine routine = null;
    Material material = null;
    long id;

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
  }


  /**
   * Populate a routine.
   */
  public static void init03() {
    Routine routine = null;
    Material material = null;
    long id;

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
  }


  /**
   * Populate a routine.
   */
  public static void init04() {
    Routine routine = null;
    Material material = null;
    long id;

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
  }


  /**
   * Populate a routine.
   */
  public static void init05() {
    Routine routine = null;
    Material material = null;
    long id;

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
  }


  /**
   * Populate a routine.
   */
  public static void init06() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Charming Chinese Challenge", "This is a three phase effect where the magician removes "
        + "Chinese coins threaded through a ribbon, one at a time.  I first learned this routine from Joshua "
        + "Jay, who credits Troy Hooser for this particular handling.");

    routine.setDuration(5);
    routine.setMethod("I can't share it without permission, but you can always ask Troy or read DesTROYers.");
    routine.setHandling("");
    routine.setResetDuration(1);
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
  }


  /**
   * Populate a routine.
   */
  public static void init07() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Two Card Monte", "This is a 'giveaway' routine I perform whereby I teach the "
        + "audience a little magic trick and I give them two gaff (novelty) cards to remember the event.");

    routine.setDuration(10);
    routine.setMethod("It's probably best just to watch the video.");
    routine.setHandling("It usually takes 10-15 minutes and I'll do this as a sort of encore after a set.");
    routine.setResetDuration(1);
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
  }


  /**
   * Populate a routine.
   */
  public static void init08() {
    Routine routine = null;
    Material material = null;
    long id;

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

  /**
   * Populate a routine.
   */
  public static void init09() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Side Steal", "The Side Steal allows total control of a single card to the top of the deck"
        + " - invisibly. It doesn’t end there, use it to control a card to any position near the top or as a stunningly"
        + " visual color change.");

    routine.setDuration(2);
    routine.setMethod("Purchase the video at https://store.theory11.com/products/side-steal-jason-england.");
    routine.setHandling("Requires nimble fingers and sleight of hand!");
    routine.setResetDuration(2);
    routine.setResetDescription("Simply shuffle the cards to reset.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/CzST8dLlsks");

    routine.setImageUrl("images/routines/401.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Cards");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(20);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/1.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init10() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Phantom", "You give half of the deck to the spectator. You take the remaining half, and "
        + "riffle through the faces. The spectator is asked to THINK of any card they see — it's a free selection.\n"
        + "Instantly, you spread through the cards and show that the card they were THINKING of is GONE. Vanished. It "
        + "was merely a PHANTOM. Where did it go? It’s been in THEIR hands all along. You even know it’s position - "
        + "from a face down pile.\n Phantom is Spidey’s adaptation of classic principles published by Theodore "
        + "Annemann, Franklin Taylor, and Charles Jordan.\n A demonstration of astral projection or remote viewing. "
        + "The ability to gather information from a distant or unseen target using extra-sensory perception (ESP).");

    routine.setDuration(2);
    routine.setMethod("Purchase the video at https://store.theory11.com/products/phantom-by-spidey.");
    routine.setHandling("Requires nimble fingers and sleight of hand!  Presentation is everything for this Routine, "
        + "especially if you want to sell the ESP portion of it.  Be sure to practice your Patter.");
    routine.setResetDuration(2);
    routine.setResetDescription("Simply shuffle the cards to reset for this routine.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/J5PeqXUJTf4");

    routine.setImageUrl("images/routines/402.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Cards");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(20);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/1.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init11() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Fancyband", "An ordinary rubberband is sprung off your fingertips, spiraling a few "
        + "meters forward - then spins on the tabletop, slingshotting it back towards you. A demonstration of skill "
        + "you can unleash at anytime.");

    routine.setDuration(1);
    routine.setMethod("Full method is available for FREE at "
        + "https://store.theory11.com/products/fancy-band-chris-kenner");

    routine.setHandling("Make sure you have a smooth flat surface to perform this Routine on.  In addition, you can "
        + "use Patter to make a ridiculous claim about what you're going to do, much to their disbelief!");
    routine.setResetDuration(1);
    routine.setResetDescription("Simply retrieve the rubber band to reset.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/7f0vUiYBfBE");

    routine.setImageUrl("images/routines/403.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Rubber Band");
    material.isInspectable(true);
    material.isGivenAway(true);
    material.isConsumed(false);
    material.setPrice(1);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/401.jpg");
    material.setDescription("A simple rubber band; the cost is for a bag.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init12() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Classic Color Change", "It is one of the simplest, most fluid, visual moves in magic - "
        + "and it is also one of the easiest. With a simple wave, one playing card visually changes into another.\n");

    routine.setDuration(1);
    routine.setMethod("Full method is available for FREE at "
        + "https://store.theory11.com/products/classic-color-change-jonathan-bayme");

    routine.setHandling("As simple as this Routine is, it's important to practice it until you get the movement fluid"
        + " and precise.  It requires steady hands, and the addition of some Patter will really spice it up.");
    routine.setResetDuration(1);
    routine.setResetDescription("Will need a moment of non-visible reset");
    routine.setYouTubeUrl("https://www.youtube.com/embed/HhKANQhcD-4");

    routine.setImageUrl("images/routines/404.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Cards");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(20);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/1.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init13() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Zig-Zag-Pencil", "This was one of the first Routines I was exposed to as a 10 year old."
        + " My grandparents purchased me a magic kit that included this, and the really cool part is how simple the "
        + "routine is--and also that you can improve upon it with a few easy steps!");

    routine.setDuration(5);
    routine.setMethod("The required kit comes with the method in-box.");

    routine.setHandling("There are a few improvements on the basic part of this set.  I've seen one that uses money "
        + "in place of the pencil, and another one that uses a two tipped two color pencil that changes when it's "
        + "reset.  Be creative and find your own way to improve upon it!.");
    routine.setResetDuration(5);
    routine.setResetDescription("Unable to reset this one in front of the audience.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/Vz9xmMJC_sQ");

    routine.setImageUrl("images/routines/405.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Zig-Zag Pencil Box");
    material.isInspectable(false);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(6);
    material.setPurchaseUrl("http://www.grandillusions.com/product/zig-zag-pencil/");
    material.setImageUrl("images/material/402.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);

    material = new Material("Pencil");
    material.isInspectable(true);
    material.isGivenAway(true);
    material.isConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/403.jpg");
    material.setDescription("You will need two; $5 for a box.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init30() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Double Exposure", "A mind-blowing new take on a classic effect. Double Exposure "
        + "by Asi Wind is a reality altering version of Triumph that happens within a borrowed camera under your "
        + "spectators complete control.");

    routine.setDuration(2);
    routine.setMethod("");

    routine.setHandling("There are no gimmicks or special applications needed. 100% impromptu. "
        + "Just you, a deck of cards, and a borrowed camera are all that's necessary.");
    routine.setResetDuration(5);
    routine.setResetDescription("No need to reset. Just give phone back to participant.");

    routine.setImageUrl("images/routines/300.png");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("iPhone");
    material.isInspectable(true);
    material.isGivenAway(true);
    material.isConsumed(false);
    material.setPrice(600);
    material.setPurchaseUrl("http://store.apple.com/us/iphone");
    material.setImageUrl("images/material/300a.jpeg");
    material.setDescription("A standard iPhone.");

    routine.getMaterials().add(material);

    material = new Material("Deck of Cards");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
        + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards");
    material.setImageUrl("images/material/300.jpg");
    material.setDescription("Standard deck of cards");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init31() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "A.A.C.A.A.N", "From one spectator, any card is named. From a different spectator, "
        + "a number one through fifty-two is named. With absolutely nothing to suspect, the named card appears "
        + "at exactly the number named. A probability so impressive only magic can explain it. "
        + "This is Any Card at Any Number, for real.");

    routine.setDuration(2);
    routine.setMethod("");

    routine.setHandling("");
    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into card box.");

    routine.setImageUrl("images/routines/301.png");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Deck of Cards");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
        + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards");
    material.setImageUrl("images/material/300.jpg");
    material.setDescription("Standard deck of cards");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init32() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Peregrine Pass", "It's not often we stumble upon a secret technique that looks "
        + "authentic to the natural action taking place, in this case - closing a spread of cards. With the "
        + "Peregrine Pass, what happens \"behind the scenes\" when compared to the polished performance is "
        + "night and day. This is sleight of hand at its finest!");

    routine.setDuration(2);
    routine.setMethod("This. Is. Awsome. Incredible. Beautiful. Devastating. EASY!!!! If you have had some "
        + "experience with card manipulation, you can do the Peregrine Pass. The method is so gorgeous it's not "
        + "even right...you WILL have the mechanics down in under 8 minutes, and if you do this in front of "
        + "a mirror, you'll fool yourself! I most definitely will be using this, it's a worker. Five stars.");

    routine.setHandling("");
    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into card box.");

    routine.setImageUrl("images/routines/302.png");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Deck of Cards");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
        + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards");
    material.setImageUrl("images/material/300.jpg");
    material.setDescription("Standard deck of cards");

    routine.getMaterials().add(material);
  }


  /**
   * Populate a routine.
   */
  public static void initTemplate() {
    Routine routine = null;
    Material material = null;
    long id;

  }


  /**
   * Initialize the Routine database.
   */
  public static void init() {
    resetRoutineDB();

    init01();
    init02();
    init03();
    init04();
    init05();
    init06();
    init07();
    init08();
    init09();
    init10();
    init11();
    init12();
    init13();
    init30();
    init31();
    init32();
  }
}
