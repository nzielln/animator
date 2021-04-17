package cs5004.animator.view;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.util.AnimationReader;

public class ViewFactory {
  
  public View create(HashMap<String, String> in, Animation m) {

    Objects.requireNonNull(in, "Inputs can't be null");
    Objects.requireNonNull(m, "Shapes list can't be null");

    int width = m.getCanvasWidth();
    int height = m.getCanvasHeight();
  
    int x = m.getCanvasX();
    int y = m.getCanvasY();
    
    if (in.get("view").equals("text")) {
      return new TextView();
    } else if (in.get("view").equals("svg")) {
      return new SVGView();
    } else if (in.get("view").equals("visual")) {
      return new GraphicView(m.getByTime(0), width, height, x, y);
    }
    
    return null;
  }
  
  
}
