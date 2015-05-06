package models;

import views.formdata.MaterialFormData;
import views.formdata.RoutineFormData;

/**
 * Initialize the Routine dataset.
 */
public class RoutineDBInit1 {

  /**
   * Populate a routine.
   */
  public static void init01() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Ambitious Card";
    routineFormData.description = "Put a card in the middle of the deck.  It magically comes to "
        + "the top.";
    routineFormData.duration = 2;

    routineFormData.method = "Get a break under the top two cards.  Perform a double turnover.  Say \"The card on the "
        + "top of the deck is the <<Card>>\".  Perform another double turnover.  Place the indifferent card anywhere "
        + "in the deck.  Turn over the top card to show that the selected card has come to the top.";
    routineFormData.handling = "Your lift+turnover should be flawless.  Any method will work.  I grasp the lower-right "
        + "corner of the cards under the break and turn them over, sliding the pair across the back of the deck to "
        + "maintain registration (alignment).  I leave the cards injogged and refer to them with my right index "
        + "finger.  Repeat the process for the second turnover.";
    routineFormData.resetDescription = "No setup is required for a normal deck assuming that the selected card is also "
        + "indifferent.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/w4iu5FMaR2o";
    routineFormData.imageUrl = "images/routines/1.jpg";
    routineFormData.reviewUrl = "http://www.themagiccafe.com/forums/viewtopic.php?topic=577109&forum=2";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "A regular deck of cards";
      materialFormData.description = "I use red 808s, but any deck will do.";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.bicyclecards.com/products/playing-card/bicycle-standard-index";
      materialFormData.imageUrl = "images/material/1.jpg";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init02() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Gypsy Thread";
    routineFormData.description = "Pieces of thread are restored into one continuous piece.";
    routineFormData.duration = 4;

    routineFormData.method = "Not shared";
    routineFormData.handling = "I use this as an opener, with the spool in hand.  After detaching the initial piece of "
        + "thread, I hand out the spool for inspection.";
    routineFormData.resetDuration = 2;
    routineFormData.resetDescription = "Not shared";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/ANdHX8X889M";
    routineFormData.imageUrl = "images/routines/2.jpg";
    routineFormData.reviewUrl = "http://www.themagiccafe.com/forums/viewtopic.php?topic=245183&forum=109";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "A spool of thread";
      materialFormData.description = "Cotton quilting thread or silk thread work great.  Make sure it contrasts with "
          + "what you are wearing.";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 10;
      materialFormData.purchaseUrl = "http://www.amazon.com/Natural-Cotton-Thread-Solids-Yards-Black/dp/B001K54U50/"
          + "ref=sr_1_fkmr0_2?ie=UTF8&qid=1428699866&sr=8-2-fkmr0&keywords=gutermann+cotton+quilting+thread+CNE50";
      materialFormData.imageUrl = "images/material/2.jpg";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init03() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Magician's Practice Deck";
    routineFormData.description = "A 'cheap' deck of cards with nothing printed on them "
        + "magically gets printed on the front and back.";
    routineFormData.duration = 3;

    routineFormData.method = "A standard Mental Photography deck.  \"Have you ever seen a magician's practice deck?  "
        + "A magician will go through a deck per week.  You know, the oils from your hands get on the cards and they "
        + "don't spread smothly anymore.  Anyway, a deck costs about $5 a pack -- and it gets expensive over time.  "
        + "So magicians have resorted to buying practice decks... and I'd like to show you mine.\"  << Remove the box "
        + "from your pocket and remove the 'blank' deck from the box.>>  At this point, perform Mental Photography.";
    routineFormData.handling = "I find myself using this as my first card trick of a set.  I put the deck back in the "
        + "box and the box in a pocket with a loaded deck I'll use later.  I do a coin trick between the card tricks "
        + "to demonstrate skill in a variety of magical elements.  This is a good way to introduce cards in the set.";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Cut the deck to the blank cards.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/4a_9ZVj1lTY";
    // TO-DO:  I need to record my own performance.
    routineFormData.imageUrl = "images/routines/3.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "A Mental Photography Deck";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 15;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/mental-photography/";
      materialFormData.imageUrl = "images/material/3.jpg";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init04() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Twice Burned";
    routineFormData.description = "This is a good bar trick I learned from Steve Johnson.  Strike a match "
        + "and blow it out.  Strike it a second time and, astonishingly, it lights!  It's a good way to get "
        + "a free beer.";
    routineFormData.duration = 2;

    routineFormData.method = "Prepare a duplicate match.  Use a sharpie to blacken the head.  Keep the dup in finger "
        + "palm and swap it with the burned out match.";
    routineFormData.handling = "";
    routineFormData.resetDuration = 2;
    routineFormData.resetDescription = "Blacken some match heads and put one in a place that's easy to get into "
        + "finger palm.";
    routineFormData.youTubeUrl = "";

    routineFormData.imageUrl = "images/routines/200.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "A matchstick";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = true;
      materialFormData.price = 0;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/200.jpg";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Sharpie";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/201.jpg";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init05() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Daryl's Vindu Knot";
    routineFormData.description = "I hope I got the title right...  This is a very fun "
        + "bit.  Take a rope and cut in half and tie the two ends together in a knot.  Have "
        + "folks from the audience test the strength of the knot -- it's solid.  Then, you have someone cover the "
        + "knot with their hand... and the knot moves.  In fact, the knot comes off in their hand and they are "
        + "left with a nice takeaway.  A beautiful torn-and-restored effect.";
    routineFormData.duration = 5;

    routineFormData.method = "I can't share it without permission, but you can always ask Darly or watch his video.";
    routineFormData.handling = "";
    routineFormData.resetDuration = 2;
    routineFormData.resetDescription = "I have several 1-meter sections of rope ready to go.  I ensure the sissors are "
        + "in my back pocket.";
    routineFormData.youTubeUrl = "";

    routineFormData.imageUrl = "images/routines/202.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Large shears or sissors";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 20;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/203.jpg";
      materialFormData.description = "Something that's big and impressive.";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Rope";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = true;
      materialFormData.price = 2;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/rope-300-foot-ball/";
      materialFormData.imageUrl = "images/material/204.gif";
      materialFormData.description = "You can re-use about 90% of the rope... About 8\" will be consumed with each "
      + "performance";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init06() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Charming Chinese Challenge";
    routineFormData.description = "This is a three phase effect where the magician removes "
        + "Chinese coins threaded through a ribbon, one at a time.  I first learned this routine from Joshua "
        + "Jay, who credits Troy Hooser for this particular handling.";
    routineFormData.duration = 5;

    routineFormData.method = "I can't share it without permission, but you can always ask Troy or read DesTROYers.";
    routineFormData.handling = "";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Get the ribbon and all of the coins in their right places.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/PLlUMopDXhc";

    routineFormData.imageUrl = "images/routines/203.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Ribbon";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 10;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/205.jpg";
      materialFormData.description = "I like bright, communist red ribbon about 8mm wide.  I cut the ends at a sharp "
          + "angle to make the coins easier to thread";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "A few Chinese Coins";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Vintage-Chinese-Wealth-Double-Fortune/dp/B00JF0UPVK/"
          + "ref=sr_1_11?ie=UTF8&qid=1428755038&sr=8-11&keywords=chinese+coins";
      materialFormData.imageUrl = "images/material/206.jpg";
      materialFormData.description = "About the size of a half-dollar... make sure they are thick.  I've had several "
          + "coins broken over the years.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init07() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Two Card Monte";
    routineFormData.description = "This is a 'giveaway' routine I perform whereby I teach the "
        + "audience a little magic trick and I give them two gaff (novelty) cards to remember the event.";
    routineFormData.duration = 10;

    routineFormData.method = "It's probably best just to watch the video.";
    routineFormData.handling = "It usually takes 10-15 minutes and I'll do this as a sort of encore after a set.";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/ts4sn0xNNJo";

    routineFormData.imageUrl = "images/routines/204.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "A double backed card";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = true;
      materialFormData.price = 10;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/double-back-cards/";
      materialFormData.imageUrl = "images/material/207.jpg";
      materialFormData.description = "This is the per-deck price";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "A double faced card";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = true;
      materialFormData.price = 10;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/double-face-cards/";
      materialFormData.imageUrl = "images/material/208.jpg";
      materialFormData.description = "This is the per-deck price.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init08() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Panic";
    routineFormData.description = "This is my favorite effect within a set.  It's a transposition effect that "
        + "allows me to switch from an audience-handled, sorted deck to a packet-loaded deck.  Strangly, people "
        + "forget about this nearly impossible effect because I follow it with my closer French Kiss.";
    routineFormData.duration = 2;

    routineFormData.method = "Go buy Aaron's video.";
    routineFormData.handling = "I've had the best luck doing several find-the-card bits before I get into Panic.  This "
        + "firmly establishes the fact that the deck is real and full of unique cards.";
    routineFormData.resetDuration = 2;
    routineFormData.resetDescription = "Panic resets instantly, but I need to sort out the decks when I'm done.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/w2m30DlKR8k";
    routineFormData.reviewUrl = "http://themagiccafe.com/forums/viewtopic.php?topic=225471&forum=109&184&start=180#3";

    routineFormData.imageUrl = "images/routines/205.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "The panic gaff";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 20;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/panic-by-aaron-fisher/";
      materialFormData.imageUrl = "images/material/209.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init09() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Side Steal";
    routineFormData.description = "The Side Steal allows total control of a single card to the top of the deck"
        + " - invisibly. It doesn’t end there, use it to control a card to any position near the top or as a stunningly"
        + " visual color change.";
    routineFormData.duration = 2;

    routineFormData.method = "Purchase the video at https://store.theory11.com/products/side-steal-jason-england.";
    routineFormData.handling = "Requires nimble fingers and sleight of hand!";
    routineFormData.resetDuration = 2;
    routineFormData.resetDescription = "Simply shuffle the cards to reset.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/CzST8dLlsks";

    routineFormData.imageUrl = "images/routines/401.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 20;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/1.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init10() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Phantom";
    routineFormData.description = "You give half of the deck to the spectator. You take the remaining half, and "
        + "riffle through the faces. The spectator is asked to THINK of any card they see — it's a free selection.\n"
        + "Instantly, you spread through the cards and show that the card they were THINKING of is GONE. Vanished. It "
        + "was merely a PHANTOM. Where did it go? It’s been in THEIR hands all along. You even know it’s position - "
        + "from a face down pile.\n Phantom is Spidey’s adaptation of classic principles published by Theodore "
        + "Annemann, Franklin Taylor, and Charles Jordan.\n A demonstration of astral projection or remote viewing. "
        + "The ability to gather information from a distant or unseen target using extra-sensory perception (ESP).";
    routineFormData.duration = 2;

    routineFormData.method = "Purchase the video at https://store.theory11.com/products/phantom-by-spidey.";
    routineFormData.handling = "Requires nimble fingers and sleight of hand!  Presentation is everything for this "
        + "Routine, especially if you want to sell the ESP portion of it.  Be sure to practice your Patter.";
    routineFormData.resetDuration = 2;
    routineFormData.resetDescription = "Simply shuffle the cards to reset for this routine.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/J5PeqXUJTf4";

    routineFormData.imageUrl = "images/routines/402.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 20;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/1.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init11() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Fancyband";
    routineFormData.description = "An ordinary rubberband is sprung off your fingertips, spiraling a few "
        + "meters forward - then spins on the tabletop, slingshotting it back towards you. A demonstration of skill "
        + "you can unleash at anytime.";
    routineFormData.duration = 1;

    routineFormData.method = "Full method is available for FREE at "
        + "https://store.theory11.com/products/fancy-band-chris-kenner";

    routineFormData.handling = "Make sure you have a smooth flat surface to perform this Routine on.  In addition, you "
        + "can use Patter to make a ridiculous claim about what you're going to do, much to their disbelief!";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Simply retrieve the rubber band to reset.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/7f0vUiYBfBE";

    routineFormData.imageUrl = "images/routines/403.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Rubber Band";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = false;
      materialFormData.price = 1;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/401.jpg";
      materialFormData.description = "A simple rubber band; the cost is for a bag.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init12() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Classic Color Change";
    routineFormData.description = "It is one of the simplest, most fluid, visual moves in magic - "
        + "and it is also one of the easiest. With a simple wave, one playing card visually changes into another.\n";
    routineFormData.duration = 1;

    routineFormData.method = "Full method is available for FREE at "
        + "https://store.theory11.com/products/classic-color-change-jonathan-bayme";

    routineFormData.handling = "As simple as this Routine is, it's important to practice it until you get the movement "
        + "fluid and precise.  It requires steady hands, and the addition of some Patter will really spice it up.";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Will need a moment of non-visible reset";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/HhKANQhcD-4";

    routineFormData.imageUrl = "images/routines/404.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 20;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/1.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init13() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Zig-Zag-Pencil";
    routineFormData.description = "This was one of the first Routines I was exposed to as a 10 year old."
        + " My grandparents purchased me a magic kit that included this, and the really cool part is how simple the "
        + "routine is--and also that you can improve upon it with a few easy steps!";
    routineFormData.duration = 5;

    routineFormData.method = "The required kit comes with the method in-box.";

    routineFormData.handling = "There are a few improvements on the basic part of this set.  I've seen one that uses "
        + "money in place of the pencil, and another one that uses a two tipped two color pencil that changes when it "
        + "is reset.  Be creative and find your own way to improve upon it!.";
    routineFormData.resetDuration = 5;
    routineFormData.resetDescription = "Unable to reset this one in front of the audience.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/Vz9xmMJC_sQ";

    routineFormData.imageUrl = "images/routines/405.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Zig-Zag Pencil Box";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 6;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/zig-zag-pencil/";
      materialFormData.imageUrl = "images/material/402.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Pencil";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/403.jpg";
      materialFormData.description = "You will need two; $5 for a box.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init14() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "eXile";
    routineFormData.description = "From the award-winning mind of Mathieu Bich comes eXile - the effect that kick "
        + "started the latest David Blaine special with a bang. eXile takes place entirely on the spectator's own "
        + "hand. Three small X's are drawn on someone's open palm. A quarter is placed in the center of their hand.\n"
        + "Slowly, you slide your fingers over each X, and they visually, instantly vanish. No sign of ink to be "
        + "seen. Nothing. When the quarter is lifted, there are three perfect X's directly in the center of their "
        + "palm.";
    routineFormData.duration = 2;

    routineFormData.method = "Full information on the method may be found at https://store.theory11.com/products/exile";

    routineFormData.handling = "It's important that the participant be able to keep still.  Take your time with "
        + "removing each of the X's, and really give it weight when dropping it under the coin.";
    routineFormData.resetDuration = 10;
    routineFormData.resetDescription = "Unable to reset this one in front of the audience.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/z7crYXJbDg4";

    routineFormData.imageUrl = "images/routines/406.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Coin";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 6;
      materialFormData.purchaseUrl = "http://kbmagic.com/replicamorgandollars.html";
      materialFormData.imageUrl = "images/material/404.jpg";
      materialFormData.description = "Any large coin will do.";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Pen";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 3;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/405.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init15() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Hellbound Spellbound";
    routineFormData.description = "A single silver coin is displayed and held at the fingertips. "
        + "With a meticulous rub, the coin instantly and visually changes into a copper coin... then changes back to "
        + "a silver coin again.\n You explain you've been using two coins - but show that they're BOTH silver.\n"
        + "Hellbound Spellbound is a stunningly visual coin trick with nothing but great methodology and pure "
        + "sleight-of-hand. NO gimmicks are needed to perform the routine.";
    routineFormData.duration = 4;

    routineFormData.method = "Full information on the method may be found at "
        + "https://store.theory11.com/products/hellbound-spellbound-chris-kenner";

    routineFormData.handling = "Practice makes perfect on this Routine.  You need to be able to handle the coins "
        + "deftly, and any mess ups will expose the trick.  Be sure to get your movements fluid!";
    routineFormData.resetDuration = 10;
    routineFormData.resetDescription = "Unable to reset this one in front of the audience.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/hJzmvlAQj78";

    routineFormData.imageUrl = "images/routines/411.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Coin";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 6;
      materialFormData.purchaseUrl = "http://kbmagic.com/replicamorgandollars.html";
      materialFormData.imageUrl = "images/material/404.jpg";
      materialFormData.description = "Four coins will be needed, two silver, two copper";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init16() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "GPS";
    routineFormData.description = "GPS is a classic and deceptively brilliant method to ascertain a spectator's "
        + "freely selected playing card - done under nearly impossible conditions. NO key cards. NO gimmicks.\n"
        + "They shuffle the the cards not once but TWICE during the demonstration.\n You are able to locate their "
        + "selection 100% of the time. Learn a powerful technique that you can apply to any magic trick you wish, "
        + "as a way to identify a selected card under truly test conditions.";
    routineFormData.duration = 4;

    routineFormData.method = "Full information on the method may be found at "
        + "https://store.theory11.com/products/gps-chris-kenner";

    routineFormData.handling = "Best performed on a table so that you can have the audience member easily shuffle.  Be "
        + " sure to handle the cards with a professional flair, and take your time when spotting the card in question.";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Instantly resets.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/d_BhLddlpp4";

    routineFormData.imageUrl = "images/routines/407.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 20;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/1.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init17() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Digital Dissolve";
    routineFormData.description = "A half dollar is placed into a spectator's closed hand. You rest "
        + "a copper English penny on the back of that same hand. In the blink of an eye and without warning, the "
        + "copper coin visually changes into the silver half dollar.\n The half dollar is immediately shown on "
        + "both sides. The spectator then slowly opens their hand to reveal the English penny. Both coins can be "
        + "immediately handed out for full examination.\n Originally published by magician Steve Dusheck, Digital "
        + "Dissolve takes simple, effective coin magic to the next level with a streamlined copper / silver "
        + "transposition routine that you'll actually use.";
    routineFormData.duration = 4;

    routineFormData.method = "Full information on the method may be found at "
        + "https://store.theory11.com/products/digital-dissolve";

    routineFormData.handling = "Best performed on a table so that you can have the audience member easily shuffle.  Be "
        + " sure to handle the cards with a professional flair, and take your time when spotting the card in question.";
    routineFormData.resetDuration = 2;
    routineFormData.resetDescription = "Requires a minute or two to reset.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/Alv_sZXmfYw";

    routineFormData.imageUrl = "images/routines/408.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Coin";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 6;
      materialFormData.purchaseUrl = "http://kbmagic.com/replicamorgandollars.html";
      materialFormData.imageUrl = "images/material/404.jpg";
      materialFormData.description = "Coins come with this Routine on purchase.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init18() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Overstuft";
    routineFormData.description = "You eat the cream inside of an Oreo cookie - and then, so visually, it "
        + "REFILLS itself! As seen on The Ellen Show with Justin Flom.\n Overstuft is a utility prop that enables "
        + "you to do a myriad of magical effects using something the whole world is familiar with - a chocolate "
        + "cookie!\n From a quick trick to a full-fledged multi-phase routine, Overstuft will be your secret weapon "
        + "for powerful, fun magic at any moment.";
    routineFormData.duration = 2;

    routineFormData.method = "Full information on the method may be found at "
        + "https://store.theory11.com/products/overstuft-by-bizzaro";

    routineFormData.handling = "";
    routineFormData.resetDuration = 2;
    routineFormData.resetDescription = "Don't reset in front of an audience, requires you to set up the effect again.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/1vdshxjIohg";

    routineFormData.imageUrl = "images/routines/409.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Overstuft Kit";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 30;
      materialFormData.purchaseUrl = "https://store.theory11.com/products/overstuft-by-bizzaro";
      materialFormData.imageUrl = "images/material/406.jpg";
      materialFormData.description = "Included with purchase of the Routine.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init19() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Magic Cup and Balls";
    routineFormData.description = "Another simple routine that I learned as a child.  There are 3 "
        + "cups and 3 balls.  Make the balls pass through the cups, and multiply the number of balls that each cup"
        + "reveals!  There are a number of different variations that can also be done on this routine.";
    routineFormData.duration = 5;

    routineFormData.method = "There is of course more than 3 sponge or cloth balls used for this routine.";

    routineFormData.handling = "  The key to making this happen for the audience is to move quickly with each cup, and "
        + "don't give them a ton of time to think about what was just done.";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Instantly resets";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/gWkyqmgAOsk";

    routineFormData.imageUrl = "images/routines/410.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Cup and Ball Kit";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 25;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/combo-cups-and-balls/";
      materialFormData.imageUrl = "images/material/407.jpg";
      materialFormData.description = "Single kit of 3 cups and balls.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

}
