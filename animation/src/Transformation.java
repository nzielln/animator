import java.util.List;

/**
 * Animation interface, represents methods implemented by the {@link AbstractTransformation} class.
 */
public interface Transformation {
  
  //GETTERS----------------------------------------------------------------------------------------
  
  /**
   * Returns the {@link Shape}.
   * @return a {@link Shape} object
   */
  Shape getShape();
  
  /**
   * Returns the {@link Transformation}(s).
   * @return a transformations
   */
  Transformation getTransformation();
  
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
  
  //OTHER------------------------------------------------------------------------------------------
  
  /**
   * Returns a copy of a transformation object.
   * @return a {@link Transformation} object
   */
  Transformation copy();

  /**
   *
   * @param other
   * @return
   */
  //boolean equals(Transformation other);
  
  /**
   * Returns a string representation of the {@link Transformation} object.
   * @return a string, decription of the transformation
   */
  String toString();
  
}
