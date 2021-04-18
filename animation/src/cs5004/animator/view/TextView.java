package cs5004.animator.view;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import cs5004.animator.model.Shape;

public class TextView extends AbstractView {
  String view;
  
  public TextView() {
    this.view = "Text";
  }
  /*
  For testing: -in "smalldemo.txt" -view "text"
  */
  @Override
  public String getView() {
    return this.view;
  }
  
  @Override
  public void animate() {
    
    //determine when to make a new animation???
    int interval = 0;
    if (this.inputs.get("speed") != null) {
      int time = Integer.parseInt(this.inputs.get("speed"));
      interval = 1000 / time;
    }
    
    StringBuilder str = new StringBuilder();
    System.out.println("Text View of the Animation:________________________________________________"
           + "\n");
    for (Shape s : this.model.getShapes()) {
      if (s.getType().equals("RECTANGLE")) {
        String desc = "Create " + s.getType().toLowerCase() + " " + s.getName() + " of color "
                + s.getColor() + " with corner at (" + s.getPositionX() + "," + s.getPositionY()
                + "), width " + s.getWidth() + " height " + s.getHeight() + ".";
        str.append(desc).append("\n");
      } else if (s.getType().equals("ELLIPSE")) {
        String desc = "Create " + s.getType().toLowerCase() + " " + s.getName() + " of color "
                + s.getColor() + " with center at (" + s.getPositionX() + "," + s.getPositionY()
                + "), radius " + s.getWidth() + " and " + s.getHeight() + ".";
        str.append(desc).append("\n");
      }
    }
    
    str.append("\n");
    
    for (Shape s : this.model.getShapes()) {
      String timeDesc = s.getName() + " appears at t=" + s.getAppears() + " and disappears at t="
              + s.getDisappears();
      str.append(timeDesc).append("\n");
    }
    
    str.append("\n");
  
    for (Shape s : this.model.getShapes()) {
      str.append(this.model.tranformationString(s).replace("Shape ", ""));
    }
  
    if (this.inputs.get("out") != null) {
      writeFile(str.toString());
    }
    System.out.println(str);
    System.out.println(str.toString().split("\n").length);
  
  }
  
  private void writeFile(String str) {
    try {
      FileWriter f = new FileWriter(this.inputs.get("out").replace("\"", ""));
      Scanner s = new Scanner(str).useDelimiter("\n");
      while (s.hasNext()) {
        String line = s.next();
        if (s.hasNext()) {
          f.write(line + "\n");
        } else {
          f.write(line);
        }
      }
      f.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
}
