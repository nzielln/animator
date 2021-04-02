package initial;

import java.awt.*;

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
  float getAppears();

  /**
   *
   * @return
   */
  float getDisappears();

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
}