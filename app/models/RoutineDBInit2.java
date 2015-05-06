package models;

import views.formdata.MaterialFormData;
import views.formdata.RoutineFormData;

/**
 * Initialize the Routine dataset.
 */
public class RoutineDBInit2 {

  /**
   * Populate a routine.
   */

  public static void init20() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "3 Long Ropes";
    routineFormData.description = "My uncle taught me this Routine when I was in elementary school. Take "
        + "three different lengths of rope, and magically make them all the same length!";
    routineFormData.duration = 5;

    routineFormData.method = "Two of the lengths are cut in such a way that when crossed behind the hand, it appears "
        + "that the three ropes are now the same length.";

    routineFormData.handling = "Take the time to let the audience inspect each piece of rope, and don't rush!";
    routineFormData.resetDuration = 2;
    routineFormData.resetDescription = "Instantly resets.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/7Tej0-P8zd0";

    routineFormData.imageUrl = "images/routines/412.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "1 length of rope";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/408.jpg";
      materialFormData.description = "Can be done with any length of rope purchased at a hardware store.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init21() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Blind";
    routineFormData.description = "Two decks with different colored backs are introduced. You ask your "
        + "spectator to choose any card and place it on top of your pack. You do the same. To everyone's amazement, "
        + "BOTH cards match.\n A free choice from the spectator leads to one impossible conclusion.\n BLIND is a "
        + "modern take on a timeless prediction plot, done under impossible conditions. NO duplicates. NO doubles. "
        + "NO possible explanation.";
    routineFormData.duration = 2;

    routineFormData.method = "Learn the method at https://store.theory11.com/products/blind-daniel-madison";

    routineFormData.handling = "Be sure that the participant doesn't look at the decks!";
    routineFormData.resetDuration = 10;
    routineFormData.resetDescription = "Need to reset both decks to perform the trick again.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/xW1sVasRkS8";

    routineFormData.imageUrl = "images/routines/413.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Cards";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 20;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/1.jpg";
      materialFormData.description = "Requires two decks of different colors; purchase price is for one deck.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init22() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Stairway";
    routineFormData.description = "An ordinary bill is borrowed from your spectator - then folded over the "
        + "bottom of two rubberbands being held at the fingertips and paperclipped to ensure full security. "
        + "Additionally, a member of your audience pinches the bottom of the bill to dissolve any doubts. "
        + "NO funny business.\n What happens next is practical, impromptu, visual magic at its best.\n"
        + "One-by-one, the bill travels up both rubberbands with just a flick of the wrist, coming to rest on the "
        + "very top strand. Three penetrations done in ten seconds time, under impossible conditions. For the finale, "
        + "the bill travels back down the bands slowly and visually - ending where it originally started.";
    routineFormData.duration = 2;

    routineFormData.method = "Learn the method at https://store.theory11.com/products/blind-daniel-madison";

    routineFormData.handling = "Be patient and go slow with the rubber band setup; you don't want to flub it.";
    routineFormData.resetDuration = 5;
    routineFormData.resetDescription = "Need to set up the rubber bands again.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/yub_tOwdS9o";

    routineFormData.imageUrl = "images/routines/414.jpg";

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

  public static void init23() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Breach";
    routineFormData.description = "Any playing card is selected and placed face up on top of the deck. The pack "
        + "is lowered beneath a glass surface or tabletop and the selection visually penetrates up through the "
        + "glass.\n Without warning, it immediately melts back down through the table again.\n BREACH is an "
        + "incredibly visual card penetration that happens with little cover using ANY glass tabletop or surface. "
        + "This is what card magic is supposed to look like.";
    routineFormData.duration = 2;

    routineFormData.method = "Learn the method at https://store.theory11.com/products/breach-daniel-madison";

    routineFormData.handling = "As always this requires good control with the cards.  A clear table is also required, "
        + "just make sure that if it's glass you don't break it!";
    routineFormData.resetDuration = 5;
    routineFormData.resetDescription = "Needs a fresh deck of cards if any of them were signed as part of the routine.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/kDWOE0-xTX0";

    routineFormData.imageUrl = "images/routines/415.jpg";

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

  public static void init24() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Free Will";
    routineFormData.description = "Three wooden tokens are shown and mixed, face down by the audience.  "
        + "A prediction is shown and placed, face down, onto the table.  The audience member chooses a token for "
        + "themselves, one for another spectator and one for the bag that the chips were taken from.  Amazingly, "
        + "even though the audience member had freewill, the prediction is perfectly accurate.\n Works EVERY "
        + "time with NO sleight of hand. Very, very easy to perform";
    routineFormData.duration = 2;

    routineFormData.method = "The method for this routine may be purchased as a kit at "
        + "http://www.grandillusions.com/product/free-will/";

    routineFormData.handling = "You can embellish on the presentation of this routine by making great stories for it!";
    routineFormData.resetDuration = 10;
    routineFormData.resetDescription = "Reset the bag trick after each performance, along with any props.";
    //routine.setYouTubeUrl(null);

    routineFormData.imageUrl = "images/routines/416.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Free Will Packet";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 18;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/free-will/";
      materialFormData.imageUrl = "images/material/409.jpg";
      materialFormData.description = "Everything needed is included in the kit.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init30() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Double Exposure";
    routineFormData.description = "A mind-blowing new take on a classic effect. Double Exposure "
        + "by Asi Wind is a reality altering version of Triumph that happens within a borrowed camera under your "
        + "spectators complete control.";
    routineFormData.duration = 2;

    routineFormData.method = "";

    routineFormData.handling = "There are no gimmicks or special applications needed. 100% impromptu. "
        + "Just you, a deck of cards, and a borrowed camera are all that's necessary.";
    routineFormData.resetDuration = 5;
    routineFormData.resetDescription = "No need to reset. Just give phone back to participant.";

    routineFormData.imageUrl = "images/routines/300.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "iPhone";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = false;
      materialFormData.price = 600;
      materialFormData.purchaseUrl = "http://store.apple.com/us/iphone";
      materialFormData.imageUrl = "images/material/300a.jpeg";
      materialFormData.description = "A standard iPhone.";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init31() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "A.A.C.A.A.N";
    routineFormData.description = "From one spectator, any card is named. From a different spectator, "
        + "a number one through fifty-two is named. With absolutely nothing to suspect, the named card appears "
        + "at exactly the number named. A probability so impressive only magic can explain it. "
        + "This is Any Card at Any Number, for real.";
    routineFormData.duration = 2;

    routineFormData.method = "";

    routineFormData.handling = "";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into card box.";

    routineFormData.imageUrl = "images/routines/301.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init32() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Peregrine Pass";
    routineFormData.description = "It's not often we stumble upon a secret technique that looks "
        + "authentic to the natural action taking place, in this case - closing a spread of cards. With the "
        + "Peregrine Pass, what happens \"behind the scenes\" when compared to the polished performance is "
        + "night and day. This is sleight of hand at its finest!";
    routineFormData.duration = 2;

    routineFormData.method = "This. Is. Awesome. Incredible. Beautiful. Devastating. EASY!!!! If you have had some "
        + "experience with card manipulation, you can do the Peregrine Pass. The method is so gorgeous it's not "
        + "even right...you WILL have the mechanics down in under 8 minutes, and if you do this in front of "
        + "a mirror, you'll fool yourself! I most definitely will be using this, it's a worker. Five stars.";

    routineFormData.handling = "";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into card box.";

    routineFormData.imageUrl = "images/routines/302.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init33() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Flux Deal";
    routineFormData.description = "A diabolical switch that allows for the seamless and constant change of "
        + "cards dealt onto the table. Switch one card or many cards, cause cards to visually change, force cards, "
        + "and more. The Flux Deal is great for mathematical tricks, gambling demonstrations, and transpositions. "
        + "The possibilities are endless! The deal is not only imperceptible, but indistinguishable. With practice, "
        + "the switch will even fool you.";
    routineFormData.duration = 2;

    routineFormData.method = "I find the grip hard to execute because my forefinger isn't long enough to hold the "
        + "cards steady. I can hold the cards with my middle finger but then it´s hard to execute the following move "
        + "so I think it's only for people with big hands.";

    routineFormData.handling = "";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into card box.";

    routineFormData.imageUrl = "images/routines/303.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init34() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Slipshift";
    routineFormData.description = "The Slipshift is a visual color change done at the fingertips. "
        + "Within this video Chris explains several variations of the change along with a method to control "
        + "a selected card to the top of the deck.";
    routineFormData.duration = 2;

    routineFormData.method = "Being able to change a card in front of the spectators face is one of the strongest "
        + "effects there are. I would say this is a must have but only for more advanced magicians.";

    routineFormData.handling = "";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into card box.";

    routineFormData.imageUrl = "images/routines/304.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init35() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Recharmed, I'm Sure!";
    routineFormData.description = "One at a time, three Chinese coins hanging on a length "
        + "of string magically come off right before your eyes. With each phase progressively appearing more "
        + "impossible, the third and final coin is held at the fingertips and visibly melts right through the "
        + "string and then back on again. Finally, it vanishes completely, reappearing with the other two on "
        + "a table.";
    routineFormData.duration = 2;

    routineFormData.method = "";

    routineFormData.handling = "The performers shows three coins and a length of string. All can be freely examined "
        + "by the audience. Threading the coins on the string, they’re clearly situated there, and yet one coin "
        + "'dances' off the string and onto a spectator’s hand. The two remaining coins are clearly seen on the "
        + "string. Again, one coin simply falls off onto the first coin. The performer holds the last coin at his "
        + "extreme fingertips. The coin is unequivocally on the center of the string and yet, the performer "
        + "visibly pulls them apart. Just as astonishingly, however, he causes the string to visibly melt right "
        + "back on the coin and immediately has the spectator pull on the string to verify that it’s really on "
        + "there. It is. No sooner is this done than the performer visibly pulls the string through the coin "
        + "again— and there is no doubt about this, the string is in one hand and the coin is in the other."
        + "Just as casually, the string visibly melts back on. Again, the spectator pulls on the string, "
        + "clearly showing at the coin is on it. Once more, the coin melts through the string into the "
        + "performer’s hand, but suddenly it’s gone, and the errant coin is finally found with the other "
        + "two, in plain view.";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put coins back into coin purse. Recoil string.";

    routineFormData.imageUrl = "images/routines/305.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Chinese Coin set";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 25;
      materialFormData.purchaseUrl = "http://shop.dananddave.com/recharmed-lance-pierce.html";
      materialFormData.imageUrl = "images/material/305.png";
      materialFormData.description = "Set of three chinese coins and piece of string.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init36() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "King Brand";
    routineFormData.description = "Visually dynamic, the effect couldn't be simpler: The deck is removed "
        + "and only four cards are presented, the two red Kings and and the two black fours. With one pair "
        + "sandwiched between the other, they visually trade places under impossible conditions. "
        + "The plot builds in three phases with the final trasposition happening in a spectators own hand.";
    routineFormData.duration = 2;

    routineFormData.method = "Three phase, sleight heavy, and super deceptive.";

    routineFormData.handling = "";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into deck.";

    routineFormData.imageUrl = "images/routines/306.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init37() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Gödel";
    routineFormData.description = "Gödel is an innovative face-up color change from the mind of Alexander "
        + "Hansford. With a wave of the hands, cards transform under direct scrutiny. Not only will you receive "
        + "two additional routines with your purchase, Twisting and Sandwich, you’ll find Gödel to be an "
        + "incredible utility for the effects you already perform.";
    routineFormData.duration = 2;

    routineFormData.method = "";

    routineFormData.handling = "After having two cards selected and lost in the pack, two black Jacks are waved "
        + "above the deck only to have one of the selections appear between them. Both sides are shown "
        + "throughout the effect, destroying any guess your spectator might have towards the method. "
        + "With one final and extremely open wave, the selection between the Jacks changes to the other "
        + "for an astonishing finish.";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into deck.";

    routineFormData.imageUrl = "images/routines/307.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init38() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Spring St. Aces";
    routineFormData.description = "As the cards are sprung face up from hand to hand, the dealer "
        + "is able to stop dead on an Ace. This is repeated three more times until all four Aces have been found. "
        + "An impeccable feat to say the least.";
    routineFormData.duration = 2;

    routineFormData.method = "";

    routineFormData.handling = "";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into deck.";

    routineFormData.imageUrl = "images/routines/308.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init39() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Diagonal Palm Shift";
    routineFormData.description = "First published in 1902 by S.W. Erdnase, the Diagonal Palm "
        + "Shift - a secret maneuver for bottom palming a selected card placed into the middle of the deck - "
        + "is explained in detail by one of this generations most beloved sleight of hand artists, Ricky Smith.";
    routineFormData.duration = 2;

    routineFormData.method = "";

    routineFormData.handling = "";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into deck.";

    routineFormData.imageUrl = "images/routines/309.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init40() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Vernon One-Hand Table Shuffle";
    routineFormData.description = "We originally learned this technique from Vernon's "
        + "book, Ultimate Secrets of Card Magic (1967); however it wasn't until we saw a video of Ross Bertram "
        + "performing the shuffle perfectly that we began to take interest. What you see before you is our own "
        + "handling created to achieve the perfect one-for-one riffle along with various subtleties acquired "
        + "from years of practice.";
    routineFormData.duration = 2;

    routineFormData.method = "";

    routineFormData.handling = "";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into deck.";

    routineFormData.imageUrl = "images/routines/310.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init41() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "WeFlex";
    routineFormData.description = "A remarkable transformation of a playing card unlike any other. Taking "
        + "place away from the deck, WeFlex is a single-card color change. It all happens at the fingertips, "
        + "so it's all very open. With apparently just the flexing of a card back and forth, it changes right "
        + "before your eyes. WeFlex is as beautiful as it is graceful, and in our opinion is one of the most "
        + "elegant and magical color change ever created.";
    routineFormData.duration = 2;

    routineFormData.method = "";

    routineFormData.handling = "It is not angle proof but its easy to get right after practice in the mirror. "
        + "This isn't the easiest to pull off smoothly and will take some time";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into deck.";

    routineFormData.imageUrl = "images/routines/311.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init42() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Catch 23";
    routineFormData.description = "Perfect for shows small and large, Asi’s Catch 23 creates a connection "
        + "between the performer and the audience that few effects have the ability to do. Catch 23 has been an "
        + "integral part of Asi’s live shows for years. Today he offers it to us. Asi’s creative ingenuity and "
        + "passion for magic has advanced our art ten-fold. This newest addition to an overwhelming collection "
        + "is nothing short of brilliant.";
    routineFormData.duration = 2;

    routineFormData.method = "";

    routineFormData.handling = "A performer invites four spectators to the stage. After cleanly showing five envelopes "
        + "that have be previously marked “1-5,” each spectator is asked to make a decision which number envelope "
        + "they’d like. This is a completely free choice. The performer having been left with the single envelope "
        + "not selected, invites an audience member to remove its contents. Within, they’ll be astonished to find "
        + "a check for the exact amount created by the envelope order of the participants on stage. In addition, "
        + "each volunteer is asked to open their selected envelops where a note card states a distinguishing "
        + "feature about them (i.e. This will be selected by the only man in glasses). The effect culminates "
        + "as the last envelope to be opened reveals the name of the participant who has made its selection.";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into deck.";

    routineFormData.imageUrl = "images/routines/312.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Evidence bag and cards";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = true;
      materialFormData.price = 50;
      materialFormData.purchaseUrl = "http://shop.dananddave.com/catch23-asi-wind.html";
      materialFormData.imageUrl = "images/material/312.png";
      materialFormData.description = "Evidence bag and cards with descriptions of participants.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init43() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Triumph and Triumph Again";
    routineFormData.description = "Two spectators are asked to make separate selections- "
        + "one to be placed immediately face down, the other remembered. The pack is then shuffled face-up and "
        + "face-down, only to be spread moments later to show the cards have returned to normal face-down position, "
        + "except for twelve like-suited cards in order! It’s discovered that the card needed to complete the "
        + "sequence is the one that’s been on the table since the start of the effect. A spectator is then invited "
        + "to shuffle the pack themselves, and the trick is repeated to reveal the second selection of an entirely "
        + "different suit. Finally, the first selection transforms into the second for a startling conclusion.";
    routineFormData.duration = 2;

    routineFormData.method = "The method is smart and fun to pull off. With so many different forms of Triumph out "
        + "there, it can be easy to assume you know all you need to, but the second wave of this trick amplifies "
        + "the effect phenomenally.";

    routineFormData.handling = "";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into deck.";

    routineFormData.imageUrl = "images/routines/313.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init44() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Trigger";
    routineFormData.description = "Trigger is a stunning and surprising effect that looks like trick "
        + "photography. The solution is impossible to reconstruct, yet seems fair and is easily achieved.";
    routineFormData.duration = 2;

    routineFormData.method = "After a card is shuffled into the center, the deck is wrapped tightly with a rubber "
        + "band, sealing the card within. At your command, the band passes through the entire deck with the "
        + "exception of a single card, which shoots out from the center for a dynamic and visual effect.";

    routineFormData.handling = "";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into deck.";

    routineFormData.imageUrl = "images/routines/314.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init45() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Static";
    routineFormData.description = "With the spectator's finger touching the top of the deck, the deck slowly "
        + "splits itself in half. With a delicate touch, their chosen card shoots out of the pack. The deck is "
        + "completely examinable before and after the effect. They will find nothing. They will have no "
        + "explanation.";
    routineFormData.duration = 2;

    routineFormData.method = "";

    routineFormData.handling = "";

    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Put cards back into deck.";

    routineFormData.imageUrl = "images/routines/315.png";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init201() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Slydini's Knotted Slilks";
    routineFormData.description = "I've wanted to learn this trick for a long time.  It's "
        + "a 4 stage trick but it has over 60 moves to it.  The essence of the trick is that two silks are tied "
        + "together with a solid knot, then magically, the silks come apart.";
    routineFormData.duration = 12;

    routineFormData.method = "Go buy the book.";
    routineFormData.handling = "Again, go buy the book.";
    routineFormData.resetDuration = 0;
    routineFormData.resetDescription = "It resets instantly and all of the silks can be examined";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/-HbTQA_4btQ";

    routineFormData.imageUrl = "images/routines/206.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Two silk scarves";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/silk-18-inch/";
      materialFormData.imageUrl = "images/material/210.gif";
      materialFormData.description = "The best material to use is strong nylon.  Cotton & Japanese silks don't work "
          + "well.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

  /**
   * Populate a routine.
   */

  public static void init202() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Blendo";
    routineFormData.description = "This is a good parlor routine.  The magician removes three 24\" colorful "
        + "silks from a black, slik bag.  The silks are inspected and a spectator puts the silks into the bag and "
        + "'mixes' them.  The magician reminds the audience that the United States is a mixture of many, many "
        + "world cultures and the three silks are red, white and blue.  The three mixed silks are then instantly "
        + "combined to produce an american flag.";
    routineFormData.duration = 4;

    routineFormData.method = "Get a blendo bag and some silks.  Learn to fold the blendo bag.";
    //routineFormData.handling = "";
    routineFormData.resetDuration = 10;
    routineFormData.resetDescription = "It takes awhile to fold the bag.  Also, make sure the silks are not wrinkly.";
    //routineFormData.youTubeUrl = "https://www.youtube.com/embed/-HbTQA_4btQ";

    routineFormData.imageUrl = "images/routines/207.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Three 18\" silk scarves: Red, White and Blue";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 8;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/silk-18-inch/";
      materialFormData.imageUrl = "images/material/210.gif";
      //materialFormData.description = "The best material to use is strong nylon.  Cotton doesn't work well.";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "A blendo bag";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 30;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/american-flag-blendo/";
      materialFormData.imageUrl = "images/material/211.jpg";
      //materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init203() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Lucifer's Wallet";
    routineFormData.description = "Remove your wallet.  Set it on fire, remove a burning business "
        + "card.  Blow it out.  Snuff out the fire in your wallet.  Hand out the still-warm card -- without a "
        + "singe mark on it.  Let the audience look at the wallet.";
    routineFormData.duration = 1;

    routineFormData.method = "Very carefully -- you're literally playing with fire.";
    //routineFormData.handling = "";
    routineFormData.resetDuration = 5;
    //routineFormData.resetDescription = "";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/O_McHgSfkf4";

    routineFormData.imageUrl = "images/routines/208.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Lucifer's wallet";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 30;
      materialFormData.purchaseUrl = "http://www.themagicdepot.com/product_info.php?products_id=6365";
      materialFormData.imageUrl = "images/material/212.jpg";
      //materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Lighter fluid";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Zippo-3165-Lighter-Fluid-12OZ/dp/B000K2U3JG";
      materialFormData.imageUrl = "images/material/213.jpg";
      //materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Business card";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = true;
      materialFormData.price = 1;
      //materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/214.jpg";
      //materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init204() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "The Magic Project Plan";
    routineFormData.description = "\"The hardest part of a project is the beginning.  The fear of "
        + "the blank page\"... thumb through a `book` full of empty pages.  Then have a project manager sprinkle some "
        + "fairy dust on it and thumb through the book again -- this time it's full of charts and graphs.  Finally "
        + "have a programmer type on the book's cover, and when you thumb through the book, it's full of code.";
    routineFormData.duration = 4;

    routineFormData.method = "I make my books by hand, but the template is a classic Magic Coloring Book";
    routineFormData.handling = "Oh, so easy.  Go visit your local magic shop and they'll set you up.";
    //routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "The routine itself resets instantly.  It takes me a couple of hours and a trip "
        + "to Kinkos to make my book.";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/bwCdRbJEJmU";

    routineFormData.imageUrl = "images/routines/209.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "A gaff book";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 10;
      materialFormData.purchaseUrl = "http://www.grandillusions.com/product/coloring-book-magic/";
      materialFormData.imageUrl = "images/material/215.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init205() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Are You Normal... or Are You an Engineer?";
    routineFormData.description = "Inspired by one of my favorite magicians "
        + "Mr. David Regal.  This routine uses a Wellington Switchboard and consists of three phases.  The first "
        + "phase introduces the switchboard... four colored lights and four colored switches.  Whenever the normal "
        + "person is asked to throw a switch the light corresponding to the switch's color lights up.  Whenever "
        + "the engineer throws a switch, the light opposite the switch lights up.";
    routineFormData.duration = 10;

    //routineFormData.method = "";
    //routineFormData.handling = "";
    //routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "Resets instantly";
    //routineFormData.youTubeUrl = "https://www.youtube.com/embed/";

    routineFormData.imageUrl = "images/routines/210.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Wellington Switchboard";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 400;
      materialFormData.purchaseUrl = "http://www.wellingtonent.com/products/mswitchb.html";
      materialFormData.imageUrl = "images/material/216.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init206() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "French Kiss";
    routineFormData.description = "This is a classic double-turnover routine that I originally found in "
        + "The Royal Road to Card Magic.  However, Wayne Houchin's version is edgy, fun and is my closer.  Thank you, "
        + "Wayne.  It's a transposition effect where a spectator's signed card, is transposed with the magician's "
        + "signed card.";
    routineFormData.duration = 4;

    routineFormData.method = "A flawless double turnover";
    routineFormData.handling = "";
    routineFormData.resetDuration = 2;
    routineFormData.resetDescription = "I just can't bring myself to post it";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/9HfWyW49-v4";

    routineFormData.imageUrl = "images/routines/211.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = true;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init207() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Three Fly";
    routineFormData.description = "Poker chips (or coins) fly from one hand to the other... and back.";
    routineFormData.duration = 2;

    routineFormData.method = "You can get that from Lee.";
    routineFormData.handling = "Checkout Lee Asher's performance of this routine 2:47 into the video...";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/1dTXKKGR06A";

    routineFormData.imageUrl = "images/routines/217.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "At least four poker chips";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 20;
      materialFormData.purchaseUrl = "http://www.leeasher.com/store/tricks/three_stylin.html";
      materialFormData.imageUrl = "images/routines/217.jpg";
      materialFormData.description = "Get some big, colorful, high-contrast, authentic chips from a Macau or "
          + "Vegas casino.";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init208() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Witness";
    routineFormData.description = "A spectator seals a 'wild joker' in a zip-lock bag.  The spectator then "
        + "selects a card an puts it in the deck.  Suddenly, the card is in the zip-lock bag.";
    routineFormData.duration = 1;

    routineFormData.method = "See Lee's website...";
    //routineFormData.handling = "";
    routineFormData.resetDuration = 2;
    //routineFormData.resetDescription = "";
    routineFormData.youTubeUrl = "https://www.youtube.com/embed/2N75cJHrkpc";

    routineFormData.imageUrl = "images/routines/218.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "The Widness DVD";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 20;
      materialFormData.purchaseUrl = "http://www.leeasher.com/store/media/witness.html";
      materialFormData.imageUrl = "images/routines/218.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "A ziplock bag";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 5;
      //materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "images/material/217.jpg";
      materialFormData.description = "Just a regular ziplock bag";

      Material.saveMaterialFromForm(materialFormData);

      // Material
      materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Deck of Cards";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = true;
      materialFormData.isConsumed = true;
      materialFormData.price = 5;
      materialFormData.purchaseUrl = "http://www.amazon.com/Bicycle-Rider-Poker-Playing-Cards/dp/B002JAZ9GY/"
          + "ref=sr_1_1?ie=UTF8&qid=1428871353&sr=8-1&keywords=a+deck+of+cards";
      materialFormData.imageUrl = "images/material/300.jpg";
      materialFormData.description = "Standard deck of cards";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init209() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Marked Cards";
    routineFormData.description = "This isn't exactly a magic trick, but it's a nice intersticial bit "
        + "I'll do.  Basically, I hand out cards from a blue-backed Fornier 505 deck.  The cards are marked, but "
        + "about 90% of the time, the audience can't find the markings.  I use the time to talk about cards and "
        + "card games.  I tend to do it when I'm getting burned by an audience and I want to bring the tension down "
        + "a bit.  Sometimes, I'll do it to demonstrate that this isn't supernatural.  Other times, I'll do it "
        + "to make an audience member feel special or not foolish.";
    routineFormData.duration = 5;

    //routineFormData.method = "";
    routineFormData.handling = "Just be yourself.";
    //routineFormData.resetDuration = 1;
    //routineFormData.resetDescription = "";
    //routineFormData.youTubeUrl = "https://www.youtube.com/embed/";

    routineFormData.imageUrl = "images/material/219.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Blue Fournier 505 Deck";
      materialFormData.isInspectable = true;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 10;
      materialFormData.purchaseUrl = "http://www.amazon.com/Fournier-Standard-Decks-Playing-Cards/dp/B000XZ0944/"
          + "ref=sr_1_1?ie=UTF8&s=toys-and-games&qid=1203992691&sr=8-1";
      materialFormData.imageUrl = "images/material/219.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Populate a routine.
   */

  public static void init210() {
    Routine routine;
    RoutineFormData routineFormData = new RoutineFormData();

    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "Cocoa";
    routineFormData.description = "I don't perform this trick... yet.  I saw David Regal perform it at a lecture "
        + "once and it's burned into my mind.  Basically, these marshmallows are coming and going out of a cup "
        + "of hot chocolate.";
    routineFormData.duration = 10;

    routineFormData.method = "Get David's book Approaching Magic";
    //routineFormData.handling = "";
    //routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "The damn thing self-resets";
    //routineFormData.youTubeUrl = "https://www.youtube.com/embed/";

    routineFormData.imageUrl = "images/routines/220.jpg";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "Approaching Magic";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 65;
      materialFormData.purchaseUrl = "http://davidregal.com/approaching-magic/";
      materialFormData.imageUrl = "images/material/220.jpg";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }

}