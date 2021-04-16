package cs5004.animator.view;


import java.util.HashMap;
import java.util.Objects;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

public class TextView extends AbstractView {
  
  
  /*
  For testing: -in "smalldemo.txt" -view "text"
  */
  @Override
  public void animate(Animation m, HashMap<String, String> in) {
    Objects.requireNonNull(m, "Animation can't be null");
    Objects.requireNonNull(in, "Inputs can't be null");
    
    //determine when to make a new animation???
    int interval = 0;
    if (in.get("speed") != null) {
      int time = Integer.parseInt(in.get("speed"));
      interval = 1000 / time;
    }
    
    StringBuilder str = new StringBuilder();
    System.out.println("Text View of the Animation:________________________________________________"
           + "\n");
    for (Shape s : m.getShapes()) {
      if (s.getType().equals("RECTANGLE")) {
        String desc = "Create " + s.getType().toLowerCase() + " " + s.getName() + " of color "
                + s.getColor() + " with corner at (" + s.getPositionX() + "," + s.getPositionY()
                + "), width " + s.getWidth() + " height " + s.getHeight() + ".";
        str.append(desc).append("\n");
      } else if (s.getType().equals("Ellipse")) {
        String desc = "Create " + s.getType().toLowerCase() + " " + s.getName() + " of color "
                + s.getColor() + " with center at (" + s.getPositionX() + "," + s.getPositionY()
                + "), radius " + s.getWidth() + " and " + s.getHeight() + ".";
        str.append(desc).append("\n");
      }
    }
    
    str.append("\n");
    
    for (Shape s : m.getShapes()) {
      String timeDesc = s.getName() + " appears at t=" + s.getAppears() + " and disappears at t="
              + s.getDisappears();
      str.append(timeDesc).append("\n");
    }
    
    str.append("\n");
  
    for (Shape s : m.getShapes()) {
      str.append(m.tranformationString(s).replace("Shape ", ""));
    }
    
    
    System.out.println(str);
    
  }
  

}
