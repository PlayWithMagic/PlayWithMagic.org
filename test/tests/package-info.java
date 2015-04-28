/**
 * Automated tests for a PlayFramework Model-View-Controller web application.
 *
 * These tests use Chrome and the Chrome Driver to automate tests.
 *
 * Some of these workflows are large because the Play Framework the application restarts between tests -- which wipes
 * out the in-memory database.
 *
 * These tests are designed to run in a fake in-memory database -- not against the production database.
 *
 * The Play Framework normally uses HTMLUnit, but it does not support the formaction attribute of a button...
 * consequently, it can't click the 'Add Material' button and we can't test materials.  After fooling around with
 * a few other drivers, we selected the Chrome Driver.
 *
 * There are instructions in the Project Wiki on how to get the Chrome Driver going, but the simple steps are:
 * 1. Install Chrome into its default location.
 * 2. Download the Chrome Driver.  It's an executable.  Put it anywhere in the path.
 *
 * Also, these test patterns differ slightly from the standard Fluentlenium design pattern.  For PlayWithMagic,
 * we needed to test whole workflows and not just individual pages.  I'm sure there's a way to refactor the pattern
 * to click pages and go to other pages, but we didn't want to get that much into it right now.  Possibly we'll
 * refactor the workflow into Fluentlenium pages some other time.
 *
 * @author Mark Nelson
 * @author David Neely
 * @author Patrick Karjala
 *
 * @see http://www.playframework.com
 * @see http://jqueryui.com/
 * @see http://getbootstrap.com/
 * @see http://fontawesome.io/icon/cog/
 * @see http://www.ics.hawaii.edu
 * @see http://www.fluentlenium.org
 * @see http://junit.org
 * @see http://www.scala-sbt.org
 * @see https://sites.google.com/a/chromium.org/chromedriver/
 *
 * @since 6.0
 */

package tests;