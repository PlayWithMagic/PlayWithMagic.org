PlayWithMagic
=============

PlayWithMagic is a web-based application that catalogs magic tricks and helps magicians build shows.

[Check out the prototype here](http://mark.nelson.engineer/PlayWithMagic/mockup/)

![Home Page](https://github.com/pkarjala/PlayWithMagic/blob/master/doc/images/README-Home.png "Home Page")

Overview
--------
_We're looking for a few good routines._

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
The web application revolves around three entities:  Magicians, Routines and Sets.  A magician creates an account
and enters profile information about themselves.  Magicians create routines, search others' routines and link
routines together.  Finally, magicians can compose sets.  Sets consist of:
  * Information unique to the set (venue, expected duration, type, etc.).
  * An interface for finding candidate routines:  A search/filter tool that allows magicians to put any shared routines
    in the applicaiton's catalog into a 'shopping cart'.  This tool will have a recommender engine to help magicians
    find routines that they may not have picked out on their own.
  * A set-builder canvas that allows magicians to drag routines from a dock (the results of the picker) into a
    visual representation of the set.  Routines can be reordered, moved back to the dock, etc.
  * Indicators/status to help magicians understand certain rules such as:  Set duration, avoid repeating the same effect
    throughout a set, cost of production, etc.

![Routine Page](https://github.com/pkarjala/PlayWithMagic/blob/master/doc/images/README-Routine.png "Routine Page")

### Use Cases
[Several use cases are documented in the Wiki.](https://github.com/pkarjala/PlayWithMagic/wiki/Use-Cases)

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
[SBT](http://www.scala-sbt.org) for the build engine.  Version control is maintained through
[GitHub](https://github.com).

### Application High-Level Design
The model revolves around three central entities:
1. Routines (A single magic trick)
2. Sets (An personalized, ordered collection of routines)
3. Magicians/Users

The application will use a Model-View-Controller (MVC) design pattern.  The application will be designed with rapid
prototyping in mind and will consequently rely on unit, integration and application tests to maintain a high level
of quality at each release.

Milestones
----------
### Mockup
Due:  25 March
  + A responsive, non-dynamic (no Java software) representation of the major elements of the application.
  + A README.md file
  + A viable GitHub project
    - Source code
    - Issue tracker
    - Wiki content

### Deliverable 1
Due:  8 April (2 weeks after Mockup)
  + Established Look & Feel
  + Consistent Navigation
  + CRUD capable entities against an in-memory database w/ 2-3 users pre-populated)
    - User Profile
    - User Routines

### Deliverable 2
Due:  22 April (2 weeks after Deliverable 1)
  + Refactor the model into a database-backed system
  + Increase the number of saved users & routines
  + Find & Save routines
  + CRUD capable Set management

### Deliverable 3
Due:  6 May (2 weeks after Deliverable 2)
  + Library mockup (not complete implementation)
  + Recommender engine mockup

### Final Project Due
Due:  13 May (1 week after Deliverable 3)

Update documentation, final fit-and-finish.
=======
PlayWithMagic is a web-based application that catalogs magic tricks for magicians and helps them build shows.

[Check out the prototype here](http://mark.nelson.engineer/PlayWithMagic/mockup/)

TODO:  Add screenshot 1

TODO:  Add screenshot 2

TODO:  Add screenshot 3

Overview
--------
We're looking for a few good tricks.

It's not difficult to learn a magic trick.  The hard part is choreographing together to build a show.
Over their careers, magicians see countless routines, learn thousands of methods, slights, banter and gaffs
(collectively called effects).  This web application allows magicians to catalog their effects.  Magicians
can cite where they learned it, who or what influenced it and how they personalized it.  Magicians
have the option to share their effect with others.  Some effects work well together and the web application will
be able to link effects.  The benefit of cataloging their effects is access the crowdsourced pool of
effects feeding a “Set Builder”.  The Set Builder filters effects appropriate for a desired set and sequences them
into a cohesive routine.  Magicians can identify effects for their set by searching effects in the catalog and adding
them into a shopping cart.  An effect recommendation engine could prompt magicians to consider routines that
work well with the other effects in the set.

Approach
--------
### User Experience
This web application will have a dynamic, database-driven, responsive user interface.  It will use traditional
metaphors such as a top navigation bar and familiar iconography.  The user interface will use web-forms for
input, tactile controls such as sliders and movable objects.  For example, in the Set Builder interface, effects
can be dragged from a dock into the set.  Effects in a set can be rearranged and will have visual cues as to
the length of the effect.

The application will be fully usable in both a desktop and tablet environment.  Mobile platform users will be able
to view sets, but not modify them.

### Application Runtime Environment
The application will run through the [Play Framework](https://www.playframework.com).  The Play Framework provides
both a webserver (production quality?) and an application runtime framework.

The application will also draw on unmodified JQuery, Bootstrap, Bootswatch, FontAwesome and Google Font tools directly
from their CDN servers.

### Application Deployment Environment
The application will be deployed through the [Heroku Cloud Platform](https://www.heroku.com).

### Application Development Environment
The application will be developed on individual Mac systems.
There are no reasons why the application could not be developed on a Windows or Linux platform, but the founding
authors use Macs.
The application will be developed in IntelliJ.  Version control is maintained in GitHub.

Recommended IntelliJ packages include:
XXX

### Application High-Level Design
The model will revolve around three central datasets:
1. Effects
2. Sets
3. Magicians/Users

The

The approach
This section describes the approach you are taking in this system to address the problem. Once again, complete implementation of your approach may require more work than is possible during this semester. Note that it must involve GitHub, the Play Framework, and Twitter Bootstrap. In almost all cases, it should able to be deployed and run from Heroku.

Quick Start
-----------
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras rutrum sem elit, et hendrerit turpis fringilla ac.

Installing Your Own Version
---------------------------
If you want to install this open source application on your own servers, here's how you'd go about it:

1. Send cash...
2. Send beer (it's a form of currency at UH)...
>>>>>>> mockup

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
 * [Aaron Fisher](http://www.aaronfishermagic.com)
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


