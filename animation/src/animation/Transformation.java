package animation;

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
  float getToX();
  
  /**
   * Returns the y-position/length the new shape should have.
   * @return float, time
   */
  float getToY();
  
  
  /**
   * Returns the color the new shape should have.
   * @return {@link Color}, color of new shape
   */
  Color getToColor();
  
  //OTHER------------------------------------------------------------------------------------------
  /**
   * Determines if two Transformation objects are identical.
   * @param other (Transformation) another Transformation object
   * @return true if the two objects are identical
   */
  boolean equals(Transformation other);
  
  
  /**
   * Returns a string representation of the {@link Transformation} object.
   * @return a string, decription of the transformation
   */
  String toString();
  
}
