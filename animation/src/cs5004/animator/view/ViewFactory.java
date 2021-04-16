package cs5004.animator.view;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.util.AnimationReader;

public class ViewFactory {
  
  public View create(HashMap<String, String> in, List<Shape> shapes,
                     int width, int height, int x, int y) {

    Objects.requireNonNull(in, "Inputs can't be null");
    Objects.requireNonNull(shapes, "Shapes list can't be null");

    if (width < 0 || height < 0 || x < 0 || y < 0) {
      throw new IllegalArgumentException("Width, height, x, and y must be positive");
    }

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
