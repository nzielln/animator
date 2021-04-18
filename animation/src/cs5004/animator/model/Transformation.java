package cs5004.animator.model;

/**
 * Animation interface, represents methods implemented by the {@link AbstractTransformation} class.
 */
public interface Transformation {
  
  //GETTERS----------------------------------------------------------------------------------------
  /**
   * Returns the {@link Transformation}(s).
   * @return a transformations
   */
  Transformation getTransformation();
  
  /**
   * Returns the Transformation's ID.
   * @return (String) Tranformastion's ID
   */
  String getID();
  
  /**
   * Returns the type of the {@link Transformation}.
   * @return a string, type of transformation
   */
  String getTransformationType();
  
  /**
   * Returns the time the transformation starts.
   * @return int, time
   */
  int getTimeStart();
  
  /**
   * Returns the time the transformation ends.
   * @return int, time
   */
  int getTimeEnd();
  
  /**
   * Returns the x-position/width the new shape should have.
   * @return float, time
   */
  int getToX();
  
  /**
   * Returns the y-position/length the new shape should have.
   * @return float, time
   */
  int getToY();
  
  /**
   * Returns the x-position/width the new shape should have.
   * @return float, time
   */
  int getToWidth();
  
  /**
   * Returns the y-position/length the new shape should have.
   * @return float, time
   */
  int getToHeight();
  
  
  /**
   * Returns the color the new shape should have.
   * @return {@link Color}, color of new shape
   */
  Color getToColor();

  /**
   *
   * @return
   */
  int getInitialX();

  /**
   *
   * @return
   */
  int getInitialY();

  /**
   *
   * @return
   */
  int getInitialWidth();

  /**
   *
   * @return
   */
  int getInitialHeight();

  /**
   *
   * @return
   */
  Color getInitialColor();

  /**
   *
   * @return
   */
  Shape getInitialshape();

  /**
   *
   * @return
   */
  Shape getFinalshape();

  //OTHER------------------------------------------------------------------------------------------

  /**
   *
   * @param name
   * @param type
   * @param x
   * @param y
   * @param w
   * @param h
   * @param r
   * @param g
   * @param b
   */
  void setFinal(String name, String type, int x, int y, int w, int h, int r, int g, int b);

  /**
   *
   * @param name
   * @param type
   * @param x
   * @param y
   * @param w
   * @param h
   * @param r
   * @param g
   * @param b
   */
  void setInitial(String name, String type, int x, int y, int w, int h, int r, int g, int b);
  
  /**
   * Determines if two Transformation objects are identical.
   * @param other (Transformation) another Transformation object
   * @return true if the two objects are identical
   */
  boolean sameObject(Transformation other);
  
  /**
   * Returns a string representation of the {@link Transformation} object.
   * @return a string, decription of the transformation
   */
  String toString();
  
}
