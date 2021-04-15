package cs5004.animator.view;

import java.awt.*;
import java.awt.Color;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

public class GraphicsPanel extends JPanel {
  private Animation model;
  
  public GraphicsPanel(Animation model, int x, int y, int width, int height) {
    super(true);
    setSize(width, height);
    setLocation(x, y);
    this.model = model;
    setBackground(Color.WHITE);
    setBounds(x, y, width, height);
    setBorder(new LineBorder(Color.BLACK, 3));
  }
  
  //Do we need this second constructor??
  public GraphicsPanel(Animation model) {
    super(true);
    this.model = model;
    setBackground(Color.WHITE);
    setLocation(0, 0);
    setBounds(20, 20, 500, 500);
    setBorder(new LineBorder(Color.BLACK, 3));
  }
  
  public void updateModel(Animation model) {
    this.model = model;
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics = (Graphics2D) g;
    
    if (this.model == null) {
      return;
    }
    
    for (Shape s: model.getByTime(5)) {
      if (s.getType().equals("RECTANGLE")) {
        graphics.setColor(new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB()));
        graphics.drawRect(s.getPositionX(), s.getPositionX(), s.getX(), s.getY());
      } else if (s.getType().equals("OVAL")) {
        graphics.setColor(new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB()));
        graphics.drawOval(s.getPositionX(), s.getPositionX(), s.getX(), s.getY());
      }
    }
  }
}
