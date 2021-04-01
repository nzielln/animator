package initial;

import java.util.List;

public interface ShapeNode {
  /**
   *
   * @return
   */
  Shape getShape();
  
  /**
   *
   * @return
   */
  float getDisappears();
  
  /**
   *
   * @return
   */
  float getAppears();
  
  /**
   *
   * @return
   */
  List<Transformation> getTransformations();
}
