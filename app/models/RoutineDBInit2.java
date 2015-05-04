package models;

import views.formdata.RoutineFormData;

/**
 * Initialize the Routine in-memory database.
 */
public class RoutineDBInit2 {

  /**
   * Populate a routine.
   */
  public static void init20() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("3 Long Ropes", "My uncle taught me this Routine when I was in elementary school. Take "
        + "three different lengths of rope, and magically make them all the same length!", 5);

    routine.setMethod("Two of the lengths are cut in such a way that when crossed behind the hand, it appears that"
        + "the three ropes are now the same length.");

    routine.setHandling("Take the time to let the audience inspect each piece of rope, and don't rush!");
    routine.setResetDuration(2);
    routine.setResetDescription("Instantly resets.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/7Tej0-P8zd0");

    routine.setImageUrl("images/routines/412.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("1 length of rope");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/408.jpg");
    material.setDescription("Can be done with any length of rope purchased at a hardware store.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init21() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Blind", "Two decks with different colored backs are introduced. You ask your "
        + "spectator to choose any card and place it on top of your pack. You do the same. To everyone's amazement, "
        + "BOTH cards match.\n A free choice from the spectator leads to one impossible conclusion.\n BLIND is a "
        + "modern take on a timeless prediction plot, done under impossible conditions. NO duplicates. NO doubles. "
        + "NO possible explanation.", 2);

    routine.setMethod("Learn the method at https://store.theory11.com/products/blind-daniel-madison");

    routine.setHandling("Be sure that the participant doesn't look at the decks!");
    routine.setResetDuration(10);
    routine.setResetDescription("Need to reset both decks to perform the trick again.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/xW1sVasRkS8");

    routine.setImageUrl("images/routines/413.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Cards");
    material.setIsInspectable(false);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(20);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/1.jpg");
    material.setDescription("Requires two decks of different colors; purchase price is for one deck.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init22() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Stairway", "An ordinary bill is borrowed from your spectator - then folded over the "
        + "bottom of two rubberbands being held at the fingertips and paperclipped to ensure full security. "
        + "Additionally, a member of your audience pinches the bottom of the bill to dissolve any doubts. "
        + "NO funny business.\n What happens next is practical, impromptu, visual magic at its best.\n"
        + "One-by-one, the bill travels up both rubberbands with just a flick of the wrist, coming to rest on the "
        + "very top strand. Three penetrations done in ten seconds time, under impossible conditions. For the finale, "
        + "the bill travels back down the bands slowly and visually - ending where it originally started.", 2);

    routine.setMethod("Learn the method at https://store.theory11.com/products/blind-daniel-madison");

    routine.setHandling("Be patient and go slow with the rubber band setup; you don't want to flub it.");
    routine.setResetDuration(5);
    routine.setResetDescription("Need to set up the rubber bands again.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/yub_tOwdS9o");

    routine.setImageUrl("images/routines/414.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Rubber Band");
    material.setIsInspectable(true);
    material.setIsGivenAway(true);
    material.setIsConsumed(false);
    material.setPrice(1);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/401.jpg");
    material.setDescription("A simple rubber band; the cost is for a bag.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init23() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Breach", "Any playing card is selected and placed face up on top of the deck. The pack "
        + "is lowered beneath a glass surface or tabletop and the selection visually penetrates up through the "
        + "glass.\n Without warning, it immediately melts back down through the table again.\n BREACH is an "
        + "incredibly visual card penetration that happens with little cover using ANY glass tabletop or surface. "
        + "This is what card magic is supposed to look like.", 2);

    routine.setMethod("Learn the method at https://store.theory11.com/products/breach-daniel-madison");

    routine.setHandling("As always this requires good control with the cards.  A clear table is also required, just "
        + "make sure that if it's glass you don't break it!");
    routine.setResetDuration(5);
    routine.setResetDescription("Needs a fresh deck of cards if any of them were signed as part of this routine.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/kDWOE0-xTX0");

    routine.setImageUrl("images/routines/415.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(20);
    material.setPurchaseUrl("");
    material.setImageUrl("images/material/1.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init24() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Free Will", "Three wooden tokens are shown and mixed, face down by the audience.  "
        + "A prediction is shown and placed, face down, onto the table.  The audience member chooses a token for "
        + "themselves, one for another spectator and one for the bag that the chips were taken from.  Amazingly, "
        + "even though the audience member had freewill, the prediction is perfectly accurate.\n Works EVERY "
        + "time with NO sleight of hand. Very, very easy to perform", 2);

    routine.setMethod("The method for this routine may be purchased as a kit at "
        + "http://www.grandillusions.com/product/free-will/");

    routine.setHandling("You can really embellish on the presentation of this routine by making great stories for it!");
    routine.setResetDuration(10);
    routine.setResetDescription("Requires the bag trick to be reset after each performance, along with any props.");
    //routine.setYouTubeUrl(null);

    routine.setImageUrl("images/routines/416.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Free Will Packet");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(18);
    material.setPurchaseUrl("http://www.grandillusions.com/product/free-will/");
    material.setImageUrl("images/material/409.jpg");
    material.setDescription("Everything needed is included in the kit.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init30() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Double Exposure", "A mind-blowing new take on a classic effect. Double Exposure "
        + "by Asi Wind is a reality altering version of Triumph that happens within a borrowed camera under your "
        + "spectators complete control.", 2);

    routine.setMethod("");

    routine.setHandling("There are no gimmicks or special applications needed. 100% impromptu. "
        + "Just you, a deck of cards, and a borrowed camera are all that's necessary.");
    routine.setResetDuration(5);
    routine.setResetDescription("No need to reset. Just give phone back to participant.");

    routine.setImageUrl("images/routines/300.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("iPhone");
    material.setIsInspectable(true);
    material.setIsGivenAway(true);
    material.setIsConsumed(false);
    material.setPrice(600);
    material.setPurchaseUrl("http://store.apple.com/us/iphone");
    material.setImageUrl("images/material/300a.jpeg");
    material.setDescription("A standard iPhone.");

    routine.getMaterials().add(material);

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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

    routine = new Routine("A.A.C.A.A.N", "From one spectator, any card is named. From a different spectator, "
        + "a number one through fifty-two is named. With absolutely nothing to suspect, the named card appears "
        + "at exactly the number named. A probability so impressive only magic can explain it. "
        + "This is Any Card at Any Number, for real.", 2);

    routine.setMethod("");

    routine.setHandling("");
    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into card box.");

    routine.setImageUrl("images/routines/301.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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

    routine = new Routine("Peregrine Pass", "It's not often we stumble upon a secret technique that looks "
        + "authentic to the natural action taking place, in this case - closing a spread of cards. With the "
        + "Peregrine Pass, what happens \"behind the scenes\" when compared to the polished performance is "
        + "night and day. This is sleight of hand at its finest!", 2);

    routine.setMethod("This. Is. Awesome. Incredible. Beautiful. Devastating. EASY!!!! If you have had some "
        + "experience with card manipulation, you can do the Peregrine Pass. The method is so gorgeous it's not "
        + "even right...you WILL have the mechanics down in under 8 minutes, and if you do this in front of "
        + "a mirror, you'll fool yourself! I most definitely will be using this, it's a worker. Five stars.");

    routine.setHandling("");
    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into card box.");

    routine.setImageUrl("images/routines/302.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init33() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Flux Deal", "A diabolical switch that allows for the seamless and constant change of "
        + "cards dealt onto the table. Switch one card or many cards, cause cards to visually change, force cards, "
        + "and more. The Flux Deal is great for mathematical tricks, gambling demonstrations, and transpositions. "
        + "The possibilities are endless! The deal is not only imperceptible, but indistinguishable. With practice, "
        + "the switch will even fool you.", 2);

    routine.setMethod("I find the grip hard to execute because my forefinger isn't long enough to hold the cards "
        + "steady. I can hold the cards with my middle finger but then it´s hard to execute the following move "
        + "so I think it's only for people with big hands.");

    routine.setHandling("");
    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into card box.");

    routine.setImageUrl("images/routines/303.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init34() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Slipshift", "The Slipshift is a visual color change done at the fingertips. "
        + "Within this video Chris explains several variations of the change along with a method to control "
        + "a selected card to the top of the deck.", 2);

    routine.setMethod("Being able to change a card right in front of the spectators face is one of the strongest "
        + "effects there are. I would say this is a must have but only for more advanced magicians.");

    routine.setHandling("");
    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into card box.");

    routine.setImageUrl("images/routines/304.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init35() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Recharmed, I'm Sure!", "One at a time, three Chinese coins hanging on a length "
        + "of string magically come off right before your eyes. With each phase progressively appearing more "
        + "impossible, the third and final coin is held at the fingertips and visibly melts right through the "
        + "string and then back on again. Finally, it vanishes completely, reappearing with the other two on "
        + "a table.", 2);

    routine.setMethod("");

    routine.setHandling("The performers shows three coins and a length of string. All can be freely examined "
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
        + "two, in plain view.");

    routine.setResetDuration(1);
    routine.setResetDescription("Put coins back into coin purse. Recoil string.");

    routine.setImageUrl("images/routines/305.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Chinese Coin set");
    material.setIsInspectable(false);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(25);
    material.setPurchaseUrl("http://shop.dananddave.com/recharmed-lance-pierce.html");
    material.setImageUrl("images/material/305.png");
    material.setDescription("Set of three chinese coins and piece of string.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init36() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("King Brand", "Visually dynamic, the effect couldn't be simpler: The deck is removed "
        + "and only four cards are presented, the two red Kings and and the two black fours. With one pair "
        + "sandwiched between the other, they visually trade places under impossible conditions. "
        + "The plot builds in three phases with the final trasposition happening in a spectators own hand.", 2);

    routine.setMethod("Three phase, sleight heavy, and super deceptive.");

    routine.setHandling("");

    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into deck.");

    routine.setImageUrl("images/routines/306.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init37() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Gödel", "Gödel is an innovative face-up color change from the mind of Alexander "
        + "Hansford. With a wave of the hands, cards transform under direct scrutiny. Not only will you receive "
        + "two additional routines with your purchase, Twisting and Sandwich, you’ll find Gödel to be an "
        + "incredible utility for the effects you already perform.", 2);

    routine.setMethod("");

    routine.setHandling("After having two cards selected and lost in the pack, two black Jacks are waved "
        + "above the deck only to have one of the selections appear between them. Both sides are shown "
        + "throughout the effect, destroying any guess your spectator might have towards the method. "
        + "With one final and extremely open wave, the selection between the Jacks changes to the other "
        + "for an astonishing finish.");

    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into deck.");

    routine.setImageUrl("images/routines/307.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init38() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Spring St. Aces", "As the cards are sprung face up from hand to hand, the dealer "
        + "is able to stop dead on an Ace. This is repeated three more times until all four Aces have been found. "
        + "An impeccable feat to say the least.", 2);

    routine.setMethod("");

    routine.setHandling("");

    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into deck.");

    routine.setImageUrl("images/routines/308.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init39() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Diagonal Palm Shift", "First published in 1902 by S.W. Erdnase, the Diagonal Palm "
        + "Shift - a secret maneuver for bottom palming a selected card placed into the middle of the deck - "
        + "is explained in detail by one of this generations most beloved sleight of hand artists, Ricky Smith.", 2);

    routine.setMethod("");

    routine.setHandling("");

    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into deck.");

    routine.setImageUrl("images/routines/309.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init40() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Vernon One-Hand Table Shuffle", "We originally learned this technique from Vernon's "
        + "book, Ultimate Secrets of Card Magic (1967); however it wasn't until we saw a video of Ross Bertram "
        + "performing the shuffle perfectly that we began to take interest. What you see before you is our own "
        + "handling created to achieve the perfect one-for-one riffle along with various subtleties acquired "
        + "from years of practice.", 2);

    routine.setMethod("");

    routine.setHandling("");

    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into deck.");

    routine.setImageUrl("images/routines/310.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init41() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("WeFlex", "A remarkable transformation of a playing card unlike any other. Taking "
        + "place away from the deck, WeFlex is a single-card color change. It all happens at the fingertips, "
        + "so it's all very open. With apparently just the flexing of a card back and forth, it changes right "
        + "before your eyes. WeFlex is as beautiful as it is graceful, and in our opinion is one of the most "
        + "elegant and magical color change ever created.", 2);

    routine.setMethod("");

    routine.setHandling("It is not angle proof but its easy to get right after practice in the mirror. "
        + "This isn't the easiest to pull off smoothly and will take some time");

    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into deck.");

    routine.setImageUrl("images/routines/311.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init42() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Catch 23", "Perfect for shows small and large, Asi’s Catch 23 creates a connection "
        + "between the performer and the audience that few effects have the ability to do. Catch 23 has been an "
        + "integral part of Asi’s live shows for years. Today he offers it to us. Asi’s creative ingenuity and "
        + "passion for magic has advanced our art ten-fold. This newest addition to an overwhelming collection "
        + "is nothing short of brilliant.", 2);

    routine.setMethod("");

    routine.setHandling("A performer invites four spectators to the stage. After cleanly showing five envelopes "
        + "that have be previously marked “1-5,” each spectator is asked to make a decision which number envelope "
        + "they’d like. This is a completely free choice. The performer having been left with the single envelope "
        + "not selected, invites an audience member to remove its contents. Within, they’ll be astonished to find "
        + "a check for the exact amount created by the envelope order of the participants on stage. In addition, "
        + "each volunteer is asked to open their selected envelops where a note card states a distinguishing "
        + "feature about them (i.e. This will be selected by the only man in glasses). The effect culminates "
        + "as the last envelope to be opened reveals the name of the participant who has made its selection.");

    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into deck.");

    routine.setImageUrl("images/routines/312.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Evidence bag and cards");
    material.setIsInspectable(false);
    material.setIsGivenAway(true);
    material.setIsConsumed(true);
    material.setPrice(50);
    material.setPurchaseUrl("http://shop.dananddave.com/catch23-asi-wind.html");
    material.setImageUrl("images/material/312.png");
    material.setDescription("Evidence bag and cards with descriptions of participants.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init43() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Triumph and Triumph Again", "Two spectators are asked to make separate selections- "
        + "one to be placed immediately face down, the other remembered. The pack is then shuffled face-up and "
        + "face-down, only to be spread moments later to show the cards have returned to normal face-down position, "
        + "except for twelve like-suited cards in order! It’s discovered that the card needed to complete the "
        + "sequence is the one that’s been on the table since the start of the effect. A spectator is then invited "
        + "to shuffle the pack themselves, and the trick is repeated to reveal the second selection of an entirely "
        + "different suit. Finally, the first selection transforms into the second for a startling conclusion.", 2);

    routine.setMethod("The method is smart and fun to pull off. With so many different forms of Triumph out "
        + "there, it can be easy to assume you know all you need to, but the second wave of this trick amplifies "
        + "the effect phenomenally.");

    routine.setHandling("");

    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into deck.");

    routine.setImageUrl("images/routines/313.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init44() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Trigger", "Trigger is a stunning and surprising effect that looks like trick "
        + "photography. The solution is impossible to reconstruct, yet seems fair and is easily achieved.", 2);

    routine.setMethod("After a card is shuffled into the center, the deck is wrapped tightly with a rubber "
        + "band, sealing the card within. At your command, the band passes through the entire deck with the "
        + "exception of a single card, which shoots out from the center for a dynamic and visual effect.");

    routine.setHandling("");

    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into deck.");

    routine.setImageUrl("images/routines/314.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init45() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Static", "With the spectator's finger touching the top of the deck, the deck slowly "
        + "splits itself in half. With a delicate touch, their chosen card shoots out of the pack. The deck is "
        + "completely examinable before and after the effect. They will find nothing. They will have no "
        + "explanation.", 2);

    routine.setMethod("");

    routine.setHandling("");

    routine.setResetDuration(1);
    routine.setResetDescription("Put cards back into deck.");

    routine.setImageUrl("images/routines/315.png");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
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
  public static void init201() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Slydini's Knotted Slilks", "I've wanted to learn this trick for a long time.  It's "
        + "a 4 stage trick but it has over 60 moves to it.  The essence of the trick is that two silks are tied "
        + "together with a solid knot, then magically, the silks come apart.", 12);

    routine.setMethod("Go buy the book.");
    routine.setHandling("Again, go buy the book.");
    routine.setResetDuration(0);
    routine.setResetDescription("It resets instantly and all of the silks can be examined");
    routine.setYouTubeUrl("https://www.youtube.com/embed/-HbTQA_4btQ");

    routine.setImageUrl("images/routines/206.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Two silk scarves");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("http://www.grandillusions.com/product/silk-18-inch/");
    material.setImageUrl("images/material/210.gif");
    material.setDescription("The best material to use is strong nylon.  Cotton and Japanese silks don't work well.");

    routine.getMaterials().add(material);
  }

  /**
   * Populate a routine.
   */
  public static void init202() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Blendo", "This is a good parlor routine.  The magician removes three 24\" colorful "
        + "silks from a black, slik bag.  The silks are inspected and a spectator puts the silks into the bag and "
        + "'mixes' them.  The magician reminds the audience that the United States is a mixture of many, many "
        + "world cultures and the three silks are red, white and blue.  The three mixed silks are then instantly "
        + "combined to produce an american flag.", 4);

    routine.setMethod("Get a blendo bag and some silks.  Learn to fold the blendo bag.");
    //routine.setHandling("");
    routine.setResetDuration(10);
    routine.setResetDescription("It takes awhile to fold the bag.  Also, make sure the silks are not wrinkly.");
    //routine.setYouTubeUrl("https://www.youtube.com/embed/-HbTQA_4btQ");

    routine.setImageUrl("images/routines/207.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Three 18\" silk scarves: Red, White and Blue");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(8);
    material.setPurchaseUrl("http://www.grandillusions.com/product/silk-18-inch/");
    material.setImageUrl("images/material/210.gif");
    //material.setDescription("The best material to use is strong nylon.  Cotton and Japanese silks don't work well.");

    routine.getMaterials().add(material);

    material = new Material("A blendo bag");
    material.setIsInspectable(false);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(30);
    material.setPurchaseUrl("http://www.grandillusions.com/product/american-flag-blendo/");
    material.setImageUrl("images/material/211.jpg");
    //material.setDescription("");

    routine.getMaterials().add(material);
  }


  /**
   * Populate a routine.
   */
  public static void init203() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Lucifer's Wallet", "Remove your wallet.  Set it on fire, remove a burning business "
        + "card.  Blow it out.  Snuff out the fire in your wallet.  Hand out the still-warm card -- without a "
        + "singe mark on it.  Let the audience look at the wallet.", 1);

    routine.setMethod("Very carefully -- you're literally playing with fire.");
    //routine.setHandling("");
    routine.setResetDuration(5);
    //routine.setResetDescription("");
    routine.setYouTubeUrl("https://www.youtube.com/embed/O_McHgSfkf4");

    routine.setImageUrl("images/routines/208.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Lucifer's wallet");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(30);
    material.setPurchaseUrl("http://www.themagicdepot.com/product_info.php?products_id=6365");
    material.setImageUrl("images/material/212.jpg");
    //material.setDescription("");

    routine.getMaterials().add(material);

    material = new Material("Lighter fluid");
    material.setIsInspectable(false);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(5);
    material.setPurchaseUrl("http://www.amazon.com/Zippo-3165-Lighter-Fluid-12OZ/dp/B000K2U3JG");
    material.setImageUrl("images/material/213.jpg");
    //material.setDescription("");

    routine.getMaterials().add(material);

    material = new Material("Business card");
    material.setIsInspectable(true);
    material.setIsGivenAway(true);
    material.setIsConsumed(true);
    material.setPrice(1);
    //material.setPurchaseUrl("");
    material.setImageUrl("images/material/214.jpg");
    //material.setDescription("");

    routine.getMaterials().add(material);
  }


  /**
   * Populate a routine.
   */
  public static void init204() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("The Magic Project Plan", "\"The hardest part of a project is the beginning.  The fear of "
        + "the blank page\"... thumb through a `book` full of empty pages.  Then have a project manager sprinkle some "
        + "fairy dust on it and thumb through the book again -- this time it's full of charts and graphs.  Finally "
        + "have a programmer type on the book's cover, and when you thumb through the book, it's full of code.", 4);

    routine.setMethod("I make my books by hand, but the template is a classic Magic Coloring Book");
    routine.setHandling("Oh, so easy.  Go visit your local magic shop and they'll set you up.");
    //routine.setResetDuration(1);
    routine.setResetDescription("The routine itself resets instantly.  It takes me a couple of hours and a trip "
        + "to Kinkos to make my book.");
    routine.setYouTubeUrl("https://www.youtube.com/embed/bwCdRbJEJmU");

    routine.setImageUrl("images/routines/209.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("A gaff book");
    material.setIsInspectable(false);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(10);
    material.setPurchaseUrl("http://www.grandillusions.com/product/coloring-book-magic/");
    material.setImageUrl("images/material/215.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);
  }


  /**
   * Populate a routine.
   */
  public static void init205() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Are You Normal... or Are You an Engineer?", "Inspired by one of my favorite magicians "
        + "Mr. David Regal.  This routine uses a Wellington Switchboard and consists of three phases.  The first "
        + "phase introduces the switchboard... four colored lights and four colored switches.  Whenever the normal "
        + "person is asked to throw a switch the light corresponding to the switch's color lights up.  Whenever "
        + "the engineer throws a switch, the light opposite the switch lights up.", 10);

    //routine.setMethod("");
    //routine.setHandling("");
    //routine.setResetDuration(1);
    routine.setResetDescription("Resets instantly");
    //routine.setYouTubeUrl("https://www.youtube.com/embed/");

    routine.setImageUrl("images/routines/210.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Wellington Switchboard");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(400);
    material.setPurchaseUrl("http://www.wellingtonent.com/products/mswitchb.html");
    material.setImageUrl("images/material/216.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);
  }


  /**
   * Populate a routine.
   */
  public static void init206() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("French Kiss", "This is a classic double-turnover routine that I originally found in "
        + "The Royal Road to Card Magic.  However, Wayne Houchin's version is edgy, fun and is my closer.  Thank you, "
        + "Wayne.  It's a transposition effect where a spectator's signed card, is transposed with the magician's "
        + "signed card.", 4);

    routine.setMethod("A flawless double turnover");
    routine.setHandling("");
    routine.setResetDuration(2);
    routine.setResetDescription("I just can't bring myself to post it");
    routine.setYouTubeUrl("https://www.youtube.com/embed/9HfWyW49-v4");

    routine.setImageUrl("images/routines/211.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(true);
    material.setIsConsumed(true);
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
  public static void init207() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Three Fly", "Poker chips (or coins) fly from one hand to the other... and back.", 2);

    routine.setMethod("You can get that from Lee.");
    routine.setHandling("Checkout Lee Asher's performance of this routine 2:47 into the video...");
    routine.setResetDuration(1);
    routine.setResetDescription("");
    routine.setYouTubeUrl("https://www.youtube.com/embed/1dTXKKGR06A");

    routine.setImageUrl("images/routines/217.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("At least four poker chips");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(20);
    material.setPurchaseUrl("http://www.leeasher.com/store/tricks/three_stylin.html");
    material.setImageUrl("images/routines/217.jpg");
    material.setDescription("Get some big, colorful, high-contrast, authentic chips from a Macau or Vegas casino.");

    routine.getMaterials().add(material);
  }


  /**
   * Populate a routine.
   */
  public static void init208() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Witness", "A spectator seals a 'wild joker' in a zip-lock bag.  The spectator then "
        + "selects a card an puts it in the deck.  Suddenly, the card is in the zip-lock bag.", 1);

    routine.setMethod("See Lee's website...");
    //routine.setHandling("");
    routine.setResetDuration(2);
    //routine.setResetDescription("");
    routine.setYouTubeUrl("https://www.youtube.com/embed/2N75cJHrkpc");

    routine.setImageUrl("images/routines/218.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("The Widness DVD");
    material.setIsInspectable(false);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(20);
    material.setPurchaseUrl("http://www.leeasher.com/store/media/witness.html");
    material.setImageUrl("images/routines/218.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);

    material = new Material("A ziplock bag");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(5);
    //material.setPurchaseUrl("");
    material.setImageUrl("images/material/217.jpg");
    material.setDescription("Just a regular ziplock bag");

    routine.getMaterials().add(material);

    material = new Material("Deck of Cards");
    material.setIsInspectable(true);
    material.setIsGivenAway(true);
    material.setIsConsumed(true);
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
  public static void init209() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Marked Cards", "This isn't exactly a magic trick, but it's a nice intersticial bit "
        + "I'll do.  Basically, I hand out cards from a blue-backed Fornier 505 deck.  The cards are marked, but "
        + "about 90% of the time, the audience can't find the markings.  I use the time to talk about cards and "
        + "card games.  I tend to do it when I'm getting burned by an audience and I want to bring the tension down "
        + "a bit.  Sometimes, I'll do it to demonstrate that this isn't supernatural.  Other times, I'll do it "
        + "to make an audience member feel special or not foolish.", 5);

    //routine.setMethod("");
    routine.setHandling("Just be yourself.");
    //routine.setResetDuration(1);
    //routine.setResetDescription("");
    //routine.setYouTubeUrl("https://www.youtube.com/embed/");

    routine.setImageUrl("images/material/219.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Blue Fournier 505 Deck");
    material.setIsInspectable(true);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(10);
    material.setPurchaseUrl("http://www.amazon.com/Fournier-Standard-Decks-Playing-Cards/dp/B000XZ0944/ref=sr_1_1?ie"
        + "=UTF8&s=toys-and-games&qid=1203992691&sr=8-1");
    material.setImageUrl("images/material/219.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);
  }


  /**
   * Populate a routine.
   */
  public static void init210() {
    Routine routine = null;
    Material material = null;
    long id;

    routine = new Routine("Cocoa", "I don't perform this trick... yet.  I saw David Regal perform it at a lecture "
        + "once and it's burned into my mind.  Basically, these marshmallows are coming and going out of a cup "
        + "of hot chocolate.", 10);

    routine.setMethod("Get David's book Approaching Magic");
    //routine.setHandling("");
    //routine.setResetDuration(1);
    routine.setResetDescription("The damn thing self-resets");
    //routine.setYouTubeUrl("https://www.youtube.com/embed/");

    routine.setImageUrl("images/routines/220.jpg");

    routine = RoutineDB.saveRoutineFromForm(new RoutineFormData(routine));

    material = new Material("Approaching Magic");
    material.setIsInspectable(false);
    material.setIsGivenAway(false);
    material.setIsConsumed(false);
    material.setPrice(65);
    material.setPurchaseUrl("http://davidregal.com/approaching-magic/");
    material.setImageUrl("images/material/220.jpg");
    material.setDescription("");

    routine.getMaterials().add(material);
  }

}
