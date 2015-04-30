import com.typesafe.config.ConfigFactory;
import models.MagicianType;
import play.Application;
import play.GlobalSettings;
import play.Logger;

/**
 * Global is instantiated by the framework when the application starts.  It performs specific tasks at start-up or
 * shut-down.
 */
public class Global extends GlobalSettings {
  @Override
  public void onStart(Application application) {
    super.onStart(application);

    MagicianType.init();
    //MagicianDB.init();
    //RoutineDB.init();
    //SetDB.init();

    Logger.info(ConfigFactory.load().getString("application.name") + " has started");
  }
}
