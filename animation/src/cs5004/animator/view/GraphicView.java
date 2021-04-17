package cs5004.animator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import cs5004.animator.model.Shape;
import cs5004.animator.model.Animation;

import javax.swing.*;

public class GraphicView extends JFrame implements View {
  private GraphicsPanel panel;
  
  public GraphicView(List<Shape> model, int width, int height, int x, int y) {
    super("Animation");

    Objects.requireNonNull(model, "Model can't be null");

    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be positive integer");
    }

    setSize(560, 560);
    setLocation(0, 0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    this.panel = new GraphicsPanel(model, 0, 0, 560, 560);
    setVisible(true);
    add(panel);
    panel.setVisible(true);
  }
  
  public void currentView(List<Shape> model) {
    Objects.requireNonNull(model, "Model can't be null");

    this.panel.updateModel(model);
    this.repaint();
  }
  
  @Override
  public void animate(Animation m, HashMap<String, String> in) {
  
    List<Shape> model = new ArrayList<>(m.getShapes());
    int tick = Integer.parseInt(in.get("speed")); //not sure if this is how to correctly rep speed + figure out how to use timer class
    if (tick <= 0) {
      throw new IllegalArgumentException("Speed needs to be positive integer");
    }
    
    if (in.get("speed") == null) {
      tick = 1;
    }
  
    int count = 0;
    int lengthAnimation = 0;
  
    //get the total length of the animation
    for (Shape shape : model) {
      if (shape.getDisappears() > lengthAnimation) {
        lengthAnimation = shape.getDisappears();
      }
    }
  
    //do we get how long the animation is from the user at all? Does this need to be <= or <?
    while (count < lengthAnimation) {
      List<Shape> modified = m.getByTime(count);
    
      //update the animation and model to newModel
      //update count
      this.currentView(modified);
      count += 1;
    
      //Timer to let user see changes
      try {
        Thread.sleep(1000 / tick);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    
    }
  
  }
 
}