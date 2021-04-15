package cs5004.animator.view;

import cs5004.animator.model.Animation;
import cs5004.animator.util.AnimationReader;

public class ViewFactory {
  
  public View create(String view, Animation model) {
    if (view.contains("text")) {
      return new TextView();
    } else if (view.contains("svg")) {
      return new SVGView();
    } else if (view.contains("visual")) {
      return new GraphicView(model);
    }
    
    return null;
  }
  
  
}
