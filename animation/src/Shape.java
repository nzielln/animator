import java.util.List;

/**
 *
 */
public interface Shape {
  
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
  String getType();

  /**
   *
   * @return
   */
  String getName();

  /**
   *
   * @return
   */
  Color getColor();

  /**
   *
   * @return
   */
  float getPositionX();

  /**
   *
   * @return
   */
  float getPositionY();
  
  /**
   *
   * @return
   */
  float getX();
  
  /**
   *
   * @return
   */
  float getY();
  
  /**
   *
   * @return
   */
  int getAppears();
  
  /**
   *
   * @return
   */
  int getDisappears();
  
  
  //SETTERS AND OTHER------------------------------------------------------------------------------
  
  /**
   *
   * @param appears
   * @return
   */
  void setAppears(int appears);
  
  /**
   *
   * @param disappears
   * @return
   */
  void setDisappears(int disappears);
  
  
  /**
   *
   * @return
   */
  String toString();
  
  /**
   *
   * @return
   */
  Shape copy();
  
}
