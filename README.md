PlayWithMagic
=============

PlayWithMagic is a web-based application that catalogs magic tricks for magicians and helps them build shows.

[Check out the prototype here](http://mark.nelson.engineer/PlayWithMagic/mockup/)

TODO:  Add screenshot 1

TODO:  Add screenshot 2

TODO:  Add screenshot 3

Overview
--------
We're looking for a few good tricks.

It's not difficult to learn a magic trick.  The hard part is choreographing a show from a set of routines.
Over their careers, magicians see countless routines, learn thousands of methods, slights, banter and gaffs
(collectively called routines).  This web application allows magicians to catalog routines.  Magicians
can cite where they learned it, who or what influenced it and how they personalized it.  Magicians
have the option to share their routines with others.  Some routines work well with others and this web application will
help magicians find complementary routines.  The benefit of cataloging routines is access the crowdsourced pool that
feed a “Set Builder”.  The set builder filters routines and sequences them into a cohesive set.  Magicians can identify
routines for their set by searching the catalog and adding them into a shopping cart.  A routine recommendation engine
could prompt magicians to consider routines that are popular, utilize similar materials or take them out of their
comfort zone.

Approach
--------
### User Experience
This web application has a dynamic, database-driven, responsive user interface.  It uses traditional
metaphors such as a top navigation bar and familiar iconography.  The user interface will use web-forms for
input, tactile controls such as sliders and movable objects.  For example, the set builder interface has users drag
routines from a dock into a set.  Routines in a set can be rearranged.  Routines have visual cues as to
length or difficulty.

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
1. Routines
2. Sets (An personalized, ordered collection of routines)
3. Magicians/Users

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

Bugs and Feature Requests
-------------------------
Got a bug or a feature request?  We'd like to hear it!  [Click here to open an issue.](https://github.com/pkarjala/PlayWithMagic/issues/new "New Issue")

Known Bugs
----------
[A list of issues can be found at the PlayWithMagic website.](https://github.com/pkarjala/PlayWithMagic/issues)

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
  * An online catalog of both your own routines and others' routines
  * A tool for choreographing routines into saved sets
  * A recommender engine for adding previously unknown routines into sets
2. An external user can successfully install and use the system.
  * The application will be cloud based
  * The only client-side software requirements is a browser
  * The client-side hardware requirement for full functionality is a desktop or tablet
3. An external developer can successfully understand and enhance the system.
  * Documentation can be found at the 

