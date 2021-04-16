package cs5004.animator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import cs5004.animator.model.Shape;
import cs5004.animator.model.Animation;

import javax.swing.*;

public class GraphicView extends JFrame implements View {
  private GraphicsPanel panel;
  private HashMap<String, String> inputs;
  
  public GraphicView(List<Shape> model, int width, int height, int x, int y) {
    super("Animation");
    setSize(width, height);
    setLocation(x, y);
    this.panel = new GraphicsPanel(model, width, height, x, y);
    setVisible(true);
    //pack();
  }
  
  public void updateModel(List<Shape> model) {
    this.panel.updateModel(model);
    this.repaint();
  }
  
  @Override
  public void animate(Animation model) {
  
  }
}