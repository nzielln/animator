package cs5004.animator.view;


import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

public class TextView extends AbstractView {
  
  
  /*
  For testing: -in "smalldemo.txt" -view "text"
  */
  @Override
  public void animate(Animation m) {
    
    //determine when to make a new animation???
    int interval = 0;
    if (this.inputs.get("speed") != null) {
      int time = Integer.parseInt(this.inputs.get("speed"));
      interval = 1000 / time;
    }
    
    StringBuilder str = new StringBuilder();
    System.out.println("Text View of the Animation:________________________________________________"
           + "\n");
    for (Shape s : m.getShapes()) {
      if (s.getType().equals("RECTANGLE")) {
        String desc = "Create " + s.getType().toLowerCase() + " " + s.getName() + " of color "
                + s.getColor() + " with corner at (" + s.getPositionX() + "," + s.getPositionY()
                + "), width " + s.getX() + " height " + s.getY() + ".";
        str.append(desc).append("\n");
      } else if (s.getType().equals("ELLIPSE")) {
        String desc = "Create " + s.getType().toLowerCase() + " " + s.getName() + " of color "
                + s.getColor() + " with center at (" + s.getPositionX() + "," + s.getPositionY()
                + "), radius " + s.getX() + " and " + s.getY() + ".";
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
      str.append(m.tranformationString(s));
    }
    
    
    System.out.println(str);
    
  }
  

}
