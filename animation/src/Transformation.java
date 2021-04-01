import java.util.List;

public interface Transformation {
  
  //GETTERS----------------------------------------------------------------------------------------
  
  /**
   *
   * @return
   */
  Shape getShape();
  
  /**
   *
   * @return
   */
  Transformation getTransformation();
  
  /**
   *
   * @return
   */
  String getTransformationType();
  
  /**
   *
   * @return
   */
  int getTimeStart();
  
  /**
   *
   * @return
   */
  int getTimeEnd();
  
  /**
   *
   * @return
   */
  float getToX();
  
  /**
   *
   * @return
   */
  float getToY();
  
  
  /**
   *
   * @return
   */
  Color getToColor();
  
  //OTHER------------------------------------------------------------------------------------------
  
  /**
   *
   * @return
   */
  Transformation copy();
  
  /**
   *
   * @param toX
   * @param toY
   * @param timeStart
   * @param timeEnd
   * @return
   */
  Shape moveShape(float toX, float toY, int timeStart, int timeEnd);
  
  /**
   *
   * @param toColor
   * @param timeStart
   * @param timeEnd
   * @return
   */
  Shape changeColor(Color toColor, int timeStart, int timeEnd);
  
  /**
   *
   * @param toX
   * @param toY
   * @param timeStart
   * @param timeEnd
   * @return
   */
  Shape scaleShape(float toX, float toY, int timeStart, int timeEnd);
  
  /**
   *
   * @return
   */
  String toString();
  
}
