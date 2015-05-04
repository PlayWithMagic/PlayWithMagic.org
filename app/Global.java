import com.typesafe.config.ConfigFactory;
import models.Magician;
import models.MagicianType;
import models.Material;
import models.Routine;
import models.RoutineDBInit1;
import models.RoutineDBInit2;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import views.formdata.MaterialFormData;
import views.formdata.RoutineFormData;

/**
 * Global is instantiated by the framework when the application starts.  It performs specific tasks at start-up or
 * shut-down.
 */
public class Global extends GlobalSettings {
  @Override
  public void onStart(Application application) {
    super.onStart(application);

    MagicianType.init();
    Magician.init();
    this.initRoutines();
    //SetDB.init();

    Logger.info(ConfigFactory.load().getString("application.name") + " has started");
  }


  /******************************************************************************************************************
   * I N I T I A L I Z E   D A T A B A S E
   ******************************************************************************************************************/

  /**
   * Populate a routine.
   */
  public static void initTemplate() {
    Routine routine;

    RoutineFormData routineFormData = new RoutineFormData();
    // Required fields
    routineFormData.id = 0;
    routineFormData.name = "";
    routineFormData.description = "";
    routineFormData.duration = 1;

    // Optional fields
    routineFormData.method = "";
    routineFormData.handling = "";
    routineFormData.resetDuration = 1;
    routineFormData.resetDescription = "";
    routineFormData.youTubeUrl = "";
    routineFormData.reviewUrl = "";
    routineFormData.inspiration = "";
    routineFormData.placement = "";
    routineFormData.choices = "";
    routineFormData.imageUrl = "";

    routine = Routine.find().where().eq("name", routineFormData.name).findUnique();
    if (routine == null) {
      routine = Routine.saveRoutineFromForm(routineFormData);

      // Material
      MaterialFormData materialFormData = new MaterialFormData();
      materialFormData.materialId = 0;
      materialFormData.routineId = routine.getId();
      materialFormData.name = "";
      materialFormData.isInspectable = false;
      materialFormData.isGivenAway = false;
      materialFormData.isConsumed = false;
      materialFormData.price = 000001;
      materialFormData.purchaseUrl = "";
      materialFormData.imageUrl = "";
      materialFormData.description = "";

      Material.saveMaterialFromForm(materialFormData);
    }
  }


  /**
   * Initialize the Routine dataset.
   */
  public static void initRoutines() {
    RoutineDBInit1.init01();
    RoutineDBInit1.init02();
    RoutineDBInit1.init03();
    RoutineDBInit2.init205();
    RoutineDBInit1.init04();
    RoutineDBInit1.init05();
    RoutineDBInit1.init06();
    RoutineDBInit1.init07();
    RoutineDBInit1.init08();
    RoutineDBInit1.init09();
    RoutineDBInit1.init10();
    RoutineDBInit1.init11();
    RoutineDBInit1.init12();
    RoutineDBInit1.init13();
    RoutineDBInit1.init14();
    RoutineDBInit1.init15();
    RoutineDBInit1.init16();
    RoutineDBInit1.init17();
    RoutineDBInit1.init18();
    RoutineDBInit1.init19();
    RoutineDBInit2.init20();
    RoutineDBInit2.init21();
    RoutineDBInit2.init22();
    RoutineDBInit2.init23();
    RoutineDBInit2.init24();
    RoutineDBInit2.init30();
    RoutineDBInit2.init201();
    RoutineDBInit2.init31();
    RoutineDBInit2.init32();
    RoutineDBInit2.init33();
    RoutineDBInit2.init34();
    RoutineDBInit2.init35();
    RoutineDBInit2.init36();
    RoutineDBInit2.init37();
    RoutineDBInit2.init38();
    RoutineDBInit2.init39();
    RoutineDBInit2.init40();
    RoutineDBInit2.init41();
    RoutineDBInit2.init42();
    RoutineDBInit2.init43();
    RoutineDBInit2.init44();
    RoutineDBInit2.init45();
    RoutineDBInit2.init202();
    RoutineDBInit2.init203();
    RoutineDBInit2.init204();
    RoutineDBInit2.init206();
    RoutineDBInit2.init207();
    RoutineDBInit2.init208();
    RoutineDBInit2.init209();
    RoutineDBInit2.init210();
  }

}
