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

  /** The minimum password length. */
  public static final int MIN_PASSWORD_LENGTH = 8;

  /** The minimum number of uppercase characters in the password. */
  public static final int MIN_PASSWORD_UPPERCASE_CHARS = 1;

  /** The minimum number of lowercase characters in the password. */
  public static final int MIN_PASSWORD_LOWERCASE_CHARS = 1;

  /** The minimum number of numeric characters in the password. */
  public static final int MIN_PASSWORD_NUMERIC_CHARS = 1;

  /** The minimum number of symbolic characters in the password. */
  public static final int MIN_PASSWORD_SYMBOL_CHARS = 1;
}
