package animation;

/**
 * Shape interface, represents methods implemented by the {@link AbstractShape} class.
 */
public interface Shape {
  
  //GETTERS----------------------------------------------------------------------------------------
  /**
   * Returns the {@link Shape}.
   * @return a {@link Shape} object
   */
  Shape getShape();
  
  /**
   * Returns the type of the {@link Shape}.
   * @return a string, type of shape
   */
  String getType();

  /**
   * Returns the name of the {@link Shape}.
   * @return a string, name/id of the shape
   */
  String getName();

  /**
   * Retunrs the color of the {@link Shape}.
   * @return a {@link Color} object of the current shape's color
   */
  Color getColor();

  /**
   * Returns the x-position of the corner/center of the {@link Shape}.
   * @return float, x-position of shape's center/corner
   */
  float getPositionX();
  
  /**
   * Returns the y-position of the corner/center of the {@link Shape}.
   * @return float, y-position of shape's center/corner
   */
  float getPositionY();
  
  /**
   * Returns the x-radius/width of the {@link Shape}.
   * @return int, x-radius/width of shape
   */
  int getX();
  
  /**
   * Returns the y-radius/length of the {@link Shape}.
   * @return int, y-radius/length of shape
   */
  int getY();
  
  /**
   * Returns the time the {@link Shape} appears in the animation.
   * @return int, time the shape appears
   */
  int getAppears();
  
  /**
   * Returns the time the {@link Shape} disappears in the animation.
   * @return int, time the shape disappears
   */
  int getDisappears();
  
  
  //SETTERS AND OTHER------------------------------------------------------------------------------
  
  /**
   * Set the time the {@link Shape} appears in the animation.
   * @param appears time in int, when shape appears
   */
  void setAppears(int appears);
  
  /**
   * Set the time the {@link Shape} disappears in the animation.
   * @param disappears time in int, when shape disappears
   */
  void setDisappears(int disappears);
  
  /**
   * Returns a copy of the {@link Shape} object.
   * @return a shape
   */
  Shape copy();

  /**
   * Returns true if a shape is equal to another shape, false if not.
   * @param other (shape) the other shape to compare the shape to.
   * @return (boolean) true if the shapes are the same, false if not.
   */
  boolean equals(Shape other);
  
  /**
   * Returns true if a shape is equal to another shape, false if not.
   * @param other (shape) the other shape to compare the shape to.
   * @return (boolean) true if the shapes are the same, false if not.
   */
  boolean equals(Shape other);
  
  /**
   * Returns a string representation of the {@link Shape}.
   * @return a string
   * "Name:
   *  Type:
   *  Corner/Center:
   *  Width/X-Radius:
   *  Length/Y-Radius:
   *  Appears:
   *  Disappears: "
   */
  String toString();

  
}
