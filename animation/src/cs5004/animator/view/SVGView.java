package cs5004.animator.view;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Transformation;


/**
 * Represents a class for an SVGView, implements the View interface.
 */
public class SVGView implements View {
  private String view;
  
  /**
   * SVGView constructor that takes in no argument, define the type of view.
   */
  public SVGView() {
    this.view = "SVG";
  }
  
  
  @Override
  public String getViewType() {
    return this.view;
  }
  
  @Override
  public void animate(HashMap<String, String> str) {
   /**
     * The dimensions provided in each .txt file were too small to display the full animation
     * For example, for the smalledemo.txt, the dimensions are 360by 360, but, the ellipse is
     * drawn at positions between (440, 70) and (440, 370), making it unviewable in the space
     * allocated for the animation. To solve this problem, we decided to set a default dimensions
     * to make sure everything is seen.
     * Width: 100%
     * Height: 100%
     */
    try {
  
      FileWriter f = new FileWriter("../outputs/"
              + str.get("out").replace("\"", ""));
     
      f.write(str.get("output"));
      f.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  @Override
  public void animateVisual(List<Shape> m) {
    throw new UnsupportedOperationException("This method is not supported by the Text view.");
    
  }
  
  @Override
  public void buildModel(int x, int y, int width, int height) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This method is not supported by the Text view.");
    
  }
  
  
  @Override
  public void currentView(List<Shape> shapes) {
    throw new UnsupportedOperationException("This operation is not supported by this class.");
    
  }
  
  @Override
  public View getView() {
    return this;
  }
  
}

