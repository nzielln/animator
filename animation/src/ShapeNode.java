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
  void setDisappears(float d);
  
  /**
   *
   * @return
   */
  void setAppears(float a);
  
  
  /**
   *
   * @return
   */
  List<Transformation> getTransformations();
}
