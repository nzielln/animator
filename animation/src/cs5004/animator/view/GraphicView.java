package cs5004.animator.view;

import java.awt.*;
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
  //private HashMap<String, String> inputs;
  private GraphicsPanel panel;
  //private Animation model;
  private String view;
  
  public GraphicView() {
    super("Animation");
    //inputs = new HashMap<>();
    //m = new AnimationImpl();
    this.view = "Visual";
  }
  
  @Override
  public void currentView(List<Shape> m) {
    Objects.requireNonNull(m, "Model can't be null");

    this.panel.updateModel(m);
    this.repaint();
  }
  
  @Override
  public String getViewType() {
    return this.view;
  }
  
  @Override
  public View getView() {
    return this;
  }
  
  @Override
  public void animate(Animation m, HashMap<String, String> in) {
  
    List<Shape> model = new ArrayList<>(m.getShapes());

    int tick = 1;

    if (in.get("speed") != null) {
      tick = Integer.parseInt(in.get("speed")); //not sure if this is how to correctly rep speed + figure out how to use timer class
      if (tick <= 0) {
        throw new IllegalArgumentException("Speed needs to be positive integer");
      }
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
  
  /*
  @Override
  public void readInputs(String in) {
    Scanner s = new Scanner(in);
    while (s.hasNext()) {
      String next = s.next();
      if (next.equals("-in")) {
        inputs.put("in", s.next());
      } else if (next.equals("-out")) {
        inputs.put("out", s.next());
      } else if (next.equals("-view")) {
        inputs.put("view", s.next());
      } else if (next.equals("-speed")) {
        inputs.put("speed", s.next());
      }
    }
    if (inputs.get("in") == null || inputs.get("in").equals("")) {
      JOptionPane.showMessageDialog(this, "You must provide an \"-in\" file.",
              "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
  }
  
   */
  
  @Override
  public void buildModel(Animation m) {
    setSize(m.getCanvasWidth(),
            m.getCanvasHeight());
    
    setLocation(m.getCanvasX(),
            m.getCanvasY());
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setVisible(true);
    
    this.panel = new GraphicsPanel(m.getByTime(0), m);
    this.panel.setPreferredSize(new Dimension(m.getCanvasWidth(),
            m.getCanvasHeight()));
  
    add(panel, BorderLayout.CENTER);
    
    JScrollPane scroll = new JScrollPane(this.panel);
    setPreferredSize(new Dimension(m.getCanvasWidth(), m.getCanvasHeight() ));
    add(scroll, BorderLayout.CENTER);
    
    setVisible(true);
    panel.setVisible(true);
    scroll.setVisible(true);
  
  }
  
  
  
  /*
  @Override
  public void getReadable() throws FileNotFoundException {
    String fileInput = inputs.get("in").replace("\"", ""); //from the CLI - should have a method for this??
    String filename = "./resources/files/" + fileInput;
    try {
      File demo = new File(filename);
      FileReader f = new FileReader(demo);
      buildModel(f);
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(this, "File not found.",
              "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }
  
   */
  
}