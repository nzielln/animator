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
  private HashMap<String, String> inputs;
  
  public GraphicView(List<Shape> model, int width, int height, int x, int y) {
    super("Animation");

    Objects.requireNonNull(model, "Model can't be null");

    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be positive integer");
    } else if (x < 0 || y < 0) {
      throw new IllegalArgumentException("X and Y must be positive");
    }

    setSize(width, height);
    setLocation(x, y);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    this.panel = new GraphicsPanel(model, x, y, width, height);
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
  public void animate(Animation model, HashMap<String, String> in) {
  
  }
}