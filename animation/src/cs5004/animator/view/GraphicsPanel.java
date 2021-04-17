package cs5004.animator.view;

import java.awt.*;
import java.awt.Color;
import java.util.List;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.LineBorder;

import cs5004.animator.model.Shape;

public class GraphicsPanel extends JPanel {
  private List<Shape> model;
  
  public GraphicsPanel(List<Shape> model, int x, int y, int width, int height) {
    super(true);

    Objects.requireNonNull(model, "Model can't be null");
    if (x < 0 || y < 0 || width < 0 || height < 0) {
      throw new IllegalArgumentException("X, Y, Width, and Height must be positive");
    }

    this.model = model;
    setSize(560, 560);
    setLocation(0, 0);
    setBackground(Color.WHITE);
    setBounds(0, 0, 560, 560);
    setBorder(new LineBorder(Color.BLACK, 3));
  }
  
  //Do we need this second constructor??
  public GraphicsPanel(List<Shape> model) {
    super(true);

    Objects.requireNonNull(model, "Model can't be null");

    this.model = model;
    setBackground(Color.WHITE);
    setLocation(0, 0);
    setBounds(20, 20, 500, 500);
    setBorder(new LineBorder(Color.BLACK, 3));
    
  }
  
  public void updateModel(List<Shape> model) {
    Objects.requireNonNull(model, "Model can't be null");
    this.model = model;
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Objects.requireNonNull(g, "Graphics object can't be null");

    Graphics2D graphics = (Graphics2D) g;
    
    if (this.model == null) {
      return; // should we return here or should we throw an exception?
    }
    
    int count = 0;
    for (Shape s: model) {
      if (s.getType().equals("RECTANGLE")) {
        Color c = new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB());
        graphics.setColor(c);
        graphics.drawRect(s.getPositionX(), s.getPositionY(), s.getWidth(), s.getHeight());
        graphics.fillRect(s.getPositionX(), s.getPositionY(), s.getWidth(), s.getHeight());
      } else if (s.getType().equals("ELLIPSE")) {
        Color c = new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB());
        graphics.setColor(c);
        graphics.drawOval(s.getPositionX(), s.getPositionY(), s.getWidth(), s.getHeight());
        graphics.fillOval(s.getPositionX(), s.getPositionY(), s.getWidth(), s.getHeight());
              }
    }
  }
}

