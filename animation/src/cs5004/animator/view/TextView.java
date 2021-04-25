package cs5004.animator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Shape;


/**
 * Represents a class for a TestView, implements the View interface.
 */
public class TextView implements View {
  private final String view;
  private Animation model;
  
  
  /**
   * TextView constructor that takes in no argument, define the type of view.
   */
  public TextView() {
    this.view = "Text";
    this.model = new AnimationImpl();
   
  }
  
  @Override
  public String getViewType() {
    return this.view;
  }
  
  @Override
  public void animate(Animation m, HashMap<String, String> in) {
  
    StringBuilder str = new StringBuilder();
    if (m.getSize() != 0) {
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
  
      if (in.get("out") != null) {
        writeFile(str.toString(), in);
      } else {
        System.out.println(str.toString().trim());
      }
    }
    
  }
  
  private void writeFile(String str, HashMap<String, String> in) {
    try {
      String n = "";
      if (in.get("in").contains("/")) {
        n = "./resources/outputs/" + in.get("out").replace("\"", "");
      } else {
        n = "../outputs/" + in.get("out").replace("\"", "");
      }
      FileWriter f = new FileWriter(n);
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
  
  @Override
  public void buildModel(Animation m) {
    this.model = m;
    
  }
  
  @Override
  public void currentView(List<Shape> shapes) {
    throw new UnsupportedOperationException("This operation is not supported by this class.");
    
  }
  
  @Override
  public View getView() {
    return this;
  }
  
  @Override
  public void exitView() {
    throw new UnsupportedOperationException("This operation is not supported by this class.");
  }
}