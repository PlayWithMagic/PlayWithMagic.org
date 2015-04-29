package tests;

import com.typesafe.config.ConfigFactory;

/**
 * A support class for all application tests.
 */
public class GlobalTest {

  /**
   * The port number on which to run the tests.
   */
  public static final int TEST_PORT = 3333;


  /**
   * The application's name.
   */
  public static final String APPLICATION_NAME = ConfigFactory.load().getString("application.name");
}
