package cs5004.animator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import cs5004.animator.model.Shape;
import cs5004.animator.model.Animation;

import javax.swing.*;

public class GraphicView extends JFrame implements Graphic {
  private GraphicsPanel panel;
  private HashMap<String, String> inputs;
  
  public GraphicView(int x, int y, int width, int height, Animation model) {
    super("Animation");
    setSize(width, height);
    setLocation(x, y);
    this.panel = new GraphicsPanel(model, x, y, width, height);
  }
  
  public void updateModel(Animation model) {
    this.panel.updateModel(model);
    this.repaint();
  }
  
  @Override
  public void animate(Animation model) {
  
  }
}