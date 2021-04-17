package cs5004.animator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Animation;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;

import javax.swing.*;

public class GraphicView extends JFrame implements View {
  private HashMap<String, String> inputs;
  private GraphicsPanel panel;
  private Animation model;
  
  public GraphicView() {
    super("Animation");
    this.inputs = new HashMap<>();
    this.model = new AnimationImpl();
  }
  
  public void currentView(List<Shape> model) {
    Objects.requireNonNull(model, "Model can't be null");

    this.panel.updateModel(model);
    this.repaint();
  }
  
  @Override
  public void animate() {
  
    List<Shape> model = new ArrayList<>(this.model.getShapes());
    int tick = Integer.parseInt(this.inputs.get("speed")); //not sure if this is how to correctly rep speed + figure out how to use timer class
    if (tick <= 0) {
      throw new IllegalArgumentException("Speed needs to be positive integer");
    }
    
    if (this.inputs.get("speed") == null) {
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
      List<Shape> modified = this.model.getByTime(count);
    
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
  
  @Override
  public void readInputs(String in) {
    Scanner s = new Scanner(in);
    while (s.hasNext()) {
      String next = s.next();
      if (next.equals("-in")) {
        this.inputs.put("in", s.next());
      } else if (next.equals("-out")) {
        this.inputs.put("out", s.next());
      } else if (next.equals("-view")) {
        this.inputs.put("view", s.next());
      } else if (next.equals("-speed")) {
        this.inputs.put("speed", s.next());
      }
    }
    if (this.inputs.get("in") == null || this.inputs.get("in").equals("")) {
      JOptionPane.showMessageDialog(this, "You must provide an \"-in\" file.",
              "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
  }
  
  @Override
  public void buildModel(FileReader f) {
    AnimationBuilder<Animation> b = new AnimationBuilderImpl(model);
    AnimationReader.parseFile(f, b);
  
    setSize(560, 560);
    setLocation(0, 0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    this.panel = new GraphicsPanel(model.getByTime(0), 0, 0, 560, 560);
    setVisible(true);
    add(panel);
    panel.setVisible(true);
    
  }
  
  @Override
  public void getReadable() throws FileNotFoundException {
    String fileInput = this.inputs.get("in").replace("\"", ""); //from the CLI - should have a method for this??
    String filename = "./src/cs5004/animator/files/" + fileInput;
    try {
      File demo = new File(filename);
      FileReader f = new FileReader(demo);
      buildModel(f);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "File not found.",
              "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
  }
  
}