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
   * Returns the x-position the new shape should have.
   * @return float, time
   */
  int getToX();
  
  /**
   * Returns the y-position the new shape should have.
   * @return float, time
   */
  int getToY();
  
  /**
   * Returns the width the new shape should have.
   * @return float, time
   */
  int getToWidth();
  
  /**
   * Returns the length the new shape should have.
   * @return float, time
   */
  int getToHeight();
  
  
  /**
   * Returns the color the new shape should have.
   * @return {@link Color}, color of new shape
   */
  Color getToColor();

  /**
   * Returns the initial x position of the shape (as provided in the -in file)
   * @return int, initial x position
   */
  int getInitialX();
  
  /**
   * Returns the initial y position of the shape (as provided in the -in file)
   * @return int, initial y position
   */
  int getInitialY();
  
  /**
   * Returns the initial width of the shape (as provided in the -in file)
   * @return int, initial width
   */
  int getInitialWidth();
  
  /**
   * Returns the initial height of the shape (as provided in the -in file)
   * @return int, initial height
   */
  int getInitialHeight();
  
  /**
   * Returns the initial Color of the shape (as provided in the -in file)
   * @return int, initial Color
   */
  Color getInitialColor();

  /**
   * Returns the initial Shape as read from the -in file in the AnimationBuilder.
   * @return shape, initial Shape with properties
   */
  Shape getInitialshape();

  /**
   * Returns the final shape as read from the -in file in the AnimationBuilder.
   * @return shape, final shape with properties
   */
  Shape getFinalshape();

  //OTHER------------------------------------------------------------------------------------------
  
  /**
   * Creates and sets the properties for the initial shape as read from the -in file in
   * AnimationBuilder.
   * @param name, String, the name of the shape
   * @param type, String, the type of shape
   * @param x, int, initial x position
   * @param y, int, initial y position
   * @param w, int, initial width
   * @param h, int, initial height
   * @param r, int, initial red value
   * @param g, int, initial green value
   * @param b, int, initial blue value
   */
  void setInitial(String name, String type, int x, int y, int w, int h, int r, int g, int b);
  
  /**
   * Creates and sets the properties for the final shape as read from the -in file in
   * AnimationBuilder.
   * @param name, String, the name of the shape
   * @param type, String, the type of shape
   * @param x, int, final x position
   * @param y, int, final y position
   * @param w, int, final width
   * @param h, int, final height
   * @param r, int, final red value
   * @param g, int, final green value
   * @param b, int, final blue value
   */
  void setFinal(String name, String type, int x, int y, int w, int h, int r, int g, int b);
  
  
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
