package cs5004.animator.view;

import java.util.Objects;

/**
 * An Abstract factory for the view in the Animation program.
 */
public class ViewFactory {
  
  /**
   * Takes in a string to determine what view objec to animate.
   * @param in string, input from CLI, passed from EasyAnimator
   * @return veiw, a view object
   */
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
