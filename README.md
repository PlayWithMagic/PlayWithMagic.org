PlayWithMagic.org
=================

[PlayWithMagic.org](https://www.playwithmagic.org) is a web application that catalogs magic tricks and helps magicians 
build shows.

![alt text](https://github.com/PlayWithMagic/PlayWithMagic.org/raw/master/doc/images/homePageDesktop.png "Logo Title Text 1")

Want to know more about PlayWithMagic?
  * [Go to PlayWithMagic.org now](https://www.playwithmagic.org)
  * [The PlayWithMagic.org Project site](http://playwithmagic.github.io/PlayWithMagic.org/) 
  
Overview
--------

  * [Responsive Layout built on Twitter Bootstrap](http://getbootstrap.com)
  * [Built with Java on the Play Framework](http://playframework.com)
  * [Hosted by Heroku](http://heroku.com)
  * [Makes CSS easier with the LESS transpiler](http://lesscss.org/)
  * [If you're interested, here's the original prototype](http://mark.nelson.engineer/PlayWithMagic/mockup/)

This application uses a Postgres database to catalog Routines and Sets for magicians.  

Tests use a separate, in-memory database and runs within their own application context, separate from both the
production and development environments.

###The Gee Wiz Test and the So What Test
"Geez, this is cool."  That's what we want to hear from our users.  There are a few novel things about this 
website.  According to our consulting magicians, there is no other website that catalogs magic tricks like this.  There 
are plenty of websites with product reviews and forums, but what sets PlayWithMagic apart is
*metadata*: The discrete fields we ask magicians to fill out.  Over time, these fields will become searchable
and will drive all kinds of unique innovations.

Another novelty of the website is the idea that Routines are owned by the magical community — like a Wiki.  _Renditions_ 
of a routine are owned by magicians.

So What?  Well, if you're not a magician, then it's probably not very interesting.  But if you are a magician — 
perhaps one who has grown up in the Internet era — then this is a terrific place to share, to learn and to 
collaborate.

Using PlayWithMagic.org
=======================

Need assistance on using PlayWithMagic.org?
  * [Visit our User Guide](https://github.com/PlayWithMagic/PlayWithMagic.org/wiki/User-Guide).

Contributing to PlayWithMagic.org
=================================

The First Few Things You Should Know as a Project Developer
-----------------------------------------------------------
  * We make extensive use of [GitHub's Issue Tracker](https://github.com/PlayWithMagic/PlayWithMagic.org/issues).
  * The application is based on Java and uses a Model-View-Controller paradigm.
  * The application has three primary entities:  Magicians, Routines and Sets.
    - Routines are not 'owned' by individuals. Any user can contribute to a routine. 
    - Sets are owned by individual users (Magicians).
  * If you want to add a new field, checkout this [tutorial on adding new fields](https://github.com/PlayWithMagic/PlayWithMagic.org/wiki/Developer-Guide:-Add-a-Field).
  * The application uses Chrome and Chrome Driver to run tests.  [Watch them run](https://www.youtube.com/watch?v=wtlIHY4bEaQ).
  

###Documentation
A great place to start is our [Project Wiki](https://github.com/PlayWithMagic/PlayWithMagic.org/wiki).  You'll find
information on setting up your development environment, use cases, programming conventions and major design decisions.

###Support
Have a question?  Found a bug?  Please open an Issue on our [GitHub Issues](https://github.com/PlayWithMagic/PlayWithMagic.org/issues) page.

###License
This project is licensed under the [Apache 2.0 License](https://github.com/PlayWithMagic/PlayWithMagic.org/blob/master/LICENSE).