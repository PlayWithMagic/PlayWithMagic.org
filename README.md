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
The application will be deployed through the [Hiroku Cloud Platform](https://www.heroku.com).

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

Bugs and Feature Requests
-------------------------
Got a bug or a feature request?  We'd like to hear it!  [Click here to open an issue.](https://github.com/pkarjala/PlayWithMagic/issues/new "New Issue")

Known Bugs
----------
 * None... yet

Creators
--------
#### Patrick Karjala
 * [Website](http://patrickakarjala.wordpress.com)
 * [GitHub](https://github.com/pkarjala/)
 * [pkarjala@hawaii.edu](mailto:pkarjala@hawaii.edu)

#### David Neely
 * [Website](http://davidneely.wordpress.com)
 * [GitHub](https://github.com/davidkneely)
 * [davidics613@gmail.com](mailto:davidics613@gmail.com)


#### Mark Nelson
 * [Website](http://mark.nelson.engineer)
 * [GitHub](https://github.com/marknelsonengineer)
 * [marknels@hawaii.edu](mailto:marknels@hawaii.edu)


Credits and Acknowledgements
-----------------------------
The authors would like to thank the University of Hawaii, the UH Department Information and Computer Science and Dr. Philip Johnson for their support during the development of this project.

The Three Prime Directives
--------------------------
1. The system successfully accomplishes a useful task.
  * An online catalog of both your own effects and others' effects
  * A tool for choreographing effects into saved sets
  * A recommender engine for adding previously unknown effects into sets
2. An external user can successfully install and use the system.
  * The application will be cloud based
  * The only client-side software requirements is a browser
  * The client-side hardware requirement for full functionality is a desktop or tablet
3. An external developer can successfully understand and enhance the system.
  * Sufficient documentation will be provided

