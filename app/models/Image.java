package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

<<<<<<< HEAD
import play.db.ebean.Model;
=======
>>>>>>> Milestone-3
import play.data.validation.Constraints;

import java.io.File;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Image holds the image associated with a magician, routine, or material.
 * Images are not required.
 * cited source: https://github.com/DirtyDan88/play-framework-blob
 */
@Entity
<<<<<<< HEAD
public class Image extends Model {
=======
public class Image extends play.db.ebean.Model {
>>>>>>> Milestone-3
  private static final long serialVersionUID = 1L;

  /** The image id. */
  @Id
  public long id;

  /** The image name. */
  @Constraints.Required
  public String name;

  /** The image data. */
  @Lob
  public byte[] data;

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
<<<<<<< HEAD
  public static Finder<Long, Image> find =
      new Finder<Long, Image>(Long.class, Image.class);
=======
  public static Finder<Long, Image> find() {
    return new Finder<Long, Image>(Long.class, Image.class);
  }
>>>>>>> Milestone-3

  /**
   * Creates a new image entity.
   * @param name The name of the image.
   * @param image The byte array with the image data.
   */
  public Image(String name, File image) {
    this.name = name;
    this.data = new byte[(int) image.length()];

    /* write the image data into the byte array */
    InputStream inStream = null;
    try {
      inStream = new BufferedInputStream(new FileInputStream(image));
      inStream.read(this.data);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      if (inStream != null) {
        try {
          inStream.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    this.save();
  }
}