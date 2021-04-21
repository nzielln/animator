package cs5004.animator.view;


import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;


/**
 * Represents a class for a TestView, implements the View interface.
 */
public class TextView implements View {
  String view;
  
  /**
   * TextView constructor that takes in no argument, define the type of view.
   */
  public TextView() {
    this.view = "Text";
  }
  
  @Override
  public String getViewType() {
    return this.view;
  }
  
  @Override
  public void animate(HashMap<String, String> str) {
    System.out.println(str.get("output"));
    if (str.get("out") != null) {
      writeFile(str.get("output"), str);
    }
  
  }
  
  @Override
  public void animateVisual(List<Shape> m) {
    throw new UnsupportedOperationException("This method is not supported by the Text view.");
    
  }
  
  @Override
  public void buildModel(int x, int y, int width, int height) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This method is not supported by the Text view.");
    
  }
  
  private void writeFile(String str, HashMap<String, String> inputs) {
    try {
      FileWriter f = new FileWriter("../outputs/" + inputs.get("out").replace("\"", ""));
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
  public void currentView(List<Shape> shapes) {
    throw new UnsupportedOperationException("This operation is not supported by this class.");
    
  }
  
  @Override
  public View getView() {
    return this;
  }
}
