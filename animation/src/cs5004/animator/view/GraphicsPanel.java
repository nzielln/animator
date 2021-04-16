package cs5004.animator.view;

import java.awt.*;
import java.awt.Color;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

import cs5004.animator.model.Shape;

public class GraphicsPanel extends JPanel {
  private List<Shape> model;
  
  public GraphicsPanel(List<Shape> model, int x, int y, int width, int height) {
    super(true);
    this.model = model;
    setSize(width, height);
    setLocation(0, 0);
    setBackground(Color.WHITE);
    setBounds(x, y, width, height);
    setBorder(new LineBorder(Color.BLACK, 3));
  }
  
  //Do we need this second constructor??
  public GraphicsPanel(List<Shape> model) {
    super(true);
    this.model = model;
    setBackground(Color.WHITE);
    setLocation(0, 0);
    setBounds(20, 20, 500, 500);
    setBorder(new LineBorder(Color.BLACK, 3));
    
  }
  
  public void updateModel(List<Shape> model) {
    this.model = model;
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics = (Graphics2D) g;
    
    if (this.model == null) {
      return;
    }
    
    int count = 0;
    for (Shape s: model) {
      if (s.getType().equals("RECTANGLE")) {
        Color c = new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB());
        graphics.setColor(c);
        graphics.drawRect(s.getPositionX(), s.getPositionX(), s.getWidth(), s.getHeight());
        graphics.fillRect(s.getPositionX(), s.getPositionX(), s.getWidth(), s.getHeight());
        System.out.println(s.getName());
      } else if (s.getType().equals("ELLIPSE")) {
        Color c = new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB());
        graphics.setColor(c);
        graphics.drawOval(s.getPositionX(), s.getPositionX(), s.getWidth(), s.getHeight());
        graphics.fillOval(s.getPositionX(), s.getPositionX(), s.getWidth(), s.getHeight());
        
        System.out.println(s.getName());
      }
    }
  }
}

