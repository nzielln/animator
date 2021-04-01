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
   * Returns a copy of a transformation object.
   * @return a {@link Transformation} object
   */
  Transformation copy();
  
  /**
   * Returns a new {@link Shape} with provided x and y positions.
   * @param toX x-position of the new shape object
   * @param toY y-position of the new shape object
   * @param timeStart time transformation starts
   * @param timeEnd time transformation ends
   * @return a new shape object
   */
  Shape moveShape(float toX, float toY, int timeStart, int timeEnd);
  
  /**
   * Returns a new {@link Shape} with provided color.
   * @param toColor {@link Color} of the new shape
   * @param timeStart time transformation starts
   * @param timeEnd time transformation ends
   * @return a new shape object
   */
  Shape changeColor(Color toColor, int timeStart, int timeEnd);
  
  /**
   * Returns a new {@link Shape} with provided x and y positions.
   * @param toX width of the new shape object
   * @param toY length of the new shape object
   * @param timeStart time transformation starts
   * @param timeEnd time transformation ends
   * @return a new shape object
   */
  Shape scaleShape(int toX, int toY, int timeStart, int timeEnd);
  
  /**
   * Returns a string representation of the {@link Transformation} object.
   * @return a string, decription of the transformation
   */
  String toString();
  
}
