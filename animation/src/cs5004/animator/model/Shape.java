package cs5004.animator.model;

/**
 * Shape interface, represents methods implemented by the {@link AbstractShape} class.
 */
public interface Shape {
  //GETTERS----------------------------------------------------------------------------------------
  /**
   * Returns the Shape.
   * @return a Shape object
   */
  Shape getShape();
  
  /**
   * Returns the type of the Shape.
   * @return a string, type of shape
   */
  String getType();

  /**
   * Returns the name of the Shape.
   * @return a string, name/id of the shape
   */
  String getName();

  /**
   * Retunrs the color of the Shape.
   * @return a {@link Color} object of the current shape's color
   */
  Color getColor();

  /**
   * Returns the x-position of the corner/center of the Shape.
   * @return float, x-position of shape's center/corner
   */
  int getPositionX();
  
  /**
   * Returns the y-position of the corner/center of the Shape.
   * @return float, y-position of shape's center/corner
   */
  int getPositionY();
  
  /**
   * Returns the x-radius/width of the Shape.
   * @return int, x-radius/width of shape
   */
  int getX();
  
  /**
   * Returns the y-radius/length of the Shape.
   * @return int, y-radius/length of shape
   */
  int getY();
  
  /**
   * Returns the time the Shape appears in the animation.
   * @return int, time the shape appears
   */
  int getAppears();
  
  /**
   * Returns the time the Shape disappears in the animation.
   * @return int, time the shape disappears
   */
  int getDisappears();
  
  /**
   *
   */
  boolean getCreated();
  
  //SETTERS AND OTHER------------------------------------------------------------------------------
  /**
   *
   * @param pointX
   * @param pointY
   * @param x
   * @param y
   * @param r
   * @param g
   * @param b
   */
  void setProperties(int pointX, int pointY, int x, int y, int r, int g, int b);
  
  /**
   * Set the time the Shape appears in the animation.
   * @param appears time in int, when shape appears
   * @throws IllegalArgumentException if time object appears in less than 0 or if appears is greater
   *        than this.disappears.
   */
  void setAppears(int appears);
  
  /**
   * Set the time the Shape disappears in the animation.
   * @param disappears time in int, when shape disappears
   * @throws IllegalArgumentException if time object disappears in less than 0 or if disappears is
   *        less than this.appears.
   */
  void setDisappears(int disappears);
  
  /**
   * Returns a copy of the Shape object.
   * @return a shape
   */
  Shape copy();

  /**
   * Returns true if a shape is equal to another shape, false if not.
   * @param other (shape) the other shape to compare the shape to.
   * @return (boolean) true if the shapes are the same, false if not.
   */
  boolean sameObject(Shape other);
  
  /**
   * Returns a string representation of the Shape.
   * @return a string
   *        "Name:
   *        Type:
   *        Corner/Center:
   *        Width/X-Radius:
   *        Length/Y-Radius:
   *        Appears:
   *        Disappears: "
   */
  String toString();

  
}
