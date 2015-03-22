PlayWithMagic
=============

PlayWithMagic is a web-based application that catalogs magic tricks and helps magicians build shows.

[Check out the prototype here](http://mark.nelson.engineer/PlayWithMagic/mockup/)

TODO:  Add screenshot 1

TODO:  Add screenshot 2

TODO:  Add screenshot 3

Overview
--------
We're looking for a few good tricks.

It's not difficult to learn a magic trick.  The hard part is choreographing a show from a set of routines.
Over their careers, magicians see countless acts, learn thousands of methods, slights, banter and gaffs
(collectively called routines).  This web application allows magicians to catalog their routines.  Magicians
can cite where they learned it, who or what influenced it and how they personalized it.  Magicians
have the option to share their routines with others.  The benefit of cataloging routines is access the crowdsourced
pool of routines that feed a “Set Builder”.  The set builder filters routines and sequences them into a cohesive set.
Magicians can identify routines for their set by searching the catalog and adding them into a shopping cart.  A routine
recommendation engine could prompt magicians to consider routines that are popular, utilize similar materials or take
them out of their comfort zone.

Approach
--------
This section describes the approach you are taking in this system to address the problem.

### User Experience
This web application has a dynamic, database-driven, responsive user interface.  It uses traditional
metaphors such as a top navigation bar and familiar iconography.  The user interface has web-forms for
input, tactile controls such as sliders and movable objects.  The set builder allows magicians to drag
routines from a dock into a set.  Routines can be visually rearranged and contain visual cues as to
length or difficulty.

The application is fully usable from a desktop or tablet.  Mobile platform users can view sets, but not modify them.

### Application Runtime Environment
The application runs through the [Play Framework](https://www.playframework.com).  The Play Framework provides
both a webserver (TODO: Production quality?) and an application runtime framework.

The application draws on unmodified [JQuery](http://jqueryui.com), [Bootstrap](http://getbootstrap.com),
[Bootswatch](https://bootswatch.com), [Font Awesome](http://fontawesome.io/icon/cog/) and
[Google Font](http://www.google.com/fonts) tools directly from their CDN servers.

### Application Deployment Environment
The application is deployed through the [Heroku Cloud Platform](https://www.heroku.com).
Information about the deployment, development and design of the application can be found at the [PlayWithMagic
Developer's Wiki hosted on GitHub](https://github.com/pkarjala/PlayWithMagic/wiki/Developer-Guide).

### Application Development Environment
The application was developed with [IntelliJ](https://www.jetbrains.com/idea/) IDE and uses
[SBT](http://www.scala-sbt.org) for the build engine.  Version control is maintainedthrough
[GitHub](https://github.com).

### Application High-Level Design
The model revolves around three central entities:
1. Routines (A single magic trick)
2. Sets (An personalized, ordered collection of routines)
3. Magicians/Users

Bugs and Feature Requests
-------------------------
Got a bug or a feature request?  We'd like to hear it!  [Click here to open an issue.](https://github.com/pkarjala/PlayWithMagic/issues/new "New Issue")

Known Bugs
----------
[An up-to-date list of issues can be found at the PlayWithMagic website.](https://github.com/pkarjala/PlayWithMagic/issues)

Creators
--------
 * Patrick Karjala
 * David Neely
 * Mark Nelson

[Checkout the Contact Us page on the PlayWithMagic Wiki](https://github.com/pkarjala/PlayWithMagic/wiki/Contact-Us)

Credits and Acknowledgements
-----------------------------
The authors would like to thank the University of Hawaii, the UH Department Information and Computer Science and Dr. Philip Johnson for their support during the development of this project.

Consulting Magicians
--------------------
 * [Lee Asher](http://leeasher.com)
 * [Mark Nelson](http://mark.nelson.engineer/wordpress/index.php/magic-home-page/)


The Three Prime Directives
--------------------------
1. The system successfully accomplishes a useful task.
  * An online catalog of your own routines
  * Ability to find others' routines
  * A tool for choreographing routines into saved sets
  * A recommender engine for adding previously unknown routines into sets
2. An external user can successfully install and use the system
  * The application will be cloud based
  * The only client-side software requirements is a browser
  * The client-side hardware requirement for full functionality is a desktop or tablet
3. An external developer can successfully understand and enhance the system
  * Documentation can be found on the Wiki and will be enough to allow a competent developer to make enhancements

