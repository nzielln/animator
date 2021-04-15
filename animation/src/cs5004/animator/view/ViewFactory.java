package cs5004.animator.view;

import java.util.HashMap;
import java.util.List;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.util.AnimationReader;

public class ViewFactory {
  
  public View create(HashMap<String, String> in, List<Shape> shapes, int width, int height, int x, int y) {
    if (in.get("view").equals("text")) {
      return new TextView();
    } else if (in.get("view").equals("svg")) {
      return new SVGView();
    } else if (in.get("view").equals("visual")) {
      return new GraphicView(shapes, width, height, x, y);
    }
    
    return null;
  }
  
  
}
