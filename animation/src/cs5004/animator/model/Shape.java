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
  int getWidth();
  
  /**
   * Returns the y-radius/length of the Shape.
   * @return int, y-radius/length of shape
   */
  int getHeight();
  
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
   * Determines if a shape has been created yet.
   * @return returns true if shape has been created, false if not
   */
  boolean getCreated();
  
  //SETTERS AND OTHER------------------------------------------------------------------------------
  /**
   * Sets the properties for a new shape.
   * @param x int, x position for the shape
   * @param y int, y position for the shape
   * @param w int, width for the shape
   * @param h int, height for the shape
   * @param r int, red value for the shape
   * @param g int, green value for the shape
   * @param b int, blue value for the shape
   */
  void setProperties(int x, int y, int w, int h, int r, int g, int b);

  
  /**
   * Set the time the Shape appears and disappears in the animation.
   * @param appears time in int, when shape appears
   * @param disappears time in int, when the shape disappears
   * @throws IllegalArgumentException if time object appears/disappears in less than 0 or if appears is greater
   *        than this.disappears.
   */
  void setAppearsDisappears(int appears, int disappears) throws IllegalArgumentException;
  
  /**
   * Changes the x and y positions of a shape.
   * @param x int, new x poisition for the shape
   * @param y int, new y position for the shape
   */
  void changePosition(int x, int y);
  
  /**
   * Changes the width and height of a shape.
   * @param w int, new width for the shape
   * @param h int, new height for the shape
   */
  void changeSize(int w, int h);
  
  /**
   * Changes the red, green and blue values for a shape.
   * @param r int, new red value
   * @param g int, new green value
   * @param b int, new blue value.
   */
  void changeColor(int r,int g, int b);
  
  
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
