package models;

/**
 * Hold database standards and singleton.
 *
 * TO-DO: Refactor name at some point.
 */
public class GlobalDbInfo {
  /** The maximum number of characters in a standard short, single-line text field. */
  public static final int MAX_SHORT_TEXT_LENGTH = 45;

  /** The maximum number of characters in a standard long, single-line text field. */
  public static final int MAX_LONG_TEXT_LENGTH = 255;

  /** The maximum number of characters in a standard multi-line text field. */
  public static final int MAX_MULTILINE_TEXT_LENGTH = 2000;
}
