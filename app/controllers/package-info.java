/**
 * Application Controllers for a PlayFramework Model-View-Controller web application.
 *
 * @author Mark Nelson
 * @author David Neely
 * @author Patrick Karjala
 *
 * The way we integrated Materials into Routines needs a little explanation.  Routines and Materials have a chicken-
 * and-egg problem.  Materials are stored in Routine objects.  Routine objects are not created until the Routine is
 * saved at the end of EditRoutine.  You run into trouble when, while you are composing a Routine, you
 * create/edit/delete some Materials.  The Materials want to save themselves in a Routine object that doesn't yet exist.
 *
 * How do we solve this?  Essentially, all of the Material buttons (Add material, Edit and Delete) will post
 * the Routine and save it.  If the Routine is incomplete and had errors, the EditRoutine page won't let you
 * continue to the Add/Edit Materials until the errors are fixed.  This makes sense... the UI is not letting
 * you continue until you have a valid Routine object.
 *
 * You could maintain all of the Material data in RoutineFormData.  Unfortunately, Play/Scala makes it difficult
 * to iterate over and get into the variables.  The easiest way to move forward is to hold Materials in Routine Java
 * objects... and make all of the Materials buttons validate the Routine before saving.
 *
 *
 * @see http://www.playframework.com
 * @see http://jqueryui.com/
 * @see http://getbootstrap.com/
 * @see http://fontawesome.io/icon/cog/
 * @see http://www.ics.hawaii.edu
 * @see http://www.fluentlenium.org
 * @see http://junit.org
 * @see http://www.scala-sbt.org
 *
 * @since 6.0
 */

package controllers;