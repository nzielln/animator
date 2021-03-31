import java.util.List;

/**
 *
 */
public interface Shape {

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
  int getAppears();
  
  /**
   *
   * @return
   */
  int getDisappears();
  
  /**
   *
   * @return
   */
  String toString();
  
}
