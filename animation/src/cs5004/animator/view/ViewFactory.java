package cs5004.animator.view;

import java.util.Objects;


public class ViewFactory {
  
  public View create(String in) {

    Objects.requireNonNull(in, "Inputs can't be null");

    if (in.contains("-view text")) {
      return new TextView();
    } else if (in.contains("-view svg")) {
      return new SVGView();
    } else if (in.contains("-view visual")) {
      return new GraphicView();
    }
    
    return null;
  }
  
  
}
