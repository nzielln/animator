package cs5004.animator.view;


import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import cs5004.animator.model.Animation;
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
  public String getViewType() {
    return this.view;
  }
  
  @Override
  public void animate(Animation m, HashMap<String, String> inputs) {
    
    //determine when to make a new animation???
    int interval = 0;
    if (inputs.get("speed") != null) {
      int time = Integer.parseInt(inputs.get("speed"));
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
      } else if (s.getType().equals("ELLIPSE")) {
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
  
    if (inputs.get("out") != null) {
      writeFile(str.toString(), inputs);
    }
  
    System.out.println(str);
  
  
  }
  
  @Override
  public void buildModel(Animation f) {
    throw new UnsupportedOperationException("This method is not supported by the Text view.");
    
  }
  
  @Override
  public View getView() {
    throw new UnsupportedOperationException("This operation isn't supported by this class.");
  }
  
  private void writeFile(String str, HashMap<String, String> inputs) {
    try {
      FileWriter f = new FileWriter("./resources/outputs/" + inputs.get("out").replace("\"", ""));
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
