package models;

import views.formdata.RoutineFormData;

/**
 * Initialize the Routine in-memory database.
 */
public class RoutineDBInit1 {

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
    routine.setReviewUrl("http://www.themagiccafe.com/forums/viewtopic.php?topic=577109&forum=2");

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
    routine.setReviewUrl("http://www.themagiccafe.com/forums/viewtopic.php?topic=245183&forum=109");

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
  public static void init14() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "eXile", "From the award-winning mind of Mathieu Bich comes eXile - the effect that kick "
        + "started the latest David Blaine special with a bang. eXile takes place entirely on the spectator's own "
        + "hand. Three small X's are drawn on someone's open palm. A quarter is placed in the center of their hand.\n"
        + "Slowly, you slide your fingers over each X, and they visually, instantly vanish. No sign of ink to be "
        + "seen. Nothing. When the quarter is lifted, there are three perfect X's directly in the center of their "
        + "palm.");

    routine.setDuration(2);
    routine.setMethod("Full information on the method may be found at https://store.theory11.com/products/exile");

    routine.setHandling("It's important that the participant be able to keep still.  Take your time with removing "
        + "each of the X's, and really give it weight when dropping it under the coin.");
    routine.setResetDuration(10);
    routine.setResetDescription("Unable to reset this one in front of the audience.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/z7crYXJbDg4");

    routine.setImageUrl("images/routines/406.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Coin");
    material.isInspectable(false);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(6);
    material.setPurchaseUrl("http://kbmagic.com/replicamorgandollars.html");
    material.setImageUrl("images/material/404.jpg");
    material.setDescription("Any large coin will do.");

    routine.getMaterials().add(material);

    material = new Material("Pen");
    material.isInspectable(false);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(3);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/405.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init15() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Hellbound Spellbound", "A single silver coin is displayed and held at the fingertips. "
        + "With a meticulous rub, the coin instantly and visually changes into a copper coin... then changes back to "
        + "a silver coin again.\n You explain you've been using two coins - but show that they're BOTH silver.\n"
        + "Hellbound Spellbound is a stunningly visual coin trick with nothing but great methodology and pure "
        + "sleight-of-hand. NO gimmicks are needed to perform the routine.");

    routine.setDuration(4);
    routine.setMethod("Full information on the method may be found at "
        + "https://store.theory11.com/products/hellbound-spellbound-chris-kenner");

    routine.setHandling("Practice makes perfect on this Routine.  You need to be able to handle the coins deftly, "
        + "and any mess ups will expose the trick.  Be sure to get your movements fluid!");
    routine.setResetDuration(10);
    routine.setResetDescription("Unable to reset this one in front of the audience.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/hJzmvlAQj78");

    routine.setImageUrl("images/routines/411.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Coin");
    material.isInspectable(false);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(6);
    material.setPurchaseUrl("http://kbmagic.com/replicamorgandollars.html");
    material.setImageUrl("images/material/404.jpg");
    material.setDescription("Four coins will be needed, two silver, two copper");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init16() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "GPS", "GPS is a classic and deceptively brilliant method to ascertain a spectator's "
        + "freely selected playing card - done under nearly impossible conditions. NO key cards. NO gimmicks.\n"
        + "They shuffle the the cards not once but TWICE during the demonstration.\n You are able to locate their "
        + "selection 100% of the time. Learn a powerful technique that you can apply to any magic trick you wish, "
        + "as a way to identify a selected card under truly test conditions.");

    routine.setDuration(4);
    routine.setMethod("Full information on the method may be found at "
        + "https://store.theory11.com/products/gps-chris-kenner");

    routine.setHandling("Best performed on a table so that you can have the audience member easily shuffle.  Be sure"
        + " to handle the cards with a professional flair, and take your time when spotting the card in question.");
    routine.setResetDuration(1);
    routine.setResetDescription("Instantly resets.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/d_BhLddlpp4");

    routine.setImageUrl("images/routines/407.jpg");

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
  public static void init17() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Digital Dissolve", "A half dollar is placed into a spectator's closed hand. You rest "
        + "a copper English penny on the back of that same hand. In the blink of an eye and without warning, the "
        + "copper coin visually changes into the silver half dollar.\n The half dollar is immediately shown on "
        + "both sides. The spectator then slowly opens their hand to reveal the English penny. Both coins can be "
        + "immediately handed out for full examination.\n Originally published by magician Steve Dusheck, Digital "
        + "Dissolve takes simple, effective coin magic to the next level with a streamlined copper / silver "
        + "transposition routine that you'll actually use.");

    routine.setDuration(4);
    routine.setMethod("Full information on the method may be found at "
        + "https://store.theory11.com/products/digital-dissolve");

    routine.setHandling("Best performed on a table so that you can have the audience member easily shuffle.  Be sure"
        + " to handle the cards with a professional flair, and take your time when spotting the card in question.");
    routine.setResetDuration(2);
    routine.setResetDescription("Requires a minute or two to reset.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/Alv_sZXmfYw");

    routine.setImageUrl("images/routines/408.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Coin");
    material.isInspectable(true);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(6);
    material.setPurchaseUrl("http://kbmagic.com/replicamorgandollars.html");
    material.setImageUrl("images/material/404.jpg");
    material.setDescription("Coins come with this Routine on purchase.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init18() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Overstuft", "You eat the cream inside of an Oreo cookie - and then, so visually, it "
        + "REFILLS itself! As seen on The Ellen Show with Justin Flom.\n Overstuft is a utility prop that enables "
        + "you to do a myriad of magical effects using something the whole world is familiar with - a chocolate "
        + "cookie!\n From a quick trick to a full-fledged multi-phase routine, Overstuft will be your secret weapon "
        + "for powerful, fun magic at any moment.");

    routine.setDuration(2);
    routine.setMethod("Full information on the method may be found at "
        + "https://store.theory11.com/products/overstuft-by-bizzaro");

    routine.setHandling("");
    routine.setResetDuration(2);
    routine.setResetDescription("Cannot be reset in front of the audience, requires you to set up the effect again.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/1vdshxjIohg");

    routine.setImageUrl("images/routines/409.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Overstuft Kit");
    material.isInspectable(false);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(30);
    material.setPurchaseUrl("https://store.theory11.com/products/overstuft-by-bizzaro");
    material.setImageUrl("images/material/406.jpg");
    material.setDescription("Included with purchase of the Routine.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init19() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine(0, "Magic Cup and Balls", "Another simple routine that I learned as a child.  There are 3 "
        + "cups and 3 balls.  Make the balls pass through the cups, and multiply the number of balls that each cup"
        + "reveals!  There are a number of different variations that can also be done on this routine.");

    routine.setDuration(5);
    routine.setMethod("There is of course more than 3 sponge or cloth balls used for this routine.");

    routine.setHandling("  The key to making this happen for the audience is to move quickly with each cup, and "
        + "don't give them a ton of time to think about what was just done.");
    routine.setResetDuration(1);
    routine.setResetDescription("Instantly resets");
    routine.setYouTubeUrl("https://www.youtube.com/embed/gWkyqmgAOsk");

    routine.setImageUrl("images/routines/410.jpg");

    id = RoutineDB.addRoutines(new RoutineFormData(routine));
    routine = RoutineDB.getRoutine(id);

    material = new Material("Cup and Ball Kit");
    material.isInspectable(false);
    material.isGivenAway(false);
    material.isConsumed(false);
    material.setPrice(25);
    material.setPurchaseUrl("http://www.grandillusions.com/product/combo-cups-and-balls/");
    material.setImageUrl("images/material/407.jpg");
    material.setDescription("Single kit of 3 cups and balls.");

    routine.getMaterials().add(material);
  }

}
